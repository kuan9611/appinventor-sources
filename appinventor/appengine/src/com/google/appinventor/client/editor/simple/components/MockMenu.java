package com.google.appinventor.client.editor.simple.components;

import com.google.appinventor.client.editor.simple.SimpleEditor;
import com.google.appinventor.client.editor.simple.palette.SimplePaletteItem;
import com.google.appinventor.client.widgets.dnd.DragSource;
import com.google.appinventor.components.common.ComponentConstants;
import com.google.gwt.user.client.ui.AbsolutePanel;

public final class MockMenu extends MockContainer {
  public static final String TYPE = "Menu";
  private AbsolutePanel menuWidget;

  // whether the mock menu is opened or closed
  private boolean open;

  /**
   * Creates a new MockMenu component.
   *
   * @param editor  editor of source file the component belongs to
   */
  public MockMenu(SimpleEditor editor) {
    super(editor, TYPE, images.listpicker(), new MockHVLayout(ComponentConstants.LAYOUT_ORIENTATION_VERTICAL));

    rootPanel.setHeight("100%");
    menuWidget = new AbsolutePanel();
    menuWidget.setStylePrimaryName("ode-SimpleMockMenu");
    menuWidget.add(rootPanel);

    initComponent(menuWidget);
  }

  @Override
  public boolean isMenu() {
    return true;
  }

  @Override
  protected boolean acceptableSource(DragSource source) {
    MockComponent component = null;
    if (source instanceof MockComponent) {
      component = (MockComponent) source;
    } else if (source instanceof SimplePaletteItem) {
      component = (MockComponent) source.getDragWidget();
    }
    return component instanceof MockMenuItem;
  }

  /**
   * Whether the menu is shown in designer.
   *
   * @return {@code true} iff menu is visible
   */
  public boolean isOpen() {
    return open;
  }

  /**
   * Toggle (open or close) the mock menu.
   */
  public void toggle() {
    open = !open;
    refreshForm();
  }

}
