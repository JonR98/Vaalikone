package rest;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import app.model.Kysymykset;

@Path("/kysymysservice")
public class KysymysService {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("toimisko14");
	@GET
	@Path("/readkysymyksetkysymykset")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Kysymykset> readKysymykset() {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<Kysymykset> list=em.createQuery("select xyx from kysymykset xyx").getResultList();		
		em.getTransaction().commit();
		return list;
	}	
	@POST
	@Path("/addkysymykset")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Kysymykset> addKysymykset(Kysymykset kysymykset) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(kysymykset);//The actual insertion line
		em.getTransaction().commit();
		//Calling the method readFish() of this service
		List<Kysymykset> list=readKysymykset();		
		return list;
	}	
	@PUT
	@Path("/updatekysymykset")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Kysymykset> updateKysymykset(Kysymykset kysymykset) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Kysymykset f=em.find(Kysymykset.class, kysymykset.getId());
		if (f!=null) {
			em.merge(kysymykset);//The actual update line
		}
		em.getTransaction().commit();
		//Calling the method readFish() of this service
		List<Kysymykset> list=readKysymykset();		
		return list;
	}	
	@DELETE
	@Path("/deletekysymykset/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Kysymykset> deleteKysymykset(@PathParam("id") int id) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Kysymykset f=em.find(Kysymykset.class, id);
		if (f!=null) {
			em.remove(f);//The actual insertion line
		}
		em.getTransaction().commit();
		//Calling the method readFish() of this service
		List<Kysymykset> list=readKysymykset();		
		return list;
	}	
	@GET
	@Path("/readtoupdatekysymykset/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Kysymykset readToUpdateKysymykset(@PathParam("id") int id) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Kysymykset f=em.find(Kysymykset.class, id);
		em.getTransaction().commit();
		return f;
	}	
}
