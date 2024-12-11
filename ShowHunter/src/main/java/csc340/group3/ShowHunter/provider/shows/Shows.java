package csc340.group3.ShowHunter.provider.shows;
import csc340.group3.ShowHunter.provider.venues.Venue;

//import csc340.group3.ShowHunter.provider.merchandise.Merchandise;
import jakarta.persistence.*;

@Entity
@Table(name = "shows")
public class Shows {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    public String name;
    public String image;
    public String description;
    public String ticket;

    @Column(nullable = false)
    public String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id", nullable = false)
    private Venue venue;

    public Shows(int id, String name, String image, String description, String ticket){
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.ticket = ticket;

    }

    public Shows() {
        this.name = "default";
        this.description = "default";
        this.ticket = "default";
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTicket() {
        return this.ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Venue getVenue(){
        return venue;
    }

    public void setVenue(Venue venue) {
         this.venue = venue;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }
}
