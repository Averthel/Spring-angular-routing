package pl.ave.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ave.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
