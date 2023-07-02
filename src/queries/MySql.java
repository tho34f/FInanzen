package queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySql {

	private static final String URL = "jdbc:mysql://localhost:3306/finanzen?allowPublicKeyRetrieval=true&amp;useUnicode=true&amp;characterEncoding=utf8&amp;useSSL=false&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC";
	private static final String USERNAME = "root"; 
	private static final String PASSWORD = "MaraTeske30031994!";
	
	//Hier alle Queries als Attribute
	private ProductAndYearsQueries productAndYerasQueries;
	
	public MySql() {
		this.productAndYerasQueries = new ProductAndYearsQueries();
	}
	
	public Connection getConnection() throws SQLException {

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);

    }

	public ProductAndYearsQueries getProductQueries() {
		return productAndYerasQueries;
	}

	public void setProductQueries(ProductAndYearsQueries productAndYerasQueries) {
		this.productAndYerasQueries = productAndYerasQueries;
	}
	
}
