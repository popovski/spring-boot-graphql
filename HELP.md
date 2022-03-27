# Mutation
mutation {
  newApplication (
    name:"name value", 
    owner: "owner value", 
    description: "description value") {
    id,
    name
  }
}

# Query

query {
  findAllApplications {
    name
  }
}
