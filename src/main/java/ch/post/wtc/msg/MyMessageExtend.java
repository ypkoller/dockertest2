package ch.post.wtc.msg;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("msgexten")
public class MyMessageExtend {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {
        
        return "My message Extend !!!!\n";
    }
}