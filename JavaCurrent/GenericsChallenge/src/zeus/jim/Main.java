package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FootballPlayer joe = new FootballPlayer("George");
        SoccerPlayer mike = new SoccerPlayer("Mike");
        FootballPlayer juan = new FootballPlayer("Juan");

        Team<FootballPlayer> redSkins = new Team<>("Red Skins");

        redSkins.addPlayer(joe);
        redSkins.addPlayer(juan);
        redSkins.addPlayer(joe);
        Team<FootballPlayer> eagles = new Team<>("Eagles");
        Team<SoccerPlayer> realMadrid = new Team<>("Real Madrid");
        eagles.addPlayer(new FootballPlayer("Zeus"));


        realMadrid.addPlayer(mike);

        Team<FootballPlayer> vcu = new Team<>("VCU");
        Team<FootballPlayer> jaguar = new Team<>("Jaguar");
        eagles.matchResult(redSkins, 54, 20);
        jaguar.matchResult(vcu, 65, 35);
        vcu.matchResult(redSkins, 23, 10);



        System.out.println(eagles.compareTo(redSkins));
        System.out.println(redSkins.compareTo(eagles));

        League<Team<FootballPlayer>> champions = new League<>("Champions");

        champions.add(redSkins);
        champions.add(eagles);
        champions.add(vcu);
        champions.add(jaguar);
        champions.showLeague();
    }
}
