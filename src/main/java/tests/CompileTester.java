package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import exercises.Exercise;
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
        Exercise TestExercise = new Exercise(codeClassName, code, testClassName, testCode, false, false, "TestDatei", "DUMMY");
        Compile.compile(code, codeClassName, testCode, testClassName);
        assertEquals(Compile.compilerResult.hasCompileErrors(), true);
}
      
      
}


