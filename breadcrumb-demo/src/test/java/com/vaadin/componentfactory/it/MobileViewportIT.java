package com.vaadin.componentfactory.it;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Test;

/**
 * Mobile mode reached through the component's own {@code (max-width: 450px), (max-height: 450px)}
 * media query, with {@code forceMobileMode} left off.
 * <p>
 * The viewport is set on the browser context rather than by resizing a live page, so the media query
 * already matches when the component first renders. Resizing afterwards races with the component's
 * resize observer, which is the only thing that triggers a relayout.
 */
@UsePlaywright(MobileViewportOptions.class)
class MobileViewportIT {

  @Test
  void narrowViewportEnablesMobileModeWithoutTheFlag(Page page) {
    page.navigate("/test/mobile");
    assertThat(page.locator("#vcf a.breadcrumb-anchor")).isVisible();

    // No flag involved - this is purely the media query.
    assertThat(page.locator("#mobile-state")).hasText("false");

    assertThat(page.locator("#breadcrumbs vcf-breadcrumb.mobile-back")).hasCount(4);
    assertThat(page.locator("#vcf")).containsClass("is-before-current");
    assertThat(page.locator("#home")).isHidden();
    assertThat(page.locator("#components")).isHidden();
  }
}
