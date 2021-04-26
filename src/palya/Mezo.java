package palya;

import jatekos.JatekElem;

import java.util.Stack;

public class Mezo implements JatekElem {

    private Stack<JatekElem> elemek = new Stack<>();

    public Mezo(JatekElem jatekElem) {
        this.elemek.push(jatekElem);
    }

    public void lehelyez(JatekElem jatekElem) {
        elemek.push(jatekElem);
    }

    public JatekElem levesz() {
        return elemek.pop();
    }

    @Override
    public void rajzol() {
        elemek.peek().rajzol();
    }
}
