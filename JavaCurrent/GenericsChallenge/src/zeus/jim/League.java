package zeus.jim;

import java.util.ArrayList;
import java.util.Collections;

public class League< T extends Team> {
    private String name;
    private ArrayList<T> league = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<T> getLeague() {
        return league;
    }
    
    public boolean add(T team){
        if(league.contains(team)){
            System.out.println("Team is already in league");
            return false;
        }else{
            league.add(team);
            System.out.println("Add to league");
            return true;
        }
    }
    
    public void showLeague(){
        System.out.println(league.size());
        Collections.sort(league);
        for (T team: league){
            System.out.println(team.getName() + " : " + team.ranking());
        }
    }
}
