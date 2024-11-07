package csc340.group3.ShowHunter.subscriptions;

import jakarta.persistence.*;

@Entity
@Table(name = "subscriptions")
public class Sub {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private int userId;

    @Column(nullable = false)
    private int venueId;

    public Sub() {}

    public Sub(int id, int userId, int venueId) {
        this.id = id;
        this.userId = userId;
        this.venueId = venueId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }
}
