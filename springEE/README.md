Project Exemplify:
  - Spring-Hibernate integration. Hibernate is using some beans to be set, and because of this, hibernate.cfg.xml is no longer needed
  - Connection with Database is done mostly in Server, so you will not see in the project all parameters to connect with database
  - jdbcTemplate is also used for connection to the database, and for Person POJO to be connected with database
  - Hibernate is used for Employee POJO
  - For testing, the idea was to test the services connected with database directly, without using a Server. Because of this, the connection with the database needed to be rewritten in TransactionalTestsSetup.java, because the connection in the project, was mainly defined in Server
  - For testing PersonService, dbUnit was used. This tool is integrated here with Spring (because of this we can have transactional communication with database). The beuty of dbUnit is that you can test the database in comparison with a schema, defined in expectedData.xml and sampleData.xml. But dbUnit can be used without Spring, but in this case, tests will not be transactional any longer. We need to take care at transactions
  - an example of how a sql command from a file is used can be seen: @Sql({"/sql/testEmployees.sql"}) 
  - an example of jndi can be seen at ApplicationConfig.java