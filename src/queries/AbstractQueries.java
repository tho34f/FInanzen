package queries;

import service.DierkesLooger;

public abstract class AbstractQueries {
	
	protected static final DierkesLooger LOGGER = new DierkesLooger();
	protected MySql sql;
	
	public MySql getSql() {
		return sql;
	}
	public void setSql(MySql sql) {
		this.sql = sql;
	}
	

}
