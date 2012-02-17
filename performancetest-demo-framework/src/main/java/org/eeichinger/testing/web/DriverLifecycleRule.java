package org.eeichinger.testing.web;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 * Manages the WebDriver lifecycle for plain unit tests
 *
 * @author Erich Eichinger
 * @since 26/01/12
 */
public class DriverLifecycleRule extends TestWatcher {

	@Override
	protected void starting(Description description) {
		WebDriverFactory.getInstance().initializeWebDriver();
	}

	@Override
	protected void finished(Description description) {
        WebDriverFactory.getInstance().getCurrentWebDriver().quit();
    }
}
