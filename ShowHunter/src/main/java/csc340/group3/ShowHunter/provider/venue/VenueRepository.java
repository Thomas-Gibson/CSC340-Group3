package csc340.group3.ShowHunter.provider.venue;

import csc340.group3.ShowHunter.provider.venue.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;


import java.util.List;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Integer> {

    @Query(value = "SELECT a FROM Venue a WHERE a.name LIKE %?1%", nativeQuery = true)
    Venue findByNameContaining(String name);
    Venue findById(int id);
}