package csc340.group3.ShowHunter.provider.venues;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Integer> {

    @Query(value = "SELECT a FROM Venue a WHERE a.name LIKE %?1%", nativeQuery = true)
    Venue findByNameContaining(String name);
}