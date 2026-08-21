package com.vaadin.componentfactory.demo.it;

import com.vaadin.componentfactory.Breadcrumb;

/**
 * Factory helpers shared by the views the Playwright integration tests drive.
 * <p>
 * Every breadcrumb gets an explicit id so the tests can address it directly instead of relying on
 * positional selectors.
 */
final class TestBreadcrumbs {

  private TestBreadcrumbs() {}

  /** A breadcrumb that links somewhere. */
  static Breadcrumb link(String id, String text, String href) {
    Breadcrumb breadcrumb = new Breadcrumb(text, href);
    breadcrumb.setId(id);
    return breadcrumb;
  }

  /** A breadcrumb that links somewhere and collapses when space runs out. */
  static Breadcrumb collapsibleLink(String id, String text, String href) {
    Breadcrumb breadcrumb = new Breadcrumb(text, href, true);
    breadcrumb.setId(id);
    return breadcrumb;
  }

  /** The trailing breadcrumb, which has no href and so represents the current page. */
  static Breadcrumb current(String id, String text) {
    Breadcrumb breadcrumb = new Breadcrumb(text);
    breadcrumb.setId(id);
    return breadcrumb;
  }
}
