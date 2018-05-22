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

import Objects.Loan;
import Services.LoanService;
import Services.LoanServiceProvider;

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
			.add("startdate",  l.getStartdate().toString())
			.add("duration", l.getDuration())
			.add("closingdate",  l.getClosingdate().toString())
			.add("loantype",l.getLoantype())
		    .add("contractidfk", l.getcontractId());
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
}
