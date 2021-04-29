package nyersanyag;

import termek.Burgonya;

import java.util.Random;

/**
 * veletlenszeruen a megadott valoszinusegnek megfeleloen letrehoz nyersanyagokat
 * osszerakja veletlenszeruen a hordo tartalmat
 */
public class NyersanyagFactory {

    private static Random random = new Random();

    private NyersanyagFactory() {
    }

    /**
     * a megadott valoszinusegnek megfeleloen add vissza egy nyersanyagott
     *
     * @return nyersanyaggal
     */
    public static Nyersanyag letrehozNyersanyag() {
        int valoszinuseg = random.nextInt(100);
        if (valoszinuseg < 32) return new Deszka();
        else if (valoszinuseg < 64) return new Level();
        else if (valoszinuseg < 96) return new Hulladek();
        else return new Hordo();
    }

    /**
     * hordo tartalmat allitja ossze
     *
     * @return
     */
    static Nyersanyag letrehozHordoTartalom() {
        int valoszinuseg = random.nextInt(4);
        if (valoszinuseg == 0) return new Deszka();
        else if (valoszinuseg == 1) return new Level();
        else if (valoszinuseg == 2) return new Hulladek();
        else return new Burgonya();
    }

}
