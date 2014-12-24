
// package test;

// from http://www.vogella.com/tutorials/JUnit/article.html#junit_testorganization
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class Tests {
	public static void main(String[] args) {
  	  Result result = JUnitCore.runClasses(BasicTest.class);
  	  for (Failure failure : result.getFailures()) {
  	    System.out.println(failure.toString());
  	  }
  	}
	
}
