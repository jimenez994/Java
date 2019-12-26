package zeus.jim;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Playlist myPlaylist = new Playlist("Cumbia");
//        Not finish
    }
    public static void userInterface(){
        boolean isOn = true;
        while(isOn){
            switch (scanner.nextInt()){
                case 0:
                    menu();
                    break;
                case 1:
                    createAlbum();
                    break;
                case 2:
                    addSongToAlbum();
            }
        }

    }

    public static void menu(){
        System.out.println("-- menu ---");
        System.out.println("0 - Show menu");
        System.out.println("1 - Create a Album");
        System.out.println("2 - Add new song to album");
        System.out.println("4 - Add song to playlist");
        System.out.println("5 - Show album");
        System.out.println("9 - Quit");
    }

    public static void createAlbum(){
        System.out.println("Album Name:");
        String name = scanner.next();
        System.out.println("Artist");
        String artist = scanner.next();
        Album newAlbum = new Album(name, artist);
    }

    public static void addSongToAlbum(){

    }


}
