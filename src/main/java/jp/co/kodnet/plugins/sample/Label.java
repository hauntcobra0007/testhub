/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.kodnet.plugins.sample;

import net.java.ao.Entity;
import net.java.ao.ManyToMany;
import net.java.ao.Preload;

/**
 *
 * @author haunt
 */
@Preload
public interface Label extends Entity {
    
    public String getName();
    public void setName(String name);
    
    @ManyToMany(value = PostToLabel.class)
    public Post[] getPosts();
}
