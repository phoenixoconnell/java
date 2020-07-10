package udemy_exercises.songs;

import java.util.ArrayList;

public class Album {
    private ArrayList<Song> songs;
    private String name;
    private int duration;
    public Album() {
        this.songs = new ArrayList<>();
        this.duration = 0;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void addSong(Song song) {
        this.songs.add(song);
        this.duration += song.getDuration();
    }
    
    public boolean inAlbum(String title) {
        Song song = findSong(title);
        return song != null;
    }
    
    public void removeSong(String title) {
        Song song = findSong(title);
        this.songs.remove(song);
    }
    
    public String albumDurationString() {
        String temp = "";
        temp += this.duration / 3600 + " hours ";
        temp += this.duration / 60 + " minutes ";
        temp += this.duration % 60 + " seconds";
        return temp;
    }
    
    public void listSongs() {
        this.songs.stream()
                .forEach(s -> System.out.println(s.getTitle() + ": " + s.getDurationString()));
        System.out.println(albumDurationString());
        System.out.println();
    }
    
    public Song findSong(String title) {
        Song song = this.songs.stream()
                .filter(s -> {
                    return s.getTitle().equals(title);
                })
                .findAny()
                .orElse(null);
        return song;
    }
}

/*
**Song Player w/ Java Classes**
     - **Album class**
       - Playlist of **Songs**.
       - addPlayist() (songs must appear in the list in the order by which they were added)
       - stop()
       - nextSong()
       - previousSong()
       - repeatSong()
       - showPlaylist()
       - removePlaylist()
     - **A song must exist in an album before it can be added to the playlist (so you can only play songs that you own.)**
*/