package ui.screens;

import ui.GUI;
import ui.buttons.navigation.BackButton;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class Screen extends JFrame {
    protected JPanel pane;
    protected GUI gui;
    protected Object object;

    protected static final int WIDTH = 450;
    protected static final int HEIGHT = 600;
    protected static final int HORIZONTAL_GAP = 0;
    protected static final int VERTICAL_GAP = 10;
    protected static final int LABEL_WIDTH = WIDTH / 3;
    protected static final int ENTRY_WIDTH = WIDTH / 2;
    protected static final int TEXT_HEIGHT = HEIGHT / 21;
    protected Font font = new Font("Dialog", Font.PLAIN, 18);


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
        new BackButton(gui, pane, previousCard);
    }

    // EFFECTS: creates unmodifiable text box
    protected JEditorPane textBox(String entry) {
        JEditorPane label = new JEditorPane();
        label.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        label.setEditable(false);
        label.setText(entry);
        label.setFont(new Font("Dialog", Font.BOLD, 16));
        label.setPreferredSize(new Dimension(LABEL_WIDTH, TEXT_HEIGHT));
        return label;
    }

    // EFFECTS: creates user entry field
    protected JEditorPane entryField() {
        JEditorPane field = new JEditorPane();
        field.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        field.setPreferredSize(new Dimension(ENTRY_WIDTH, TEXT_HEIGHT));
        field.setFont(font);
        return field;
    }

    public JPanel getPane() {
        return pane;
    }
}
