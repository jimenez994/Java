package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Song misSentimientos = new Song("Mis Sentimientos", 3.45);
        Song niContigo = new Song("Ni Contigo", 4.32);
        Song ximena = new Song("Sin Ti no puedo estar mal", 5.05);
        Album losAngelesAzules = new Album("Los Angeles Azules" , "Angeles");
        Album.SongList albumList = losAngelesAzules.new SongList();
        albumList.addSong(misSentimientos);
        albumList.addSong(niContigo);
        albumList.addSong(ximena);
        albumList.addSong(misSentimientos);
        Song foundSong = albumList.findSong("Ni Contigo");
        System.out.println(foundSong.toString());

        Song blar = new Song("bla", 3.4);
        System.out.println(blar.toString());
        losAngelesAzules.addNewSong(blar);
        losAngelesAzules.findSong("bla");
    }

}
