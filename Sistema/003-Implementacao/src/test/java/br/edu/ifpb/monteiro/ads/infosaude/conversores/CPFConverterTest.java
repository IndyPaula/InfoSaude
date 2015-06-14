package br.edu.ifpb.monteiro.ads.infosaude.conversores;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author Vanderlan Gomes
 * @date 20/05/2015
 */
public class CPFConverterTest {

    private final CPFConverter converter;
    
    
    public CPFConverterTest() {

        converter = new CPFConverter();
    }
    @Test
    public void testCpfConverter() {

        String result = converter.getAsString(null, null, "101.454.734-22");
        assertEquals(result, "101.454.734-22");
    }
    @Test
    public void testCpfConverterObject() {

        Object result = converter.getAsObject(null, null, "101.454.734-22");
        
        assertEquals(result, "10145473422");
    }
}
