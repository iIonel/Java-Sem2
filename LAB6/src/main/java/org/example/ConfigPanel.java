package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;
    private int numVertices;
    private double edgeProbability;

    public ConfigPanel(MainFrame frame) {
        System.out.println("ConfigPanel");
        this.frame = frame;
        init();
    }

    private void init() {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        // create the rest of the components
        linesLabel = new JLabel("Edge Probability");
        linesCombo = new JComboBox(new Double[]{0.5, 0.6, 0.7, 0.8, 0.9, 1.0});
        createButton = new JButton("Create");
        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);

        //configure listeners for all components
        createButton.addActionListener(this::createGame);
    }

    private void createGame(ActionEvent e) {
        numVertices = (Integer) dotsSpinner.getValue();
        edgeProbability = (Double) linesCombo.getSelectedItem();
        frame.canvas.changeDim();
    }
}