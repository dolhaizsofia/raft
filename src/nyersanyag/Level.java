package nyersanyag;

public class Level extends Nyersanyag {
    @Override
    public void rajzol() {
        System.out.print("L");
    }
    @Override
    public String getImageName() {
        return "level";
    }

}
