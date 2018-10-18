package com.vaadin.flow.component.incubator;

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
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;

/**
 * Server-side component for the <code>incubator-breadcrumb</code> element.
 *
 * @author Vaadin Ltd
 */
@Tag("incubator-breadcrumb")
@HtmlImport("frontend://bower_components/incubator-breadcrumbs/src/incubator-breadcrumb.html")
public class Breadcrumb extends PolymerTemplate<Breadcrumb.BreadcrumbModel> {

    public Breadcrumb() {
    }

    public Breadcrumb(String text) {
        setText(text);
    }

    public Breadcrumb(String text, String href) {
        this(text);
        setHref(href);
    }

    public Breadcrumb(String text, String href, boolean shift) {
        this(text, href);
        setShift(shift);
    }

    /**
     * Setting text of breadcrumb
     *
     * @param text
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
     * Setting shift parameter
     *
     * @param shift
     */
    public void setShift(boolean shift) {
        getModel().setShift(shift);
    }

    /**
     *  Getting shift parameter
     *
     * @return strength indication
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
     */
    public void setHref(String href) {
        getModel().setHref(href);
    }

    /**
     * This model binds properties between java(Breadcrumb) and polymer(incubator-breadcrumb.html)
     */
    public interface BreadcrumbModel extends TemplateModel {
        void setShift(boolean mobile);
        boolean isShift();

        void setHref(String href);
        String getHref();
    }
}
