package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    // create all buttons (Load, Save, etc.)
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");

    public ControlPanel(MainFrame frame) {
        System.out.println("ControlPanel");
        this.frame = frame;
        init();
    }

    private void init() {
        // change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        //add all buttons ...TODO
        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);
        //configure listeners for all buttons
        exitBtn.addActionListener(this::exitGame);
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        resetBtn.addActionListener(this::resetGame);
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void loadGame(ActionEvent e) {
        //...TODO
    }

    private void saveGame(ActionEvent e) {
        WritableImage writableImage = new WritableImage((int) canvasPaneId.getWidth(), (int) canvasPaneId.getHeight());
        this.canvasGroupRoot.snapshot(null, writableImage);

        File file = new File("image.png");
        // Convert the writable image to a buffered image
        java.awt.image.BufferedImage bufferedImage = SwingFXUtils.fromFXImage(writableImage, null);

        // Save the buffered image as a PNG file
        Platform.runLater(() -> {
            RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
            try {
                ImageIO.write(renderedImage, "png", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void resetGame(ActionEvent e) {
        //...TODO
    }

}