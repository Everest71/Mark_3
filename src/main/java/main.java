import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;



public class main {
    static ArrayList<Player> PlayerDatabase = new ArrayList<Player>();
    static int QB_Salary_Frame = 6565;
    static int RB1_Salary_Frame = 6506;
    static int RB2_Salary_Frame = 5424;
    static int WR1_Salary_Frame = 7547;
    static int WR2_Salary_Frame = 6329;
    static int WR3_Salary_Frame = 4959;
    static int TE_Salary_Frame = 4700;
    static int FLEX_Salary_Frame = 4512;
    static int DST_Salary_Frame = 3100;
    static ArrayList<Player> QB_Potentials_List;
    static ArrayList<Player> RB1_Potentials_List;
    static ArrayList<Player> RB2_Potentials_List;
    static ArrayList<Player> WR1_Potentials_List;
    static ArrayList<Player> WR2_Potentials_List;
    static ArrayList<Player> WR3_Potentials_List;
    static ArrayList<Player> TE_Potentials_List;
    static ArrayList<Player> FLEX_Potentials_List;
    static ArrayList<Player> DST_Potentials_List;
    static ArrayList<ArrayList<Player>> List_of_all_Lists=new ArrayList<>(9);

    public static void main(String[] args) throws FileNotFoundException {

            Scanner pregameData = new Scanner((new File("C:\\Users\\Everest\\IdeaProjects\\Mark 3\\src\\main\\java\\DKsalaries.csv")));
            String clear = pregameData.nextLine();
            String local;
            String holder;
            int PlayerRanking = 1;
            while(pregameData.hasNextLine()){
                String[] info = pregameData.nextLine().split(",");
                holder = info[6].split("@")[0];
                if (holder.equals(info[7]))
                    local = "Away";
                else {
                    local = "Home";}
                PlayerDatabase.add(new Player(info[1],Integer.parseInt(info[5]),Double.parseDouble(info[8]),info[4].split("/")[0],info[7],local,info[6].split(" ")[2],PlayerRanking));
                PlayerRanking++;
            }



        QB_Potentials_List = tools.Positional_Salary_Check(PlayerDatabase,QB_Salary_Frame,"QB");
        RB1_Potentials_List = tools.Positional_Salary_Check(PlayerDatabase,RB1_Salary_Frame,"RB1");
        RB2_Potentials_List = tools.Positional_Salary_Check(PlayerDatabase,RB2_Salary_Frame,"RB2");
        WR1_Potentials_List = tools.Positional_Salary_Check(PlayerDatabase,WR1_Salary_Frame,"WR1");
        WR2_Potentials_List = tools.Positional_Salary_Check(PlayerDatabase,WR2_Salary_Frame,"WR2");
        WR3_Potentials_List = tools.Positional_Salary_Check(PlayerDatabase,WR3_Salary_Frame,"WR3");
        TE_Potentials_List = tools.Positional_Salary_Check(PlayerDatabase,TE_Salary_Frame,"TE");
        FLEX_Potentials_List = tools.Positional_Salary_Check(PlayerDatabase,FLEX_Salary_Frame,"FLEX");
        DST_Potentials_List = tools.Positional_Salary_Check(PlayerDatabase,DST_Salary_Frame,"DST");



        List_of_all_Lists.add(QB_Potentials_List);
        List_of_all_Lists.add(RB1_Potentials_List);
        List_of_all_Lists.add(RB2_Potentials_List);
        List_of_all_Lists.add(WR1_Potentials_List);
        List_of_all_Lists.add(WR2_Potentials_List);
        List_of_all_Lists.add(WR3_Potentials_List);
        List_of_all_Lists.add(TE_Potentials_List);
        List_of_all_Lists.add(FLEX_Potentials_List);
        List_of_all_Lists.add(DST_Potentials_List);



        Scanner keyboard = new Scanner(System.in);
        String answer;
        while (true){
            System.out.println("What shall I do?\nGO.)Build Teams\nQB.)Output Quarterbacks\nHome.)Only Home Teams\nQuit.)Quit");
            answer = keyboard.nextLine();
        switch(answer.toUpperCase(Locale.ROOT)){
            case "GO":
                tools.team_builder(List_of_all_Lists);
                break;
            case "QB":
                for (int i = 0; i < QB_Potentials_List.size(); i++) {
                    System.out.println(QB_Potentials_List.get(i));
                }
                break;



            case "HOME":
                //Remove any players who are not playing at home(Away)
                for (int i = 0; i < QB_Potentials_List.size();) {
                    if (QB_Potentials_List.get(i).getPlayer_location().equals("Away")){
                        QB_Potentials_List.remove(i);  //If the Player's local is Away, Remove the Player
                    }

                    else if (QB_Potentials_List.get(i).getPlayer_location().equals("Home")){
                        i++;  //If the Player's local is home, continue the loop at the next iteration
                    }
                }






                break;
            case "D":
                System.exit(1);
                break;

        }}






    }}
