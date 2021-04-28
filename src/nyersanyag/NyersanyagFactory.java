package nyersanyag;

import termek.Burgonya;

import java.util.Random;

public class NyersanyagFactory {

    private static Random random = new Random();

    public static Nyersanyag letrehozNyersanyag() {
        int valoszinuseg = random.nextInt(100);
        if (valoszinuseg < 32) return new Deszka();
        else if (valoszinuseg < 64) return new Level();
        else if (valoszinuseg < 96) return new Hulladek();
        else return new Hordo();
    }

    public static Nyersanyag letrehozHordoTartalom() {
        int valoszinuseg = random.nextInt(4);
        if (valoszinuseg == 0) return new Deszka();
        else if (valoszinuseg == 1) return new Level();
        else if (valoszinuseg == 2) return new Hulladek();
        else return new Burgonya();
    }

}
