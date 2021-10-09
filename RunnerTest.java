package RunnerfileAssignment;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;









@CucumberOptions(
		features = "src/main/java/FeatureFIleAssignment" ,
        monochrome = true , 
        glue = "StepDef" , 
      
        publish = true)
public class RunnerTest extends AbstractTestNGCucumberTests {

}
