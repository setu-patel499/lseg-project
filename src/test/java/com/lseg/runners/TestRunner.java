package com.lseg.runners;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources/featurefiles",//content root path from feature file
        glue = "com/lseg",//source root path from com.lseg.cucumber from test
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html",
                "com.cucumber.listener.ExtentCucumberFormatter:target/Extent_Reports/report.html"
        },
        tags = "@Regression"// tags for grouping
)
public class TestRunner {
    @AfterClass
    public static void setUp() {
        String projectPath = System.getProperty("user.dir");
        String reportConfigPath = projectPath + "/src/test/java/resources/extentreport/extent-config.xml";
        Reporter.loadXMLConfig(reportConfigPath);
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
        Reporter.setSystemInfo("Selenium", "3.141.59");
        Reporter.setSystemInfo("Maven", "3.5.9");
        Reporter.setSystemInfo("Java Version", "1.8.0_151");
    }
}

