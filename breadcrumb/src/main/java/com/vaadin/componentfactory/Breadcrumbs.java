package com.vaadin.componentfactory;

/*
 * #%L
 * Vaadin Breadcrumb for Vaadin 10
 * %%
 * Copyright (C) 2017 - 2019 Vaadin Ltd
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.vaadin.flow.component.HasOrderedComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;

/**
 * Server-side component for the <code>vcf-breadcrumbs</code> element.
 * An easy way to display breadcrumb on web pages.
 * This component is container for Breadcrumb components
 *
 * @author Vaadin Ltd
 */
@Tag("vcf-breadcrumbs")
@HtmlImport("frontend://bower_components/vcf-breadcrumbs/src/vcf-breadcrumbs.html")
@NpmPackage(value = "@vaadin-component-factory/vcf-breadcrumb", version = "1.2.0")
@JsModule("@vaadin-component-factory/vcf-breadcrumb/src/vcf-breadcrumb.js")
public class Breadcrumbs extends PolymerTemplate<TemplateModel>
        implements HasOrderedComponents<Breadcrumb>, HasSize {

    /**
     * Creates instance of Breadcrumbs  as container for breadcrumbs which are passed as param
     *
     * @param breadcrumbs
     *                      brick components of breadcrumbs component
     */
    public Breadcrumbs(Breadcrumb... breadcrumbs) {
        add(breadcrumbs);
    }
}
