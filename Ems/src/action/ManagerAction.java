package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import service.ManagerService;
import service.impl.ManagerServiceImpl;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import entity.Manager;

public class ManagerAction {

	private Manager manager;
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	//1.登录
	public String LoginManagerAction() throws Exception {
		System.out.println("登录的账号："+manager);
		System.out.println("登录的昵称为："+manager.getUsername());
		HttpServletRequest req = ServletActionContext.getRequest();
		Manager m=null;
		//2.调用业务
		ManagerService ms =new ManagerServiceImpl();
		try{
			m=ms.login(manager.getUsername());
			if(m==null){
				throw new RuntimeException("用户名不存在");
			}else if(!m.getPassword().equals(manager.getPassword())){
				throw new RuntimeException("密码输入错误");
			}else{
				HttpSession session=req.getSession();
				session.setAttribute("login", "ok");
				session.setAttribute("username", manager.getUsername());
				return "loginOk";
			}
		}catch(Exception e){
			return "loginError";
		}
	}

	//2.注册
	public String RegistManagerAction() throws Exception {
		HttpServletRequest req = ServletActionContext.getRequest();
		ManagerService ms =new ManagerServiceImpl();
		try{
			ms.regist(manager);
			HttpSession session =req.getSession();
			session.setAttribute("login", "ok");
			session.setAttribute("username", manager.getUsername());
			//3.跳转
			return "registOk";
		}catch(Exception e){
			return "registError";
		}
	}
}
