package zeus.jim;

import java.util.ArrayList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public void addNewSong(Song song){
        this.songs.addSong(song);
    }

    public Song findSong(String name){
        return this.songs.findSong(name);
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public class SongList{
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<>();
        }

        public void addSong(Song song){
            if(findSong(song.getName()) != null){
                System.out.println("Song is already on the album");
            }else{
                this.songs.add(song);
                System.out.println("Song successfully added to album");
            }
        }

        public Song findSong(String name){
            for (Song song: songs) {
                if(song.getName().equals(name)){
                    System.out.println(song.getName() + " found!");
                    return song;
                }
            }
            System.out.println("Song not found");
            return null;
        }
    }
}
