
public class User {
    String name ;
    public User(String name, int numberOfTickets) {
        this.name = name;
        this.numberOfTickets = numberOfTickets;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNumberOfTickets() {
        return numberOfTickets;
    }
    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
    int numberOfTickets;


}
