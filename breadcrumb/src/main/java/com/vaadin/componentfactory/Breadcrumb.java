package com.vaadin.componentfactory;

/*
 * #%L
 * Breadcrumb Component
 * %%
 * Copyright (C) 2018 - 2020 Vaadin Ltd
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

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;

/**
 * Server-side component for the <code>vcf-breadcrumb</code> element.
 *
 * @author Vaadin Ltd
 */
@Tag("vcf-breadcrumb")
@HtmlImport("frontend://bower_components/vcf-breadcrumbs/src/vcf-breadcrumb.html")
@NpmPackage(value = "@vaadin-component-factory/vcf-breadcrumb", version = "1.2.0")
@JsModule("@vaadin-component-factory/vcf-breadcrumb/src/vcf-breadcrumb.js")
public class Breadcrumb extends PolymerTemplate<Breadcrumb.BreadcrumbModel> {

    /**
     * Creates instance of Breadcrumb with text set
     *
     * @param text
     *              text of breadcrumb
     */
    public Breadcrumb(String text) {
        setText(text);
    }

    /**
     *
     * @param text
     *              text of breadcrumb
     * @param href
     *              URL or a URL fragment that the breadcrumb points to
     */
    public Breadcrumb(String text, String href) {
        this(text);
        setHref(href);
    }

    /**
     *
     * @param text
     *              text of breadcrumb
     * @param href
     *              URL or a URL fragment that the breadcrumb points to
     * @param shift
     *              indicates whether breadcrumb should be hidden for small viewport(hidden when set to true)
     */
    public Breadcrumb(String text, String href, boolean shift) {
        this(text, href);
        setShift(shift);
    }

    /**
     * Setting text of breadcrumb
     *
     * @param text
     *              text of breadcrumb
     */
    public void setText(String text) {
        getElement().setText(text);
    }

    /**
     * @return of breadcrumb
     */
    public String getText() {
        return getElement().getText();
    }

    /**
     * Setting shift parameter which indicates whether breadcrumb should be hidden for small viewport
     * Will be hidden when shift is set to true
     *
     * @param shift
     *              indicates whether breadcrumb should be hidden for small viewport(hidden when set to true)
     */
    public void setShift(boolean shift) {
        getModel().setShift(shift);
    }

    /**
     *  Getting shift parameter
     *
     * @return shift parameter
     */
    public boolean isShift() {
        return getModel().isShift();
    }

    /**
     * @return href of breadcrumb
     */
    public String getHref() {
        return getModel().getHref();
    }

    /**
     * Setting href for breadcrumb
     *
     * @param href
     *              URL or a URL fragment that the breadcrumb points to
     */
    public void setHref(String href) {
        getModel().setHref(href);
    }

    /**
     * This model binds properties between java(Breadcrumb) and polymer(vcf-breadcrumb.html)
     */
    public interface BreadcrumbModel extends TemplateModel {
        void setShift(boolean mobile);
        boolean isShift();

        void setHref(String href);
        String getHref();
    }
}
