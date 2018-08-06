/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.kodnet.plugins.sample;

import com.atlassian.activeobjects.external.ActiveObjects;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Lists.newArrayList;
import java.util.List;

/**
 *
 * @author haunt
 */
public class TodoServiceIml implements TodoService{

    private final ActiveObjects ao;
    public TodoServiceIml(ActiveObjects ao){
        this.ao = checkNotNull(ao);
    }
    @Override
    public Todo add(String description) {
        final Todo todo = ao.create(Todo.class);
        todo.setDescription(description);
        todo.setComplete(false);
        todo.save();
        return todo;
    }

    @Override
    public List<Todo> all() {
        return newArrayList(ao.find(Todo.class));
    }
    
}
