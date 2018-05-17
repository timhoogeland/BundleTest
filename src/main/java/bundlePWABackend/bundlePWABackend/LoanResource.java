package bundlePWABackend.bundlePWABackend;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/loan")
public class LoanResource {
	@GET
	@Produces("application/json")
	public String getLoan(){
		LoanService service = LoanServiceProvider.getMedewerkerService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		for(Loan l :service.getAllLoans()){
			JsonObjectBuilder job =Json.createObjectBuilder();
			job.add("status", l.getStatus())
		    .add("amount", l.getAmount());
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
}
