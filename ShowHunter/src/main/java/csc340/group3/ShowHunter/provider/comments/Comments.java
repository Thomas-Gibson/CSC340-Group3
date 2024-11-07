package csc340.group3.ShowHunter.provider.comments;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    public int userid;
    public int venueid;
    public String text;

    public Comments() {
        this.id = 1;
        this.userid = 2;
        this.venueid = 3;
        this.text = "default";
    }
}
