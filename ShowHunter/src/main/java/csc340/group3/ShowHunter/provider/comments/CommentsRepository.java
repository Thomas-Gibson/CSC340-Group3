//package csc340.group3.ShowHunter.provider.comments;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//import java.util.Optional;
//
//
//import java.util.List;
//
//@Repository
//public interface CommentsRepository extends JpaRepository<Comments, Integer> {
//
//    @Query(value = "SELECT a FROM Comments a WHERE a.name LIKE %?1%", nativeQuery = true)
//    Optional<Comments> findByNameContaining(String name);
//    Optional<Comments> findByVenueId(int id);
//}