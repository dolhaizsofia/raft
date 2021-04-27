package nyersanyag;

public class Deszka extends Nyersanyag{
    @Override
    public void rajzol() {
        System.out.print("D");
    }
   @Override
    public String getImageName() {
        return "deszka";
    }
}
