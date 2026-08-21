package com.vaadin.componentfactory.demo.it;

import static com.vaadin.componentfactory.demo.it.TestBreadcrumbs.current;
import static com.vaadin.componentfactory.demo.it.TestBreadcrumbs.link;

import com.vaadin.componentfactory.Breadcrumbs;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * Starts in desktop mode so a test can toggle {@code forceMobileMode} in both directions. The same
 * view also exercises the responsive path, by shrinking the viewport below the component's
 * {@code (max-width: 450px)} breakpoint without touching the flag.
 */
@Route("test/mobile")
public class MobileBreadcrumbsView extends VerticalLayout {

  public MobileBreadcrumbsView() {
    Breadcrumbs breadcrumbs = new Breadcrumbs(
        link("home", "Home", "test/mobile"),
        link("components", "Components", "test/mobile"),
        link("vcf", "VCF Components", "test/mobile"),
        current("current", "Breadcrumbs"));
    breadcrumbs.setId("breadcrumbs");

    Span state = new Span(String.valueOf(breadcrumbs.isForceMobileMode()));
    state.setId("mobile-state");

    Button toggle = new Button("Toggle mobile mode", e -> {
      breadcrumbs.setForceMobileMode(!breadcrumbs.isForceMobileMode());
      state.setText(String.valueOf(breadcrumbs.isForceMobileMode()));
    });
    toggle.setId("toggle-mobile");

    add(breadcrumbs, toggle, state);
  }
}
