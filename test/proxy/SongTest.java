package proxy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SongTest {

    @Test
    public void testSongGetters() {
        Song song = new Song(3, "Taste", "Sabrina Carpenter", "Short n' Sweet", 160);

        assertEquals(3, song.getId());
        assertEquals("Taste", song.getTitle());
        assertEquals("Sabrina Carpenter", song.getArtist());
        assertEquals("Short n' Sweet", song.getAlbum());
        assertEquals(160, song.getDuration());
    }

    @Test
    public void testToString() {
        Song song = new Song(4, "BIRDS OF A FEATHER", "Billie Eilish", "HIT ME HARD AND SOFT", 210);
        String expected = "Song[ID=4, Title='BIRDS OF A FEATHER', Artist='Billie Eilish', Album='HIT ME HARD AND SOFT', Duration=210s]";
        assertEquals(expected, song.toString());
    }
}
