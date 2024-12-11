//package csc340.group3.ShowHunter.provider.merchandise;
//
//import csc340.group3.ShowHunter.provider.shows.Shows;
//import csc340.group3.ShowHunter.provider.venue.Venue;
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "merchandise")
//public class Merchandise {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//
//    public String image;
//    public double price;
//    public String description;
//    public int show_id;
//
//    public Merchandise() {
//
//        this.id = 1;
//        this.image = "default";
//        this.price = 1.0;
//        this.description = "default";
//
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public int getShowid() {
//        return show_id;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public void setShowid(int show_id) {
//        this.show_id = show_id;
//    }
//}
