package Resource;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import Objects.Group;
import Objects.LoanGroup;
import Services.LoanGroupService;
import Services.LoanGroupServiceProvider;


@Path("/loangroup")
public class LoanGroupResource {
	private LoanGroupService service = LoanGroupServiceProvider.getLoanGroupService();
	
	private JsonObjectBuilder buildJSON(LoanGroup l){
		JsonObjectBuilder job = Json.createObjectBuilder();
		
		job.add("loanGroupId", l.getId());
		job.add("loanOfficerId", l.getloanofficerId());
		
		return job;
	}
	
	@GET
	@Path("/{loanofficerId}")
	@Produces("application/json")
	public String getGroupByLoanOfficer(@PathParam("loanofficerId") int loanofficerId){
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for(LoanGroup l :service.getAllLoanGroupsByLoanOfficer(loanofficerId)){		
			jab.add(buildJSON(l));
		}
		JsonArray array = jab.build();
		return array.toString();
	}
}
