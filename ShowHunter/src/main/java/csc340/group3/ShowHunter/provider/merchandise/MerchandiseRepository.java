package csc340.group3.ShowHunter.provider.merchandise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;


import java.util.List;

@Repository
public interface MerchandiseRepository extends JpaRepository<Merchandise, Integer> {

    @Query(value = "SELECT a FROM Merchandise a WHERE a.name LIKE %?1%", nativeQuery = true)
    Optional<Merchandise> findByNameContaining(String name);
}