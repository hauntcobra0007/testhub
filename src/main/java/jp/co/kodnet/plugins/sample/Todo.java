/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.kodnet.plugins.sample;
import net.java.ao.Entity;
import net.java.ao.Preload;
import net.java.ao.schema.AutoIncrement;
import net.java.ao.schema.NotNull;
import net.java.ao.schema.PrimaryKey;

/**
 *
 * @author haunt
 */
@Preload
public interface Todo extends Entity{
    @PrimaryKey
    @NotNull
    @AutoIncrement
    int getPrimary();
 
    
    String getTodoId();
    void setTodoId(String todoId);
    
    String getDescription();
    void setDescription(String description);
    
    boolean isComplete();
    void setComplete(boolean complete);
    
}
