/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.kodnet.plugins.sample;

/**
 *
 * @author haunt
 */
public interface BlogService {
    Blog getBlog();
    Post addPost(String title, String text, String labels);
    Comment addComment(Post post, String author, String comment);
    
    Iterable<Post> allPosts();
    
    Post getPost(int id);

    void deletePost(Post post);
}
