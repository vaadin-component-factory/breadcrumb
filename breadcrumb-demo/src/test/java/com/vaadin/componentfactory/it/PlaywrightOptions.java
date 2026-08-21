package com.vaadin.componentfactory.it;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;
import java.nio.file.Paths;

/**
 * Shared Playwright configuration for the integration tests.
 * <p>
 * The base URL comes from the {@code it.baseUrl} system property, which the {@code it} Maven profile
 * points at the Jetty instance it starts. Pass {@code -Dit.headed=true} to watch a run in a real
 * browser window. On failure a trace is retained under {@code target/playwright}; open it with
 * {@code npx playwright show-trace <trace.zip>}.
 */
public class PlaywrightOptions implements OptionsFactory {

  /**
   * A fixed viewport keeps the collapse tests deterministic: they depend on the breadcrumbs
   * container being wider than the 460px max-width it sets on itself, and comfortably above the
   * component's 450px mobile breakpoint.
   */
  private static final int VIEWPORT_WIDTH = 1280;
  private static final int VIEWPORT_HEIGHT = 720;

  @Override
  public Options getOptions() {
    return new Options()
        .setBaseUrl(System.getProperty("it.baseUrl", "http://localhost:8081"))
        .setHeadless(!Boolean.getBoolean("it.headed"))
        .setContextOptions(new Browser.NewContextOptions()
            .setViewportSize(VIEWPORT_WIDTH, VIEWPORT_HEIGHT))
        .setTrace(Options.Trace.RETAIN_ON_FAILURE)
        .setOutputDir(Paths.get("target", "playwright"));
  }
}
