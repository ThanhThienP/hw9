package proxy;

import java.util.ArrayList;
import java.util.List;

public class SongServiceProxy implements SongService {
    private RealSongService server;
    private List<Song> cache = new ArrayList<>();

    public SongServiceProxy(RealSongService server) {
        this.server = server;
    }

    @Override
    public Song searchById(Integer songID) {
        for (Song s : cache) {
            if (s.getId().equals(songID)) {
                System.out.println("[Cache Hit] ID: " + songID);
                return s;
            }
        }
        System.out.println("[Cache Miss] Fetching ID: " + songID);
        Song song = server.searchById(songID);
        if (song != null) {
            cache.add(song);
        }
        return song;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        List<Song> results = new ArrayList<>();
        for (Song s : cache) {
            if (s.getTitle().equalsIgnoreCase(title)) {
                results.add(s);
            }
        }
        if (!results.isEmpty()) {
            System.out.println("[Cache Hit] Title: " + title);
            return results;
        }

        System.out.println("[Cache Miss] Fetching Title: " + title);
        results = server.searchByTitle(title);
        for (Song s : results) {
            if (!cache.contains(s)) {
                cache.add(s);
            }
        }
        return results;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        List<Song> results = new ArrayList<>();
        for (Song s : cache) {
            if (s.getAlbum().equalsIgnoreCase(album)) {
                results.add(s);
            }
        }
        if (!results.isEmpty()) {
            System.out.println("[Cache Hit] Album: " + album);
            return results;
        }

        System.out.println("[Cache Miss] Fetching Album: " + album);
        results = server.searchByAlbum(album);
        for (Song s : results) {
            if (!cache.contains(s)) {
                cache.add(s);
            }
        }
        return results;
    }
}