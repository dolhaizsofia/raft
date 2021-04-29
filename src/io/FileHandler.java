package io;

import main.Tabla;
import palya.elemek.nyersanyag.Deszka;
import palya.elemek.nyersanyag.Hordo;
import palya.elemek.nyersanyag.Hulladek;
import palya.elemek.nyersanyag.Level;
import palya.*;
import palya.elemek.Capa;
import palya.elemek.Fold;
import palya.elemek.Jatekos;
import palya.elemek.Tenger;
import termek.Halo;
import termek.Tuz;
import termek.Viztisztito;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import static java.lang.Integer.parseInt;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.SwingUtilities.invokeLater;
import static palya.elemek.nyersanyag.Deszka.DESZKA_TIPUS;
import static palya.elemek.nyersanyag.Hordo.HORDO_TIPUS;
import static palya.elemek.nyersanyag.Hulladek.HULLADEK_TIPUS;
import static palya.elemek.nyersanyag.Level.LEVEL_TIPUS;
import static palya.elemek.Capa.CAPA_TIPUS;
import static palya.elemek.Fold.FOLD_TIPUS;
import static palya.elemek.Jatekos.JATEKOS_TIPUS;
import static termek.Burgonya.BURGONYA_TIPUS;
import static termek.Hal.HAL_TIPUS;
import static termek.Halo.HALO_TIPUS;
import static termek.Tuz.TUZ_TIPUS;
import static termek.Viztisztito.VIZ_TISZTITO_TIPUS;

public class FileHandler {

    private FileHandler() {
    }

    public static void loadGame(Tabla tabla, Palya palya) {
        openFileChooser(tabla, false).ifPresent(filePath -> {
            try {
                load(filePath, palya);
                invokeLater(() -> tabla.draw(tabla));
            } catch (IOException e) {
                e.printStackTrace();
                showMessageDialog(null, "File not found!", "warning", ERROR_MESSAGE);
            }
        });
    }

    private static void load(String fileName, Palya palya) throws IOException {
        Jatekos jatekos = palya.getJatekos();
        palya.letorol();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String sor = br.readLine();
            String[] jatekosMezok = sor.split(" ");
            jatekos.setCselekvesSzamlalo(parseInt(jatekosMezok[0]));
            jatekos.setEhseg(parseInt(jatekosMezok[1]));
            jatekos.setSzomjusag(parseInt(jatekosMezok[2]));
            jatekos.getHolmik().put(DESZKA_TIPUS, parseInt(jatekosMezok[3]));
            jatekos.getHolmik().put(LEVEL_TIPUS, parseInt(jatekosMezok[4]));
            jatekos.getHolmik().put(HULLADEK_TIPUS, parseInt(jatekosMezok[5]));
            jatekos.getHolmik().put(BURGONYA_TIPUS, parseInt(jatekosMezok[6]));
            jatekos.getHolmik().put(HAL_TIPUS, parseInt(jatekosMezok[7]));

            int i = 0;
            while ((sor = br.readLine()) != null) {
                String[] mezok = sor.split(" ");
                for (int j = 0; j < mezok.length; j++) {
                    Mezo m = new Mezo();
                    for (String jatekElem : mezok[j].split(";")) {
                        m.lehelyez(nevhezJatekElem(jatekElem, jatekos));
                    }
                    palya.getTabla()[i][j] = m;
                }
                i++;
            }
        }
    }

    public static void saveGame(JFrame f, Palya palya) {
        openFileChooser(f, true).ifPresent(filePath -> {
            try {
                save(filePath + ".rft", palya);
            } catch (IOException e) {
                e.printStackTrace();
                showMessageDialog(null, "File not found!", "warning", ERROR_MESSAGE);
            }
        });
    }

    private static void save(String fileName, Palya palya) throws IOException {
        Mezo[][] tabla = palya.getTabla();
        Jatekos jatekos = palya.getJatekos();
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(jatekos.getCselekvesSzamlalo() + " ");
            fw.write(jatekos.getEhseg() + " ");
            fw.write(jatekos.getSzomjusag() + " ");
            for (Map.Entry<String, Integer> entry : jatekos.getHolmik().entrySet()) {
                fw.write(entry.getValue() + " ");
            }
            fw.write("\n");
            for (Mezo[] mezos : tabla) {
                for (Mezo mezo : mezos) {
                    for (int k = 0; k < mezo.getElemek().size(); k++) {
                        fw.write(mezo.getElemek().get(k).tipus());
                        if (k < mezo.getElemek().size() - 1) {
                            fw.write(";");
                        }
                    }
                    fw.write(" ");
                }
                fw.write("\n");
            }
        }
    }

    private static Optional<String> openFileChooser(JFrame f, boolean save) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("raft file extention", "rft"));
        int returnVal = save ? chooser.showSaveDialog(f) : chooser.showOpenDialog(f);
        if (returnVal == JFileChooser.APPROVE_OPTION)
            return of(chooser.getSelectedFile().getAbsolutePath());
        return empty();
    }

    private static JatekElem nevhezJatekElem(String nev, Jatekos jatekos) {
        switch (nev) {
            case FOLD_TIPUS:
                return new Fold();
            case CAPA_TIPUS:
                return new Capa();
            case JATEKOS_TIPUS:
                return jatekos; // ne csinalj uj jatekost
            case LEVEL_TIPUS:
                return new Level();
            case HORDO_TIPUS:
                return new Hordo();
            case HULLADEK_TIPUS:
                return new Hulladek();
            case DESZKA_TIPUS:
                return new Deszka();
            case HALO_TIPUS:
                return new Halo();
            case TUZ_TIPUS:
                return new Tuz();
            case VIZ_TISZTITO_TIPUS:
                return new Viztisztito();
            default:
                return new Tenger();
        }
    }

}

