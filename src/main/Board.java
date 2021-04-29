package main;

import palya.Jatekos;
import palya.Palya;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static io.FileHandler.loadGame;
import static io.FileHandler.saveGame;
import static java.util.Objects.requireNonNull;
import static javax.imageio.ImageIO.read;
import static javax.swing.BorderFactory.createEmptyBorder;
import static javax.swing.BorderFactory.createLineBorder;
import static javax.swing.BoxLayout.Y_AXIS;

public class Board extends JFrame {

    private Palya palya;
    private JPanel centerPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    private JPanel westPanel = new JPanel();
    private JPanel eastPanel = new JPanel();
    private JTextArea magyarazat = new JTextArea();
    private Label korokSzamaLabel = new Label();
    private Label szomjusagLabel = new Label();
    private Label ehsegLabel = new Label();
    private Label holmikLabel = new Label();
    private JButton saveButton = new JButton("mentes");
    private JButton loadButton = new JButton("betoltes");
    private ImagePanel[] panels;

    Board(Palya palya) {
        this.palya = palya;
        panels = new ImagePanel[palya.getTabla().length * palya.getTabla()[0].length];
        createAndShowGUI();
    }

    /**
     * GUI-t csinal
     */
    private void createAndShowGUI() {
        setTitle("Raft");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        Container container = getContentPane();
        southPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        southPanel.add(korokSzamaLabel, gbc);
        southPanel.add(szomjusagLabel, gbc);
        southPanel.add(ehsegLabel, gbc);
        southPanel.add(holmikLabel, gbc);
        eastPanel.setLayout(new BoxLayout(eastPanel, Y_AXIS));
        westPanel.add(magyarazat);
        eastPanel.add(new Box.Filler(new Dimension(10, 10), new Dimension(10, 10), new Dimension(10, 10)));
        eastPanel.add(saveButton);
        eastPanel.add(new Box.Filler(new Dimension(10, 10), new Dimension(10, 10), new Dimension(10, 10)));
        eastPanel.add(loadButton);
        saveButton.addActionListener(e -> saveGame(this, palya));
        loadButton.addActionListener(e -> loadGame(this, palya));
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
        container.add(eastPanel, BorderLayout.EAST);
        draw(container);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * kirajzolja a jatekos ertekeit
     * @param contentPane
     */
    public void draw(Container contentPane) {
        Jatekos jatekos = palya.getJatekos();
        korokSzamaLabel.setText(jatekos.getFormazottCselekvesSzamlalo());
        szomjusagLabel.setText(jatekos.getFormazottSzomjusag());
        ehsegLabel.setText(jatekos.getFormazottEhseg());
        holmikLabel.setText(jatekos.getFormazottHolmik());
        GridLayout gridLayout = new GridLayout(palya.getTabla().length, palya.getTabla()[0].length);
        centerPanel.setLayout(gridLayout);
        centerPanel.setBorder(createEmptyBorder(2, 2, 2, 2));
        centerPanel.removeAll();
        addPanelsAndLabels();
        contentPane.add(centerPanel, BorderLayout.CENTER);
    }

    private void addPanelsAndLabels() {
        addPanelsAndImages();
        for (ImagePanel panel : panels) {
            centerPanel.add(panel);
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

    static class ImagePanel extends JPanel {

        private Image image;

        ImagePanel(String fileName) {
            try {
                image = read(new File(requireNonNull(getClass().getClassLoader().getResource(fileName + ".png")).toURI()));
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
