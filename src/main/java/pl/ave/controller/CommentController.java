package pl.ave.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.ave.model.Comment;
import pl.ave.repository.CommentRepository;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/comments")
public class CommentController {

    private CommentRepository commentRepository;

    @Autowired
    public CommentController(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Comment>> findAll(){
        List<Comment> allComents = commentRepository.findAll();
        return ResponseEntity.ok(allComents);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id){
        Comment comment = commentRepository.findById(id).orElse(null);
        return ResponseEntity.ok(comment);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveComment(@RequestBody Comment comment){
        Comment save = commentRepository.save(comment);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{}id")
                .buildAndExpand(save.getId())
                .toUri();
        return ResponseEntity.created(location).body(save);
    }

}