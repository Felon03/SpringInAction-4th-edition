package soundsystem;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-05-30 15:15
 * Description:
 */
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
