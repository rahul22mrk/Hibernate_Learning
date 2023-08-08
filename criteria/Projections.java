package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;

import com.tut.Student;

public class Projections {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("/com/tut/hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Student.class);

		// Aggregate Methods
//		criteria.setProjection(org.hibernate.criterion.Projections.rowCount());
//		Long count = (Long) criteria.uniqueResult();
//		System.out.println("Total Rows " + count);

		// multiple Aggregate methods
		ProjectionList projectionList = org.hibernate.criterion.Projections.projectionList();
		projectionList.add(org.hibernate.criterion.Projections.rowCount());
		projectionList.add(org.hibernate.criterion.Projections.sum("id"));
		projectionList.add(org.hibernate.criterion.Projections.avg("id"));
		projectionList.add(org.hibernate.criterion.Projections.max("id"));
		projectionList.add(org.hibernate.criterion.Projections.min("id"));

		criteria.setProjection(projectionList);

		Object[] resultObjects = (Object[]) criteria.uniqueResult();
		Long rowCount = (Long) resultObjects[0];
		System.out.println("total Rows " + rowCount);
		Long sumLong = (Long) resultObjects[1];
		System.out.println("Sum is " + sumLong);
		Double avgDouble = (Double) resultObjects[2];
		System.out.println("Average is " + avgDouble);
		Integer maxLong = (Integer) resultObjects[3];
		System.out.println("Max is " + maxLong);
		Integer minLong = (Integer) resultObjects[4];
		System.out.println("Min is " + minLong);

		session.createCriteria(Student.class);
		ProjectionList projectionList2 = org.hibernate.criterion.Projections.projectionList();
		projectionList2.add(org.hibernate.criterion.Projections.property("name"));
		projectionList2.add(org.hibernate.criterion.Projections.property("certificate.course"));
		criteria.setProjection(projectionList2);

		List<Object[]> resObjects = criteria.list();
		for (Object[] objects : resObjects) {
			System.out.println("Student Name : " + objects[0] + " and Course is " + objects[1]);

		}

		session.close();
		factory.close();
	}

}
