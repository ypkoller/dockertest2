package ch.post.wtc.servlet;

import java.sql.DriverManager;

import javax.persistence.EntityManager;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import ch.post.wtc.entities.GroupDo;
import ch.post.wtc.jpa.JPAUtil;

public class DBServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
//		try {
//            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//            DriverManager.getConnection("jdbc:derby:memory:unit-testing-jpa;create=true").close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            throw new ServletException(ex);
//        }
		 EntityManager entityManager = JPAUtil.getEntityManager();
		    entityManager.getTransaction().begin();

		    GroupDo gdo = new GroupDo();
		    gdo.setId(1);
		    gdo.setName("Name");
		    entityManager.persist(gdo);

		    entityManager.getTransaction().commit();
		super.init(config);
	}

}
