package ui.screens;

import model.Workout;
import ui.GUI;
import ui.buttons.BackButton;

import javax.swing.*;

public abstract class Screen extends JFrame {
    JPanel pane;
    GUI gui;
    Object object;
    String cardName;

    public Screen(GUI gui, Object object, String cardName) {
        pane = new JPanel();
        this.gui = gui;
        this.object = object;
        this.cardName = cardName;
        initializePane();
    }

    protected void initializePane() {
        pane.setSize(gui.getScreenWidth(), gui.getScreenHeight());
        gui.getContainer().add(this.getPane(), cardName);
    }

    // MODIFIES: parent
    // EFFECTS: adds scroll pane to parent
    protected JScrollPane createScrollPane(JComponent parent) {
        return new JScrollPane(parent,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    }

    protected void createBackButton(String previousCard) {
        new BackButton(gui, pane, gui.getWorkoutSet(), previousCard);
    }

    public JPanel getPane() {
        return pane;
    }
}
