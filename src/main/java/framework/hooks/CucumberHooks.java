package framework.hooks;

import framework.driverhelpers.DriverHelper;
import framework.driverhelpers.TestConstants;
import framework.utils.TestContext;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberHooks {
    private TestContext context;

    public CucumberHooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void beforeScenario(Scenario scenario){
        var driverHelper = new DriverHelper();
        
    }
}
