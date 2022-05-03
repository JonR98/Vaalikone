package app;

import java.io.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import app.model.Kysymykset;

@WebServlet(
    name = "Addkysymykset",
    urlPatterns = {"/addkysymykset2"}
)
public class Addkysymys2 extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {

    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");

    PrintWriter out=response.getWriter();
    out.println("Adding a fish");
    Kysymykset kysymykset=new Kysymykset();
    //Create an EntityManagerFactory by the name of persistence unit - see persistence.xml
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa247");
	//And then EntityManager, which can manage the entities.
	EntityManager em=emf.createEntityManager();
	//When using default (RESOURCE-LOCAL) transaction type
	//Every transaction must begin and end.
	em.getTransaction().begin();
	em.persist(kysymykset);
	em.getTransaction().commit();
  }
}
