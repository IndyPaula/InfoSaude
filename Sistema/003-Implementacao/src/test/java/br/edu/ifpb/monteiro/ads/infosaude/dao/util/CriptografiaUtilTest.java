package br.edu.ifpb.monteiro.ads.infosaude.dao.util;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vanderlan Gomes
 */
public class CriptografiaUtilTest {
    
    public CriptografiaUtilTest() {
    
    }
    

    /**
     * Test of convertStringToMd5 method, of class CriptografiaUtil.
     */
    @Test
    public void stringValida() {
        String valor = "senha";
        String expResult = "e8d95a51f3af4a3b134bf6bb680a213a";

        String result = CriptografiaUtil.convertStringToMd5(valor);
        
        assertEquals(expResult, result);

    }
    
      @Test
    public void stringNula() {
        String valor = "";
        String expResult = null;

        String result = CriptografiaUtil.convertStringToMd5(valor);
        
        assertEquals(expResult, result);

    }
    
}
