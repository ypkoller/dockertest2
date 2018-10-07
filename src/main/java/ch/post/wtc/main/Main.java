package ch.post.wtc.main;

import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import ch.post.wtc.entities.GroupDo;
import ch.post.wtc.jpa.JPAUtil;

public class Main {

	public static void main(String[] args) throws Exception {
		
		try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            DriverManager.getConnection("jdbc:derby:memory:unit-testing-jpa;create=true").close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }

		ResourceConfig config = new ResourceConfig();
		 config.packages("ch.post.wtc.msg"); //Folgendes package nach Services scannen
		 ServletHolder servlet = new ServletHolder(new ServletContainer(config));

		Server server = new Server(2222);
		 ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
		 context.setContextPath("/");
		 context.addServlet(servlet, "/rest/*");
		 server.setHandler(context);
		
		 EntityManager entityManager = JPAUtil.getEntityManager();
		    entityManager.getTransaction().begin();

		    GroupDo gdo = new GroupDo();
		    gdo.setId(1);
		    gdo.setName("Name");
		    entityManager.persist(gdo);

		    entityManager.getTransaction().commit();
		 
		try {
			server.start();
			server.join();
		} catch (Exception ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		} finally {

			server.destroy();
		    entityManager.close();
		}
	}
}