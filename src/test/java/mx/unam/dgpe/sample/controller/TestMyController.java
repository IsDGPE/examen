package mx.unam.dgpe.sample.controller;

import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

import io.vertx.core.AbstractVerticle;
import static mx.unam.dgpe.sample.controller.RestUtil.*;

public class TestMyController extends AbstractVerticle {
    private static final Logger logger = Logger.getLogger(TestMyController.class);
    
    @Test
    public void suma() throws Exception {

        
	String result = sendGet("http://localhost:8080/api/sumar?a=11&b=14");
        System.out.println(result);
        assertTrue("Operacion suma", result.length() > 1);
        

    }

    @Test
    public void restar() throws Exception {
       
	String result = sendGet("http://localhost:8080/api/restar?a=11&b=14");
        System.out.println(result);
        assertTrue("Operacion restar", result.length() > 1);
        

    }

    @Test
    public void dividir() throws Exception {
       
	String result = sendGet("http://localhost:8080/api/divide?a=11&b=14");
        System.out.println(result);
        assertTrue("Operacion dividir", result.length() > 1);
        

    }


    @Test
    public void multiplicar() throws Exception {
       
	String result = sendGet("http://localhost:8080/api/multiplica?a=11&b=14");
        System.out.println(result);
        assertTrue("Operacion multiplicar", result.length() > 1);
        

    }

}
