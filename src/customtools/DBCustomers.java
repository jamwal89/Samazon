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
	 public static boolean isValidUser(String username, String userpassword)
	 {
	 EntityManager em = DBUtil.getEmFactory().createEntityManager();
	 String qString = "Select count(b.userid) from Samazonuser b "
	 + "where b.username = :username and b.userpassword = :userpassword";
	 TypedQuery<Long> q = em.createQuery(qString,Long.class);
	 boolean result = false;
	 q.setParameter("username", username);
	 q.setParameter("userpassword", userpassword);
	 
	 try{
	 long userId = q.getSingleResult();
	 
	 if (userId > 0)
	 {
	 result = true;
	 }
	 }catch (Exception e){

	 result = false;
	 }
	 finally{
	 em.close(); 
	 } 
	 System.out.println(result);
	 return result;

	 }

}
