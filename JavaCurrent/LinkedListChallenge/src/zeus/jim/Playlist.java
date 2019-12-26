package zeus.jim;

import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist {
    private LinkedList<Song> songs = new LinkedList<Song>();
    private String name;

    public Playlist(String name) {
        this.name = name;
    }

    public void addSong(Song song){
        songs.add(song);
    }

    public void showSongs(){
        ListIterator<Song> iterator = songs.listIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }

    public LinkedList<Song> getSongs() {
        return songs;
    }

    public String getName() {
        return name;
    }
}
