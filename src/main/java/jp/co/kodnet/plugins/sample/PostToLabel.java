/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.kodnet.plugins.sample;

import net.java.ao.Entity;
import net.java.ao.Preload;

/**
 *
 * @author haunt
 */
@Preload
public interface PostToLabel extends Entity{
    public void setPost(Post post);
    public Post getPost();

    public void setLabel(Label label);
    public Label getLabel();
}
