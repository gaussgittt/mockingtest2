package util.test;

import java.nio.file.Paths;

import org.junit.Test;

import com.mocking.vm.component.SourceCode;

// TODO need to write Sping mocking test as I do not have time for now

public class RunCodeTest {

	private String testFileNoCompilationError = "HelloWorld.txt";

    private String getFileName(String fileName) {
    	return Paths.get(fileName).getFileName().toString().replaceFirst("[.][^.]+$", "");
    }
    
    @Test
	public void testRunCodeWithNoCompilationError() {
	// Test above code here.
    SourceCode sourceCode = null;
	 /* 
     try {
	        String codeInString = RunCode.readFileAsString(testFileNoCompilationError);
	        sourceCode = new SourceCode(getFileName(testFileNoCompilationError), codeInString);
	        new RunCode(sourceCode).executeCode();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    */
	}
}
