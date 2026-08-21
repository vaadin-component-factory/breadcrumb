package com.vaadin.componentfactory.it;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Defects that exist in web component 3.0.4, each reproduced by a test that asserts the behaviour
 * the Java API promises. They are expected to FAIL.
 * <p>
 * Tagged {@code known-issue} and excluded from {@code mvn verify -Pit} so the suite stays a usable
 * regression signal. Run them deliberately with:
 *
 * <pre>mvn verify -Pit -Dfailsafe.excludedGroups= -Dit.test=KnownIssuesIT</pre>
 *
 * <p>
 * Both share one root cause: {@code vcf-breadcrumb} builds its anchor once, in
 * {@code firstUpdated()}, and nothing re-syncs the anchor when a property changes afterwards.
 */
@Tag("known-issue")
@UsePlaywright(PlaywrightOptions.class)
class KnownIssuesIT {

  /**
   * {@code Breadcrumb.setHref()} sets the host property, and the component reflects it to the host
   * attribute, but {@code _createAnchor()} only copies href into the anchor during
   * {@code firstUpdated()}. The item therefore never becomes clickable.
   */
  @Test
  void settingHrefAfterRenderMakesTheItemALink(Page page) {
    page.navigate("/test/dynamic");
    assertThat(page.locator("#home a.breadcrumb-anchor")).isVisible();

    page.locator("#set-href").click();

    assertThat(page.locator("#current")).hasAttribute("href", "hello");
    // Fails: the anchor has no href attribute at all.
    assertThat(page.locator("#current a.breadcrumb-anchor")).hasAttribute("href", "hello");
  }

  /**
   * {@code Breadcrumb.setText()} goes through {@code Element.setText()}, which replaces every child
   * node of the host - including the generated anchor, whose label text node was moved inside it.
   * The new label renders, but the item silently stops being a link.
   */
  @Test
  void settingTextAfterRenderKeepsTheItemALink(Page page) {
    page.navigate("/test/dynamic");
    assertThat(page.locator("#home a.breadcrumb-anchor")).isVisible();

    page.locator("#rename").click();

    assertThat(page.locator("#middle")).hasText("Renamed");
    // Fails: setText() wiped the anchor, leaving a bare text node.
    assertThat(page.locator("#middle a.breadcrumb-anchor")).hasCount(1);
  }
}
