package udemy_exercises.songs;

import java.util.ArrayList;
import java.util.Scanner;

public class SongPlayer {
    private ArrayList<Song> songs;
    private ArrayList<Album> albums;
    private Scanner sc;
    private int currentTrack;
    private boolean showMainLoop;
    SongPlayer() {
        this.songs = new ArrayList<>();
        this.albums = new ArrayList<>();
        this.sc = new Scanner(System.in);
        this.currentTrack = 0;
        this.showMainLoop = true;
    }
    public void displayMainMenu() {
//        String[] prompt = {"Welcome!", "Please make a selection using the first word of each menu item!", "Album options", "Song options", "Player options", "Exit"};
        String[] prompt = {"Welcome!", "Please make a selection using the first word of each menu item!", "Album options", "Player options", "Exit"};
        while(this.showMainLoop) {
            showPrompt(prompt);
            loadCategoryMenu(getSelection());
        }
    }
    private void loadCategoryMenu(String selection) {
        switch(selection) {
            case "Album":
                showPrompt(new String[]{"Please make a selection using the first word of each menu item:", "Create album", "Delete album", "Find album by name", "Back"});
                runAlbumMenu(getSelection());
                break;
//            case "Song":
//                showPrompt(new String[]{"Please make a selection using the first word of each menu item:", "Create song", "Delete song", "Add song to album", "Find song", "Back"});
//                showSongMenu(getSelection());
//                break;
            case "Player":
                showPrompt(new String[]{"Please make a selection using the first word of each menu item:", "Load songs", "Play songs", "Replay song", "Next song", "Previous song", "Stop", "Back"});
                runPlayerMenu(getSelection());
            case "Exit":
                exit();
                break;
            default:
                badSelection(null);
                break;
        }
    }
    private void runAlbumMenu(String selection) {
        switch(selection) {
            case "Create":
                createAlbum();
                break;
            case "Delete":
                deleteAlbum();
                break;
            case "Find":
                findAlbum();
                break;
            case "Back":
                displayMainMenu();
                break;
            default:
                badSelection("Album");
                break;
        }
    }
//    private void showSongMenu(String selection) {
//        switch(selection) {
//            case ""
//        }
//    }
    private void runPlayerMenu(String selection) {
        switch(selection) {
            case "Load":
                loadSongs();
                break;
            case "Play":
                play();
            case "Replay":
                replay();
                break;
            case "Next":
                next();
                break;
            case "Previous":
                previous();
                break;
            case "Stop":
                stop();
                break;
            case "Back":
                displayMainMenu();
                break;
            default:
                badSelection("Player");
                break;
        }
    }
//    private void exit() {
//        this.showMainLoop = false;
//    }
    private void badSelection(String menu) {
        System.out.println("Invalid selection!\n");
        if(menu == null) displayMainMenu();
        loadCategoryMenu(menu);
    }
    private void loadSongs() {
        boolean loadMore = true;
        String title;
        Song song;
        do{
            showPrompt("What's the song title?");
            title = getSelection();
            for(Album a: this.albums) {
                song = a.findSong(title);
                if(song != null) {
                    this.songs.add(song);
                    System.out.println(song.getTitle() + " loaded!");
                }
                else System.out.println("Song not found!");
            }
            showPrompt("Load another song (y/N?)");
            String answer = getSelection();
            loadMore = answer.equals("y") || answer.equals("yes") ? true : false;
        } while(loadMore);
        System.out.println("Songs loaded");
        loadCategoryMenu("Player");
    }
    private void createAlbum() {
        boolean loadMore = true;
        String answer;
        Song song;
        Album album = new Album();
        String title;
        int duration;
        do {
            showPrompt("What's the song title?");
            title = getSelection();
            showPrompt("What's the duration (in seconds)?");
            duration = sc.nextInt();
            sc.nextLine();
            song = new Song(title, duration);
            album.addSong(song);
            showPrompt("Add another song (y/N)?");
//            answer = getSelection();
            answer = sc.nextLine();
            System.out.println(answer);
            loadMore = answer.equals("y") || answer.equals("yes") ? true : false;
        } while(loadMore);
        showPrompt("What's the album title?");
        album.setName(getSelection());
        this.albums.add(album);
        System.out.println("Album added!");
        displayMainMenu();
    }
    private void findAlbum() {
        String name;
        showPrompt("Which album would you like to find?");
        name = getSelection();
        Album album = this.albums.stream()
                .filter(a -> {
                    return a.getName().equals(name);
                })
                .findAny()
                .orElse(null);
        if(album != null) {
            System.out.println(album.getName());
            album.listSongs();
        } else {
            System.out.println("Album does not exist!");
        }
        displayMainMenu();
    }
    private void deleteAlbum() {
        String name;
        showPrompt("Which album would you like to delete?");
        name = getSelection();
        Album album = this.albums.stream()
                .filter(a -> {
                    return a.getName().equals(name);
                })
                .findAny()
                .orElse(null);
        if(album != null) {
            this.albums.remove(album);
            System.out.println("Album removed!");
        } else {
            System.out.println("Album does not exist!");
        }
        displayMainMenu();
    }
    private String getSelection() {
        String selection = sc.nextLine();
        return selection;
    }
    private void showPrompt(String prompt) {
        System.out.println(prompt);
    }
    private void showPrompt(String[] prompts) {
        for(String p: prompts) {
            showPrompt(p);
        }
    }

    public void play() {
        if(this.songs.size() == 0) {
            System.out.println("Please load some songs first!");
        } else {
            System.out.println("Currently playing: " + this.songs.get(this.currentTrack).getTitle());
        }
        loadCategoryMenu("Player");
    }
    public void replay() {
        play();
    }
    public void next() {
        this.currentTrack++;
        play();
    }
    public void previous() {
        this.currentTrack--;
        play();
    }
    public void stop() {
        System.out.println("Stopped!");
        loadCategoryMenu("Player");
    }
    private void exit() {
        this.showMainLoop = false;
        displayMainMenu();
    }
    public static void main(String[] args) {
        SongPlayer sp = new SongPlayer();
        sp.displayMainMenu();
    }
}