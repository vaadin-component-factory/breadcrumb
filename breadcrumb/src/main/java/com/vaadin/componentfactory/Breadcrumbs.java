/*
 * #%L
 * Breadcrumb Component
 * %%
 * Copyright (C) 2018 - 2025 Vaadin Ltd
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

import com.vaadin.flow.component.HasOrderedComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.littemplate.LitTemplate;

/**
 * Server-side component for the <code>vcf-breadcrumbs</code> element. An easy way to display
 * breadcrumb on web pages. This component is container for Breadcrumb components
 *
 * @author Vaadin Ltd
 */
@SuppressWarnings("serial")
@Tag("vcf-breadcrumbs")
@NpmPackage(value = "@vaadin-component-factory/vcf-breadcrumb", version = "2.2.0")
@JsModule("@vaadin-component-factory/vcf-breadcrumb/dist/src/vcf-breadcrumbs.js")
public class Breadcrumbs extends LitTemplate implements HasOrderedComponents, HasSize {

  /**
   * Creates instance of Breadcrumbs as container for breadcrumbs which are passed as param
   *
   * @param breadcrumbs brick components of breadcrumbs component
   */
  public Breadcrumbs(Breadcrumb... breadcrumbs) {
    add(breadcrumbs);
  }

  /**
   * Sets whether the component should force mobile mode, regardless of the current screen size or
   * media query state.
   * <p>
   * This allows programmatic control over mobile styling, for example when the application uses its
   * own logic to detect mobile devices.
   *
   * @param forceMobileMode {@code true} to enable mobile mode manually; {@code false} to disable it
   */
  public void setForceMobileMode(boolean forceMobileMode) {
    getElement().setProperty("forceMobileMode", forceMobileMode);
  }

  /**
   * Returns whether mobile mode has been forced programmatically.
   *
   * @return {@code true} if mobile mode is enabled, {@code false} otherwise
   */
  public boolean isForceMobileMode() {
    return getElement().getProperty("forceMobileMode", false);
  }
  
}
