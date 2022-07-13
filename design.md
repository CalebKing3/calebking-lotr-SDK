
# Lord of the Rings - SDK

# Interacting with API

This API is organized around [REST](http://en.wikipedia.org/wiki/Representational_State_Transfer).
It has predictable, resource-oriented URLs, and uses HTTP response codes to indicate API errors.
We use built-in HTTP features, like HTTP authentication and HTTP verbs, which are understood by off-the-shelf HTTP clients.

https://the-one-api.dev/v2

## HTTP Verbs Supported

As per RESTful design patterns, API implements following HTTP verbs:

- `GET` - Read resources. Should hever change resources on server (idempotency) since most of http proxies and services may reply same request multiple times.
- `POST` - Search for a resource

## Endpoints
> Start service and using postman you'll be able to call these endpoints

	* GET:  http://localhost:8080/v1/lord-of-the-rings/movie/
	* GET:  http://localhost:8080/v1/lord-of-the-rings/book/
	* GET:  http://localhost:8080/v1/lord-of-the-rings/movie/{id}
	* GET:  http://localhost:8080/v1/lord-of-the-rings/book/{id}
	* GET:  http://localhost:8080/v1/lord-of-the-rings/movie/longest
	* GET:  http://localhost:8080/v1/lord-of-the-rings/book/title/{id}
	* POST: http://localhost:8080/v1/lord-of-the-rings/movie/search



## HTTP status codes

HTTP Code | Description
--------- | -----------
`200` | Everything worked as expected.
`201` | Created.
`202` | Accepted. Returned when created a finite-state machine or business process, that is not yet in final state to suggest front-end that it should re-query results and take appropriate actions.
`204` | No Content. Deletion of not-existent resource.
`400` | Bad Request. The request was unacceptable, often due to missing a required parameter. Or request contains invalid JSON. Duplicate idempotency key.
`401` | Unauthorized. No valid API key provided or API key doesn't match project.
`402` | The parameters were valid but the request failed.
`403` | Source or destination account is disabled.
`404` | Not Found. The requested resource doesn't exist.
`415` | Incorrect ```Content-Type``` HTTP header.
`422` | Logical error. For example, POST'ed resource did not pass validation.
`429` | Too Many Requests. Rate limit is exceeded.
`500` `502` `503` `504` | Server Errors. Something went wrong on our end. (These are rare.)


## Context Path

`/v1/lord-of-the-rings`

## Authentication

I used bearer token provided by https://the-one-api.dev/v2

1. bearer token

## Request structure

Request consist with a root object that contain resource and metadata as it's childs:

**POST Request example:**

```json
{
  "name" : "The Lord of the Rings Series"
}
```

## Response structure

Response can consist of 5 root properties:

- `docs` - groups the entire response
- `id` - unique identifier for each book
- `name` - title of the book
- `runtimeInMinutes` - Total runtime for the movie in minutes
- `budgetInMillions` - budget for the movie
- `boxOfficeRevenueInMillions` - movie financial success
- `academyAwardNominations` - movie awards nominations
- `academyAwardWins` - movie awards received
- `rottenTomatoesScore` - movie financial success

**Response example:**

```json
{
  "docs": [
    {
      "_id": "5cd95395de30eff6ebccde56",
      "name": "The Lord of the Rings Series",
      "runtimeInMinutes": 558,
      "budgetInMillions": 281,
      "boxOfficeRevenueInMillions": 2917,
      "academyAwardNominations": 30,
      "academyAwardWins": 17,
      "rottenTomatoesScore": 94
    },
    {
      "_id": "5cd95395de30eff6ebccde57",
      "name": "The Hobbit Series",
      "runtimeInMinutes": 462,
      "budgetInMillions": 675,
      "boxOfficeRevenueInMillions": 2932,
      "academyAwardNominations": 7,
      "academyAwardWins": 1,
      "rottenTomatoesScore": 66.33333333
    },
    {
      "_id": "5cd95395de30eff6ebccde58",
      "name": "The Unexpected Journey",
      "runtimeInMinutes": 169,
      "budgetInMillions": 200,
      "boxOfficeRevenueInMillions": 1021,
      "academyAwardNominations": 3,
      "academyAwardWins": 1,
      "rottenTomatoesScore": 64
    },
    {
      "_id": "5cd95395de30eff6ebccde59",
      "name": "The Desolation of Smaug",
      "runtimeInMinutes": 161,
      "budgetInMillions": 217,
      "boxOfficeRevenueInMillions": 958.4,
      "academyAwardNominations": 3,
      "academyAwardWins": 0,
      "rottenTomatoesScore": 75
    },
    {
      "_id": "5cd95395de30eff6ebccde5a",
      "name": "The Battle of the Five Armies",
      "runtimeInMinutes": 144,
      "budgetInMillions": 250,
      "boxOfficeRevenueInMillions": 956,
      "academyAwardNominations": 1,
      "academyAwardWins": 0,
      "rottenTomatoesScore": 60
    },
    {
      "_id": "5cd95395de30eff6ebccde5b",
      "name": "The Two Towers ",
      "runtimeInMinutes": 179,
      "budgetInMillions": 94,
      "boxOfficeRevenueInMillions": 926,
      "academyAwardNominations": 6,
      "academyAwardWins": 2,
      "rottenTomatoesScore": 96
    },
    {
      "_id": "5cd95395de30eff6ebccde5c",
      "name": "The Fellowship of the Ring",
      "runtimeInMinutes": 178,
      "budgetInMillions": 93,
      "boxOfficeRevenueInMillions": 871.5,
      "academyAwardNominations": 13,
      "academyAwardWins": 4,
      "rottenTomatoesScore": 91
    },
    {
      "_id": "5cd95395de30eff6ebccde5d",
      "name": "The Return of the King",
      "runtimeInMinutes": 201,
      "budgetInMillions": 94,
      "boxOfficeRevenueInMillions": 1120,
      "academyAwardNominations": 11,
      "academyAwardWins": 11,
      "rottenTomatoesScore": 95
    }
  ],
  "total": 8,
  "limit": 1000,
  "offset": 0,
  "page": 1,
  "pages": 1
}
```

## Errors

All errors are return as a string. Two exception are provided.

## Next Steps
I would have liked to made an interactive swagger doc to run this with a UI.
Unit test and API test with something like Karate for e2e