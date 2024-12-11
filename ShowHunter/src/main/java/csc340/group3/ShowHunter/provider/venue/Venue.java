package csc340.group3.ShowHunter.provider.venue;
import csc340.group3.ShowHunter.provider.comments.Comments;
import csc340.group3.ShowHunter.provider.shows.Shows;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "venues")
public class Venue {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column(nullable = false)
    public String name;
    public String profile_pic;
    public String description;


    public Venue(int id, String name, String profile_pic, String description) {
        this.id = id;
        this.name = name;
        this.profile_pic = profile_pic;
        this.description = description;
    }

    public Venue(){
        this.name = "name";
        this.profile_pic = "pfp";
        this.description = "default";
    }


    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getProfile_pic(){
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic){
        this.profile_pic = profile_pic;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

}