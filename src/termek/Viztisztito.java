package termek;

public class Viztisztito extends Termek {

    public static final String VIZ_TISZTITO = "viztisztito";

    private int vizMennyiseg = 0;

    public void novelVizMennyiseg() {
        vizMennyiseg++;
    }

    @Override
    public String tipus() {
        return VIZ_TISZTITO;
    }
}
