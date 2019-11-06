package interceptor;

import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		//1.ªÒ»°session
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session =request.getSession();
		String s=(String)session.getAttribute("login");
		if(s==null){
			return "error";
		}else{
			ai.invoke();
		}
		return null;
	}
}
