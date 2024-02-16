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

@WebServlet("/display")
public class DisplayUsers extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		Configuration cfg= new Configuration().configure().addAnnotatedClass(Register.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();


		Query<Register> query = session.createQuery("from Register");
		List<Register> list = query.getResultList();

		req.setAttribute("details", list);
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("display.jsp");
		requestDispatcher.forward(req, res);

		trans.commit();
		session.close();

	}
}



