/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.kodnet.plugins.sample;
import static com.google.common.base.Preconditions.checkNotNull;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author haunt
 */
public class TodoServlet extends HttpServlet {

    //private final ActiveObjects ao;
    private final TodoService todoService;

    //public TodoServlet(ActiveObjects ao)
    public TodoServlet(TodoService todoService)
    {
        //this.ao = checkNotNull(ao);
        this.todoService = checkNotNull(todoService);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final PrintWriter w = response.getWriter();
        w.write("<h1>Todos</h1>");
        w.write("<form method=\"post\">");
        w.write("<input type=\"text\" name=\"task\" size=\"25\"/>");
        w.write("  ");
        w.write("<input type=\"submit\" name=\"submit\" value=\"Add\"/>");
        w.write("</form>");
        w.write("<ol>");
        //ao.executeInTransaction(new TransactionCallback<Void>()
        //{
            //@Override
            //public Void doInTransaction() 
            //{
                //for (Todo todo : ao.find(Todo.class) ) 
                for (Todo todo : todoService.all() ) 
                {
                 w.printf("<li><%2$s> %s </%2$s></li>", todo.getDescription(), todo.isComplete() ? "strike" : "strong");
                    
                }
                //return null;
            //}
        //});
        w.write("</ol>");
        w.write("<script language='javascript'>document.forms[0].elements[0].focus();</script>");
        w.close();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //final String description = request.getParameter("task");
        //ao.executeInTransaction(new TransactionCallback<Todo>() {
            //@Override
           // public Todo doInTransaction() {
                //final Todo todo = ao.create(Todo.class);
                //todoService.add(description);
                //todo.setDescription(description);
                //todo.setComplete(false);
                //todo.save();
                //return todo;
            //}
        //});
        response.sendRedirect(request.getContextPath()+ "/plugins/servlet/todo/list");
    }

}
