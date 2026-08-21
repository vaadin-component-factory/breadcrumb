package com.vaadin.componentfactory.demo.it;

import static com.vaadin.componentfactory.demo.it.TestBreadcrumbs.current;
import static com.vaadin.componentfactory.demo.it.TestBreadcrumbs.link;

import com.vaadin.componentfactory.Breadcrumbs;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * A plain four-item trail: three links plus the current page. Used to verify rendering, order,
 * anchors, aria semantics, separators and navigation.
 */
@Route("test/basic")
public class BasicBreadcrumbsView extends VerticalLayout {

  public BasicBreadcrumbsView() {
    Breadcrumbs breadcrumbs = new Breadcrumbs(
        link("home", "Home", "hello"),
        link("components", "Components", "test/basic"),
        link("vcf", "VCF Components", "test/basic"),
        current("current", "Breadcrumbs"));
    breadcrumbs.setId("breadcrumbs");
    add(breadcrumbs);
  }
}
