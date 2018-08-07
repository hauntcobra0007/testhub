/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.kodnet.plugins.sample;

import net.java.ao.Entity;

/**
 *
 * @author haunt
 */
public interface Comment extends Entity {
	public String getName();
	public void setName(String name);
	
	public String getComment();

	public void setComment(String comment);
	
	public Post getPost();
	public void setPost(Post post);
}