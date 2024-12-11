package csc340.group3.ShowHunter.provider.merchandise;

import csc340.group3.ShowHunter.provider.shows.Shows;
import csc340.group3.ShowHunter.provider.venues.Venue;
import jakarta.persistence.*;

@Entity
@Table(name = "merchandise")
public class Merchandise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public String image;
    public double price;
    public String description;


    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    private Shows show;

    public Merchandise() {

        this.image = "default";
        this.price = 1.0;
        this.description = "default";

    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public Shows getShow() {
        return show;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setShow(Shows show) {
        this.show = show;
    }
}
