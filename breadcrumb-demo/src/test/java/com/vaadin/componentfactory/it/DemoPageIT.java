package com.vaadin.componentfactory.it;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Test;

/**
 * A smoke test for the demo page itself. The detailed assertions live against the dedicated
 * {@code test/…} views; this only guards that the demo still renders, since it no longer uses
 * {@code DemoView} from {@code flow-component-demo-helpers} and builds its cards itself.
 */
@UsePlaywright(PlaywrightOptions.class)
class DemoPageIT {

  @Test
  void allExampleCardsRender(Page page) {
    page.navigate("/breadcrumbs");
    assertThat(page.locator("vaadin-card").first()).isVisible();

    assertThat(page.locator("vaadin-card")).hasCount(6);
    assertThat(page.locator("vaadin-card vcf-breadcrumbs")).hasCount(6);
  }
}
