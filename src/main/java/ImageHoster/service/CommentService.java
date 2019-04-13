package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

@Autowired
        private CommentRepository commentRepository;

        //retrieves all the comments related an image, from the database
        /*public Tag getComments(Image image) {
        return commentRepository.(tag);
        }*/

        public Comment createComment(Comment comment) {
            return commentRepository.createComment(comment);
        }
}
