package ch.post.wtc.msg;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ch.post.wtc.entities.GroupDo;
import ch.post.wtc.jpa.JPAUtil;

@Path("group")
public class MyMessage {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {
    	
    	 EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    	 EntityTransaction tx = entityManager.getTransaction();
    	 tx.begin();
    	 GroupDo gdo = entityManager.find(GroupDo.class, Integer.valueOf(1));
    	 String res = gdo.toString();
    	 tx.rollback();
        
        return "Find Group: " + res;
    }
}