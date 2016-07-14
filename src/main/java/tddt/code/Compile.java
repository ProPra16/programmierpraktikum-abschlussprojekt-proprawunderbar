package tddt.code;

import java.util.Collection;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import tddt.UI.Test_UI;
import vk.core.api.CompilationUnit;
import vk.core.api.CompileError;
import vk.core.api.CompilerResult;
import vk.core.api.TestFailure;
import vk.core.api.TestResult;
import vk.core.internal.InternalCompiler;

public class Compile {
	
	static int failedTests = 0;
	static CompilationUnit test;
	static CompilationUnit program;
	public static CompilerResult compilerResult;
	static TextField outputConsole;
	
	public static void compile(String code,String codeClassName, String tests, String testClassName, TextArea output){

		test = new CompilationUnit(testClassName, tests, true);
		program = new CompilationUnit(codeClassName, code, false);
		// JavaStringCompiler compiler = CompilerFactory.getCompiler(test,program);
		CompilationUnit[] cus = {test , program};
		InternalCompiler compiler = new InternalCompiler(cus);
		compiler.compileAndRunTests();
		compilerResult = compiler.getCompilerResult();
		if(compilerResult.hasCompileErrors()){
			Collection<CompileError> codeError = compilerResult.getCompilerErrorsForCompilationUnit(program);
			Collection<CompileError> testError = compilerResult.getCompilerErrorsForCompilationUnit(test);
		
			int codeErrors = codeError.size();
			int testErrors = testError.size();
			
			CompileError[] codeErrorArray= new CompileError[codeErrors];
			codeErrorArray = codeError.toArray(codeErrorArray);
			for(int i= 0; i<codeErrors;i++){
				Test_UI.compileOutput.setText(Test_UI.compileOutput.getText()+"\n In class"+ codeClassName+":");
				Test_UI.compileOutput.setText(Test_UI.compileOutput.getText()+" \n"+codeErrorArray[i].getCodeLineContainingTheError());
				Test_UI.compileOutput.setText(Test_UI.compileOutput.getText()+" \n"+codeErrorArray[i].toString());
				System.out.println("In class"+ codeClassName+":");
				System.out.println(codeErrorArray[i].getCodeLineContainingTheError());
				System.out.println(codeErrorArray[i].toString());
			}
			CompileError[] testErrorArray= new CompileError[codeErrors];
			testErrorArray = testError.toArray(testErrorArray);
			for(int i= 0; i<testErrors;i++){
				Test_UI.compileOutput.setText(Test_UI.compileOutput.getText()+" \n"+testErrorArray[i].getCodeLineContainingTheError());
				Test_UI.compileOutput.setText(Test_UI.compileOutput.getText()+" \n"+testErrorArray[i].toString());
				System.out.println(testErrorArray[i].getCodeLineContainingTheError());
				System.out.println(testErrorArray[i].toString());
			}
			if(Test_UI.status.equals("writeTest"))
			Test_UI.switchStatus(true);
		}
	}
		
		
	public static void runTests(String code,String codeClassName, String tests, String testClassName, TextArea output){
		compile(code ,codeClassName , tests, testClassName, output);
		if(compilerResult.hasCompileErrors())
			return;
		failedTests=0;
		CompilationUnit[] cus = {test , program};
		InternalCompiler compiler = new InternalCompiler(cus);
		compiler.compileAndRunTests();
		TestResult testResult = compiler.getTestResult();
		if(testResult != null)
			failedTests = testResult.getNumberOfFailedTests();
		if(failedTests > 0){
			Collection<TestFailure> testFailures = testResult.getTestFailures();
			TestFailure[] failureArray = new TestFailure[testFailures.size()];
			failureArray = testFailures.toArray(failureArray);
			for(int i=0; i<failureArray.length;i++){
				output.setText(Test_UI.compileOutput.getText()+" \n"+ failureArray[i].getMethodName());
				output.setText(Test_UI.compileOutput.getText()+" \n"+ failureArray[i].getMessage());
				System.out.println(failureArray[i].getMethodName());
				System.out.println(failureArray[i].getMessage());
			}
		}
		if(failedTests == 1 && Test_UI.status.equals("writeTest"))
			Test_UI.switchStatus(true);
		if(failedTests == 0 && Test_UI.status.equals("fixTest"))
			Test_UI.switchStatus(true);
	}
}

