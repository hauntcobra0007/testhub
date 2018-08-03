/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.kodnet.plugins.sample;

import com.atlassian.confluence.core.ConfluenceActionSupport;
import com.opensymphony.xwork.ActionContext;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haunt
 */
public class OutputFormAction extends ConfluenceActionSupport{
    
    private String uname;
    private String sexValue;
    private List<String> interestsValue;
    private String[] interestsStr = {" baseball","Football","rugby",
                                                "Sumo", "Tennis","Table Tennis"};
    private String[] sexStr = {"Male", "Female"};
    @Override
    public String execute() throws Exception {
        ActionContext context = ActionContext.getContext();
        setUname(this.getParameterValue(context, "uname"));
        if(getUname() == null || "".equals(getUname())){
            return ERROR;
        }
        int sex = Integer.parseInt(this.getParameterValue(context, "sex"));
        String[] interests = getParameterValues(context, "interests");
        setSexValue(getSexStr()[sex]);
        setInterestsValue(new ArrayList<String>());
        if(interests != null){
            for (String interest : interests){
                getInterestsValue().add(getInterestsStr()[Integer.parseInt(interest)]);
            }
        }
        return SUCCESS;
    }

    private String getParameterValue(ActionContext context, String key) {
        Object paramValues = context.getParameters().get(key);
        if(paramValues instanceof String[] && ((String[])paramValues).length != 0){
            return ((String[])paramValues)[0];
        } else if(paramValues instanceof String){
            return (String)paramValues;
        }
        return null;
    }
    private String[] getParameterValues(ActionContext context, String key) {
        Object paramValues = context.getParameters().get(key);
        if(paramValues instanceof String[] && ((String[])paramValues).length != 0){
            return (String[])paramValues;
        } 
        return new String[0];
    }

    /**
     * @return the uname
     */
    public String getUname() {
        return uname;
    }

    /**
     * @param uname the uname to set
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     * @return the sexValue
     */
    public String getSexValue() {
        return sexValue;
    }

    /**
     * @param sexValue the sexValue to set
     */
    public void setSexValue(String sexValue) {
        this.sexValue = sexValue;
    }

    /**
     * @return the interestsValue
     */
    public List<String> getInterestsValue() {
        return interestsValue;
    }

    /**
     * @param interestsValue the interestsValue to set
     */
    public void setInterestsValue(List<String> interestsValue) {
        this.interestsValue = interestsValue;
    }

    /**
     * @return the interestsStr
     */
    public String[] getInterestsStr() {
        return interestsStr;
    }

    /**
     * @param interestsStr the interestsStr to set
     */
    public void setInterestsStr(String[] interestsStr) {
        this.interestsStr = interestsStr;
    }

    /**
     * @return the sexStr
     */
    public String[] getSexStr() {
        return sexStr;
    }

    /**
     * @param sexStr the sexStr to set
     */
    public void setSexStr(String[] sexStr) {
        this.sexStr = sexStr;
    }
    
}
