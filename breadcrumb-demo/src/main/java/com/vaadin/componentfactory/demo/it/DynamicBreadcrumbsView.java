package com.vaadin.componentfactory.demo.it;

import static com.vaadin.componentfactory.demo.it.TestBreadcrumbs.link;

import com.vaadin.componentfactory.Breadcrumb;
import com.vaadin.componentfactory.Breadcrumbs;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * Exercises the server-side API after the initial render: adding and removing items, and changing
 * text, href and collapse on an item that is already attached.
 */
@Route("test/dynamic")
public class DynamicBreadcrumbsView extends VerticalLayout {

  private final Breadcrumbs breadcrumbs;
  private final Breadcrumb middle = link("middle", "Middle", "test/dynamic");
  private final Breadcrumb current = TestBreadcrumbs.current("current", "Current");
  private int added;

  public DynamicBreadcrumbsView() {
    breadcrumbs = new Breadcrumbs(link("home", "Home", "hello"), middle, current);
    breadcrumbs.setId("breadcrumbs");
    breadcrumbs.setMaxWidth("600px");

    // Inserted before the current item, which is where a new trail segment really belongs.
    Button add = new Button("Add", e -> {
      added++;
      breadcrumbs.addComponentAtIndex(breadcrumbs.getComponentCount() - 1,
          link("added-" + added, "Added " + added, "test/dynamic"));
    });
    add.setId("add");

    Button removeLast = new Button("Remove last", e -> {
      int count = breadcrumbs.getComponentCount();
      if (count > 0) {
        breadcrumbs.remove(breadcrumbs.getComponentAt(count - 1));
      }
    });
    removeLast.setId("remove-last");

    Button removeAll = new Button("Remove all", e -> breadcrumbs.removeAll());
    removeAll.setId("remove-all");

    Button rename = new Button("Rename middle", e -> middle.setText("Renamed"));
    rename.setId("rename");

    Button setHref = new Button("Link current", e -> current.setHref("hello"));
    setHref.setId("set-href");

    Button toggleCollapse =
        new Button("Toggle collapse", e -> middle.setCollapse(!middle.getCollapse()));
    toggleCollapse.setId("toggle-collapse");

    Button narrow = new Button("Narrow", e -> breadcrumbs.setMaxWidth("150px"));
    narrow.setId("narrow");

    add(breadcrumbs,
        new HorizontalLayout(add, removeLast, removeAll),
        new HorizontalLayout(rename, setHref, toggleCollapse, narrow));
  }
}
