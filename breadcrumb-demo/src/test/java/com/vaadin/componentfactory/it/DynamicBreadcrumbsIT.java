package com.vaadin.componentfactory.it;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Server-side API changes applied after the component has already rendered. */
@UsePlaywright(PlaywrightOptions.class)
class DynamicBreadcrumbsIT {

  @BeforeEach
  void openView(Page page) {
    page.navigate("/test/dynamic");
    assertThat(page.locator("#home a.breadcrumb-anchor")).isVisible();
    assertThat(page.locator("#breadcrumbs vcf-breadcrumb")).hasCount(3);
  }

  @Test
  void addingAnItemInsertsItBeforeTheCurrentPage(Page page) {
    page.locator("#add").click();

    assertThat(page.locator("#breadcrumbs vcf-breadcrumb"))
        .hasText(new String[] {"Home", "Middle", "Added 1", "Current"});
    assertThat(page.locator("#added-1 a.breadcrumb-anchor"))
        .hasAttribute("href", "test/dynamic");
  }

  @Test
  void removingTheLastItemShortensTheTrail(Page page) {
    page.locator("#remove-last").click();

    assertThat(page.locator("#breadcrumbs vcf-breadcrumb")).hasCount(2);
    assertThat(page.locator("#current")).hasCount(0);
    assertThat(page.locator("#breadcrumbs vcf-breadcrumb"))
        .hasText(new String[] {"Home", "Middle"});
  }

  @Test
  void removingAllItemsLeavesAnEmptyComponent(Page page) {
    page.locator("#remove-all").click();

    assertThat(page.locator("#breadcrumbs vcf-breadcrumb")).hasCount(0);
    // The container itself survives and stays a valid navigation landmark.
    assertThat(page.locator("#breadcrumbs")).hasAttribute("role", "navigation");
  }

  @Test
  void settingHrefUpdatesTheHostProperty(Page page) {
    page.locator("#set-href").click();

    // Only the host is asserted here. The generated anchor does not pick the href up after the
    // first render - see KnownIssuesIT#settingHrefAfterRenderMakesTheItemALink.
    assertThat(page.locator("#current")).hasAttribute("href", "hello");
  }

  @Test
  void settingTextUpdatesTheVisibleLabel(Page page) {
    page.locator("#rename").click();

    // The label updates, but the item stops being a link - see
    // KnownIssuesIT#settingTextAfterRenderKeepsTheItemALink.
    assertThat(page.locator("#middle")).hasText("Renamed");
  }

  @Test
  void enablingCollapseMakesTheItemEligibleForTheEllipsis(Page page) {
    page.locator("#toggle-collapse").click();
    page.locator("#narrow").click();

    assertThat(page.locator("#breadcrumbs vcf-breadcrumb[part='ellipsis']")).isVisible();
    assertThat(page.locator("#middle")).isHidden();
  }
}
