package ui.screens;

import model.Workout;
import ui.GUI;

import javax.swing.*;

public abstract class Screen {
    JPanel pane;
    GUI gui;
    Object object;

    public Screen(GUI gui, Object object) {
        pane = new JPanel();
        this.gui = gui;
        this.object = object;
    }

    protected void initializePane() {
        pane.setSize(gui.getScreenWidth(), gui.getScreenHeight());
    }

    protected abstract void createBackButton();

    public JPanel getPane() {
        return pane;
    }
}
