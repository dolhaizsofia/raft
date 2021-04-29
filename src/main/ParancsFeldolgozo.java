package main;

import palya.Palya;
import parancs.Parancs;

import java.util.List;
/**
 * feldolgoza a parancsokat
 */
public class ParancsFeldolgozo {

    private Palya palya;

    ParancsFeldolgozo(Palya palya) {
        this.palya = palya;
    }

    public void vegrehajt(List<Parancs> allandoParancsok) {
        for (Parancs parancs : allandoParancsok) {
            palya.vegigMegy(parancs);
        }
    }

}
