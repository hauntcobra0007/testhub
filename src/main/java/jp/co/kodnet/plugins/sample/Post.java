/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.kodnet.plugins.sample;
import java.util.Calendar;
import net.java.ao.Entity;
import net.java.ao.ManyToMany;
import net.java.ao.OneToMany;
import net.java.ao.Preload;
/**
 *
 * @author haunt
 */
@Preload
public interface Post extends Entity{
    
    public String getTitle();

    public void setTitle(String title);

    public String getText();

    public void setText(String text);

    public Calendar getPublished();
    public void setPublished(Calendar published);

    public Blog getBlog();
    
    public void setBlog(Blog blog);

    @OneToMany
    public Comment[] getComments();

    @ManyToMany(value = PostToLabel.class)
    public Label[] getLabels();
}
