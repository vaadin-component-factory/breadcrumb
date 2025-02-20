package com.vaadin.componentfactory.demo;

import com.vaadin.componentfactory.Breadcrumb;
import com.vaadin.componentfactory.Breadcrumbs;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.demo.DemoView;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@SuppressWarnings("serial")
@Route("breadcrumbs")
@RouteAlias("")
@CssImport("./styles/demo-styles.css")
public class BreadcrumbView extends DemoView {

  @Override
  protected void initView() {
    basicUseExample();
    routingExample();
    collapseExample();
    collapseEllispisOnlyExample();
    stylingExample();
  }

  private void basicUseExample() {
    Breadcrumbs breadcrumbs = new Breadcrumbs(
        new Breadcrumb("Home", "breadcrumbs/#"),
        new Breadcrumb("Components", "breadcrumbs/#"),
        new Breadcrumb("VCF Components", "breadcrumbs/#"), 
        new Breadcrumb("Breadcrumbs"));
    addCard("Breadcrumbs basic usage", breadcrumbs);
  }

  private void routingExample() {
    Breadcrumbs breadcrumbs = new Breadcrumbs(
        new Breadcrumb("Home", "hello"),
        new Breadcrumb("Components", "breadcrumbs/#"),
        new Breadcrumb("VCF Components", "breadcrumbs/#"), 
        new Breadcrumb("Breadcrumbs"));
    Div description = new Div();
    description.setText("When clicking on \"Home\" it will navigate to a Hello World View.");
    addCard("Breadcrumbs with routing", breadcrumbs, description);
  }

  private void collapseExample() {
    Breadcrumbs breadcrumbs = new Breadcrumbs(
        new Breadcrumb("Home", "breadcrumbs/#"),
        new Breadcrumb("Vaadin Flow", "breadcrumbs/#", true),
        new Breadcrumb("Components", "breadcrumbs/#", true),
        new Breadcrumb("VCF Components", "breadcrumbs/#", true), 
        new Breadcrumb("Breadcrumbs"));
    breadcrumbs.setWidth("350px");
    Div description = new Div();
    description.setText("The first item in the breadcrumb is always shown in full. "
        + "The items with 'collapse' in true are clipped and shown with ellipsis when space runs out.");
    addCard("Breadcrumbs showing ellipsis", breadcrumbs, description);
  }

  private void collapseEllispisOnlyExample() {
    Breadcrumbs breadcrumbs = new Breadcrumbs(
        new Breadcrumb("Home", "breadcrumbs/#"),
        new Breadcrumb("Vaadin Flow", "breadcrumbs/#", true),
        new Breadcrumb("Components", "breadcrumbs/#"),
        new Breadcrumb("VCF Components", "breadcrumbs/#", true), 
        new Breadcrumb("Breadcrumbs"));
    breadcrumbs.setWidth("250px");
    Div description = new Div();
    description.setText(
        "If space is limited, the items with 'collapse' in true are hidden and a single ellipsis element is shown instead."
            + " The first item is always shown in full.");
    addCard("Breadcrumbs showing collapse elements replaced with ellipsis element.", breadcrumbs,
        description);
  }

  private void stylingExample() {
    Breadcrumbs breadcrumbs = new Breadcrumbs(
        createdHomeBreadcrumb("Home", "breadcrumbs/#"),
        createStyledBreadcrumb("Vaadin Flow", "breadcrumbs/#"),
        createStyledBreadcrumb("Components", "breadcrumbs/#"),
        createStyledBreadcrumb("VCF Components", "breadcrumbs/#"), 
        new Breadcrumb("Breadcrumbs"));
    Div description = new Div();
    description.setText("Styles applied to replace default separator with \"/\", "
        + " change default color of anchor links and make \"Home\" to have a different color "
        + "than the rest of the breadcrumbs.");
    addCard("Breadcrumbs with styling", breadcrumbs, description);
  }

  private Breadcrumb createStyledBreadcrumb(String text, String href) {
    Breadcrumb breadcrumb = new Breadcrumb(text, href);
    breadcrumb.addClassName("styled-breadcrumb");
    return breadcrumb;
  }

  private Breadcrumb createdHomeBreadcrumb(String text, String href) {
    Breadcrumb breadcrumb = createStyledBreadcrumb(text, href);
    breadcrumb.addClassName("home-style");
    return breadcrumb;
  }
}
