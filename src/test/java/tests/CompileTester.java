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
        code = "public class HelloWorld{xdcffv;gbhnjk}";
        testCode = "safasd";
        Exercise TestExercise = new Exercise(codeClassName, code, testClassName, testCode, false, false, "TestDatei", "DUMMY");
        Compile.compile(TestExercise.classCode, TestExercise.className, TestExercise.testCode, TestExercise.testName);
        assertEquals(Compile.compilerResult.hasCompileErrors(), true);
    }
      
    @Test
    public void compileSuccess() throws Exception {
      codeClassName = "HelloWorld";
      testClassName = "HelloWorldTest";
      code = "public class HelloWorld{";
      code += "public static string foo(){return \"foo\"}}";
      testCode = "import static org.junit.Assert.*;";
      testCode += "import org.junit.*;";
      testCode += "public class HelloWorldTest { @Test";
      testCode += "public void foo() { assertEquals(HelloWorld.foo , \"foo\");}}";
      Exercise TestExercise = new Exercise(codeClassName, code, testClassName, testCode, false, false, "TestDatei", "DUMMY");
      Compile.compile(TestExercise.classCode, TestExercise.className, TestExercise.testCode, TestExercise.testName);
      assertEquals(Compile.compilerResult.hasCompileErrors(), false);
  } 
    
    
    //hier sollen alle Tests stimmen
    @Test
    public void test0Misses() throws Exception {
      codeClassName = "HelloWorld";
      testClassName = "HelloWorldTest";
      code = "public class HelloWorld{";
      code += "public static string foo(){return \"foo\"}}";
      testCode = "import static org.junit.Assert.*;";
      testCode += "import org.junit.*;";
      testCode += "public class HelloWorldTest { @Test";
      testCode += "public void foo() { assertEquals(HelloWorld.foo , \"foo\");}}";
      Exercise TestExercise = new Exercise(codeClassName, code, testClassName, testCode, false, false, "TestDatei", "DUMMY");
      Compile.runTests(TestExercise.classCode, TestExercise.className, TestExercise.testCode, TestExercise.testName);
      assertEquals(Compile.failedTests, 0);
  } 
    
  //hier solle der Test fehlschlagen
    @Test
    public void test1Miss() throws Exception {
      codeClassName = "HelloWorld";
      testClassName = "HelloWorldTest";
      code = "public class HelloWorld{";
      code += "public static string foo(){return \"foo\"}}";
      testCode = "import static org.junit.Assert.*;";
      testCode += "import org.junit.*;";
      testCode += "public class HelloWorldTest { @Test";
      testCode += "public void foo() { assertEquals(HelloWorld.foo , \"Foo\");}}";
      Exercise TestExercise = new Exercise(codeClassName, code, testClassName, testCode, false, false, "TestDatei", "DUMMY");
      Compile.runTests(TestExercise.classCode, TestExercise.className, TestExercise.testCode, TestExercise.testName);
      assertEquals(Compile.failedTests, 1);
  } 
}

