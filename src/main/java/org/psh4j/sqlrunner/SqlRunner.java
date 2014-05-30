package org.psh4j.sqlrunner;

import java.io.IOException;
import java.sql.SQLException;

/**
 * SQL 실행 프로그램.
 * 
 * @author SungHoon, Park
 */
public class SqlRunner {
	private static final String JDBC_PROPERTIES = "/jdbc.properties";

	public static void main(String[] args) throws IOException, SQLException {
		SqlRunnerProcessor processor = new SqlRunnerProcessor(JDBC_PROPERTIES);
		processor.query();
	}
}
