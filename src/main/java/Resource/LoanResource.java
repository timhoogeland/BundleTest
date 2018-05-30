package Resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Objects.Loan;
import Objects.User;
import Services.LoanService;
import Services.LoanServiceProvider;
import Services.ServiceProvider;

@Path("/loan")
public class LoanResource {
	private LoanService service = LoanServiceProvider.getLoanService();
	
	private JsonObjectBuilder buildJson(Loan loan) {
		JsonObjectBuilder job = Json.createObjectBuilder();
		
		job.add("loanId", loan.getLoanId());
		job.add("loantype",loan.getLoanType());
		job.add("amount", loan.getAmount());
		job.add("status", loan.getStatus());
		job.add("startdate", loan.getStartDate().toString());
		job.add("duration", loan.getDuration());
		if (loan.getClosingDate() != null){
			job.add("closingdate", loan.getClosingDate().toString());
		}else{
			job.add("closingdate", "");
		}
		job.add("paidamount", loan.getPaidAmount());
		job.add("contractpdf", loan.getContractPdf());
		job.add("description", loan.getDescription());
		job.add("useridfk", loan.getUserIdFk());
		return job;
	}
	
	@GET
	@Produces("application/json")
	public String getAllLoans(){
		JsonArrayBuilder jab = Json.createArrayBuilder();
		for(Loan l : service.getAllLoans()){
			jab.add(buildJson(l));
		}
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@GET
	@Path("/{loanId}")
	@Produces("application/json")
	public String getLoan(@PathParam("loanId") int loanId){
		JsonArrayBuilder jab = Json.createArrayBuilder();
		for(Loan l :service.getLoanById(loanId)){
			jab.add(buildJson(l));
		}
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response newLoan(@FormParam("loantype") String loanType,
							@FormParam("amount") String amount,
							@FormParam("startdate") String startDate,
							@FormParam("duration") String duration,
							@FormParam("loandescription") String description,
							@FormParam("useridfk") String userIdFk) throws ParseException{
		
		LoanService service = LoanServiceProvider.getLoanService();
		
		String status = "Pending";
				
		java.util.Date utilStartDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
		java.util.Date utilClosingDate = new SimpleDateFormat("yyyy-MM-dd").parse("00-00-0000");
		java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
		java.sql.Date sqlClosingDate = new java.sql.Date(utilClosingDate.getTime());
		Random rand = new Random();
		Loan newLoan = new Loan(rand.nextInt(1000), loanType, Integer.parseInt(amount), status, sqlStartDate, Integer.parseInt(duration), sqlClosingDate, 0, "", description, Integer.parseInt(userIdFk));
		if (service.newLoan(newLoan)){
			return Response.ok().build();
		}else{
			return Response.status(Response.Status.FOUND).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response updateLoan( @FormParam("loanid") String loanId,
								@FormParam("status") String status,
								@FormParam("duration") String duration,
								@FormParam("closingdate") String closingDate,
								@FormParam("paidamount") String paidAmount,
								@FormParam("contractpdf") String contractPdf,
								@FormParam("description") String description) throws ParseException{

		java.util.Date utilClosingDate = new SimpleDateFormat("yyyy-MM-dd").parse(closingDate);
		java.sql.Date sqlClosingDate = new java.sql.Date(utilClosingDate.getTime());
		Loan loan = new Loan(Integer.parseInt(loanId), null, 0, status, null, Integer.parseInt(duration), sqlClosingDate, Integer.parseInt(paidAmount), contractPdf, description, 0);
		if (service.updateLoan(loan)){
			return Response.ok().build();
		}else{
			return Response.status(Response.Status.FOUND).build();
		}
	}
}
