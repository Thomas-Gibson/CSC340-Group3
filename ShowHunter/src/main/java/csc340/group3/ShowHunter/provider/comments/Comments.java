//package csc340.group3.ShowHunter.provider.comments;
//
//import csc340.group3.ShowHunter.provider.venue.Venue;
//import jakarta.persistence.*;
//
//import java.util.Optional;
//
//@Entity
//@Table(name = "comments")
//public class Comments {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int commentid;
//    public int userid;
//    public String text;
//
//
//    public Comments() {
//        this.commentid = 1;
//        this.userid = 2;
//        this.text = "default";
//    }
//
//
//    public void setCommentid(int commentid) {
//        this.commentid = commentid;
//    }
//
//    public int getUserid() {
//        return userid;
//    }
//
//    public int getCommentid() {
//        return commentid;
//    }
//
////    public int getVenueid() {
////        return venueid;
////    }
//
//    public String getText() {
//        return text;
//    }
//
////    public Venue getVenue() {
////        return venue;
////    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    public void setUserid(int userid) {
//        this.userid = userid;
//    }
//
////    public void setVenueid(int venueid) {
////        this.venueid = venueid;
//    }
////}
