package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.TAdminDAO;
import com.dao.THuiyuanDAO;
import com.model.TAdmin;
import com.model.THuiyuan;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Cart;

public class loginAction extends ActionSupport{
	private TAdminDAO adminDAO;
	private THuiyuanDAO huiyuanDAO;
	
	public String login(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String userName = request.getParameter("userName");
		String userPassWord = request.getParameter("userPassWord");
		int userType = Integer.parseInt(request.getParameter("userType"));
		String result = "no";
		if(userType==0){
			//系统管理员登录
			String sql="from TAdmin where userName=? and userPw=?";
			Object[] con={
				userName.trim(),
				userPassWord.trim()
			};
			List adminList=adminDAO.getHibernateTemplate().find(sql,con);
			if(adminList.size()==0){
				 result="no";
			}else{
				 TAdmin admin=(TAdmin)adminList.get(0);
				 session.setAttribute("userType", 0);
	             session.setAttribute("admin", admin);
	             result="yes";
			}
		}
		if(userType==1){
			System.out.println(userName+"GG");
			System.out.println(userPassWord+"GG");
			
			String sql="from THuiyuan where loginname=? and loginpw=? and del='no'";
			Object[] con={
				userName.trim(),
				userPassWord.trim()
			};
			List huiyuanList=huiyuanDAO.getHibernateTemplate().find(sql,con);
			if(huiyuanList.size()==0){
				 result="no";
			}else{
				 THuiyuan huiyuan=(THuiyuan)huiyuanList.get(0);
				 session.setAttribute("userType", 1);
	             session.setAttribute("huiyuan", huiyuan);
	             
	             Cart cart=new Cart();
				 session.setAttribute("cart", cart);
				 
	             result="yes";
			}
		}
		if(userType==2){
			
		}
		return result;
	}

	public TAdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(TAdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	public THuiyuanDAO getHuiyuanDAO() {
		return huiyuanDAO;
	}

	public void setHuiyuanDAO(THuiyuanDAO huiyuanDAO) {
		this.huiyuanDAO = huiyuanDAO;
	}

}
