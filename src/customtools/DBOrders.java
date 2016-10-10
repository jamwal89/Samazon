package customtools;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import customtools.DBUtil;

import model.Samazonorder;
import model.Samazonuser;

public class DBOrders {
	 public static void insert(Samazonorder or) {
		    
		 EntityManager em = DBUtil.getEmFactory().createEntityManager();
		 EntityTransaction trans = em.getTransaction();
		 //System.out.println("DbBullhorn: begin transaction");
		 try {
		 trans.begin();
		 em.persist(or);
		 //System.out.println("DbBullhorn: commit transaction");
		 trans.commit();
		 } catch (Exception e) {
		 e.printStackTrace();
		 //System.out.println("DbBullhorn: rollback transaction");
		 trans.rollback();
		 } finally {
		 //System.out.println("DbBullhorn: close em");
		 em.close();
		 }
		 
		 
		 }
}

