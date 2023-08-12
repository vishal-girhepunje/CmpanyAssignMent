Problem :-1

# Type 2 : Maven Implementation

## Problem 1:

Create a Jdbc application that follows a DAO pattern by using Maven to implement the following
functionalities:

Create **Database: db1** and **table: Employee** with the following fields.

```java
Employee{
	empId: int primary key
	name: varchar
	address: varchar
	salary: int
}
```

Implement the following methods of the **EmployeeDao** interface

```java
public interface EmployeeDao {

			public String registerEmployee(Employee employee);
			
			public Employee getEmployeeById(int empId)throws EmployeeException;
			
			public List<Employee> getAllEmployee();
			
			public String deleteEmployeeById(int empId)throws EmployeeException;
			
			public String giveBonusToEmployee(int empId, int amount)throws EmployeeException;

}
```

**Note:** EmployeeException should be checked exception

## Reference :

**pom.xml: sample (check the version of mysql)**

- In properties and change the version to **java-17.**
- In dependency: Add MySQL dependency
    
    **Note:** **check the version of MySQL)** 
    

```java
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
```
create table

    CREATE TABLE employee (
        empId INT NOT NULL,
        name VARCHAR(255),
        address VARCHAR(255),
        salary INT,
        PRIMARY KEY (empId)
    );



## Problem 2:

Create a Jdbc application that follows a DAO pattern by using Maven to implement the following
functionalities:

Create **Database: db1** and a **table: Student** with the following fields.

```java
Student{
	rollNo: int primary key
	studentName: varchar
	address: varchar
	marks: int
}
```

Implement the following methods of the **StudentDao** interface

```java
public interface StudentDao {

			public Student getStudentByRollNo(int rollNo)throws StudentException;
		
			public List<Student> getAllStudent();
		
			public String saveStudentDetails(Student student);
		
			public boolean deleteStudentByRollNo(int rollNo)throws StudentException;
		
			public String graceStudentMarks(int rollNo, int marks)throws StudentException;
		
			public List<Student> getStudentsByName(String name)throws StudentException;
}
```

**Note: StudentException** should be checked exception

## Reference :

**pom.xml: sample (check the version of mysql)**

```java
<properties>
		<maven.compiler.source>17</maven.compiler.source>
		<maven.compiler.target>17</maven.compiler.target>
</properties>

<dependencies>
			<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
			<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.28</version>
			</dependency>
</dependencies>
```
create table
    
    CREATE TABLE student (
        rollNo INT NOT NULL,
        studentName VARCHAR(255),
        address VARCHAR(255),
        marks INT,
        PRIMARY KEY (rollNo)
    );
## Problem 3:

Court provides an API that allows the creation, deletion, and update in the Lawyer table. Write Implementation of **CourtDAO** interface:

Implement **CourtDAOJdbcImpl:** using plain JDBC approach **which will perform above mention crud operation.**

**Note:** 

For the JDBC approach, create **DBUtil** class for getting the connection.

 

**Create the use case classes to call and test the given methods.**
Database name: **courtDB**
Create a table **Lawyer** with the following fields.

```java
Lawyer{
	id: int Primary key 
	name: varchar
	email: varchar
	address: varchar
	experience: int (year)
}
```

Create the interface **CourtDAO** with the following methods.

```java
public interface CourtDAO {
		Lawyer findLawyerById(int id)
		String saveLawyer(Lawyer lawyer);
		String deleteLawyerById(int id)
		String updateLawyerExperience(int id, int experience)
}
```
creating table

    CREATE TABLE lawyer (
        id INT NOT NULL,
        name VARCHAR(255),
        email VARCHAR(255),
        address VARCHAR(255),
        experience INT,
        PRIMARY KEY (id)
    );
**Note:** **Please do by traditional JDBC approach by adding the Jar dependency.**

CREATE TABLE employee (
    empId INT NOT NULL,
    name VARCHAR(255),
    address VARCHAR(255),
    salary INT,
    PRIMARY KEY (empId)
);

Problem:- 2


CREATE TABLE student (
    rollNo INT NOT NULL,
    studentName VARCHAR(255),
    address VARCHAR(255),
    marks INT,
    PRIMARY KEY (rollNo)
);

Problem:-3

CREATE TABLE lawyer (
    id INT NOT NULL,
    name VARCHAR(255),
    email VARCHAR(255),
    address VARCHAR(255),
    experience INT,
    PRIMARY KEY (id)
);
