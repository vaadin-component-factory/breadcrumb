package com.vaadin.componentfactory.demo;

import com.vaadin.componentfactory.Breadcrumb;
import com.vaadin.componentfactory.Breadcrumbs;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.demo.DemoView;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route("breadcrumbs")
@RouteAlias("")
public class BreadcrumbView extends DemoView {

    @Override
    protected void initView() {
        Breadcrumbs breadcrumbs = new Breadcrumbs(
                new Breadcrumb("Home","breadcrumbs/#", true),
                new Breadcrumb("Components", "breadcrumbs/#", true),
                new Breadcrumb("VCF Components", "breadcrumbs/#"),
                new Breadcrumb("Breadcrumbs"));

        Div description = new Div();
        description.setText("Breadcrumbs \"Home\" and \"Components\" will be hidden when " +
                "viewport size will be smaller then 420px");

        addCard("Basic Breadcrumbs usage", breadcrumbs, description);
    }
}