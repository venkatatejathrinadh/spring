package Student_Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Student_Dto.Studentdto;

public class Studentdao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public String insert(Studentdto d1) {
		et.begin();
		em.persist(d1);
		et.commit();
		return "Data is Inserted";
	}
	
	public String delete(int id) {
		Studentdto d1 = em.find(Studentdto.class, id);
		if(d1!=null) {
			et.begin();
			em.remove(d1);
			et.commit();
			return "Single record is deleted";
		}
		
		else {
			return "Data not found";}
	}
	
	public String deleteall() {
		Query q = em.createQuery("select data from Studentdto data");
		List<Studentdto> list = q.getResultList();
		if(list.isEmpty()) {
			return "no data found";
		}
		else {
			for(Studentdto uv:list) {
				et.begin();
				em.remove(uv);
				et.commit();
			}
			return "All data removed";
		}
	}
}
