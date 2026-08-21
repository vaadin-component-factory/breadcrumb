package com.vaadin.componentfactory.it;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Test;

/**
 * Mobile mode collapses the trail to a back path: every item is marked {@code mobile-back}, and only
 * the item immediately before the current page stays visible, carrying a back icon.
 * <p>
 * Both entry points are covered: the flag set before the component is attached, and the flag toggled
 * on an already-rendered component. The latter only started working in web component 3.0.4.
 */
@UsePlaywright(PlaywrightOptions.class)
class MobileModeIT {

  @Test
  void desktopModeShowsTheWholeTrail(Page page) {
    page.navigate("/test/mobile");
    assertThat(page.locator("#home a.breadcrumb-anchor")).isVisible();

    assertThat(page.locator("#breadcrumbs vcf-breadcrumb")).hasCount(4);
    assertThat(page.locator("#home")).isVisible();
    assertThat(page.locator("#components")).isVisible();
    assertThat(page.locator("#vcf")).isVisible();
    assertThat(page.locator("#current")).isVisible();
    assertThat(page.locator("#breadcrumbs vcf-breadcrumb.mobile-back")).hasCount(0);
  }

  @Test
  void forcedMobileModeShowsOnlyTheBackPath(Page page) {
    page.navigate("/test/mobile-forced");
    // In mobile mode only the back link is visible, so it is the readiness marker.
    assertThat(page.locator("#vcf a.breadcrumb-anchor")).isVisible();

    // Every item is marked for the mobile layout...
    assertThat(page.locator("#breadcrumbs vcf-breadcrumb.mobile-back")).hasCount(4);
    // ...but only the one directly before the current page is shown, as the back target.
    assertThat(page.locator("#vcf")).containsClass("is-before-current");
    assertThat(page.locator("#vcf a.breadcrumb-anchor")).containsClass("add-mobile-back-icon");

    assertThat(page.locator("#home")).isHidden();
    assertThat(page.locator("#components")).isHidden();
    assertThat(page.locator("#current")).isHidden();
  }

  @Test
  void togglingForceMobileModeRelayoutsBothWays(Page page) {
    page.navigate("/test/mobile");
    assertThat(page.locator("#home a.breadcrumb-anchor")).isVisible();

    page.locator("#toggle-mobile").click();
    assertThat(page.locator("#mobile-state")).hasText("true");

    assertThat(page.locator("#breadcrumbs vcf-breadcrumb.mobile-back")).hasCount(4);
    assertThat(page.locator("#vcf")).containsClass("is-before-current");
    assertThat(page.locator("#home")).isHidden();
    assertThat(page.locator("#current")).isHidden();

    page.locator("#toggle-mobile").click();
    assertThat(page.locator("#mobile-state")).hasText("false");

    assertThat(page.locator("#breadcrumbs vcf-breadcrumb.mobile-back")).hasCount(0);
    assertThat(page.locator("#home")).isVisible();
    assertThat(page.locator("#current")).isVisible();
  }
}
