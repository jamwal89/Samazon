package customtools;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;






@SuppressWarnings("unused")
public class DBUtil {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Samazon");
	public static EntityManagerFactory getEmFactory(){
		return emf;
	}
	
	
}
