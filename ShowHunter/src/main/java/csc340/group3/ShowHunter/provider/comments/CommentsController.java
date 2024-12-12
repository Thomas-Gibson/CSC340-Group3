package csc340.group3.ShowHunter.provider.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

@Controller
@RequestMapping("/venues")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @GetMapping("/{id}/comments")
    public String getComments(@PathVariable int id, Model model) {
        model.addAttribute("comments", commentsService.getCommentsByVenue(id));
        model.addAttribute("venueId", id);
        model.addAttribute("newComment", new Comments());
        return "comments";
    }

    @PostMapping("/{id}/comments/new")
    @Transactional
    public String addComment(@PathVariable int id, @ModelAttribute("text") String text) {
        Comments comment = new Comments();
        comment.setText(text);
        commentsService.addComment(comment, id);
        return "redirect:/venues/" + id + "/comments";
    }

    @GetMapping("/comments/delete/{commentId}/{venueId}")
    public String deleteComment(@PathVariable("commentId") int commentId, 
                              @PathVariable("venueId") int venueId) {
        commentsService.deleteComment(commentId);
        return "redirect:/venues/" + venueId + "/comments";
    }
}
