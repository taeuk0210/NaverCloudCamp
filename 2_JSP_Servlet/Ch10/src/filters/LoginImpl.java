package filters;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;


@WebListener
public class LoginImpl implements HttpSessionBindingListener {

	String id;
	String pw;
	public static int total = 0;
    public LoginImpl() { }
    public LoginImpl(String id, String pw) {
    	this.id=id;
    	this.pw=pw;
    }


    @Override
    public void valueBound(HttpSessionBindingEvent event)  { 
    	++total;
    }


    @Override
    public void valueUnbound(HttpSessionBindingEvent event)  { 
    	total--;
    }
	
}
