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
		//1.��ȡsession����
		HttpSession session =req.getSession();
		//2.��session�������
		session.invalidate();
		//3.��ת��¼ҳ��
		//res.sendRedirect(req.getContextPath()+"/ems/login.jsp");
		return "exit";
	}
	
}
