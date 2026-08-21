package com.vaadin.componentfactory.it;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.junit.Options;

/**
 * A phone-sized viewport, below the component's {@code (max-width: 450px)} breakpoint.
 * <p>
 * The viewport is set on the context rather than by resizing a live page, so the media query is
 * already matching when the component first renders. That matters because the component only
 * relayouts from its resize observer, so a late media-query change would race.
 */
public class MobileViewportOptions extends PlaywrightOptions {

  @Override
  public Options getOptions() {
    return super.getOptions()
        .setContextOptions(new Browser.NewContextOptions().setViewportSize(390, 844));
  }
}
