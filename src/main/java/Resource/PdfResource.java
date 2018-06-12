package Resource;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import PdfGenerator.GeneratePage;

@Path("/pdf")
public class PdfResource {
	@POST
	@Produces("application/json")
	public Response getPdfData(@FormParam("street") String street,
            				 @FormParam("number") String number,
            				 @FormParam("country") String country,
            				 @FormParam("postalcode") String postalcode,
            				 @FormParam("description") String adresDescription,
            				 @FormParam("location") String location,
							 
            				 @FormParam("usertype") String userType,
     						 @FormParam("firstname") String firstname,
                             @FormParam("lastname") String lastname,
                             @FormParam("phonenumber") String phonenumber,
                             @FormParam("password") String password,
     						 @FormParam("addressidfk") String addressIdFk,
     						 @FormParam("photo") String photo,
     						 @FormParam("dateofbirth") String dateOfBirth,
			 				 
     						 @FormParam("loantype") String loanType,
							 @FormParam("amount") String amount,
							 @FormParam("startdate") String startDate,
							 @FormParam("duration") String duration,
							 @FormParam("loandescription") String loanDescription,
							 @FormParam("useridfk") String userIdFk){
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("street", street);
		job.add("number", number);
		job.add("country", country);
		job.add("postalcode", postalcode);
		job.add("adresDescription", adresDescription);
		job.add("location", location);
		
		
		job.add("firstname", firstname);
		job.add("lastname", lastname);
		job.add("phonenumber", phonenumber);
		job.add("dateOfBirth", dateOfBirth);
		
		job.add("loantype", loanType);
		job.add("amount", amount);
		job.add("startDate", startDate);
		job.add("duration", duration);
		job.add("loandescription", loanDescription);
		job.add("useridfk", userIdFk);
		
		
		JsonArrayBuilder jab = Json.createArrayBuilder();
		jab.add(job);
		JsonArray array = jab.build();
		System.out.println(array);
		GeneratePage pdf = new GeneratePage(); 
    	pdf.main(array, userIdFk);
		//System.out.println(jab.build().toString());
		
		
		return Response.ok().build();
		
	}
}
