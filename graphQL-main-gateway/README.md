# graphQL-With-Spring-Boot-MongoDB
A simple graphQL project with spring boot and MongoDB as backedn Database. It have basic CRUD operation.

## GraphQL APIs to do CRUD operations

1. Create an Author
2. Create a Tutorial
3. Read all Tutorials
4. Read all Authors
5. Update a Tutorial
6. Delete a Tutorial
7. Count number of Tutorials
___
**Create an Author**

GraphQL Request

```json
mutation {
  createAuthor(
    name: "Anand",
    age: 24) {
      id name
  }
}
```

Response
```json
{
  "data": {
    "createAuthor": {
      "id": "638c1081c50e8c75aa62231e",
      "name": "Anand"
    }
  }
}
```

**Create a Tutorial**

GraphQL Request: requiring Tutorial id, title and author (name) for response
```json
mutation {
  createTutorial (
    title: "Java Tutorial #1",
    description: "Java Tut Description 1"
    author: "638c1081c50e8c75aa62231e")
    {
      id title author { name }
    }
}
```

Response

```json
{
  "data": {
    "createTutorial": {
      "id": "638c1091c50e8c75aa622321",
      "title": "Java Tutorial #1",
      "author": {
        "name": "Anand"
      }
    }
  }
}
```




**Read all Tutorials**

GraphQL Request
```json
{
  findAllTutorials{
    id
    title
    description
    author{
      id
      name
    }
  }
}
```

Response

```json
{
    "data": {
        "findAllTutorials": [
            {
                "id": "638c1089c50e8c75aa62231f",
                "title": "Java Tutorial #1",
                "description": "Java Tut Description 1"
            },
            {
                "id": "638c108ec50e8c75aa622320",
                "title": "Java Tutorial #2",
                "description": "Java Tut Description 2"
            },
            {
                "id": "638c1091c50e8c75aa622321",
                "title": "Java Tutorial #3",
                "description": "Java Tut Description 3"
            }
        ]
    }
}
```



**Read all Authors**

GraphQL Request
```json
{
  findAllAuthors{
    id
    name
    age
  }
}
```

Response

```json
{
    "data": {
        "findAllAuthors": [
            {
                "id": "638c1081c50e8c75aa62231e",
                "name": "Anand",
                "age": 42
            }
        ]
    }
}
```


**Update a Tutorial**

GraphQL Request
```json
mutation {
  updateTutorial (
    id: "638c1089c50e8c75aa62231f"
    description: "Java Tut Description -1 (Updated)")
    {
      id title description author { name }
    }
}
```

Response

```json
{
    "data": {
        "updateTutorial": {
            "id": "638c1089c50e8c75aa62231f",
            "title": "Java Tutorial #3",
            "description": "Java Tut Description -1 (Updated)",
            "author": {
                "name": "Anand"
            }
        }
    }
}
```




**Delete a Tutorial**

GraphQL Request
```json
mutation {
  deleteTutorial(id: "638c1091c50e8c75aa622321")
}
```

Response

```json
{
    "data": {
        "deleteTutorial": true
    }
}
```


**Count number of Tutorials**

GraphQL Request
```json
{
  countTutorials
}
```

Response

```json
{
  "data": {
    "countTutorials": 3
  }
}
```