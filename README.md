sqlcaller
=======

SQL 실행 프로그램<br>
(업무에서 DB 커넥션, SQL실행 등을 서버 콘솔에서 간단하게 확인하기 위한 용도)

how to use
=======
* 프로젝트를 클로닝한다.<br>
Git 사용자가 아니라면, 우측의 'Download Zip' 버튼을 클릭하여 개인PC로 소스를 다운로드한다.

* pom.xml 수정<br />
사용할 DB 라이브러리 dependency로 변경한다.
 ```
<!-- you can change here -->
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <version>5.0.7</version>
</dependency>
```

* jdbc.properties 수정<br />
연결할 DB의 JDBC 드라이버명, JDBC URL, 계정, 패스워드, 쿼리를 변경한다.
 ```
driver=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/db
user=root
password=1234
query=select 1
```

* 콘솔에서 'mvn assembly:assembly' 메이븐 빌드 명령을 실행한다.
 ```
mvn assembly:assembly
```

* 메이븐 빌드 명령으로 생성된 'sqlcaller-1.0.0-jar-dependency.jar' 파일을 다음과 같이 실행한다.
 ```
java -jar sqlcaller-1.0.0-jar-dependency.jar'
```

* 콘솔에 결과값이 출력된다.
 ```
===== SqlCaller Result =====
{1}
```
