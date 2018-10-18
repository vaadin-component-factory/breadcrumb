package com.vaadin.flow.component.incubator.vaadincom;

/*
 * #%L
 * Vaadin Breadcrumb for Vaadin 10
 * %%
 * Copyright (C) 2017 - 2018 Vaadin Ltd
 * %%
 * This program is available under Commercial Vaadin Add-On License 3.0
 * (CVALv3).
 * 
 * See the file license.html distributed with this software for more
 * information about licensing.
 * 
 * You should have received a copy of the CVALv3 along with this program.
 * If not, see <http://vaadin.com/license/cval-3>.
 * #L%
 */

import com.vaadin.flow.component.HasOrderedComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.templatemodel.TemplateModel;

/**
 * Server-side component for the <code>incubator-breadcrumb</code> element.
 *
 * @author Vaadin Ltd
 */
@Tag("incubator-breadcrumbs")
@HtmlImport("frontend://bower_components/incubator-breadcrumbs/src/incubator-breadcrumbs.html")
public class Breadcrumbs extends PolymerTemplate<TemplateModel>
        implements HasOrderedComponents<Breadcrumb>, HasSize {
}
