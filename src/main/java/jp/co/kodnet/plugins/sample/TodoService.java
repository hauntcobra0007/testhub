/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.kodnet.plugins.sample;

import com.atlassian.activeobjects.tx.Transactional;
import java.util.List;

/**
 *
 * @author haunt
 */
@Transactional
public interface TodoService {
    Todo add(String description, boolean complete, String id);
    List<Todo> all();
    List<Todo> getById(String todoId);
    //void associatePostToLabel(Post post, Label label) ;
}
