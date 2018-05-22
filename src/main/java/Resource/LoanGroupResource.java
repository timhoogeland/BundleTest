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
@GET
@Path("/{loanofficerId}")
@Produces("application/json")
public String getGroup(@PathParam("loanofficerId") int loanofficerId){
	LoanGroupService service = LoanGroupServiceProvider.getLoanGroupService();
	JsonArrayBuilder jab = Json.createArrayBuilder();
	for(LoanGroup g :service.getAllGroups(loanofficerId)){
		JsonObjectBuilder job =Json.createObjectBuilder();
		job.add("id", g.getId());
		
		jab.add(job);
	}
	JsonArray array = jab.build();
	return array.toString();
}

}
