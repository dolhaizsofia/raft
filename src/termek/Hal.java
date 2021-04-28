package termek;

public class Hal extends Termek {

    public static final String HAL = "hal";

    private int atsultseg = 0;

    public void novelAtsultseg() {
        atsultseg++;
    }

    public int getAtsultseg() {
        return atsultseg;
    }

    public boolean kesz() {
        return atsultseg >= 25;
    }

    @Override
    public String tipus() {
        return HAL;
    }
}
