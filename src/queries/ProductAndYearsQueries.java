package queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.FinanceProduct;
import service.DierkesLooger;

public class ProductAndYearsQueries extends AbstractQueries {
	
	private final DierkesLooger LOGGER = new DierkesLooger();
	
	public ProductAndYearsQueries(MySql mySql) {
		this.sql = mySql;
	}
	
	public List<FinanceProduct> getFinanceProducts() {
		LOGGER.writeInfoLog("getFinanceProducts()", ProductAndYearsQueries.class.getName());
		List<FinanceProduct> financeProducts = new ArrayList<>();
		
		try(Connection con = getSql().getConnection()){
			LOGGER.writeInfoLog("getFinanceProducts(): Verbindung zur DB erfolgreich", ProductAndYearsQueries.class.getName());
			String sql = "SELECT * FROM financeproduct";
			try(PreparedStatement pstmt = con.prepareStatement(sql)){
				try(ResultSet rs = pstmt.executeQuery()){
					FinanceProduct financeProduct = null;
					while(rs.next()) {
						financeProduct = new FinanceProduct(rs.getInt("id"),rs.getString("bezeichnung"), rs.getLong("standing"));
						financeProducts.add(financeProduct);
					}
				}
			}
		} catch (SQLException e) {
			LOGGER.writeExceptionLog(e, "getFinanceProducts(): SQL-Exception", ProductAndYearsQueries.class.getName());
			return financeProducts;
		}
		
		return financeProducts;
	}
	
	public boolean saveNewFinanceProduct(String name, long standing) {
		LOGGER.writeInfoLog("saveNewFinanceProducts()", ProductAndYearsQueries.class.getName());
		boolean success = true;
		
		try(Connection con = getSql().getConnection()){
			LOGGER.writeInfoLog("saveNewFinanceProducts(): Verbindung zur DB erfolgreich", ProductAndYearsQueries.class.getName());
			String sql = "INSERT INTO financeproduct( bezeichnung, standing) VALUES (?, ?)";
			try(PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setString(1, name);
				pstmt.setLong(2, standing);
				success = pstmt.execute();
			}
		} catch (SQLException e) {
			LOGGER.writeExceptionLog(e, "saveNewFinanceProducts(): SQL-Exception", ProductAndYearsQueries.class.getName());
			return false;
		}
		
		return success;
	}
	
	public boolean deleteFinanceProduct(int id) {
		LOGGER.writeInfoLog("deleteFinanceProduct()", ProductAndYearsQueries.class.getName());
		boolean success = true;
		
		try(Connection con = getSql().getConnection()){
			LOGGER.writeInfoLog("deleteFinanceProduct(): Verbindung zur DB erfolgreich", ProductAndYearsQueries.class.getName());
			String sql = "DELETE FROM financeproduct where id = ?;";
			try(PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setInt(1, id);
				success = pstmt.execute();
			}
		} catch (SQLException e) {
			LOGGER.writeExceptionLog(e, "deleteFinanceProduct(): SQL-Exception", ProductAndYearsQueries.class.getName());
			return false;
		}
		
		return success;
	}

}
