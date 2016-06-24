package tddt.code;


import java.util.Collection;

import tddt.UI.Test_UI;
import vk.core.api.CompilationUnit;
import vk.core.api.CompileError;
import vk.core.api.CompilerResult;
import vk.core.api.TestFailure;
import vk.core.api.TestResult;
import vk.core.internal.InternalCompiler;

public class Compile {
	public static void compile(String code,String codeClassName, String tests, String testClassName, String status){
		CompilationUnit test = new CompilationUnit(testClassName, tests, true);
		CompilationUnit program = new CompilationUnit(codeClassName, code, false);
		// JavaStringCompiler compiler = CompilerFactory.getCompiler(test,program);
		CompilationUnit[] cus = {test , program};
		InternalCompiler compiler = new InternalCompiler(cus);
		compiler.compileAndRunTests();
		CompilerResult compilerResult = compiler.getCompilerResult();
		if(compilerResult.hasCompileErrors()){
			Collection<CompileError> codeError = compilerResult.getCompilerErrorsForCompilationUnit(program);
			Collection<CompileError> testError = compilerResult.getCompilerErrorsForCompilationUnit(test);
		
			int codeErrors = codeError.size();
			int testErrors = testError.size();
			
			CompileError[] codeErrorArray= new CompileError[codeErrors];
			codeErrorArray = codeError.toArray(codeErrorArray);
			for(int i= 0; i<codeErrors;i++){
				System.out.println("In class"+ codeClassName+":");
				System.out.println(codeErrorArray[i].getCodeLineContainingTheError());
				System.out.println(codeErrorArray[i].toString());
			}
			CompileError[] testErrorArray= new CompileError[codeErrors];
			testErrorArray = testError.toArray(testErrorArray);
			for(int i= 0; i<testErrors;i++){
				System.out.println(testErrorArray[i].getCodeLineContainingTheError());
				System.out.println(testErrorArray[i].toString());
			}
			Test_UI.switchStatus();
		}
		int failedTests=0;
		TestResult testResult = compiler.getTestResult();
		if(testResult != null)
			failedTests = testResult.getNumberOfFailedTests();
			if(failedTests > 0){
				Collection<TestFailure> testFailures = testResult.getTestFailures();
				TestFailure[] failureArray = new TestFailure[testFailures.size()];
				failureArray = testFailures.toArray(failureArray);
				for(int i=0; i<failureArray.length;i++){
					System.out.println(failureArray[i].getMethodName());
					System.out.println(failureArray[i].getMessage());
				}
			}
			if(failedTests == 1 && status.equals("writeTest"))
				Test_UI.switchStatus();
			if(failedTests == 0 && status.equals("fixTest"))
				Test_UI.switchStatus();
		}
}
