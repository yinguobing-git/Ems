package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import service.EmsService;
import service.impl.EmsServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

import entity.Ems;

@SuppressWarnings("serial")
public class EmsAction extends ActionSupport{
	private Ems ems;
	private List<Integer>ids;
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	public Ems getEms() {
		return ems;
	}
	public void setEms(Ems ems) {
		this.ems = ems;
	}

	//�����ϵ��
	public String AddEmsAction() throws Exception {
		HttpServletRequest req = ServletActionContext.getRequest();
		//����ҵ��
		try{
			EmsService es =new EmsServiceImpl();
			es.regist(ems);
			return "addOk";
		}catch(Exception ee){
			String message=ee.getMessage();
			req.setAttribute("message", message);
			return "addError";
		}
	}

	//����ɾ����ϵ��
	public String DeleteMoreEmsAction() throws Exception {
		EmsService es =new EmsServiceImpl(); 
		if(ids==null){
			return "deleteError";
		}else{
			for (int i = 0; i < ids.size(); i++) {
				es.remove(ids.get(i));
			}
			return "deleteMoreOk";
		}
	}

	public String DeleteEmsAction() throws Exception {
		//����ҵ��
		EmsService es =new EmsServiceImpl(); 
		es.remove(id);
		//��ת
		return "deleteOk";
	}

	//�޸���ϵ��
	public String UpdateEmsAction() throws Exception {
		HttpServletRequest req = ServletActionContext.getRequest();
		try{
			//����ҵ��
			EmsService es =new EmsServiceImpl(); 
			es.update(ems);
			HttpSession session=req.getSession();
			session.setAttribute("ems", ems);
			return "updateOk";
		}catch(Exception ee){
			return "updateError";
		}
	}

	//�鵥����ϵ��
	public String QuerryEmsByIdAction() throws Exception {
		HttpServletRequest req = ServletActionContext.getRequest();
		EmsService es =new EmsServiceImpl();
		//����ҵ��
		System.out.println("Ҫ�޸ĵ�Ա�����Ϊ��"+id);
		Ems ems=es.queryById(id);
		System.out.println(ems);
		HttpSession session=req.getSession();
		session.setAttribute("ems", ems);
		return "queryOk";
	}

	//��ѯ������ϵ��
	public String ShowAllEmsAction() throws Exception {
		HttpServletRequest req = ServletActionContext.getRequest();
		//����ҵ��
		EmsService es =new EmsServiceImpl(); 
		List<Ems>list=new ArrayList<Ems>();
		list=es.queryAll();
		req.setAttribute("list", list);
		//��ת
		return "showOk";
	}
}

