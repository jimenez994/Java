package zeus.jim;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches = new ArrayList<Branch>();

    public Bank(String name) {
        this.name = name;
    }

    public void addBranch(Branch branch){
        if(!branch.getName().isEmpty()){
            branches.add(branch);
            System.out.println(branch.getName() +" has been created");
        }else{
            System.out.println("Branch need a name");
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

}
