package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ExitAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		HttpServletRequest req = ServletActionContext.getRequest();
		//1.获取session对象
		HttpSession session =req.getSession();
		//2.将session对象清空
		session.invalidate();
		//3.跳转登录页面
		//res.sendRedirect(req.getContextPath()+"/ems/login.jsp");
		return "exit";
	}
	
}
