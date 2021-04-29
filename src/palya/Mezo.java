package palya;

import java.util.ArrayList;
import java.util.List;
/**
 * lekezeli a mezoket
 */
public class Mezo {

    private List<JatekElem> elemek = new ArrayList<>();

    public Mezo() { }

    public Mezo(JatekElem jatekElem) {
        this.elemek.add(jatekElem);
    }

    public void lehelyez(JatekElem jatekElem) {
        elemek.add(jatekElem);
    }

    public JatekElem levesz() {
        return elemek.remove(getElemekSzama()-1);
    }

    public boolean ellFelsoKetTipusat(String felsoTipus, String alattaTipus) {
        return getLegfelso().tipus().equals(felsoTipus) && getMasodikLegfelso().tipus().equals(alattaTipus);
    }

    public JatekElem getLegfelso() {
        return elemek.get(getElemekSzama()-1);
    }

    public JatekElem getMasodikLegfelso() {
        return elemek.get(getElemekSzama()-2);
    }

    public List<JatekElem> getElemek() {
        return elemek;
    }

    private int getElemekSzama() {
        return elemek.size();
    }
}
