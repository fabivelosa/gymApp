package com.ait.gym.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.ait.gym.utils.Helper;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String password;
	private String userName;

	public Login(String password, String userName) {
		super();
		this.password = password;
		this.userName = userName;
	}

	public Login() {
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		System.out.println("Password = " + password);
		this.password = password;
	}

	public String getUserName() {

		return userName;
	}

	public void setUserName(String userName) {
		System.out.println("User = " + userName); 
		this.userName = userName;
	}

	public String loginYesNo() {

		Member member = getMemberbyUserName(userName);
		String message = "index.xhtml?faces-redirect=true";
		
		FacesContext context2 = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);
        
        
		if (member != null) {
			if (member.getPassword().equals(this.password) && member.getUserName().equals(this.userName)) {
				message = "member";
				session.setAttribute("loggedUser", member);
				session.setAttribute("isUserLogged", Boolean.TRUE);
			}
		}

		return message;
	}

	private Member getMemberbyUserName(String username) {
		MembersList memberList = Helper.getBean("membersList", MembersList.class);
		return memberList.getMemberByUserName(userName);
	}

	public String logout() {
		//Helper.expungeSession();
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext()
		         .getSession(true)).invalidate();
		     return "index";
	}

}