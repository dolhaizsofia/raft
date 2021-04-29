package io;

import nyersanyag.Deszka;
import nyersanyag.Hordo;
import nyersanyag.Level;
import palya.*;
import termek.Halo;
import termek.Tuz;
import termek.Viztisztito;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import static nyersanyag.Deszka.DESZKA_TIPUS;
import static nyersanyag.Hordo.HORDO_TIPUS;
import static nyersanyag.Level.LEVEL_TIPUS;
import static palya.Capa.CAPA_TIPUS;
import static palya.Fold.FOLD_TIPUS;
import static palya.Jatekos.JATEKOS_TIPUS;
import static palya.Tenger.TENGER_TIPUS;
import static termek.Halo.HALO_TIPUS;
import static termek.Tuz.TUZ_TIPUS;
import static termek.Viztisztito.VIZ_TISZTITO_TIPUS;

public class FileHandler {

    private FileHandler() {
    }

    private static Map<String, JatekElem> JATEKELEM_NEVHEZ_OBJEKTUM = new HashMap<>();

    static {
        JATEKELEM_NEVHEZ_OBJEKTUM.put(FOLD_TIPUS, new Fold());
        JATEKELEM_NEVHEZ_OBJEKTUM.put(TENGER_TIPUS, new Tenger());
        JATEKELEM_NEVHEZ_OBJEKTUM.put(CAPA_TIPUS, new Capa());
        JATEKELEM_NEVHEZ_OBJEKTUM.put(JATEKOS_TIPUS, new Jatekos());
        JATEKELEM_NEVHEZ_OBJEKTUM.put(LEVEL_TIPUS, new Level());
        JATEKELEM_NEVHEZ_OBJEKTUM.put(HORDO_TIPUS, new Hordo());
        JATEKELEM_NEVHEZ_OBJEKTUM.put(DESZKA_TIPUS, new Deszka());
        JATEKELEM_NEVHEZ_OBJEKTUM.put(HALO_TIPUS, new Halo());
        JATEKELEM_NEVHEZ_OBJEKTUM.put(TUZ_TIPUS, new Tuz());
        JATEKELEM_NEVHEZ_OBJEKTUM.put(VIZ_TISZTITO_TIPUS, new Viztisztito());
    }

    public static void loadGame(JFrame f, Palya palya) {
        openFileChooser(f, false).ifPresent(filePath -> {
            try {
                loadSetting(filePath, palya);
            } catch (IOException e) {
                e.printStackTrace();
                showMessageDialog(null, "File not found!", "warning", ERROR_MESSAGE);
            }
        });
    }

    private static void loadSetting(String fileName, Palya palya) throws IOException {
        Jatekos jatekos = palya.getJatekos();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line = br.readLine();
            String[] darabok = line.split(" ");

            while ((line = br.readLine()) != null) {

            }
        }
    }

    public static void saveGame(JFrame f, Palya palya) {
        openFileChooser(f, true).ifPresent(filePath-> {
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
        try (FileWriter fw = new FileWriter(fileName)){
            fw.write(jatekos.getEhseg() + " ");
            fw.write(jatekos.getSzomjusag() + " ");
            for (Map.Entry<String, Integer> entry : jatekos.getHolmik().entrySet()) {
                fw.write(entry.getValue() + " ");
            }
            fw.write("\n");
            for (Mezo[] mezos : tabla) {
                for (int j = 0; j < mezos.length; j++) {
                    for (int k = 0; k < mezos[j].getElemek().size(); k++) {
                        fw.write(mezos[j].getElemek().get(k).tipus());
                        if (k < mezos[j].getElemek().size() - 1) {
                            fw.write(";");
                        }
                    }
                    fw.write(" ");
                }
                fw.write("\n");
            }
        }
    }

    private static Optional<String> openFileChooser(JFrame f, boolean save){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("raft file extention","rft");
        chooser.setFileFilter(filter);
        int returnVal;
        if (save) {
            returnVal = chooser.showSaveDialog(f);
        } else {
            returnVal = chooser.showOpenDialog(f);
        }
        if(returnVal == JFileChooser.APPROVE_OPTION) {
                    return of(chooser.getSelectedFile().getAbsolutePath());
        }
        return empty();
    }

}

