package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import javafx.scene.control.TextArea;
import tddt.code.Compile;


public class CompileTester {
    private static String codeClassName;
    private static String code;
    private static String testClassName;
    private static String testCode;
    

    @Test
      public void compileFail() throws Exception {
        codeClassName = "HelloWorld";
        testClassName = "HelloWorldTest";
        //code soll nicht kompilen können
        code = "public class HelloWorld{}";
        testCode = "safasd";
        Compile.compile(code, codeClassName, testCode, testClassName,new TextArea());
        assertEquals(Compile.compilerResult.hasCompileErrors(), true);
}
      
      
}


