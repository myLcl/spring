package com.httpClient;




import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import org.apache.commons.codec.Charsets;
import org.apache.commons.collections.MapUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.StandardHttpRequestRetryHandler;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.cookie.BestMatchSpecFactory;
import org.apache.http.impl.cookie.BrowserCompatSpec;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class HttpServiceImpl implements IHttpService {

    private static final int DEFAULT_TIME_OUT = 60 * 1000; // 超时时间

    @Override
    public String get(String uri) {
        return get(uri, null, null);
    }

    @Override
    public String get(String uri, Map<String, String> parameters) {
        return get(uri, null, parameters);
    }

    @Override
    public String get(String uri, Map<String, String> headers, Map<String, String> parameters) {
        return doHttp(RequestBuilder.get(), uri, headers, parameters, 0);
    }

    @Override
    public String post(String uri) {
        return post(uri, null, null);
    }

    @Override
    public String post(String uri, Map<String, String> parameters) {
        return post(uri, null, parameters);
    }

    @Override
    public String post(String uri, Map<String, String> headers, Map<String, String> parameters) {
        return post(uri, headers, parameters, 0);
    }

    @Override
    public String post(String uri, Map<String, String> headers, Map<String, String> parameters, int timeOut) {
        return doHttp(RequestBuilder.post(), uri, headers, parameters, timeOut);
    }

    @Override
    public String postJSON(String uri, String jsonParam) {
        return postJSON(uri, jsonParam, 0);
    }

    @Override
    public String postJSON(String uri, String jsonParam, int timeOut) {
        return postJSON(uri, null, jsonParam, timeOut);
    }

    @Override
    public String postJSON(String uri, Map<String, String> headers, String jsonParam, int timeOut) {
        return doHttp(RequestBuilder.post(), uri, headers, jsonParam, timeOut);
    }

    /**
     * 发送http请求，参数为json串，Content-Type为application/json
     * @param requestBuilder
     * @param uri
     * @param headers
     * @param jsonParam
     * @param timeOut
     * @return
     */
    private String doHttp(RequestBuilder requestBuilder, String uri, Map<String, String> headers, String jsonParam, int timeOut) {

        String method = requestBuilder.getMethod();
        HttpEntity httpEntity = null;
        CloseableHttpResponse httpResponse = null;
        try {
            /************** 设置URI **************/
            requestBuilder.setUri(uri);

            /************** 公共配置 **************/
            this.setConfig(requestBuilder, timeOut);

            /************** 设置Header **************/
            this.setHeader(requestBuilder, headers);

            /************** 设置Parameter **************/
            requestBuilder.setEntity(new StringEntity(jsonParam, ContentType.APPLICATION_JSON));

            /************** 发送请求 **************/
            httpResponse = httpClient().execute(requestBuilder.build());
            httpEntity = httpResponse.getEntity();
            String response = EntityUtils.toString(httpEntity, Charsets.UTF_8);


            return response;
        } catch (Exception e) {
            return null;
        } finally {
            EntityUtils.consumeQuietly(httpEntity);
            try {
                if(httpResponse != null){
                    httpResponse.close();
                }
            } catch (Exception e) {
            }
        }
    }

    /**
     * 发送普通http/https请求，参数为map
     * @param requestBuilder
     * @param uri
     * @param headers
     * @param parameters
     * @param timeOut
     * @return
     */
    private String doHttp(RequestBuilder requestBuilder, String uri, Map<String, String> headers, Map<String, String> parameters, int timeOut) {

        String method = requestBuilder.getMethod();
        HttpEntity httpEntity = null;
        CloseableHttpResponse httpResponse = null;
        try {
            /************** 设置URI **************/
            requestBuilder.setUri(uri);

            /************** 公共配置 **************/
            this.setConfig(requestBuilder, timeOut);

            /************** 设置Header **************/
            this.setHeader(requestBuilder, headers);

            /************** 设置Parameter **************/
            this.setParameter(requestBuilder, parameters, method);

            /************** 发送请求 **************/
            httpResponse = httpClient().execute(requestBuilder.build());
            httpEntity = httpResponse.getEntity();
            String response = EntityUtils.toString(httpEntity, Charsets.UTF_8);


            return response;
        } catch (Exception e) {
            return null;
        } finally {
            EntityUtils.consumeQuietly(httpEntity);
            try {
                if(httpResponse == null){
                    return null;
                }
                httpResponse.close();
            } catch (Exception e) {
            }
        }
    }

    /**
     * Create HttpClient
     *
     * @return
     * @throws KeyStoreException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public CloseableHttpClient httpClient() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        //  socket factory
        ConnectionSocketFactory plainSocketFactory = new PlainConnectionSocketFactory();
        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(
                null, (x509Certificates, authType) -> true).build();

        LayeredConnectionSocketFactory sslSocketFactory =
                new SSLConnectionSocketFactory(sslContext, new AllowAllHostnameVerifier());
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", plainSocketFactory)
                .register("https", sslSocketFactory).build();

        // cookie specification
        Registry<CookieSpecProvider> cookieSpecProviderRegistry = RegistryBuilder.<CookieSpecProvider>create()
                .register(CookieSpecs.BEST_MATCH, new BestMatchSpecFactory())
                .register(CookieSpecs.BROWSER_COMPATIBILITY, new BrowserCompatSpecFactory())
                .register("easy", httpContext -> new BrowserCompatSpec() {
                    public void validate(Cookie cookie, CookieOrigin origin) throws MalformedCookieException {
                    }
                }).build();

        // connection manager
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);

        connectionManager.setMaxTotal(10000);
        connectionManager.setDefaultMaxPerRoute(1000);

        // retry handler
        HttpRequestRetryHandler retryHandler = new StandardHttpRequestRetryHandler(3, false);

        // keep alive strategy
        ConnectionKeepAliveStrategy keepAliveStrategy = new DefaultConnectionKeepAliveStrategy();

        // httpclient
        return HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setRetryHandler(retryHandler)
                .setKeepAliveStrategy(keepAliveStrategy)
                .setDefaultCookieSpecRegistry(cookieSpecProviderRegistry).build();
    }

    /**
     * Set Parameter
     *
     * @param requestBuilder
     * @param parameters
     * @param method
     */
    private void setParameter(RequestBuilder requestBuilder, Map<String, String> parameters, String method) {
        if (MapUtils.isNotEmpty(parameters)) {
            parameters = Maps.filterValues(parameters, Predicates.notNull());

            Set<Map.Entry<String, String>> entrys = parameters.entrySet();
            /************** Get 请求 **************/
            if (method.equalsIgnoreCase(HttpGet.METHOD_NAME)) {
                for (Map.Entry<String, String> entry : entrys) {
                    requestBuilder.addParameter(entry.getKey(), entry.getValue());
                }
            }
            /************** Post 请求 **************/
            else {
                List<NameValuePair> valuePairs = new ArrayList<>();
                for (Map.Entry<String, String> entry : entrys) {
                    valuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                requestBuilder.setEntity(new UrlEncodedFormEntity(valuePairs, Charsets.UTF_8));
            }
        }
    }

    /**
     * Set Header
     *
     * @param requestBuilder
     * @param headers
     */
    public void setHeader(RequestBuilder requestBuilder, Map<String, String> headers) {
        requestBuilder.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Safari/537.36")
                .setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                .setHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6")
                .setHeader("Connection", "keep-alive");

        if (MapUtils.isNotEmpty(headers)) {
            headers = Maps.filterValues(headers, Predicates.notNull());

            Set<Map.Entry<String, String>> entrys = headers.entrySet();
            for (Map.Entry<String, String> entry : entrys) {
                requestBuilder.addHeader(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * Request config
     *
     * @return
     */
    private void setConfig(RequestBuilder requestBuilder, int timeOut) {
        int realTimeOut = (timeOut < 3000 || timeOut > 60000)?DEFAULT_TIME_OUT : timeOut; // 设置超时时间至少3s，最多60s
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(realTimeOut)
                .setSocketTimeout(realTimeOut)
                .setConnectionRequestTimeout(realTimeOut)
                .build();
        requestBuilder.setConfig(requestConfig);
    }
}
