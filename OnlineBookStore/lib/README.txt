IMPORTANT: External JARs (not included here)
-------------------------------------------
This ZIP cannot include external binary jars due to environment restrictions.
Please download these jars and place them into WEB-INF/lib directory (create it):

1) mysql-connector-java-8.0.xx.jar
   - Download from: https://dev.mysql.com/downloads/connector/j/
2) (Optional) Any servlet/jsp API jars if compiling outside Tomcat, but Tomcat provides runtime APIs.

After placing the connector jar into WEB-INF/lib, restart Tomcat.
