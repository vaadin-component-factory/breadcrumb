package com.vaadin.componentfactory.demo;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("hello")
public class HelloWorldView extends HorizontalLayout {

  private TextField name;
  private Button sayHello;

  public HelloWorldView() {
    name = new TextField("Your name");
    sayHello = new Button("Say hello");
    sayHello.addClickListener(e -> {
      Notification.show("Hello " + name.getValue());
    });
    sayHello.addClickShortcut(Key.ENTER);

    setMargin(true);
    setVerticalComponentAlignment(Alignment.END, name, sayHello);

    add(name, sayHello);
  }
}
