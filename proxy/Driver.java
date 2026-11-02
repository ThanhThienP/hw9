package proxy;

public class Driver {
    public static void main(String[] args) {
        RealSongService server = new RealSongService();

        server.database.add(new Song(1, "Song A", "Artist 1", "Album X", 200));
        server.database.add(new Song(2, "Song B", "Artist 1", "Album X", 180));
        server.database.add(new Song(3, "Taste", "Sabrina Carpenter", "Short n' Sweet", 160));
        server.database.add(new Song(4, "BIRDS OF A FEATHER", "Billie Eilish", "HIT ME HARD AND SOFT", 210));
        server.database
                .add(new Song(5, "Pink Pony Club", "Chappell Roan", "The Rise and Fall of a Midwest Princess", 260));

        SongService proxy = new SongServiceProxy(server);

        System.out.println(server);
    }
}