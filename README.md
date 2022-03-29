# Spring Boot GraphQL

This is a sample project for integration with Spring Boot and GraphQL.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

* Java JDK 8

### Installing

* Clone this repository
* If you are using IDE open it or if you want to use CLI go to the project directory and write mvn install

### Build and Start the project

* If you are using IDE just run it as a Spring Application or if you are using CLI run mvn spring-boot:run
* Open web browser and navigate to http://localhost:8080/graphiql, you should see the GraphQL interactive UI.

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot)
* [Maven](https://maven.apache.org/) - Dependency Management
* [GraphQL](https://graphql.org/)

## Demo
		
# Mutations


	Mutation new book
	
	mutation {
	  newBook(title: "title",description: "description") {
		id
		title
		description
	  }
	}


	Mutation update book
	
	mutation {
	  updateBook(newTitle: "new title", uuid: "02b7f0d44ac848fd8a3fe3a3e29576e8") {
		id
		title
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
