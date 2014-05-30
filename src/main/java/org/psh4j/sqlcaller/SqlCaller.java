package org.psh4j.sqlcaller;

/**
 * SQL 실행 프로그램.
 * 
 * @author SungHoon, Park
 */
public class SqlCaller {
	private static final String JDBC_PROPERTIES = "/jdbc.properties";

	public static void main(String[] args) throws Exception {
		SqlInfo sqlInfo = new SqlInfo(JDBC_PROPERTIES);

		SqlCallerProcessor processor = new SqlCallerProcessor(sqlInfo);
		processor.query();
	}
}
