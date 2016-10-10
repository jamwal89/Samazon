package customtools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import customtools.DBUtil;
import model.Samazonproduct;
import model.Samazonuser;

public class DBProduct {
	public static List<Samazonproduct> getProductList() {
		 EntityManager em = DBUtil.getEmFactory().createEntityManager();
	       String qString = "SELECT s FROM Samazonproduct s";
	        
	        List<Samazonproduct> posts = null;
	        try{
	            TypedQuery<Samazonproduct> query = em.createQuery(qString,Samazonproduct.class);
	            posts = query.getResultList();

	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        finally{
	                em.close();
	            }
	        return posts;
	    }
	
	public static Samazonproduct getProduct(long productid)
	 {
	 EntityManager em = DBUtil.getEmFactory().createEntityManager();
	 String qString = "SELECT s FROM Samazonproduct s where s.productid = :productid";
	 TypedQuery<Samazonproduct> q = em.createQuery(qString, Samazonproduct.class);
	 q.setParameter("productid", productid);
	 Samazonproduct product = null;
	 try {
		 product = q.getSingleResult();
	 }catch (NoResultException e){
	 System.out.println(e);
	 }finally{
	 em.close();
	 }
	 return product;
	

	}
}


