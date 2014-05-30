package org.psh4j.sqlrunner;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

/**
 * SQL 실행 프로세서.
 * 
 * @author SungHoon, Park
 */
public class SqlRunnerProcessor {
	private BasicDataSource dataSource;

	private String driver;
	private String url;
	private String user;
	private String password;
	private String query;

	/**
	 * 기본생성자.
	 * JDBC 프로퍼티를 읽어서 DataSource를 설정한다.
	 * 
	 * @param propsName JDBC 프로퍼티명
	 * @throws IOException
	 */
	public SqlRunnerProcessor(String propsName) throws IOException {
		loadJdbcProperties(propsName);
		setBasicDataSource();
	}

	/**
	 * JDB 프로퍼티에서 DB연결정보 값을 읽는다.
	 * 
	 * @param propsName JDBC 프로퍼티명
	 * @throws IOException
	 */
	private void loadJdbcProperties(String propsName) throws IOException {
		InputStream is = getClass().getResourceAsStream(propsName);
		Properties props = new Properties();
		props.load(is);

		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		password = props.getProperty("password");
		query = props.getProperty("query");
	}

	/**
	 * BasicDataSource 객체를 설정한다.
     * 설정되는 정보는 driver, url, user, password이다.
	 */
	private void setBasicDataSource() {
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
	}

	/**
	 * SQL을 실행후 결과값을 출력한다.
	 * 
	 * @throws SQLException
	 */
	public void query() throws SQLException {
        QueryRunner runner = new QueryRunner(dataSource);
		List<Map<String, Object>> resultList = runner.query(query, new MapListHandler());

		System.out.println("===== SqlRunner Result =====");
		for (Map<String, Object> result : resultList) {
			System.out.println(result);
		}
	}

}
