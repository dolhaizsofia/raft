package jatekos;

public class Jatekos {
    private int egeszseg = 3;

    public boolean isAlive() {
        return egeszseg > 0;
    }

    public void csokkentEgeszseg() {
        egeszseg--;
    }
}
