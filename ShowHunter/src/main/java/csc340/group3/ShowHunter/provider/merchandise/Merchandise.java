package csc340.group3.ShowHunter.provider.merchandise;

import jakarta.persistence.*;

@Entity
@Table(name = "merchandise")
public class Merchandise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    public int showid;
    public String image;
    public double price;
    public String description;


    public Merchandise() {
        this.id = 1;
        this.showid = 2;
        this.image = "default";
        this.price = 1.0;
        this.description = "default";

    }
}
