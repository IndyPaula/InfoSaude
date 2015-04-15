package br.edu.ifpb.monteiro.ads.infosaude.dao.util;

import java.security.MessageDigest;

/**
 *
 * @author Vanderlan Gomes<vanderlan.gs@gmail.com>
 * @date 15/04/2015
 */
public class CriptografiaUtil {
    
    
    
    public static String convertStringToMd5(String valor) {
        MessageDigest mDigest;
        try {
            mDigest = MessageDigest.getInstance("MD5");

            byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8"));

            StringBuffer sb = new StringBuffer();
            for (byte b : valorMD5) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


}
