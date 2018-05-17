package Resource;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import Services.LoanService;
import Services.LoanServiceProvider;
import bundlePWABackend.bundlePWABackend.Loan;

@Path("/loan")
public class LoanResource {
	@GET
	@Produces("application/json")
	public String getLoan(){
		LoanService service = LoanServiceProvider.getLoanService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		for(Loan l :service.getAllLoans()){
			JsonObjectBuilder job =Json.createObjectBuilder();
			job.add("loanId", l.getLoanId())
			.add("amount", l.getAmount())
			.add("status", l.getStatus())
			.add("startdate", (JsonValue) l.getStartdate())
			.add("duration", l.getDuration())
			.add("closingdate", (JsonValue) l.getClosingdate())
			.add("loantype",l.getLoantype())
		    .add("contractidfk", l.getcontractId());
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
}
