package csc340.group3.ShowHunter.provider.shows;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;


import java.util.List;

@Repository
public interface ShowsRepository extends JpaRepository<Shows, Integer> {

    @Query(value = "SELECT a FROM Shows a WHERE a.name LIKE %?1%", nativeQuery = true)
    Optional<Shows> findByNameContaining(String name);
}