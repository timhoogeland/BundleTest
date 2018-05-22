package Objects;

public class LoanGroup {
private int id;
private int loanofficerId;
public LoanGroup(int id, int localofficerId) {
	super();
	this.id = id;
	this.loanofficerId = localofficerId;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getloanofficerId() {
	return loanofficerId;
}
public void setloanofficerId(int loanofficerId) {
	this.loanofficerId = loanofficerId;
}


}
