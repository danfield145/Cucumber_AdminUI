package com.cucumber;


import Utilities.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BeforeAfter_steps {


    @Before
    public void startUp() {
        //Initialise a driver for this test
        DriverFactory.getInstance().getDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.getInstance().destroyDriver();
    }
}
