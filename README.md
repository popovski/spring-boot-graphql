# Spring Boot GraphQL

	This is a sample project for integration with Spring Boot and GraphQL.
	To set this project follow this steps :
		1. Clone this repository
		2. If you are using IDE open it or if you want to use CLI go to the project directory and write mvn install
		3. If you are using IDE just run it as a Spring Application or if you are using CLI run mvn spring-boot:run
		4. Open web browser and navigate to http://localhost:8080/graphiql, you should see the GraphQL interactive UI.
		
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
