package com.vaadin.componentfactory.it;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import java.util.regex.Pattern;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Rendering, semantics and navigation of a plain breadcrumb trail. */
@UsePlaywright(PlaywrightOptions.class)
class BasicBreadcrumbsIT {

  @BeforeEach
  void openView(Page page) {
    page.navigate("/test/basic");
    // Wait for the web component to have upgraded and generated its anchors.
    assertThat(page.locator("#home a.breadcrumb-anchor")).isVisible();
  }

  @Test
  void rendersAllItemsInOrder(Page page) {
    assertThat(page.locator("#breadcrumbs vcf-breadcrumb")).hasCount(4);
    assertThat(page.locator("#breadcrumbs vcf-breadcrumb"))
        .hasText(new String[] {"Home", "Components", "VCF Components", "Breadcrumbs"});
  }

  @Test
  void wrapperExposesNavigationSemantics(Page page) {
    assertThat(page.locator("#breadcrumbs")).hasAttribute("role", "navigation");
    assertThat(page.locator("#breadcrumbs")).hasAttribute("aria-label", "breadcrumb");
    // Pierces the shadow root of vcf-breadcrumbs.
    assertThat(page.locator("#breadcrumbs [part='links-list']")).hasAttribute("role", "list");
  }

  @Test
  void linkItemsRenderAnchorWithHref(Page page) {
    assertThat(page.locator("#home a.breadcrumb-anchor")).hasAttribute("href", "hello");
    assertThat(page.locator("#components a.breadcrumb-anchor"))
        .hasAttribute("href", "test/basic");
    assertThat(page.locator("#vcf a.breadcrumb-anchor")).hasAttribute("href", "test/basic");
  }

  @Test
  void currentItemIsMarkedAndHasNoHref(Page page) {
    assertThat(page.locator("#current")).hasAttribute("aria-current", "page");
    assertNull(page.locator("#current a.breadcrumb-anchor").getAttribute("href"),
        "the trailing breadcrumb represents the current page and must not be a link");
  }

  @Test
  void separatorIsHiddenOnLastItemOnly(Page page) {
    assertThat(page.locator("#home [part='separator']")).isVisible();
    assertThat(page.locator("#current [part='separator']")).isHidden();
  }

  @Test
  void clickingLinkNavigates(Page page) {
    page.locator("#home a.breadcrumb-anchor").click();
    assertThat(page).hasURL(Pattern.compile("/hello$"));
    assertThat(page.getByRole(AriaRole.BUTTON,
        new Page.GetByRoleOptions().setName("Say hello"))).isVisible();
  }
}
