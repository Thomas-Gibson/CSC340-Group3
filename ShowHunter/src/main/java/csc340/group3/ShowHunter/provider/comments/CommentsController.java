//package csc340.group3.ShowHunter.provider.comments;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/venues")
//public class CommentsController {
//
//    @Autowired
//    private CommentsService commentsService;
//
//    @GetMapping ("{id}/comments")
//    public Optional<Comments> getComments(@PathVariable int id) {
//        return commentsService.getComments(id);
//    }
//
//    @PostMapping ("/{id}/comments/new")
//    public Comments addComment(@RequestBody Comments comment) {
//        return commentsService.addComment(comment);
//    }
//
//
//}
