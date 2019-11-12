package ohtu;

public class Player implements Comparable<Player> {

    private String name;
    private String team;
    private int goals;
    private int assists;
    private String nationality;

    public void setName(String name, String team, int goals, int assists, String nationality) {
        this.name = name;
        this.team = team;
        this.goals = goals;
        this.assists = assists;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return this.nationality;
    }

    @Override
    public String toString() {
        return String.format("%-20s", this.name) + " " + this.team + " " + String.format("%2d", this.goals) + " + "
                + String.format("%2d", this.assists) + " = " + (this.goals + this.assists);
    }

    @Override
    public int compareTo(Player o) {
        return (o.goals + o.assists) - (this.goals + this.assists);
    }

}
