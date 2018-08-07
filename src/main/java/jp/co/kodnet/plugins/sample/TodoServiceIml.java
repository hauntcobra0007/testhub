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
import net.java.ao.Query;

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
    public Todo add(String description, boolean complete, String id) {
        final Todo todo = ao.create(Todo.class);
        todo.setDescription(description);
        todo.setComplete(complete);
        todo.setTodoId(id);
        todo.save();
        return todo;
    }

    @Override
    public List<Todo> all() {
        //  List<Todo> listTodo = 
        //newArrayList(ao.find(Todo.class, Query.select().where("complete = ? ", param)));
        return newArrayList(ao.find(Todo.class));
    }

    @Override
    public List<Todo> getById(String todoId) {
        List<Todo> todoList = newArrayList(ao.find(Todo.class, Query.select().where("TODO_ID = ?", todoId)));
        return todoList;
    }
    
}
