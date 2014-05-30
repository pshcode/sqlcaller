package org.psh4j.sqlcaller;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * SQL 실행 프로세서.
 * 
 * @author SungHoon, Park
 */
public class SqlCallerProcessor {
    private SqlInfo sqlInfo;

    /**
     * 기본생성자.
     * 파라미터로 SqlInfo를 입력받는다.
     *
     * @param sqlInfo SQL 정보
     * @throws SQLException
     */
	public SqlCallerProcessor(SqlInfo sqlInfo) throws SQLException {
        this.sqlInfo = sqlInfo;
	}

    /**
     * SQL을 실행한 후, 결과값을 console에 출력한다.
     *
     * @throws SQLException
     */
    public void query() throws SQLException {
        QueryRunner runner = new QueryRunner();
        List<Map<String, Object>> resultList = runner.query(getConnection(), sqlInfo.getQuery(), new MapListHandler());

        System.out.println("===== SqlCaller Result =====");
        for (Map<String, Object> result : resultList) {
            System.out.println(result);
        }
    }

    /**
     * DB 커넥션 정보를 가져온다.
     *
     * @return DB 커넥션
     * @throws SQLException
     */
    private Connection getConnection() throws SQLException {
        DbUtils.loadDriver(sqlInfo.getDriverName());

        return DriverManager.getConnection(sqlInfo.getUrl(), sqlInfo.getUser(), sqlInfo.getPassword());
    }
}
