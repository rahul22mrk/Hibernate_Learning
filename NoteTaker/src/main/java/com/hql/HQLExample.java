package com.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.entities.Note;
import com.helper.FactoryProvider;

public class HQLExample {
	public static void main(String[] args) {
		Session session = FactoryProvider.getFactory().openSession();
		// HQL Syntax
		String hql = "from Note";

		Query query = session.createQuery(hql);
		// single - unique
		// multile - list
		List<Note> notes = query.list();
		for (Note note : notes) {
			System.out.println(
					note.getId() + " : " + note.getTitle() + " : " + note.getContent() + " : " + note.getCreatedDate());
		}
		session.close();
	}
}
