package customtools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;


import customtools.DBUtil;

import model.Samazonorder;
import model.Samazonproduct;



@SuppressWarnings("unused")
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
	 
	 public static void delete(Samazonorder product) {
    	 EntityManager em = DBUtil.getEmFactory().createEntityManager();
    	 EntityTransaction trans = em.getTransaction();
    	 try {
    		 System.out.println("product deleted");
    	 trans.begin();
    	 em.remove(em.merge(product));
    	 trans.commit();
    	 } catch (Exception e) {
    	 System.out.println(e);
    	 trans.rollback();
    	 } finally {
    	 em.close();
    	 } 
		 
	 }
	 

	 public static void update(Samazonorder or) {
		 EntityManager em = DBUtil.getEmFactory().createEntityManager();
		 EntityTransaction trans = em.getTransaction();
		 try {
		 trans.begin();
		 em.merge(or);
		 trans.commit();
		 } catch (Exception e) {
		 System.out.println(e);
		 trans.rollback();
		 } finally {
		 em.close();
		 }
		 }
	 
	 
		public static List<Samazonorder> getProductList() {
			 EntityManager em = DBUtil.getEmFactory().createEntityManager();
		       String qString = "SELECT s FROM Samazonorder s";
		        
		        List<Samazonorder> order = null;
		        try{
		            TypedQuery<Samazonorder> query = em.createQuery(qString,Samazonorder.class);
		            order = query.getResultList();

		        }catch (Exception e){
		            e.printStackTrace();
		        }
		        finally{
		                em.close();
		            }
		        if(order == null) {
		        	System.out.println("The list is null");
		        }
		        return order;
		    }
		
		
		 
		 public static  Samazonorder getProduct(long productid)
		 {
		 EntityManager em = DBUtil.getEmFactory().createEntityManager();
		 String qString = "SELECT s FROM Samazonorder s where s.samazonproduct.productid = :productid";
		 TypedQuery<Samazonorder> q = em.createQuery(qString, Samazonorder.class);
		 q.setParameter("productid", productid);
		 Samazonorder product = null;
		 try {	
			 product = q.getSingleResult();
		 }catch (NoResultException e){
		 System.out.println(e);
		 }finally{
		 em.close();
		 }
		 return product;
		

		}
		 public static List<Samazonorder> getProductHistory(long userid) {
			 EntityManager em = DBUtil.getEmFactory().createEntityManager();
		
		       String qString = "SELECT s FROM Samazonorder s where  s.samazonuser.userid =:userid ";
		        
		        List<Samazonorder> orderHistory = null;
		        try{
		            TypedQuery<Samazonorder> query = em.createQuery(qString,Samazonorder.class);
		            query.setParameter("userid", userid);
		        
		           
		   
		            orderHistory = query.getResultList();

		        }catch (Exception e){
		            e.printStackTrace();
		        }
		        finally{
		                em.close();
		            }
		       
		        return orderHistory;
		    }
		
		

		}


