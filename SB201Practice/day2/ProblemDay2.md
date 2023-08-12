# Type 2 : Implementation

## Problem 1: Product

Create an Entity Class **product** with the  following fields,

```jsx
**product
	productId int primary key
	productName String
	quantity int
	price int**
```

- Insert 5 records manually inside this table. (Using SQL)
- Inside the Demo class (main class) perform the operation
    - To search a particular Product based on the Product Id using Entity Manager.

```java
package com.masai;

public class Demo {

	public static void main(String[] args) {
		
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("product");
		
			EntityManager em= emf.createEntityManager();
			
			//write your logic here.
	}
}
```

To get the Object from the Database we need to call **find(--)** method on the **EntityManager** object this **find(--)** method takes 2 parameters:

1. The class name of the Entity Object which we want.
2. The ID value for which Entity we want the object.

### Persistence.xml

```java
<?xml version="1.0" encoding="UTF-8"?>

<persistence xmlns="http://java.sun.com/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
             version="2.0">

    <persistence-unit name="product" >

<properties>
         
           <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
          <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/db1db" />
            <property name="javax.persistence.jdbc.user" value="root" />
            <property name="javax.persistence.jdbc.password" value="root" />
  

        </properties>

    </persistence-unit>
</persistence>
```

## Problem 2:  **MasaiSchool**

**MasaiSchool** provides an API that allows the creation, deletion, and update in the Student table. Your job is to implement the **MasaiDAOImpl** class using **EntityManager.** 

Database name: **masaiDB**
**Create a Table Student with the following fields.**

```java
**student**{
	**studentCode:** int Primary key
	**email:** varchar
	**address:** varchar
	**course:** varchar
	**level:** int
}
```

```java
public interface masaiDAO {
		Student findStudentById(int id)
		String saveStudent(Student student);
		String deleteStudentById(int id)
		String updateStudentLevel(int id, int level)
}
```

Reference :

**Sample of persistence.xml: (modify it accordingly)**

```java
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://java.sun.com/xml/ns/persistence"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://java.sun.com/xml/ns/persistence
http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
version="2.0">
<persistence-unit name="masaiUnit" >
		<properties>
				<property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
				<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/masaiDB" />
				<property name="javax.persistence.jdbc.user" value="" />
				<property name="javax.persistence.jdbc.password" value="" />
		</properties>
		</persistence-unit>
</persistence>
```

**pom.xml: sample (check the version of mysql)**

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

## Problem 3: Employee

Create a Maven project to implement the following functionalities:

Create **Database: db1** and **table: Employee** with the following fields.

```java
Employee{
	empId: int primary key
	name: varchar
	address: varchar
	salary: int
}
```

Implement the following methods of the **EmployeeDao** interface using Entity Manager.

```java
public interface EmployeeDao {

			public String registerEmployee(Employee employee);
			
			public Employee getEmployeeById(int empId)
			
			public String deleteEmployeeById(int empId)
			
			public String updateEmployeeSalary(int empId, int amount)
}
```

**Note: Exceptions should be properly handled.**

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

### Persistence.xml

```java
<?xml version="1.0" encoding="UTF-8"?>

<persistence xmlns="http://java.sun.com/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
             version="2.0">

    <persistence-unit name="employee" >

<properties>
         
           <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
          <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/db1db" />
            <property name="javax.persistence.jdbc.user" value="root" />
            <property name="javax.persistence.jdbc.password" value="root" />
  

        </properties>

    </persistence-unit>
</persistence>
```