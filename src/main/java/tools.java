import java.util.ArrayList;


public class tools {

    public static boolean team_check(ArrayList<Player> team_to_check){
        if ((team_to_check.get(1).getPlayerSalary() > team_to_check.get(2).getPlayerSalary())
                && (team_to_check.get(3).getPlayerSalary() > team_to_check.get(4).getPlayerSalary())
                    && (team_to_check.get(4).getPlayerSalary() > team_to_check.get(5).getPlayerSalary())
                        && ((get_team_salary(team_to_check)) <= 50000)
                            && ((get_team_salary(team_to_check)) >= 47000)){
            return true;
        }
        if (get_team_salary(team_to_check) > 50000)
            System.out.println("Error: Salary Too Large");
        if (get_team_salary(team_to_check) > 50000)
            System.out.println("Error: Salary Too Small");
        return false;
    }

    public static int get_team_salary(ArrayList<Player> team_to_check){
        int team_salary_total = 0;
        for (int i = 0; i < team_to_check.size(); i++) {
            team_salary_total += team_to_check.get(i).getPlayerSalary();
        }

        return team_salary_total;
    }
    public static ArrayList<Player> Positional_Salary_Check(ArrayList<Player> PlayerList, int Salary_Frame, String position) {
        switch (position) {

            case "QB":
                ArrayList<Player> QB_List = new ArrayList<Player>();
                for (int i = 0; i < PlayerList.size(); i++) {
                    if (PlayerList.get(i).getPlayerPosition().equals(position)) {
                        if (((PlayerList.get(i).getPlayerSalary()) <= (Salary_Frame + 1050)) && ((PlayerList.get(i).getPlayerSalary()) >= (Salary_Frame - 1050))) {
                            QB_List.add(PlayerList.get(i));
                        }
                    }
                }
                return QB_List;


            case "RB1":
                ArrayList<Player> RB1_List = new ArrayList<Player>();
                for (int i = 0; i < PlayerList.size(); i++) {
                    if (PlayerList.get(i).getPlayerPosition().equals("RB")) {
                        if (((PlayerList.get(i).getPlayerSalary()) <= (Salary_Frame + 800)) && ((PlayerList.get(i).getPlayerSalary()) >= (Salary_Frame - 800))) {
                            RB1_List.add(PlayerList.get(i));
                        }
                    }
                }
                return RB1_List;


            case "RB2":
                ArrayList<Player> RB2_List = new ArrayList<Player>();
                for (int i = 0; i < PlayerList.size(); i++) {
                    if (PlayerList.get(i).getPlayerPosition().equals("RB")) {
                        if (((PlayerList.get(i).getPlayerSalary()) <= (Salary_Frame + 780)) && ((PlayerList.get(i).getPlayerSalary()) >= (Salary_Frame - 780))) {
                            RB2_List.add(PlayerList.get(i));
                        }
                    }
                }
                return RB2_List;


            case "WR1":
                ArrayList<Player> WR1_List = new ArrayList<Player>();
                for (int i = 0; i < PlayerList.size(); i++) {
                    if (PlayerList.get(i).getPlayerPosition().equals("WR")) {
                        if (((PlayerList.get(i).getPlayerSalary()) <= (Salary_Frame + 850)) && ((PlayerList.get(i).getPlayerSalary()) >= (Salary_Frame - 850))) {
                            WR1_List.add(PlayerList.get(i));
                        }
                    }
                }
                return WR1_List;

            case "WR2":
                ArrayList<Player> WR2_List = new ArrayList<Player>();
                for (int i = 0; i < PlayerList.size(); i++) {
                    if (PlayerList.get(i).getPlayerPosition().equals("WR")) {
                        if (((PlayerList.get(i).getPlayerSalary()) <= (Salary_Frame + 598)) && ((PlayerList.get(i).getPlayerSalary()) >= (Salary_Frame - 598))) {
                            WR2_List.add(PlayerList.get(i));
                        }
                    }
                }
                return WR2_List;


            case "WR3":
                ArrayList<Player> WR3_List = new ArrayList<Player>();
                for (int i = 0; i < PlayerList.size(); i++) {
                    if (PlayerList.get(i).getPlayerPosition().equals("WR")) {
                        if (((PlayerList.get(i).getPlayerSalary()) <= (Salary_Frame + 1043)) && ((PlayerList.get(i).getPlayerSalary()) >= (Salary_Frame - 1043))) {
                            WR3_List.add(PlayerList.get(i));
                        }
                    }
                }
                return WR3_List;


            case "TE":
                ArrayList<Player> TE_List = new ArrayList<Player>();
                for (int i = 0; i < PlayerList.size(); i++) {
                    if (PlayerList.get(i).getPlayerPosition().equals("TE")) {
                        if (((PlayerList.get(i).getPlayerSalary()) <= (Salary_Frame + 1446)) && ((PlayerList.get(i).getPlayerSalary()) >= (Salary_Frame - 1446))) {
                            TE_List.add(PlayerList.get(i));
                        }
                    }
                }
                return TE_List;

            case "FLEX":
                ArrayList<Player> FLEX_List = new ArrayList<Player>();
                for (int i = 0; i < PlayerList.size(); i++) {
                    if ((PlayerList.get(i).getPlayerPosition().equals("TE")) || (PlayerList.get(i).getPlayerPosition().equals("WR")) || (PlayerList.get(i).getPlayerPosition().equals("RB")))
                        if (((PlayerList.get(i).getPlayerSalary()) <= (Salary_Frame + 710)) && ((PlayerList.get(i).getPlayerSalary()) >= (Salary_Frame - 710))) {
                            FLEX_List.add(PlayerList.get(i));
                        }
                }
                return FLEX_List;


            case "DST":
                ArrayList<Player> DST_List = new ArrayList<Player>();
                for (int i = 0; i < PlayerList.size(); i++) {
                    if (PlayerList.get(i).getPlayerPosition().equals("DST")) {
                        if (((PlayerList.get(i).getPlayerSalary()) <= (Salary_Frame + 605)) && ((PlayerList.get(i).getPlayerSalary()) >= (Salary_Frame - 605))) {
                            DST_List.add(PlayerList.get(i));
                        }
                    }
                }
                return DST_List;
        }


        return null;
    }

    static ArrayList<ArrayList<Player>> team_builder(ArrayList<ArrayList<Player>> List_of_Lists){
        ArrayList<Player> current_team = new ArrayList<>(9);
        ArrayList<ArrayList<Player>> potential_teams= new ArrayList<>();
        // Number of arrays
        int n = List_of_Lists.size();

        // To keep track of next element in the array
        int []indices = new int[n];

        // Initialize with first element's index
        for(int i = 0; i < n; i++)
            indices[i] = 0;

        while (true)
        {

            for(int i = 0; i < n; i++){
                current_team.add(List_of_Lists.get(i).get(indices[i]));
                if (current_team.size()==9) {
                    if (tools.team_check(current_team)){
                        potential_teams.add(current_team);
                        System.out.println(current_team);
                }
                current_team.clear();
                }
                if(potential_teams.size() == 100)
                    System.out.println(potential_teams);


            // Find the rightmost array that has more
            // elements left after the current element
            // in that array
            int next = n - 1;
            while (next >= 0 &&
                    (indices[next] + 1 >=
                            List_of_Lists.get(next).size()))
                next--;

            // No such array is found so no more
            // combinations left
            if (next < 0)
                return(potential_teams);

            // If found move to next element in that
            // array
            indices[next]++;

            // For all arrays to the right of this
            // array current index again points to
            // first element
            for(int k = next + 1; k < n; k++){
                indices[k] = 0;}
        }
    }


}}

