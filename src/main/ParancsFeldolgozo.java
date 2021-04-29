package main;

import palya.Palya;
import parancs.Parancs;

import java.util.List;
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
     * @param allandoParancsok
     */
    public void vegrehajt(List<Parancs> allandoParancsok) {
        for (Parancs parancs : allandoParancsok) {
            palya.vegigMegy(parancs);
        }
    }

}
