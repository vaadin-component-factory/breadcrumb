package com.vaadin.componentfactory;

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

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;

/*
 * #%L
 * Vaadin Breadcrumb for Vaadin 10
 * %%
 * Copyright (C) 2017 - 2019 Vaadin Ltd
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
