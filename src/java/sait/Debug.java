package sait;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author 679918
 */
public class Debug extends TagSupport {

private boolean debug;
    
    public void setDebug(boolean debug) {
        this.debug = debug;
    }
    
    @Override
    public int doStartTag() throws JspException {               
        String domain = pageContext.getRequest().getServerName();
           
        if (debug && (domain.equals("localhost") || domain.startsWith("test")) ) {
            return EVAL_BODY_INCLUDE;
        }

        return SKIP_BODY;
    }
}
