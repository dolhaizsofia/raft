package main;

import palya.Palya;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

import static javax.imageio.ImageIO.read;
import static javax.swing.BorderFactory.createEmptyBorder;
import static javax.swing.BorderFactory.createLineBorder;

class Board extends JFrame {

    private Palya palya;
    private JPanel centerPanel = new JPanel();
    private ImagePanel[] panels;

    Board(Palya palya) {
        this.palya = palya;
        panels = new ImagePanel[palya.getTabla().length * palya.getTabla()[0].length];
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        setTitle("Chess board example");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        draw(getContentPane());
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void draw(Container contentPane) {
        centerPanel.removeAll();
        GridLayout gridLayout = new GridLayout(palya.getTabla().length, palya.getTabla()[0].length);
        centerPanel.setLayout(gridLayout);
        centerPanel.setBorder(createEmptyBorder(2, 2, 2, 2));

        //call method to add panels and labels to the center panel which holds the board
        addPanelsAndLabels();
        //add all panels to frame
        contentPane.add(centerPanel, BorderLayout.CENTER);
    }

    public void addPanelsAndLabels() {
        addPanelsAndImages();
        for (int i = 0; i < panels.length; i++) {
            centerPanel.add(panels[i]);
        }
//        centerPanel.repaint();
        centerPanel.revalidate();
    }

    private void addPanelsAndImages() {
        int count = 0;

        for (int row = 0; row < palya.getTabla().length; row++) {
            for (int col = 0; col < palya.getTabla()[0].length; col++) {
                ImagePanel imagePanel = new ImagePanel(palya.getTabla()[row][col].getJatekElem().getImageName());
                imagePanel.setBorder(createLineBorder(Color.BLACK));
                panels[count] = imagePanel;
                count++;
            }
        }
    }

    //nested class used to set the background of frame contenPane
    class ImagePanel extends JPanel {

        private Image image;

        ImagePanel(String fileName) {
            try {
                image = read(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(fileName + ".png")).toURI()));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            g.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
        }
    }
}
