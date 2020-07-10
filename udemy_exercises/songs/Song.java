package udemy_exercises.songs;

public class Song {
    private String title;
    private int duration;
    public Song(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public int getDuration() {
        return duration;
    }
    
    public String getDurationString() {
        String temp = "";
        temp += this.duration / 60 + " minutes ";
        temp += this.duration % 60 + " seconds";
        return temp;
    }
    
    public void setDuration(int duration) {
        this.duration = duration;
    }
}

/*
**Song Player w/ Java Classes**
     - **Song class**
       - Title
       - Duration
     - **A song must exist in an album before it can be added to the playlist (so you can only play songs that you own.)**
*/
