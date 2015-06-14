package br.edu.ifpb.monteiro.ads.infosaude.validadores;

import javax.faces.validator.ValidatorException;
import org.junit.Test;

/**
 * @author Vanderlan Gomes
 * @date 20/05/2015
 */
public class CPFValidatorTest {

    private final CPFValidator validator;
    
    public CPFValidatorTest() {

        validator = new CPFValidator();
    }
    @Test(expected = ValidatorException.class)
    public void testCpfinvalido() {

        validator.validate(null, null, "10145478722");
        
    }
    
    @Test
    public void testCpfvalido() {

        validator.validate(null, null, "06435915407");
        
    }
    
    @Test(expected = ValidatorException.class)
    public void testCpfFormatError() {

        validator.validate(null, null, "knfew7yfew87f");
        
    }
    
     @Test(expected = ClassCastException.class)
    public void testCpfFormatInteiro() {

        validator.validate(null, null, 534534);
        
    }
    
}
