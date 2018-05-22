package Resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import Objects.Loan;
import Services.LoanService;
import Services.LoanServiceProvider;

@Path("/loan")
public class LoanResource {
	@GET
	@Path("/{loanId}")
	@Produces("application/json")
	public String getLoan(@PathParam("loanId") int loanId){
		LoanService service = LoanServiceProvider.getLoanService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		for(Loan l :service.getLoanById(loanId)){
			JsonObjectBuilder job =Json.createObjectBuilder();
			job.add("loanId", l.getLoanId())
			.add("amount", l.getAmount())
			.add("status", l.getStatus())
			.add("startdate",  l.getStartDate().toString())
			.add("duration", l.getDuration())
			.add("closingdate",  l.getClosingDate().toString())
			.add("loantype",l.getLoanType())
		    .add("contractid", l.getContractId());
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@POST
	public Response newLoan(@FormParam("amount") String amount,
							@FormParam("status") String status,
							@FormParam("startdate") String startDate,
							@FormParam("duration") String duration,
							@FormParam("closingdate") String closingDate,
							@FormParam("loantype") String loanType,
							@FormParam("contractid") String contractId) throws ParseException{
		LoanService service = LoanServiceProvider.getLoanService();
		
		java.util.Date utilStartDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
		java.util.Date utilClosingDate = new SimpleDateFormat("yyyy-MM-dd").parse(closingDate);
		java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
		java.sql.Date sqlClosingDate = new java.sql.Date(utilClosingDate.getTime());
		
		Loan newLoan = new Loan(0, Integer.parseInt(amount), status, sqlStartDate, Integer.parseInt(duration), sqlClosingDate, loanType, Integer.parseInt(contractId));
		if (service.newLoan(newLoan)){
			return Response.ok().build();
		}else{
			return Response.status(Response.Status.FOUND).build();
		}
	}
}
