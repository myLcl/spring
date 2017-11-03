package com.springData.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES编码器工具
 * 使用AES加密解密 AES-128-ECB加密
 * @version 1.0
 */
public class AESUtil {

    /**
     * KEY算法
     */
    private static final String KEY_ALGORITHM = "AES";

    /**
     * 加密算法
     * "/算法/模式/补码方式"
     */
    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    /**
     * 编码格式
     */
    private static final String data_encoding = "utf-8";

    /**
     * 数据加密 aes + base64
     * @param data 待加密的数据
     * @param key  加密使用的KEY
     * @return 加密之后的数据
     */
    public static String encryptAndBase64Encode(String data, String key) {
        try {
                if (key == null || "".equals(key.trim().length())) {
                    return null;
                }
                byte[] raw = key.getBytes(data_encoding);
                SecretKeySpec skeySpec = new SecretKeySpec(raw, KEY_ALGORITHM);
                Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
                cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
                byte[] encrypted = cipher.doFinal(data.getBytes(data_encoding));
                return new Base64().encodeToString(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    /**
     * 数据解解密 aes + base64
     * @param data 待解密的数据
     * @param key  解密使用的KEY
     * @return 解密之后的数据
     */
    public static String decryptAfterBase64Decode(String data, String key) {
        try {
            if (key == null || "".equals(key.trim().length())) {
                return null;
            }
            byte[] raw = key.getBytes(data_encoding);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = new Base64().decode(data);
            byte[] original = cipher.doFinal(encrypted1);
            if (original != null && original.length > 0) {
                return new String(original, data_encoding);
            }else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
