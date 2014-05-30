package org.psh4j.sqlcaller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * SQL 정보 Model.
 *
 * @author SungHoon, Park
 */
public class SqlInfo {
	private String driverName;
	private String url;
	private String user;
	private String password;
	private String query;

    /**
     * 기본생성자
     */
	public SqlInfo() {
	}

    /**
     * 프로퍼티 경로를 입력받아 SQL 정보를 구성하는 생성자.
     *
     * @param propsPath 프로퍼티 경로
     * @throws IOException
     */
	public SqlInfo(String propsPath) throws IOException {
		InputStream is = getClass().getResourceAsStream(propsPath);
		Properties props = new Properties();
		props.load(is);

		driverName = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		password = props.getProperty("password");
		query = props.getProperty("query");
	}

	public String getDriverName() {
		return driverName;
	}

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public String getQuery() {
		return query;
	}
}
