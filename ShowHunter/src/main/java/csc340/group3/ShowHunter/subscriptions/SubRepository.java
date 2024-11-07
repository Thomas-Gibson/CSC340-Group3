package csc340.group3.ShowHunter.subscriptions;

import csc340.group3.ShowHunter.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubRepository extends JpaRepository<Sub, Integer> {

    @Query(value = "select * from subscriptions s where s.user_id = ?1", nativeQuery = true)
    List<Sub> getSubSubscriptionsByUser(int id);

    @Query(value = "select * from subscriptions s where s.venue_id = ?1", nativeQuery = true)
    List<Sub> getSubSubscriptionsByVenue(int id);
}
