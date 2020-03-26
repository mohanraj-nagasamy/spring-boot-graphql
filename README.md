# Create GraphQL server using Java, SpringBoot.

## Library used
* https://github.com/graphql-java-kickstart/graphql-spring-boot

## Running the project

```
mvn spring-boot:run
```

## Step 1:
```
http://localhost:8080/hi
```

Step 2:
### Add GraphQL dependencies (already updated pom.xml)

* http://localhost:9001/graphiql
* http://localhost:9001/playground
* http://localhost:9001/altair
* http://localhost:9001/voyager

 
### Simple Query

```
query {
  allTalks {
    id
    title
  }
}
```

### Multiple Query

```
query {
  allTalks {
    id
    title
    
  }
  allSpeakers {
    id
    name
  }
}
```

### Multiple Query with alias along with Union type

```
query {
  talks:allTalks {
    id
    title
    description
    speakers{
      id
      name
      twitter
    }
  }
  
  allOfAll {
    type:__typename
    ... on Speaker {
      speakerId: id
      name
      twitter
    }
    ... on Talk {
      talkId: id
      title
      description
    }
  }
}

```

### Mutation
```
mutation {
  addSpeaker(name: "mohan") {
    id
    name
    twitter
  }
}

mutation {
  addSpeakerObject(speakerInput: {
    name: "mohan_object",
    twitter:"mohan_twitter"
  }) {
    id
    name
    twitter
  }
}

```

```
subscription {
  scores(title:"get started") {
    title
    score
  }
}

```

### Beware of Cyclic Query and MaxQueryDepth 

```
query {
  allTalks {
    id
    title 
    speakers {
      id
      name
      talks {
        id
        title
        speakers {
          id
          name
        }
      }
    }
  }
}

```

### Not covered - Auth, Exception handling, and Pagination 

### Other GraphQL Java libraries to checkout
* https://github.com/leangen/graphql-spqr

