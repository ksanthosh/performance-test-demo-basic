package org.eeichinger.testing.web;

import org.junit.Rule;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Convenience base class for webdriver test cases
 *
 * @author Erich Eichinger/OpenCredo
 * @author Neale Upstone/OpenCredo
 */
public class BaseWebDriverTest {
	private final TestTracerRule loggerRule = new TestTracerRule();
	private final TestRule screenshotRule = new ScreenshotCaptureRule();
	private final TestRule driverLifecycle = new DriverLifecycleRule();
    
    @Rule public final RuleChain chain = RuleChain
    		.outerRule(driverLifecycle)
    		.around(screenshotRule)
    		.around(loggerRule);

    protected final Logger log = LoggerFactory.getLogger(getClass());
}
