package proxy;

import java.util.ArrayList;
import java.util.List;

public class RealSongService implements SongService {
    public List<Song> database = new ArrayList<>();

    @Override
    public Song searchById(Integer songID) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        return new ArrayList<>();
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        return new ArrayList<>();
    }
}