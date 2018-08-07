/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.kodnet.plugins.sample;

import com.atlassian.confluence.core.ConfluenceActionSupport;
import com.opensymphony.xwork.ActionContext;
import java.util.List;

/**
 *
 * @author haunt
 */
public class OutputaoFormAction extends ConfluenceActionSupport {

    private List<Todo> todoList;
    private TodoService todoService;

    @Override
    public String execute() throws Exception {
        ActionContext context = ActionContext.getContext();
        //String description = (String)context.getParameters().get("task");
        boolean isComplete = true;
        String description = getParameterValue(context, "task");
        String id = getParameterValue(context, "id");
        int complete = Integer.parseInt(this.getParameterValue(context, "complete"));
        if (complete == 1){
            isComplete = true;
        } else if (complete == 0){
            isComplete = false;
        }
        if (description != null) {
            todoService.add(description, isComplete , id);            
            //this.todoList = this.todoService.all(); 
            if(isComplete == false){
                this.todoList = this.todoService.getById(id);
            } else {
                this.todoList = this.todoService.all(); 
            }
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    private String getParameterValue(ActionContext context, String key) {
        Object paramValues = context.getParameters().get(key);
        if (paramValues instanceof String[] && ((String[]) paramValues).length != 0) {
            return ((String[]) paramValues)[0];
        } else if (paramValues instanceof String) {
            return (String) paramValues;
        }
        return null;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }

    public void setTodoService(TodoService todoService) {
        this.todoService = todoService;
    }

    public TodoService getTodoService() {
        return todoService;
    }
}
