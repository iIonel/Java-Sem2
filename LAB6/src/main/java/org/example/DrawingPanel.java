package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {
    final static int W = 800, H = 600;
    final MainFrame frame;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;

    public DrawingPanel(MainFrame frame) {
        System.out.println("DrawingPanel");
        this.frame = frame;
        createOffscreenImage();
        initPanel();
        createBoard();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                createBoard();
                repaint();
            }
        });

    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }

    final void createBoard() {
        //System.out.println((Integer) this.frame.configPanel.dotsSpinner.getValue());
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        //numVertices = 20;
        edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();
        createOffscreenImage();
        createVertices();
        drawLines();
        drawVertices();
        repaint();
    }

    private void createVertices() {
        int x0 = W / 2;
        int y0 = H / 2; // middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = (int) (x0 + radius * Math.cos(alpha * i));
            y[i] = (int) (y0 + radius * Math.sin(alpha * i));
        }
    }

    private void drawLines() {
        //draw the lines
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < numVertices; i++)
            for (int j = i + 1; j < numVertices; j++)
                if (Math.random() < edgeProbability) graphics.drawLine(x[i], y[i], x[j], y[j]);
    }

    private void drawVertices() {
        //draw the vertices
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < numVertices; i++) {
            graphics.fillOval(x[i] - 7, y[i] - 7, 15, 15);
            graphics.drawString(String.valueOf(i), x[i] - 8, y[i] - 8); //draw the vertex number, TODO: try to print the number outside the vertex
        }
    }

    public void changeDim() {
        System.out.println("changeDim");
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();
        createOffscreenImage();
        createBoard();
    }

    @Override
    public void update(Graphics g) {
    } //no need for update

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

}