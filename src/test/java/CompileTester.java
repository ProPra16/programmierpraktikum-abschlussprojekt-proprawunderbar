
import static org.junit.Assert.assertEquals;

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
		//code ist "random" damit der Compile fehlschl�gt
		code = "public class HelloWorld{}";
		testCode = "import tddt.code.Compile; \n"+" import static org.junit.Assert.*\n"+
		"public class HelloWorldTest{}";
		Compile.compile(code, codeClassName, testCode, testClassName,new TextArea());
		assertEquals(Compile.compilerResult.hasCompileErrors(), true);
}
	  
	  
}


