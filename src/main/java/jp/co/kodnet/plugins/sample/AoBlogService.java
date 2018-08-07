/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.kodnet.plugins.sample;
import static com.google.common.base.Preconditions.checkNotNull;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.java.ao.EntityManager;
import net.java.ao.Query;

/**
 *
 * @author haunt
 */
public final class AoBlogService implements BlogService{

    private final EntityManager entityManager;
    
    public AoBlogService(EntityManager entityManager){
        this.entityManager = checkNotNull(entityManager);
    }
    
    @Override
    public Blog getBlog() {
        try 
        {
            final Blog blog = getSingleBlog();
            return blog != null ? blog : createBlog();
        } 
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Post addPost(String title, String text, String labels) {
        try {
            final Blog blog = getBlog();
            final Post post = entityManager.create(Post.class);
            post.setBlog(blog);
            post.setPublished(Calendar.getInstance());
            post.setText(text);
            post.setTitle(title);
            post.save();
            return post;
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }

    @Override
    public Comment addComment(Post post, String author, String comment) {
        try {
            final Comment c = entityManager.create(Comment.class);
            c.setPost(post);
            c.setName(author);
            c.setComment(comment);
            c.save();
            return c;
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }

    @Override
    public Iterable<Post> allPosts() {
        try {
//            final Query query = Query.select().where("blogID = ?", getBlog()).order("published DESC");
//                    return Lists.newArrayList(entityManager.find(Post.class, query));
                return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Post getPost(int id) {
        try {
            return entityManager.get(Post.class, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletePost(Post post) {
        try {
            entityManager.delete(post.getComments());
            entityManager.delete(post);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    private Blog getSingleBlog() throws SQLException {
       final Blog[] blogs = entityManager.find(Blog.class);
       if (blogs.length > 1)
       {
           throw new IllegalStateException("Application cannot have more than 1 blog");
       }
       return blogs.length > 0 ? blogs[0] : null;
       
    }

    private Blog createBlog() throws SQLException {
        final Blog blog = entityManager.create(Blog.class);
        blog.setName("Active Objects Dog Food Blog");
        blog.save();
        return blog;
    }
    
}
