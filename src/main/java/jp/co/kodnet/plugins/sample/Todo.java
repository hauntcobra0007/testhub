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
public interface Todo extends Entity{
    String getDescription();
    void setDescription(String description);
    boolean isComplete();
    void setComplete(boolean complete);
}
