package com.madhu.registration;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

@WebServlet("/register")
public class RegisterUser extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String dob=req.getParameter("dob");
		String password=req.getParameter("password");
		
		
		Register register=new Register();
		register.setName(name);
		register.setEmail(email);
		register.setDob(dob);
		register.setPassword(password);
		
		
		Configuration cfg= new Configuration().configure().addAnnotatedClass(Register.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		
		session.save(register);
		
		trans.commit();
		session.close();
		res.sendRedirect("index.jsp");
		
	}

}
