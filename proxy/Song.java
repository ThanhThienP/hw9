package proxy;

public class Song {
    public Integer id;
    public String title;
    public String artist;
    public String album;
    public int duration;

    public Song(Integer id, String title, String artist, String album, int duration) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return title + " by " + artist + " (" + album + ") - " + duration + "s";
    }
}