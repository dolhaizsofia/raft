package palya;

import java.util.ArrayList;
import java.util.List;
/**
 * lekezeli a mezoket
 */
public class Mezo {

    private List<JatekElem> elemek = new ArrayList<>();

    public Mezo() { }

    /**
     *
     * @param jatekElem  jatekelem minden ami a palyan megjelenik es megjelenhet
     */
    public Mezo(JatekElem jatekElem) {
        this.elemek.add(jatekElem);
    }

    /**
     * lehelyezhet egy jatekelemet pl viztisztito
     * @param jatekElem
     */
    public void lehelyez(JatekElem jatekElem) {
        elemek.add(jatekElem);
    }

    /**
     * felvehet egy jatekelemet vagyis a nyersanyagokat
     * @return
     */
    public JatekElem levesz() {
        return elemek.remove(getElemekSzama()-1);
    }

    /**
     * a palya retegekbol epul fel es ha leveszel egy elemet az allata levo jelenik meg
     * @param felsoTipus a legfelso jatekelem amit latsz
     * @param alattaTipus az a jatekelem ami allatta van
     * @return
     */
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
