package csc340.group3.ShowHunter.provider.comments;

import csc340.group3.ShowHunter.provider.venues.Venue;
import csc340.group3.ShowHunter.provider.venues.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;
    @Autowired
    private VenueRepository venueRepository;

    public Comments getCommentById(int id) {
        return commentsRepository.findById(id).orElse(null);
    }

    @Transactional
    public Comments addComment(String text, int venueId) {
        Venue venue = venueRepository.findById(venueId)
                .orElseThrow(() -> new RuntimeException("Venue not found"));
        
        Comments comment = new Comments();
        comment.setText(text);
        comment.setVenue(venue);
        comment.setUserid(1); 
        
        return commentsRepository.save(comment);
    }

    public List<Comments> getCommentsByVenue(int venueId) {
        return commentsRepository.findByVenueId(venueId);
    }

    @Transactional
    public void deleteComment(int id) {
        commentsRepository.deleteById(id);
    }
}
