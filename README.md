# Spring Boot GraphQL

This is a sample project for integration with Spring Boot and GraphQL.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

* Java JDK 8

### Installing

* Clone repo "git clone git@github.com:popovski/spring-boot-graphql.git"
* Import the project in any IDE

### Build and Start the project

* ./mvnw clean package
* ./mvnw spring-boot:run
* Open web browser and navigate to http://localhost:8080/graphiql, you should see the GraphQL interactive UI.

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot)
* [Maven](https://maven.apache.org/) - Dependency Management
* [GraphQL](https://graphql.org/)

## Demo
		
# Mutations


	Mutation new book
	
	mutation {
	  newBook(book:
		{
		  title: "title",
		  description: "description"
		}
	  )
	  {
		id
		title
		description
	  }
	}



	Mutation update book
	
	mutation {
	  updateBook(book:
		{
		  title: "newTitle",
		  description: "newDescription"
		}, uuid:"67b68681d82140f2a27606f79a424511"
	  )
	  {
		id
		title
		description
	  }
	}

	Mutation delete book

	mutation {
	  deleteBook(uuid: "02b7f0d44ac848fd8a3fe3a3e29576e8") 
	}
	
# Query

	Get All books

	query {
	  findAllBooks {
		title
	  }
	}

	Get all books with pagination

	query {
	  findAllBooks(pageNumber:0,pageSize:2) {
		id
		title
	  }
	}
	
	Get Book by UUID
	
	
	query {
	  findByUuid(uuid:"") {
		id
		title
	  }
	}
