package week_7.encapsulation.assignment_problems;

import java.util.Arrays;

public class Playlist {
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
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }
}