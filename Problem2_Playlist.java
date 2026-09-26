public class Problem2_Playlist {

    static class Playlist {
        private final int maxSize;
        private final String[] songs;
        private int count;

        public Playlist(int maxSize) {
            this.maxSize = maxSize;
            this.songs = new String[maxSize];
            this.count = 0;
        }

        public void addSong(String title) {
            if (count < maxSize && title != null) {
                songs[count] = title;
                count++;
            }
        }

        public String[] getSongs() {
            String[] copy = new String[count];
            System.arraycopy(songs, 0, copy, 0, count);
            return copy;
        }

        public int getSongCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked";
        System.out.println("Playlist songs: " + java.util.Arrays.toString(p.getSongs()));
        System.out.println("Song count: " + p.getSongCount());
    }
}