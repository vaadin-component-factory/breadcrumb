package com.vaadin.componentfactory.it;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The collapse behaviour: when the container cannot fit the whole trail, consecutive collapsible
 * items are replaced by a single ellipsis element that reveals them in a popover.
 */
@UsePlaywright(PlaywrightOptions.class)
class CollapseBreadcrumbsIT {

  private static final String ELLIPSIS = "#breadcrumbs vcf-breadcrumb[part='ellipsis']";
  /**
   * Direct child on purpose: the ellipsis also contains the popover, whose hidden-item anchors would
   * otherwise be matched too.
   */
  private static final String ELLIPSIS_LINK = ELLIPSIS + " > a.breadcrumb-anchor";

  @BeforeEach
  void openView(Page page) {
    page.navigate("/test/collapse");
    assertThat(page.locator("#home a.breadcrumb-anchor")).isVisible();
  }

  @Test
  void collapsibleItemsAreReplacedByEllipsisWhenSpaceRunsOut(Page page) {
    assertThat(page.locator(ELLIPSIS)).isVisible();
    assertThat(page.locator(ELLIPSIS)).hasAttribute("aria-label", "Hidden breadcrumbs");
    assertThat(page.locator(ELLIPSIS_LINK)).hasAttribute("aria-haspopup", "true");
    assertThat(page.locator(ELLIPSIS_LINK)).hasAttribute("aria-expanded", "false");

    // The three consecutive collapsible items form one range and are hidden together.
    assertThat(page.locator("#directory")).isHidden();
    assertThat(page.locator("#flow")).isHidden();
    assertThat(page.locator("#latest")).isHidden();

    // The first item is always shown in full, and non-collapsible items stay put.
    assertThat(page.locator("#home")).isVisible();
    assertThat(page.locator("#components")).isVisible();
    assertThat(page.locator("#current")).isVisible();
  }

  @Test
  void ellipsisPopoverListsTheHiddenItems(Page page) {
    page.locator(ELLIPSIS_LINK).click();

    Locator menuItems = page.locator("vaadin-popover a[role='menuitem']");
    assertThat(menuItems).hasCount(3);
    assertThat(menuItems)
        .hasText(new String[] {"Add-ons Directory", "Vaadin Flow", "Vaadin Latest"});
  }

  @Test
  void clickingAPopoverItemNavigatesAndClosesThePopover(Page page) {
    page.locator(ELLIPSIS_LINK).click();

    Locator flow = page.locator("vaadin-popover a[role='menuitem']").getByText("Vaadin Flow");
    assertThat(flow).isVisible();
    flow.click();

    assertThat(page.locator("vaadin-popover a[role='menuitem']")).hasCount(0);
  }

  @Test
  void wideningTheContainerRestoresAllItems(Page page) {
    assertThat(page.locator(ELLIPSIS)).isVisible();

    page.locator("#widen").click();

    assertThat(page.locator(ELLIPSIS)).hasCount(0);
    assertThat(page.locator("#directory")).isVisible();
    assertThat(page.locator("#flow")).isVisible();
    assertThat(page.locator("#latest")).isVisible();
  }
}
