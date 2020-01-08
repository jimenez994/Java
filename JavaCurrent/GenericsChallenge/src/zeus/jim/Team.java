package zeus.jim;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {
    private String name;
    int played = 0;
    int won = 0;
    int lose = 0;
    int tie = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player){
        if(members.contains(player)){
            System.out.println(player.getName() +" is already in this team");
            return false;
        }else{
            members.add(player);
            System.out.println(player.getName() + " picked for team " + this.name);
            return true;
        }
    }

    public int numPlayers(){
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore){
        String message;

        if(ourScore > theirScore){
            won++;
            message = "Beat ";
        }else if(ourScore == theirScore){
            tie++;
            message = "Tie to ";
        }else{
            lose--;
            message = "Lose to";
        }
        played++;
        System.out.println(message + opponent.getName());
    }

    public int ranking(){
        return (won * 2) + tie;
    }

    @Override
    public int compareTo(Team<T> team) {
        if(ranking() > team.ranking() ){
            return -1;
        }else if(team.ranking() > ranking()){
            return 1;
        }else{
            return 0;
        }
    }
}
