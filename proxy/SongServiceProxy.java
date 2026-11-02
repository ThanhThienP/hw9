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
        // todo
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        // todo
        return new ArrayList<>();
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        // todo
        return new ArrayList<>();
    }
}