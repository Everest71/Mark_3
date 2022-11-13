public class Player {

    private String playerPosition;
    private String playerName;
    private int playerSalary;
    private Double playerfppg;
    private int playerRanking;
    private String player_team;
    private String player_location;
    private String time_of_game;


    public Player(String name, int salary, double fppg, String position, String team, String location, String kickoff_time,int ranking){
        playerName = name;
        playerPosition = position;
        playerSalary = salary;
        playerfppg = fppg;
        player_team = team;
        player_location = location;
        time_of_game =  kickoff_time;
        playerRanking = ranking;

    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public Double getPlayerfppg() {
        return playerfppg;
    }

    public int getPlayerRanking() {
        return playerRanking;
    }

    public int getPlayerSalary() {
        return playerSalary;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayer_location() {
        return player_location;
    }

    public String getPlayer_team() {
        return player_team;
    }

    public String getTime_of_game() {
        return time_of_game;
    }

    @Override
    public String toString() {
        return playerName+" :"+playerPosition+", "+playerSalary+", "+playerfppg+", "+player_team+", "+player_location+", "+time_of_game;
    }
}
