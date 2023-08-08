package com.servlets;

import java.io.IOException;
import java.util.Date;

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
public class UpdateServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateServelt() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int noteId = Integer.parseInt(request.getParameter("hiddenNoteId").trim());
			Session session = FactoryProvider.getFactory().openSession();
			Transaction tx = session.beginTransaction();
			Note note = (Note) session.get(Note.class, noteId);
			note.setTitle(title);
			note.setContent(content);
			note.setCreatedDate(new Date());
			session.saveOrUpdate(note);
			tx.commit();
			session.close();
			response.sendRedirect("allNotes.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
