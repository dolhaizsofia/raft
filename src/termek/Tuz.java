package termek;

import java.util.ArrayList;
import java.util.List;

public class Tuz extends Termek {

    private List<Burgonya> burgonyak;
    private List<Hal> halak;

    public static final String TUZ = "tuz";

    public Tuz() {
        burgonyak = new ArrayList<>();
        halak = new ArrayList<>();
    }

    public void rarak(Burgonya b) {
        burgonyak.add(b);
    }

    public void rarak(Hal h) {
        halak.add(h);
    }

    public boolean vanSultHal() {
        for (Hal h: halak) {
            if (h.kesz()) {
                return true;
            }
        }
        return false;
    }

    public boolean vanSultBurgonya() {
        for (Burgonya b: burgonyak) {
            if (b.kesz()) {
                return true;
            }
        }
        return false;
    }

    public void sul() {
        for (Burgonya b: burgonyak) {
            b.novelAtsultseg();
        }
        for (Hal h: halak) {
            h.novelAtsultseg();
        }
    }

    public void leveszBurgonya() {
        for (Burgonya b: burgonyak) {
            if (b.kesz()) {
                burgonyak.remove(b);
                break;
            }
        }
    }

    public void leveszHal() {
        for (Hal h: halak) {
            if (h.kesz()) {
                halak.remove(h);
                break;
            }
        }
    }

    @Override
    public String tipus() {
        return TUZ;
    }
}
