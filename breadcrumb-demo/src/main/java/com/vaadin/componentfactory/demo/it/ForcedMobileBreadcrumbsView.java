package com.vaadin.componentfactory.demo.it;

import static com.vaadin.componentfactory.demo.it.TestBreadcrumbs.current;
import static com.vaadin.componentfactory.demo.it.TestBreadcrumbs.link;

import com.vaadin.componentfactory.Breadcrumbs;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * Mobile mode switched on before the component is attached, which is how the demo and the README
 * use it. Kept separate from {@code test/mobile} because toggling the flag after the first render
 * does not currently relayout the component.
 */
@Route("test/mobile-forced")
public class ForcedMobileBreadcrumbsView extends VerticalLayout {

  public ForcedMobileBreadcrumbsView() {
    Breadcrumbs breadcrumbs = new Breadcrumbs(
        link("home", "Home", "test/mobile-forced"),
        link("components", "Components", "test/mobile-forced"),
        link("vcf", "VCF Components", "test/mobile-forced"),
        current("current", "Breadcrumbs"));
    breadcrumbs.setId("breadcrumbs");
    breadcrumbs.setForceMobileMode(true);
    add(breadcrumbs);
  }
}
