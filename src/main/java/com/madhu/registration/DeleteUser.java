package com.madhu.registration;

import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
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

@WebServlet("/delete")
public class DeleteUser extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String email=req.getParameter("email");


		Configuration cfg= new Configuration().configure().addAnnotatedClass(Register.class);
		SessionFactory sf= cfg.buildSessionFactory();
		Session session= sf.openSession();
		Transaction transcation =session.beginTransaction();

		CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		CriteriaDelete<Register> query = criteriaBuilder.createCriteriaDelete(Register.class);
		Root<Register> root = query.from(Register.class);
		query.where(criteriaBuilder.equal(root.get("email"), email));

		Query<Register> query1=session.createQuery(query);
		query1.executeUpdate();
		


		Query<Register> query11 = session.createQuery("from Register");
		List<Register> list = query11.getResultList();
		
		req.setAttribute("details", list);
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("display.jsp");
		requestDispatcher.forward(req, res);
		transcation.commit();
		session.close();



	}


}
