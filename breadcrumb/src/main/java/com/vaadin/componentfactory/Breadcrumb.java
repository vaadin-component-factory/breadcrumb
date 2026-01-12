/*
 * #%L
 * Breadcrumb Component
 * %%
 * Copyright (C) 2018 - 2026 Vaadin Ltd
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
package com.vaadin.componentfactory;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.littemplate.LitTemplate;

/**
 * Server-side component for the <code>vcf-breadcrumb</code> element.
 *
 * @author Vaadin Ltd
 */
@Tag("vcf-breadcrumb")
@NpmPackage(value = "@vaadin-component-factory/vcf-breadcrumb", version = "3.0.0")
@JsModule("@vaadin-component-factory/vcf-breadcrumb/dist/src/vcf-breadcrumbs.js")
public class Breadcrumb extends LitTemplate {

  /**
   * Creates instance of Breadcrumb with text set.
   *
   * @param text text of breadcrumb
   */
  public Breadcrumb(String text) {
    setText(text);
  }

  /**
   * Creates instance of Breadcrumb with text and href defined.
   *
   * @param text text of breadcrumb
   * @param href URL or a URL fragment that the breadcrumb points to
   */
  public Breadcrumb(String text, String href) {
    this(text);
    setHref(href);
  }

  /**
   * Creates an instance of Breadcrumb with text, href and collapse option defined.
   * 
   * @param text text of breadcrumb
   * @param href URL or a URL fragment that the breadcrumb points to
   * @param collapse true to make the breadcrumb collapsible
   */
  public Breadcrumb(String text, String href, boolean collapse) {
    this(text, href);
    setCollapse(collapse);
  }

  /**
   * Setting text of breadcrumb
   *
   * @param text text of breadcrumb
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
   * @return href of breadcrumb
   */
  public String getHref() {
    return getElement().getProperty("href");
  }

  /**
   * Setting href for breadcrumb
   *
   * @param href URL or a URL fragment that the breadcrumb points to
   */
  public void setHref(String href) {
    getElement().setProperty("href", href);
  }

  /**
   * Gets wheter the breadcrumb is collapsible or not.
   * 
   * @return collapse value of breadcrumb
   */
  public boolean getCollapse() {
    return getElement().getProperty("collapse", false);
  }

  /**
   * Setting collapse "true" to indicate breadcrumb is collapsible This means that the breadcrumb
   * will srink and show its label with ellipsis when the space available is not enough to display
   * it completely.
   * 
   * @param collapse true to make the breadcrumb collapsible
   */
  public void setCollapse(boolean collapse) {
    getElement().setProperty("collapse", collapse);
  }

}
