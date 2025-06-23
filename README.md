# Component Factory Breadcrumb for Vaadin Flow
Breadcrumb is the Java API for [`<vcf-breadcrumb>`](https://github.com/vaadin-component-factory/vcf-breadcrumb) web component for Vaadin Flow. 
It provides an easy way to display breadcrumb on web pages.

## Usage
Create instance of `Breadcrumbs` and instances of `Breadcrumb`. You can set breadcrumb `text` and `href`. 
Also you can set property `collpase`, which will indicate whether breadcrumb should collapse when there's no enough space to display in full.
```
Breadcrumbs breadcrumbs = new Breadcrumbs();
breadcrumbs.add(
    new Breadcrumb("Home","breadcrumbs/#"),
    new Breadcrumb("Directory","breadcrumbs/#"),
    new Breadcrumb("Components", "breadcrumbs/#", true),
    new Breadcrumb("VCF Components", "breadcrumbs/#", true),
    new Breadcrumb("Breadcrumbs"));
```
Breadcrumbs "Components" && "VCF Components" will collapse and show ellipsis when space available for display is not wide enough.

![breadcrumbs-01](https://github.com/user-attachments/assets/82ab0cd5-60cc-47e6-936a-0af8c7479e8e)
![breadcrumbs-02](https://github.com/user-attachments/assets/ed7b09bf-8dac-4212-bf4b-6c250c20fb93)
![breadcrumbs-03](https://github.com/user-attachments/assets/1e6ebd84-4b44-4532-ac48-0a5e04573c83)

## Updates since version 3.0.0
- Vaadin 24.5+ support.
- Web component part (version 2.0.0) is now Lit based.
- The first item in the breadcrumb is always shown in full.
- The items can be collapsed when space runs out. This is configurable by using the attribute `collapse`. When availabe space is not enough to display the full label, then the label is shown with ellipsis.
- If space is even more limited, and some breadcrumbs have the `collapse` attribute:
    - Consecutive collapsed items are grouped into ranges.
    - Each range is hidden when necessary and replaced with an ellipsis element.
- `shift` attribute from previous version was removed. Responsive behavior is now given by the `collapse` attribute implementation.

## Updates since version 3.1.0

- Update web component version to [2.1.0](https://github.com/vaadin-component-factory/vcf-breadcrumb/releases/tag/v2.1.0). This version includes new feature to display a popover showing the hidden (collapsible) breadcrumbs items on ellipsis element when space is not enough to display all breadcrumbs.

## Updates since version 3.2.0

- Update web component version to [2.2.0](https://github.com/vaadin-component-factory/vcf-breadcrumb/releases/tag/v2.2.0). This version adds support for [Mobile Mode](https://github.com/vaadin-component-factory/vcf-breadcrumb/issues/6), which can be triggered in two ways:
	- Based on a fixed breakpoint (same as other Vaadin components): `(max-width: 450px), (max-height: 450px)` or
	- Programmatically, using the flag `forceMobileMode`, which allows to enable mobile layout manually

![breadcrumbs-mobile-mode](https://github.com/user-attachments/assets/1c555264-944a-4134-83d2-6b47e0c32610)

## Setting up for development:
Clone the project in GitHub (or fork it if you plan on contributing)
```
https://github.com/vaadin-component-factory/breadcrumb
```
To build and install the project into the local repository run 
```mvn install ```

## Demo
To run demo go to `breadcrumbs-demo/` subfolder and run `mvn jetty:run`.
After server startup, you'll be able find demo at [http://localhost:8080/breadcrumbs](http://localhost:8080/breadcrumbs)

## License & Author

This Add-on is distributed under Apache 2.0.

Breadcrumb component is written by Vaadin Ltd.

### Sponsored development
Major pieces of development of this add-on has been sponsored by multiple customers of Vaadin. Read more  about Expert on Demand at: [Support](https://vaadin.com/support) and  [Pricing](https://vaadin.com/pricing)
