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

## Updates since version 4.0.1
- Vaadin 25.2+ support (platform updated from 25.0.0 to 25.2.6).
- Playwright integration tests added; see [Integration tests](#integration-tests).
- Web component updated to [3.0.4](https://github.com/vaadin-component-factory/vcf-breadcrumb/releases/tag/v3.0.4).
  `setForceMobileMode()` now takes effect on an already-rendered component; previously the flag was
  only honoured when set before the component was attached.
  (3.0.3 was skipped: in mobile mode it left the current page item visible, because its extra
  relayout ran before the items had set `aria-current="page"`, leaving a stale
  `is-last-not-current` class.)

## Updates since version 4.0.0
- Vaadin 25.0+ support.
- Web component updated to [3.0.1](https://github.com/vaadin-component-factory/vcf-breadcrumb/releases/tag/v3.0.1)
  (Lit-based v3 line, rebuilt for Vaadin 25).

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
To run demo go to `breadcrumb-demo/` subfolder and run `mvn jetty:run`.
After server startup, you'll be able find demo at [http://localhost:8080/breadcrumbs](http://localhost:8080/breadcrumbs)

## Integration tests

The add-on is covered by [Playwright for Java](https://playwright.dev/java/) integration tests that
drive a real browser against the demo application. Run them from the repository root with:

```
mvn verify -Pit
```

The `it` profile builds the frontend in production mode, starts Jetty on port 8081, runs the tests
and stops Jetty again, so no server needs to be running beforehand. Chromium is downloaded
automatically on the first run and cached in `~/.cache/ms-playwright`
(`~/Library/Caches/ms-playwright` on macOS).

Useful options:

| Option | Effect |
| --- | --- |
| `-Dit.headed=true` | run in a visible browser window instead of headless |
| `-Dit.test=CollapseBreadcrumbsIT` | run a single test class |
| `-Dit.port=9090` | use a different HTTP port |
| `-Dit.excludedGroups=` | also run `KnownIssuesIT` (see below) |

On failure a Playwright trace is kept under `breadcrumb-demo/target/playwright/`; inspect it with
`npx playwright show-trace <trace.zip>`.

The tests drive dedicated views under `test/…` (`test/basic`, `test/collapse`, `test/mobile`,
`test/mobile-forced`, `test/dynamic`) rather than the demo page, so that every element has a stable
id. They live in `breadcrumb-demo/src/main/java/com/vaadin/componentfactory/demo/it/`. `DemoPageIT`
additionally smoke-tests the demo page itself.

> **Note:** Vaadin runs npm with `--min-release-age=1`, so a web component version published less
> than a day ago cannot be installed and the build fails with `ETARGET ... no matching version found
> with a date before <yesterday>`. Until the pinned version is a day old, add
> `-Dvaadin.npm.minimumFrontendPackageAgeDays=0`.

> **Note:** the `it` profile sets `forceProductionBuild`. Vaadin decides whether the production
> bundle needs rebuilding by looking at npm dependencies, themes and CSS - not at Flow route chunks.
> Without forcing the build, a newly added `@Route` gets no chunk in the packaged bundle, and because
> `Flow.loadOnDemand()` ignores unknown chunk keys, the route renders with its web components never
> upgraded and no error reported anywhere.

### Known issues

`KnownIssuesIT` reproduces defects that exist in web component 3.0.4. It is tagged
`known-issue` and excluded from `mvn verify -Pit` so the suite stays a usable regression signal. Run
it deliberately with:

```
mvn verify -Pit -Dit.excludedGroups= -Dit.test=KnownIssuesIT
```

Both come from the same root cause: `vcf-breadcrumb` builds its anchor once, in `firstUpdated()`, and
nothing re-syncs the anchor when a property changes afterwards.

- `Breadcrumb.setHref()` after the first render updates the host property and attribute, but not the
  generated anchor, so the item never becomes clickable.
- `Breadcrumb.setText()` after the first render replaces every child node of the host, including the
  generated anchor. The new label shows, but the item silently stops being a link.

## License & Author

This Add-on is distributed under Apache 2.0.

Breadcrumb component is written by Vaadin Ltd.

### Sponsored development
Major pieces of development of this add-on has been sponsored by multiple customers of Vaadin. Read more  about Expert on Demand at: [Support](https://vaadin.com/support) and  [Pricing](https://vaadin.com/pricing)
