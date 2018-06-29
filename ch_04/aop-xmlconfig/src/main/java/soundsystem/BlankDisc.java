package soundsystem;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-06 21:16
 * Description:
 */
public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    List<String> tracks;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        for (String track : tracks) {
            System.out.println("-Track: " + track);
        }
    }

    @Override
    public void playTrack(int trackNumber) {
        System.out.println("Playing " + title + " by " + artist);
        System.out.println("-Track: " + tracks.get(trackNumber));
    }
}
