/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.kodnet.plugins.sample;

import com.atlassian.confluence.core.ConfluenceActionSupport;

/**
 *
 * @author haunt
 */
public class InputFormAction extends ConfluenceActionSupport{
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
