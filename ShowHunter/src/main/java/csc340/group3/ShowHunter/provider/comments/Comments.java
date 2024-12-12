package csc340.group3.ShowHunter.provider.comments;

import csc340.group3.ShowHunter.provider.venues.Venue;
import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentid", nullable = false, updatable = false)
    private int commentid;
    
    @Column(nullable = false)
    private String text;

    @Column(name = "userid", nullable = false)
    private int userid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "venue_id", nullable = false)
    private Venue venue;

    public Comments() {
        this.text = "default";
        this.userid = 1;
    }

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
