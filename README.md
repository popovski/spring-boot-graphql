# Mutation new book
mutation {
  newBook(title: "title",description: "description") {
    id
    title
    description
  }
}


# Mutation update book
mutation {
  updateBook (
    newTitle:"new title", 
    id: 1
    ) {
    id,
    title
  }
}

# Query

query {
  findAllBooks {
    title
  }
}
