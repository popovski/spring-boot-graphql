# Mutation new application
mutation {
  newApplication (
    name:"name value", 
    owner: "owner value", 
    description: "description value") {
    id,
    name
  }
}

# Mutation update application
mutation {
  updateApplicationOwner (
    newOwner:"name value1", 
    id: 1 
    ) {
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
