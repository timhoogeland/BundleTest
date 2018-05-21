package Resource;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import Services.LoginService;
import Services.LoginServiceProvider;
import bundlePWABackend.bundlePWABackend.Login;
/*
@Path("/login")
public class LoginResource {
	@GET
	@Produces("application/json")
	public String getUserId(@FormParam("username") String username,
			  				@FormParam("password") String password){
		LoginService service = LoginServiceProvider.getUserId();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		//Login l = new Login(username, password);
		JsonObjectBuilder job =Json.createObjectBuilder();
		//job.add("userid", );
		
		jab.add(job);
		
		JsonArray array = jab.build();
		return array.toString();
	}
}
*/