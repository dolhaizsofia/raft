package palya;

/**
 * eltarolja a poziciokat
 */
public class Pozicio {
    private final int x;
    private final int y;

    /**
     * @param x x kordinatalya annak hogy hol van
     * @param y y kordinataja annak hogy hol van
     */
    Pozicio(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
