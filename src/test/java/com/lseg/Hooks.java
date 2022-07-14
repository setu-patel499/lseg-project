package com.lseg;

import com.cucumber.listener.Reporter;
import com.lseg.Utility.Utility;
import com.lseg.propertyreader.PropertyReader;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;

public class Hooks extends Utility {
    @Before
    public void setUp() {
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));//get browser from propertyReader
    }

    @After
    public void tearDown(Scenario scenario) {//take screenshot
        if (scenario.isFailed()) {
            String screenShotPath = Utility.getScreenshot(driver, scenario.getName().replace(" ", "_"));
            try {
                Reporter.addScreenCaptureFromPath(screenShotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        closeBrowser();
    }
}

