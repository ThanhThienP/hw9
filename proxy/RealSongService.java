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
        for (Song s : database) {
            if (s.getId().equals(songID)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        List<Song> results = new ArrayList<>();
        for (Song s : database) {
            if (s.getTitle().equalsIgnoreCase(title)) {
                results.add(s);
            }
        }
        return results;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        List<Song> results = new ArrayList<>();
        for (Song s : database) {
            if (s.getAlbum().equalsIgnoreCase(album)) {
                results.add(s);
            }
        }
        return results;
    }
}