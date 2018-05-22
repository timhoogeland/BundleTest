package Resource;

import java.sql.Date;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import Objects.User;
import Services.ServiceProvider;
import Services.UserService;

@Path("/user")
public class UserResource {
    private UserService service = ServiceProvider.getUserService();

    private JsonObjectBuilder buildJSON(User user) {
        JsonObjectBuilder job = Json.createObjectBuilder();

        job.add("userid", user.getUserID())
                .add("userType", user.getUserType())
                .add("name", user.getName())
                .add("phonenumber", user.getPhonenumber())
                .add("password", user.getPassword())
                .add("salt", user.getSalt())
                .add("status", user.getStatus())
                .add("dateofbirth", user.getDateOfBirth().toString())
                .add("adresIDFK", user.getAdresIDFK())
        		.add("airtimeIDFK", user.getAirtimeIDFK());

        return job;
    }
    
//    @GET
//    @Path("/{id}/qrcode")
//    public Response getQRCode(@PathParam("id") int id,
//    						@Context SecurityContext context){
//    	User user = service.getAccountByID(id);
//    	
//    	if(user == null){
//    		return Response.status(Response.Status.NOT_FOUND).build();
//    	} else {
//    		if(user.getName().equals(context.getUserPrincipal().getName())){
//	    		String secretKey = user.getSecretKey();
//	    		String email = user.getEmail();
//	    		
//	    		return Response.ok().build();
//    		} else {
//    			return Response.status(Response.Status.FORBIDDEN).build();
//    		}
//    	}
//    	
//    }

    @GET
//    @RolesAllowed({"beheerder","admin"})
    @Produces("application/json")
    public String getAccounts() {
        JsonArrayBuilder jab = Json.createArrayBuilder();

        for (User u : service.getAllUsers()) {
            jab.add(buildJSON(u));
        }

        JsonArray array = jab.build();
        return array.toString();
    }

    @GET
    @Path("/{id}")
//    @RolesAllowed({"beheerder","admin","user"})
    @Produces("application/json")
    public String getAccountByID(@PathParam("id") int id) {
        User user = service.getUserByID(id);
        if(user != null) {
            JsonArrayBuilder jab = Json.createArrayBuilder();
            jab.add(buildJSON(user));
            return jab.build().toString();
        }
        return Response.status(Response.Status.NOT_FOUND).toString();
    }

    @POST
    @Produces("application/json")
    public Response addUser(@FormParam("userid") int id,
                               @FormParam("usertype") String userType,
                               @FormParam("name") String name,
                               @FormParam("phonenumber") int phonenumber,
                               @FormParam("password") String password,
                               @FormParam("salt") String salt,
                               @FormParam("status") String status,
                               @FormParam("dateofbirth") Date birth,
    						   @FormParam("adresidfk") int adresidfk,
    						   @FormParam("airtimeidfk") int airtimeidfk)
    {
        User newUser = new User(id, userType, name, phonenumber, password, salt, status, birth, adresidfk, airtimeidfk);
        User returnUser = service.addUser(newUser);
        if (returnUser != null) {
            String a = buildJSON(returnUser).build().toString();
            return Response.ok(a).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/{id}")
//    @RolesAllowed({"beheerder","admin","user"})
    public Response updateAccount(@FormParam("userid") int id,
						            @FormParam("usertype") String userType,
						            @FormParam("name") String name,
						            @FormParam("phonenumber") int phonenumber,
						            @FormParam("password") String password,
						            @FormParam("salt") String salt,
						            @FormParam("status") String status,
									@FormParam("adresidfk") int adresidfk,
									@FormParam("airtimeidfk") int airtimeidfk){

        User user = service.getUserByID(id);
        if (user != null) {
        	user.setName(name);
            user.setPassword(password);
            user.setPhonenumber(phonenumber);
            user.setSalt(salt);
            user.setStatus(status);
            user.setAdresIDFK(adresidfk);
            user.setAirtimeIDFK(airtimeidfk);
            
            User updatedUser = service.update(user);

            return Response.ok(buildJSON(updatedUser)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
//    @RolesAllowed({"beheerder","admin"})
    public Response deleteAccount (@PathParam("id") int id) {
        User user = service.getUserByID(id);
        if (user != null) {
            if (service.delete(user)) {
                return Response.ok().build();
            } else {
                return Response.status(Response.Status.CONFLICT).build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}

