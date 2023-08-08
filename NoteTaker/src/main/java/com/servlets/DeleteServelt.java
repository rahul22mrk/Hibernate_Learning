package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveNoteServlet
 */
public class DeleteServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServelt() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			int noteId = Integer.parseInt(request.getParameter("noteId").trim());
			Session session = FactoryProvider.getFactory().openSession();
			Transaction tx = session.beginTransaction();
			Note note = (Note) session.get(Note.class, noteId);
			session.delete(note);
			tx.commit();
			session.close();
			response.sendRedirect("allNotes.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
