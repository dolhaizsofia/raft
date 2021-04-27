package main;

import palya.Palya;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static javax.imageio.ImageIO.read;
import static javax.swing.BorderFactory.createEmptyBorder;
import static javax.swing.BorderFactory.createLineBorder;

public class Board extends JFrame {

    //intialize variables
   private Palya palya;
    //intialize components
    private JPanel centerPanel = new JPanel();
    //initialze arrays to hold panels and images of the board
    private ImagePanel[] panels = new ImagePanel[35 * 25];

    public Board(Palya palya) {
        this.palya = palya;
        createAndShowGUI();//call method to create gui
    }

    private void createAndShowGUI() {
        setTitle("Chess board example");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addComponentsToPane(getContentPane());

        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Adds all the necessary components to the content pane of the JFrame, and
     * adds appropriate listeners to components.
     */
    public void addComponentsToPane(Container contentPane) {
        centerPanel.removeAll();
        GridLayout gridLayout = new GridLayout(25, 35);
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
                image = read(new File(getClass().getClassLoader().getResource(fileName + ".png").toURI()));
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
