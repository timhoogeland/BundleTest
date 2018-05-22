package DAOS;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class baseDAO{
	private Connection connection;

	protected final Connection getConnection(){
		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try{
			connection = DriverManager.getConnection("jdbc:postgresql://ec2-54-246-84-200.eu-west-1.compute.amazonaws.com:5432/d3befq5rtbsq27?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory",
					"knhrtzyjjogvfx",
					"e7d603d54069603da1c9a731f2c8ed0c2d434db04c240bcbc4155e6e89746a91");
		}catch (SQLException e) {
			e.printStackTrace();
		}
			
		return connection;
	}
}
