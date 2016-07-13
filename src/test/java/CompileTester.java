
import tddt.code.Compile; 
import static org.junit.Assert.*;
import org.junit.*;


public class CompileTester {
	private static String codeClassName;
	private static String code;
	private static String testClassName;
	private static String testCode;
	
	@Test
	  public void compileFail() throws Exception {
		codeClassName = "HelloWorld";
		testClassName = "HelloWorldTest";
		//code ist "random" damit der Compile fehlschlägt
		code = "qweqras";
		testCode = "Afsawas";
		Compile.compile(code, codeClassName, testCode, testClassName);
		assertEquals(Compile.compilerResult.hasCompileErrors(), true);
	}
	  
	  
}


