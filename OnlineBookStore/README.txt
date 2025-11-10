OnlineBookStore - Ready to deploy (Tomcat v11 on Windows)
-------------------------------------------------------
Steps to run (Windows, Tomcat 11, IntelliJ Community):
1) Ensure MySQL server is running. Login to MySQL and run `database.sql` included in this ZIP.
   - MySQL user: root
   - MySQL password: Kumarankit09@
   - Database created: OnlineBookStore
   - Admin user: admin@example.com / admin123

2) Place this folder into Tomcat's webapps directory:
   C:\apache-tomcat-11.0.x\webapps\OnlineBookStore\

3) Add required JARs to WEB-INF/lib (not included because external download is needed):
   - mysql-connector-java-8.0.xx.jar  (download from MySQL site)
   - jakarta.servlet-api-5.0.0.jar (if needed for compilation)
   Note: Tomcat provides servlet API at runtime; you only need the MySQL connector in WEB-INF/lib.
   Put the mysql connector jar into WEB-INF/lib folder (create if missing).

4) Start Tomcat (bin\startup.bat). Open browser:
   http://localhost:8080/OnlineBookStore/

5) Login:
   Admin: admin@example.com / admin123
   (or register a new user)

Troubleshooting:
- If you get ClassNotFoundException: com.mysql.cj.jdbc.Driver --> copy the mysql-connector jar to WEB-INF/lib.
- If DB connection fails, open src/com/example/bookstore/util/DBUtil.java and update DB URL, user, password.
