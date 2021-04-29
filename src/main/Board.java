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
    private JPanel southPanel = new JPanel();
    private JPanel westPanel = new JPanel();
    private JTextArea magyarazat = new JTextArea();
    private Label korokSzamaLabel = new Label();
    private Label szomjusagLabel = new Label();
    private Label ehsegLabel = new Label();
    private Label holmikLabel = new Label();
    private ImagePanel[] panels;

    Board(Palya palya) {
        this.palya = palya;
        panels = new ImagePanel[palya.getTabla().length * palya.getTabla()[0].length];
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        setTitle("Raft");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container container = getContentPane();
        southPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        southPanel.add(korokSzamaLabel, gbc);
        southPanel.add(szomjusagLabel, gbc);
        southPanel.add(ehsegLabel, gbc);
        southPanel.add(holmikLabel, gbc);
        westPanel.add(magyarazat);
        magyarazat.setText("mozgas: szamok (kiveve 5)\n" +
                "\n" +
                "Parancsok irannyal:\n" +
                "nyersanyag felvetele: 1\n" +
                "halo lehelyezese: 2\n" +
                "viztisztito lehelyezese: 3\n" +
                "tuzhely lehelyezese: 4\n" +
                "bovites: 5\n" +
                "\n" +
                "Irany nelkuli parancsok:\n" +
                "ivas: 90\n" +
                "hal evese: 91\n" +
                "burgonya evese: 92\n" +
                "horgaszat: 93\n" +
                "hal sutese: 94\n" +
                "burgonya sutese: 95");
        magyarazat.setEnabled(false);
        container.add(southPanel, BorderLayout.SOUTH);
        container.add(westPanel, BorderLayout.WEST);
        draw(container, new VisszaJelzes());
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void draw(Container contentPane, VisszaJelzes visszaJelzes) {
        korokSzamaLabel.setText(visszaJelzes.getKorokSzama());
        szomjusagLabel.setText(visszaJelzes.getSzomjusag());
        ehsegLabel.setText(visszaJelzes.getEhseg());
        holmikLabel.setText(visszaJelzes.getHolmik());
        GridLayout gridLayout = new GridLayout(palya.getTabla().length, palya.getTabla()[0].length);
        centerPanel.setLayout(gridLayout);
        centerPanel.setBorder(createEmptyBorder(2, 2, 2, 2));

        centerPanel.removeAll();

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
        centerPanel.revalidate();
    }

    private void addPanelsAndImages() {
        int count = 0;

        for (int row = 0; row < palya.getTabla().length; row++) {
            for (int col = 0; col < palya.getTabla()[0].length; col++) {
                ImagePanel imagePanel = new ImagePanel(palya.getTabla()[row][col].getLegfelso().tipus());
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
