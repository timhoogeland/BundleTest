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
import Services.GroupService;
import Services.GroupServiceProvider;


@Path("/group")
public class GroupResource {
@GET
@Path("/{loanofficerid}")
@Produces("application/json")
public String getGroup(@PathParam("loanofficerid") int loanofficerid){
	GroupService service = GroupServiceProvider.getGroupService();
	JsonArrayBuilder jab = Json.createArrayBuilder();
	for(Group g :service.getAllGroups(loanofficerid)){
		JsonObjectBuilder job =Json.createObjectBuilder();
		job.add("id", g.getId())
		.add("loanofficerfk", g.getloanofficerfk());
		
		jab.add(job);
	}
	JsonArray array = jab.build();
	return array.toString();
}
@GET
@Path("/{loanofficerid}/{groupid}")
@Produces("application/json")
public String getGroupById(@PathParam("loanofficerid") int loanofficerid, @PathParam("groupid") int groupid){
	GroupService service = GroupServiceProvider.getGroupService();
	JsonArrayBuilder jab = Json.createArrayBuilder();
	for(Group g :service.getAllGroups(loanofficerid)){
		JsonObjectBuilder job =Json.createObjectBuilder();
		job.add("id", g.getId())
		.add("loanofficerfk", g.getloanofficerfk());
		
		jab.add(job);
	}
	JsonArray array = jab.build();
	return array.toString();
}
}
