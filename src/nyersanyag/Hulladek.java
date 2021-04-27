package nyersanyag;

public class Hulladek extends Nyersanyag{
    @Override
    public void rajzol() {
        System.out.print("h");
    }
    @Override
    public String getImageName() {
        return "szemet";
    }
}
