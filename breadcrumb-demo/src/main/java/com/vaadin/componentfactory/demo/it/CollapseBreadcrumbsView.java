package com.vaadin.componentfactory.demo.it;

import static com.vaadin.componentfactory.demo.it.TestBreadcrumbs.collapsibleLink;
import static com.vaadin.componentfactory.demo.it.TestBreadcrumbs.current;
import static com.vaadin.componentfactory.demo.it.TestBreadcrumbs.link;

import com.vaadin.componentfactory.Breadcrumbs;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * A trail whose middle items are collapsible, inside a container too narrow to show them all, so the
 * web component replaces the collapsible range with an ellipsis element. The buttons let a test grow
 * or shrink the container and observe the ellipsis appearing and disappearing.
 */
@Route("test/collapse")
public class CollapseBreadcrumbsView extends VerticalLayout {

  private static final String NARROW = "280px";

  public CollapseBreadcrumbsView() {
    Breadcrumbs breadcrumbs = new Breadcrumbs(
        link("home", "Home", "test/collapse"),
        collapsibleLink("directory", "Add-ons Directory", "test/collapse"),
        collapsibleLink("flow", "Vaadin Flow", "test/collapse"),
        collapsibleLink("latest", "Vaadin Latest", "test/collapse"),
        link("components", "Components", "test/collapse"),
        current("current", "Breadcrumbs"));
    breadcrumbs.setId("breadcrumbs");
    breadcrumbs.setMaxWidth(NARROW);

    Button widen = new Button("Widen", e -> breadcrumbs.setMaxWidth("1200px"));
    widen.setId("widen");
    Button narrow = new Button("Narrow", e -> breadcrumbs.setMaxWidth(NARROW));
    narrow.setId("narrow");

    add(breadcrumbs, new HorizontalLayout(widen, narrow));
  }
}
