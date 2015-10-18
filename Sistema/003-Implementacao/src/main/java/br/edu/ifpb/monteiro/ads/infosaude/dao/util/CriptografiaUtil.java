package br.edu.ifpb.monteiro.ads.infosaude.dao.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Vanderlan Gomes<vanderlan.gs@gmail.com>
 * @date 15/04/2015
 *
 */
public class CriptografiaUtil {

    private CriptografiaUtil() {

    }

    public static String convertStringToMd5(String valor) {

        MessageDigest mDigest;
        StringBuffer sb;

        if (valor == "") {
            return null;
        }
        try {
            mDigest = MessageDigest.getInstance("MD5");
            byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8"));
            sb = new StringBuffer();

            for (byte b : valorMD5) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(MessageDigest.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(StringBuffer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
