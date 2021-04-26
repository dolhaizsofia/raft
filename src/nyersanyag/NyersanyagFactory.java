package nyersanyag;

import java.util.Random;

public class NyersanyagFactory {

    public static Nyersanyag letrehozNyersanyag() {
        Random random = new Random();
        int valoszinuseg = random.nextInt(100);
        if (valoszinuseg < 32) return new Deszka();
        else if (valoszinuseg < 64) return new Level();
        else if (valoszinuseg < 96) return new Hulladek();
        else return new Hordo();
    }

}
