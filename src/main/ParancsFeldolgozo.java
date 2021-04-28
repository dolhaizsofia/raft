package main;

import palya.Palya;
import parancs.Parancs;

import java.util.List;

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
