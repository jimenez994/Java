package zeus.jim;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private ArrayList<Song> songs = new ArrayList<Song>();
    private String name;
    private String artist;

    public Album(String name, String artist) {
        if(name.isEmpty() || artist.isEmpty()){
            System.out.println("Name or artist cannot be empty");
        }else{
            this.name = name;
            this.artist = artist;
        }
    }

    public void addSong(String title, double duration){
        if(isSongInAlbum(title)){
            System.out.println("Song already exists in album");
        }else{
            songs.add(new Song(title, duration));
        }
    }

    public boolean addSongToPlaylist(int trackNumber, LinkedList<Song> playlist){
        int index = trackNumber -1;
        if(index >= 0 && index <= this.songs.size()){
            playlist.add(this.songs.get(index));
            System.out.println("Song successfully added to playlist");
            return true;
        }else{
            System.out.println("Album does not contain track number " + trackNumber);
            return false;
        }
    }

    public boolean isSongInAlbum(String title){
        for (Song song: songs) {
            if(song.getTitle().equals(title)){
                return false;
            }
        }
        return true;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }
}
