package com.madhu.registration;

import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

@WebServlet("/update")
public class UpdateUser extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int id=Integer.parseInt(req.getParameter("id"));


		Configuration cfg= new Configuration().configure().addAnnotatedClass(Register.class);
		SessionFactory sf= cfg.buildSessionFactory();
		Session session= sf.openSession();
		Transaction transcation =session.beginTransaction();
		
		Register register = session.get(Register.class, id);
		 
		transcation.commit();
		session.close();

		req.setAttribute("list", register);
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("Update.jsp");
		requestDispatcher.forward(req, res);


	}

}
