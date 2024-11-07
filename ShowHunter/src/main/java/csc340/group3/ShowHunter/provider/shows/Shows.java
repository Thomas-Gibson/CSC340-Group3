package csc340.group3.ShowHunter.provider.shows;

import jakarta.persistence.*;

@Entity
@Table(name = "shows")
public class Shows {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    public String name;
    public String image;
    public String description;
    public String ticket;
    public int venue_id;

    public Shows(int id, int venue_id, String name, String image, String description, String ticket){
        this.id = id;
        this.venue_id = venue_id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.ticket = ticket;

    }

    public Shows() {
        this.id = 100;
        this.venue_id = 1;
        this.name = "default";
        this.description = "default";
        this.ticket = "default";
    }

    public int getShowId() {
        return this.id;
    }

    public void setShowId(int id) {
        this.id = id;
    }

    public String getShowName() {
        return this.name;
    }

    public void setShowName(String name) {
        this.name = name;
    }

    public String getShowDescription() {
        return this.description;
    }

    public void setShowDescription(String description) {
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
}