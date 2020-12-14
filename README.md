# Component Factory Breadcrumb for Vaadin 10+
Breadcrumb is Java API for [<vcf-breadcrumbs>](https://github.com/vaadin-component-factory/vcf-breadcrumb) web component for Vaadin 10. 
It provides an easy way to display breadcrumb on web pages.

[Live Demo ↗](https://incubator.app.fi/breadcrumb-demo/breadcrumbs)

[<img src="https://raw.githubusercontent.com/vaadin/incubator-breadcrumb/master/screenshot.png" width="400" alt="Screenshot of incubator-breadcrumbs">](https://vaadin.com/directory/components/vaadinincubator-breadcrumbs)


## Usage
Create instance of `Breadcrumbs` and instances of `Breadcrumb`. You can set breadcrumb text and href. 
Also you can set property shift, which will indicate whether breadcrumb should be hidden for 
mobile view(when viewport is smaller then 420px).
```
Breadcrumbs breadcrumbs = new Breadcrumbs();
breadcrumbs.add(
    new Breadcrumb("Home","breadcrumbs/#", true),
    new Breadcrumb("Components", "breadcrumbs/#", true),
    new Breadcrumb("VCF Components", "breadcrumbs/#"),
    new Breadcrumb("Breadcrumbs"));
```
Breadcrumbs "Home" and "Components" will be hidden when viewport is less then 420px  


## Setting up for development:
Clone the project in GitHub (or fork it if you plan on contributing)

```
https://github.com/vaadin-component-factory/vcf-breadcrumb
```

To build and install the project into the local repository run 

```mvn install ```

## Demo
To run demo go to `breadcrumbs-demo/` subfolder and run `mvn jetty:run`.
After server startup, you'll be able find demo at [http://localhost:8080/breadcrumbs](http://localhost:8080/breadcrumbs)


## License & Author

This Add-on is distributed under Apache 2.0

Component Factory Breadcrumb is written by Vaadin Ltd.

### Sponsored development
Major pieces of development of this add-on has been sponsored by multiple customers of Vaadin. Read more  about Expert on Demand at: [Support](https://vaadin.com/support) and  [Pricing](https://vaadin.com/pricing)
