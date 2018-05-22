package Resource;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import Objects.Group;
import Services.GroupService;
import Services.GroupServiceProvider;
import Services.LoanGroupService;
import Services.LoanGroupServiceProvider;

@Path("/group")
public class GroupResource {

	@GET
	@Path("/{groupId}")
	@Produces("application/json")
	public String getGroupById(@PathParam("groupId") int groupId){
		GroupService service = GroupServiceProvider.getGroupService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		for(Group g :service.getGroupById(groupId)){
			JsonObjectBuilder job =Json.createObjectBuilder();
			job.add("userId", g.getUserId());
			job.add("Loanid", g.getLoanId());
			
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
}
