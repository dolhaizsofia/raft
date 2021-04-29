package main;

import palya.Palya;
import parancs.*;

import java.util.ArrayList;
import java.util.List;

import static parancs.ParancsFactory.letrehozParancs;

/**
 * feldolgoza a parancsokat
 */
public class ParancsFeldolgozo {

    private Palya palya;

    /**
     * feldolgozza a parancsokat
     * @param palya
     */
    ParancsFeldolgozo(Palya palya) {
        this.palya = palya;
    }

    /**
     * vegigmegy a parancsokon
     * @param parancs
     */
    public void vegrehajt(int parancs) {
        elokeszitParancsok(parancs);
        for (Parancs p : elokeszitParancsok(parancs)) {
            palya.vegigMegy(p);
        }
    }

    private List<Parancs> elokeszitParancsok(int parancs) {
        List<Parancs> parancsok = new ArrayList<>();
        parancsok.add(letrehozParancs(parancs));
        parancsok.add(new MozgatNyersanyag());
        parancsok.add(new GeneralUjNyersanyagok());
        parancsok.add(new LeveszEro());
        parancsok.add(new TisztitViz());
        parancsok.add(new SulEtel());
        parancsok.add(new HaloBegyujt());
        parancsok.add(new CapaMozgas());
        return parancsok;
    }

}
