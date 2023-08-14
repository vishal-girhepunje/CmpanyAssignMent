 Type 2 : Implementation


Problem 1: Employee

Consider the following table:

        employee :
            empId: int primary key
            name: varchar not null
            address: varchar not null
            salary: int not null
​
Implement the following methods of the EmployeeDao interface using JPA with hibernate.<br>
- Implement the Generator to auto-generate the empId.

    public void save(Employee emp);
    public String getAddressOfEmployee(int empId);
    public String giveBonusToEmployee(int empId, int bonus);
    public boolean deleteEmployee(int empId);
​
Write a class to call all the above methods and display the result and handle the exceptions.
Sample of persistence.xml: (modify it accordingly)


        <?xml version="1.0" encoding="UTF-8"?>
        <persistence xmlns="http://java.sun.com/xml/ns/persistence"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://java.sun.com/xml/ns/persistence
        http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
        version="2.0">
        <persistence-unit name="empUnit" >
            <properties>
                <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
                <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/db1" />
                <property name="javax.persistence.jdbc.user" value="" />
                <property name="javax.persistence.jdbc.password" value="" />
            </properties>
            </persistence-unit>
        </persistence>
        ​
        pom.xml: sample (check the version of mysql)
        <properties>
            <maven.compiler.source>1.8</maven.compiler.source>
            <maven.compiler.target>1.8</maven.compiler.target>
        </properties>

        
        
        
        
        <dependencies>

        <!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
        <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>5.6.12.Final</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
        <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.28</version>
        </dependency>

        </dependencies>
​
Problem 2 :  Book
Perform crud on the following table :
The book will contain this information :


            Book Id : 101,
            name: "C++",
        author: "Nitesh",
        publication: "Rajput Publication",
        category: "Computer Programming",
        pages: 1500,
        price: 240,
        created_timestamp : 2019-12-11 10:58:37
​
Make use of EMUtil class to get the EntityManager
Get the information of any particular book by id
Create a new Book
Delete Book by ID
Update Book by ID by doubling the price
Reference :
Sample of persistence.xml: (modify it accordingly)

    <?xml version="1.0" encoding="UTF-8"?>
    <persistence xmlns="http://java.sun.com/xml/ns/persistence"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://java.sun.com/xml/ns/persistence
    http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
    version="2.0">
    <persistence-unit name="book-unit" >
            <properties>
                    <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
                    <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/bookdb" />
                    <property name="javax.persistence.jdbc.user" value="" />
                    <property name="javax.persistence.jdbc.password" value="" />
            </properties>
            </persistence-unit>
    </persistence>
​
pom.xml: sample (check the version of mysql)
    <properties>
            <maven.compiler.source>17</maven.compiler.source>
            <maven.compiler.target>17</maven.compiler.target>
    </properties>

        <dependencies>

                <!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
                <dependency>
                <groupId>org.hibernate</groupId>
                <artifactId>hibernate-core</artifactId>
                <version>5.6.12.Final</version>
                </dependency>

                <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
                <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>8.0.28</version>
                </dependency>

    </dependencies>
​
Problem 3: Court
Court provides an API that allows the creation, deletion, and update in the Lawyer table. Write Implementation of CourtDAO interface:
Implement CourtDAOJdbcImpl: using plain ORM approach which will perform above mention crud operation.
Note: 
For the ORM approach, create EMUtil class to get the EntityManager
 
Create the use case classes to call and test the given methods.
Database name: courtDB
Create a table for Lawyer with the following fields.
Lawyer{
	id: int Primary key 
	name: varchar
	email: varchar
	address: varchar
	experience: int (year)
}
​
Create the interface CourtDAO with the following methods.
public interface CourtDAO {
		Lawyer findLawyerById(int id)
		String saveLawyer(Lawyer lawyer);
		String deleteLawyerById(int id)
		String updateLawyerExperience(int id, int experience)
}
​
Reference :
Sample of persistence.xml: (modify it accordingly)
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://java.sun.com/xml/ns/persistence"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://java.sun.com/xml/ns/persistence
http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
version="2.0">
<persistence-unit name="court-unit" >
		<properties>
				<property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
				<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/courtDB" />
				<property name="javax.persistence.jdbc.user" value="" />
				<property name="javax.persistence.jdbc.password" value="" />
		</properties>
		</persistence-unit>
</persistence>
​
pom.xml: sample (check the version of MySQL)
<properties>
		<maven.cMySQLer.source>17</maven.compiler.source>
		<maven.compiler.target>17</maven.compiler.target>
</properties>

<dependencies>

			<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
			<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>5.6.12.Final</version>
			</dependency>

			<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
			<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.28</version>
			</dependency>

</dependencies>