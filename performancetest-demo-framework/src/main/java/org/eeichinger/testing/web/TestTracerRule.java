package org.eeichinger.testing.web;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logs test method execution
 *
 * @author Neale Upstone/OpenCredo
 */
public class TestTracerRule extends TestWatcher {
    
    protected final Logger log = LoggerFactory.getLogger(getClass());
    
    @Override
    public void starting(Description description) {
        log.info("Starting: {}", description.getMethodName());
    }

    @Override
    public void failed(Throwable e, Description description) {
        log.error("Failed: {}", description.getMethodName(), e);
    }

    @Override
    public void succeeded(Description description) {
        log.info("Success: {}", description.getMethodName());
    }
}
