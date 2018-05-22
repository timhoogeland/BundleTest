package Objects;

public class Group {
private int id;
private int loanofficerfk;
public Group(int id, int localofficerid) {
	super();
	this.id = id;
	this.loanofficerfk = localofficerid;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getloanofficerfk() {
	return loanofficerfk;
}
public void setloanofficerfk(int loanofficerfk) {
	this.loanofficerfk = loanofficerfk;
}


}
