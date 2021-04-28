package palya;

import java.util.ArrayList;
import java.util.List;

public class Mezo {

    private List<JatekElem> elemek = new ArrayList<>();

    public Mezo(JatekElem jatekElem) {
        this.elemek.add(jatekElem);
    }

    public void lehelyez(JatekElem jatekElem) {
        elemek.add(jatekElem);
    }

    public JatekElem levesz() {
        return elemek.remove(getNumberOfElements()-1);
    }

    public JatekElem getJatekElem() {
        return elemek.get(getNumberOfElements()-1);
    }

    public int getNumberOfElements() {
        return elemek.size();
    }

}
