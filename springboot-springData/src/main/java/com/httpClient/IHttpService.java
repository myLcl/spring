package com.httpClient;

import java.util.Map;


public interface IHttpService {

    /**
     * Http Get
     *
     * @param uri
     * @return
     */
    String get(String uri);

    /**
     * Http Get
     *
     * @param uri
     * @param parameters
     * @return
     */
    String get(String uri, Map<String, String> parameters);

    /**
     * Http Get
     *
     * @param uri
     * @param headers
     * @param parameters
     * @return
     */
    String get(String uri, Map<String, String> headers, Map<String, String> parameters);

    /**
     * Http Post
     *
     * @param uri
     * @return
     */
    String post(String uri);

    /**
     * Http Post
     *
     * @param uri
     * @param parameters
     * @return
     */
    String post(String uri, Map<String, String> parameters);

    /**
     * Http Post
     * @param uri
     * @param headers
     * @param parameters
     * @return
     */
    String post(String uri, Map<String, String> headers, Map<String, String> parameters);

    /**
     * Http Post
     * @param uri
     * @param headers
     * @param parameters
     * @param timeOut
     * @return
     */
    String post(String uri, Map<String, String> headers, Map<String, String> parameters, int timeOut);

    /**
     * Http Post JSON
     * Content-Type : application/json
     * @param uri
     * @param jsonParam
     * @return
     */
    String postJSON(String uri, String jsonParam);

    /**
     * Http Post JSON
     * Content-Type : application/json
     * @param uri
     * @param jsonParam
     * @param timeOut
     * @return
     */
    String postJSON(String uri, String jsonParam, int timeOut);

    /**
     * Http Post JSON
     * Content-Type : application/json
     * @param uri
     * @param headers
     * @param jsonParam
     * @param timeOut
     * @return
     */
    String postJSON(String uri, Map<String, String> headers, String jsonParam, int timeOut);
}
