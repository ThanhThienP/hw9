package proxy;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SongServiceProxyTest {

    private RealSongService createServerWithDriverSongs() {
        RealSongService server = new RealSongService();
        server.database.add(new Song(1, "Song A", "Artist 1", "Album X", 200));
        server.database.add(new Song(2, "Song B", "Artist 1", "Album X", 180));
        server.database.add(new Song(3, "Taste", "Sabrina Carpenter", "Short n' Sweet", 160));
        server.database.add(new Song(4, "BIRDS OF A FEATHER", "Billie Eilish", "HIT ME HARD AND SOFT", 210));
        server.database.add(new Song(5, "Pink Pony Club", "Chappell Roan", "The Rise and Fall of a Midwest Princess", 260));
        return server;
    }

    @Test
    public void testSearchById() {
        RealSongService server = createServerWithDriverSongs();
        SongService proxy = new SongServiceProxy(server);

        Song result1 = proxy.searchById(2);
        assertNotNull(result1);
        assertEquals("Song B", result1.getTitle());

        // Second search should hit the cache and return the exact same object
        Song result2 = proxy.searchById(2);
        assertSame(result1, result2, "Second search should return cached song");
    }

    @Test
    public void testSearchByIdNotFound() {
        RealSongService server = createServerWithDriverSongs();
        SongService proxy = new SongServiceProxy(server);

        Song result = proxy.searchById(99);
        assertNull(result);
    }

    @Test
    public void testSearchByTitle() {
        RealSongService server = createServerWithDriverSongs();
        SongService proxy = new SongServiceProxy(server);

        List<Song> result1 = proxy.searchByTitle("BIRDS OF A FEATHER");
        assertEquals(1, result1.size());
        assertEquals("Billie Eilish", result1.get(0).getArtist());

        // Second search should hit the cache
        List<Song> result2 = proxy.searchByTitle("BIRDS OF A FEATHER");
        assertEquals(1, result2.size());
        assertSame(result1.get(0), result2.get(0));
    }

    @Test
    public void testSearchByAlbum() {
        RealSongService server = createServerWithDriverSongs();
        SongService proxy = new SongServiceProxy(server);

        List<Song> result1 = proxy.searchByAlbum("Short n' Sweet");
        assertEquals(1, result1.size());
        assertEquals("Taste", result1.get(0).getTitle());

        // Second search should hit the cache
        List<Song> result2 = proxy.searchByAlbum("Short n' Sweet");
        assertEquals(1, result2.size());

        List<Song> albumX = proxy.searchByAlbum("Album X");
        assertEquals(2, albumX.size());
    }

    @Test
    public void testDriverMainExecution() {
        assertDoesNotThrow(() -> Driver.main(new String[] {}));
    }
}
