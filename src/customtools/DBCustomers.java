package customtools;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import customtools.DBUtil;
import model.Samazonuser;

public class DBCustomers {
	 public static Samazonuser getUserByName(String name)
	 {
	 EntityManager em = DBUtil.getEmFactory().createEntityManager();
	 String qString = "Select u from Samazonuser u "
	 + "where u.username = :name";
	 TypedQuery<Samazonuser> q = em.createQuery(qString, Samazonuser.class);
	 q.setParameter("name", name);
	 Samazonuser user = null;
	 try {
	 user = q.getSingleResult();
	 }catch (NoResultException e){
	 System.out.println(e);
	 }finally{
	 em.close();
	 }
	 return user;

	 }

}
