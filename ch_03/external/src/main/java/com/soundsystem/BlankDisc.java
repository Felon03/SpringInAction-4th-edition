package com.soundsystem;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-05-31 20:16
 * Description:
 */
public class BlankDisc {

    private final String title;
    private final String artist;

    public BlankDisc(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}
