package goit.iavorskyi.db;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JndiTester {

	public static void main(String[] args) throws Exception {
		JndiTester jt = new JndiTester();
		jt.doS();
		
	}
	public void doS() throws Exception {
		InitialContext cxt = new InitialContext();
		DataSource ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/postgres");
		ds.getConnection();
	}
}
