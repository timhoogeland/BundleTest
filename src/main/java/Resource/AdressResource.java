package Resource;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import Objects.Adress;
import Objects.User;
import Services.AdressService;
import Services.ServiceProvider;

@Path("/adress")
public class AdressResource {
    private AdressService service = ServiceProvider.getAdressService();

	    private JsonObjectBuilder buildJSON(Adress a) {
	        JsonObjectBuilder job = Json.createObjectBuilder();

	        job.add("adressid", a.getAdressID())
	                .add("street", a.getStreet())
	                .add("number", a.getNumber())
	                .add("country", a.getCountry())
	                .add("postalcode", a.getPostalCode());

	        return job;
	    }
	    @GET
//	    @RolesAllowed({"beheerder","admin"})
	    @Produces("application/json")
	    public String getAccounts() {
	        JsonArrayBuilder jab = Json.createArrayBuilder();

	        for (Adress a : service.getAllAdresses()) {
	            jab.add(buildJSON(a));
	        }

	        JsonArray array = jab.build();
	        return array.toString();
	    }
	    
	    @POST
	    @Produces("application/json")
	    public Response addUser(@FormParam("adressid") int id,
	                               @FormParam("street") String street,
	                               @FormParam("number") int number,
	                               @FormParam("country") String country,
	                               @FormParam("postalcode") String postalcode)

	    {
	        Adress newAdress = new Adress(id, street, number, country, postalcode);
	        Adress returnAdress = service.addContract(newAdress);
	        if (returnAdress != null) {
	            String a = buildJSON(returnAdress).build().toString();
	            return Response.ok(a).build();
	        } else {
	            return Response.status(Response.Status.BAD_REQUEST).build();
	        }
	    }	    
}