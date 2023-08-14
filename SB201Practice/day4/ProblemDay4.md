# Type 2 : Implementation

## Problem 1: Player

Create a Table Player with the following fields & Insert 5 records.

```java
Pid: int (primary key)
Name: varchar
SportName: varchar
Age: int
```

Inside the demo class having the main method write the following JPQL queries which can retrieve an entity object

1. Write a Query That will return the list of player names in Upper case (**Scalar function**) 
2. Write a Query That will give a min age of a player out of all players. (**Aggregate function**)
3. Write a Query  That will give a list of players with an age group between 18 to 25 years. (**Between**)
4. Write a Query that will return the name of players whose names start with a particular letter. (**Like**) 

```java
public class Demo {
   public static void main( String[ ] args ) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( " " );
      EntityManager entitymanager = emfactory.createEntityManager();

      //write your logic here
     
   }
}
```

## Problem 2: Customer

Create an Entity Class Customer

```java
Database name: db1

Table: customer{
	customerId: int primary key
	name: varchar not null
	address: varchar not null
	budget: int not null
}
```

Create a class Demo with the main method and perform the below operations.

1. Write a NamedQuery to find “**customer by id**” by creating NamedQuery which will return customer details.
2. Write NativeQuery to get a “**List of All the customers**” by creating NamedQuery which will return all customer details.

```jsx
public class Demo {
   public static void main( String[ ] args ) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( " " );
      EntityManager entitymanager = emfactory.createEntityManager();
      Query query = entitymanager.createNamedQuery(" ");
		
		 //write your logic here      
     
   }   
}
```

## Problem 3: Employee

Create an Entity Employee with the following fields

```java
Employee{
	empId: int (primary key)
	empName: string
	address: string
	salary: int 
	email : string
}

```

**Create a class Demo with the main method and** Write the NamedNativeQueries for the following operations. 

1. FindAllEmployee
2. FindEmployeeByName

```java
public class Demo {
   public static void main( String[ ] args ) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( " " );
      EntityManager entitymanager = emfactory.createEntityManager();
      Query query = entitymanager.createNamedQuery(" ");
		
		 //write your logic here      
     
   }   
}
```