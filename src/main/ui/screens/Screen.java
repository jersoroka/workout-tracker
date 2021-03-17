package ui.screens;

import model.Workout;
import ui.GUI;
import ui.buttons.BackButton;

import javax.swing.*;

public class Screen extends JFrame {
    protected JPanel pane;
    protected GUI gui;
    protected Object object;

    protected static final int WIDTH = 2000;
    protected static final int HEIGHT = 1600;
    protected static final int HORIZONTAL_GAP = 0;
    protected static final int VERTICAL_GAP = 10;


    public Screen(GUI gui, Object object) {
        pane = new JPanel();
        this.gui = gui;
        this.object = object;
        initializePane();
    }

    protected void initializePane() {
        pane.setSize(WIDTH, HEIGHT);
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
