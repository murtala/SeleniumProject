package cucumber;

import static org.junit.Assert.*;

import org.junit.Test;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/"  //refer to Feature file
	)
public class GoogleCalculatorStepsTest {

}
