package com.example.springbootrestservice.api;

import com.example.springbootrestservice.entity.Comment;
import com.example.springbootrestservice.entity.Post;
import com.example.springbootrestservice.repositories.CommentRepository;
import com.example.springbootrestservice.repositories.PostRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/posts")
public class PostController {

  @Autowired
  PostRepository postRepository;

  @Autowired
  CommentRepository commentRepository;

  @ResponseStatus(HttpStatus.CREATED)
  @RequestMapping(value="",method = RequestMethod.POST)
  public Post createPost(@RequestBody Post post){
    return postRepository.save(post);
  }

  @RequestMapping(value="", method = RequestMethod.GET)
  public List<Post> listPosts() {

    return postRepository.findAll();
  }

  @RequestMapping(value="/{id}", method = RequestMethod.GET )
  public Post getPost(@PathVariable("id") Integer id) {

    Post post = postRepository.getOne(id);

    if(post == null) {
      throw new ResourceNotFoundException("No post found with id=" + id);
    }
    return post;
  }

  @RequestMapping(value="/{id}", method = RequestMethod.PUT)
  public Post updatePost(@PathVariable("id") Integer id, @RequestBody @Valid Post post) {

    Post oldPost = postRepository.getOne(id);
    if(oldPost== null){
      throw new ResourceNotFoundException("no post found with id=" + id);
    }
    return postRepository.save(post);
  }

  @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
  public void deletePost(@PathVariable("id") Integer id) {

    Post post = postRepository.getOne(id);

    if(post == null) {
      throw new ResourceNotFoundException("no post found with id=" + id);
    }

    postRepository.delete(post);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @RequestMapping(value = "/{id}/comments", method = RequestMethod.POST)
  public void createPostComment(@PathVariable("id") Integer id, @RequestBody Comment comment){

    Post post = postRepository.getOne(id);

    if(post == null) {

      throw new ResourceNotFoundException("no found with id=" + id);

    }
    post.getComments().add(comment);
  }

  @RequestMapping(value = "/{postId}/comments/{commentId}", method = RequestMethod.GET)
  public Comment getPostComment(@PathVariable("postId") Integer postId,
                                @PathVariable("commentId") Integer commentId) {

      Comment comment = commentRepository.getOne(commentId);
      if(comment == null) {

        throw new ResourceNotFoundException("no found with comment id= "+ commentId);
      }
    return comment;
  }

  @RequestMapping(value="/{postId}/comments/{commentId}", method=RequestMethod.POST)
  public void deletePostComment(@PathVariable("postId") Integer postId,
                                @PathVariable("commentId") Integer commentId)
  {
    commentRepository.deleteById(commentId);
  }

}
