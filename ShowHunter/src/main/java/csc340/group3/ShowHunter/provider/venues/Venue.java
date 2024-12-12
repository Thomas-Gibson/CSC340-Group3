package csc340.group3.ShowHunter.provider.venues;
//import csc340.group3.ShowHunter.provider.comments.Comments;
import csc340.group3.ShowHunter.provider.shows.Shows;
import csc340.group3.ShowHunter.provider.comments.Comments;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "venues")
public class Venue {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(nullable = false)
    public String name;
    public String profile_pic;
    public String description;

    @OneToMany(mappedBy = "venue", cascade = CascadeType.ALL)
    private List<Shows> shows = new ArrayList<>();

    @OneToMany(mappedBy = "venue", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comments> comments = new ArrayList<>();

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

    public void addShow(Shows show) {
        shows.add(show);
        show.setVenue(this);
    }

    public void removeShow(Shows show) {
        shows.remove(show);
        show.setVenue(null);
    }

    public List<Shows> getShows(){
        return shows;
    }

    public void setShows(List<Shows> shows) {
        this.shows = shows;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public void addComment(Comments comment) {
        comments.add(comment);
        comment.setVenue(this);
    }

    public void removeComment(Comments comment) {
        comments.remove(comment);
        comment.setVenue(null);
    }

}