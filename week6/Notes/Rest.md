# REST (REpresentational State Transfer)

- Previously, we have used the term *REST* quite loosely
- Before, it simply meant that our API was designed as a collection of resources
- However, Rest is much more specific and adheres to strict principles
- Supports many datatypes
  - JSON, XML, SOAP, etc
- Generally HTTP is used, but can support any protocol
- Resources identified by unique URI

## HTTP Methods

- GET: Request and receieve info
- POST: Insert into backend
- PUT: Update (also sometimes insert -- debated)
- DELETE
- TRACE: Return IP Addresses hit by the request
- HEAD: Returns the Header metadata

## Safe Vs Idempotent

- Safe: Server data won't be changed
  - GET, HEAD, TRACE
- Idempotent: The result is the same with consecutive use
  - GET, PUT, DELETE, HEAD (TRACE also depending on context)

## 6 Traits of REST

- All REST should be **stateless**
  - No request saves information about other requests
- REST should have a **uniform interface**
  - All resources are identified by their URL/URI & accessible ONLY through their identifier
- Should be **cacheable** to avoid needless hits
- Should develop a **client-server relationship**
- Supports **layered architecture**
  - Client should be able to retrieve data from an intended nested server
- Should be able to **provide code-on-demand**
  - Should provide executable code to its client
  - Often considered optional, or extra

## Richardson Maturity Model (RMM)

- A model (developed by Leonard Richardson) that breaks down the principal elements of a REST approach into three steps
- There are a total of 4 levels, starting at 0, which means following none of the principles

### Level 0 - RPC

- Effectively following none of the REST principles
- Any HTTP verb is used
  - Commonly, APIs might use POST requests for all resources, even if a GET would be sufficient
- Additionally, little attention is paid to Response codes
  - Frequently just sending 200 OK to all requests, even if they were invalid
- Commonly structured as an RPC, instead of a collection of resources

### Level 1 - Resources

- Design API as resources, instead of RPC
- Different endpoints for each resource
- Still no attention to HTTP methods or response codes

### Level 2 - HTTP Verbs

- Change API to require HTTP verbs according to their usage
- GET requests should be a safe operation to retrieve a resource
- POST requests should be an un-safe operation that updates/creates a resource
- PUT requests similar to POST requests
  - Particular usage is up to debate
- In addition, attention is also taken to provide meaningful response codes
  - For POST/PUT requests, consider 201 Created
  - For GET requests, 200 might be acceptable
  - If a resource is unavailable, consider a 4XX response code instead of an empty 200

### Level 3 - Hypermedia Controls

- Introduces acronym HATEOAS (Hypertext As The Engine Of Application State)
  - This simply means that information on how to use your API is included in responses
  - Ex: Response from a PUT request that creates user with id 1

        Status Code: HTTP 201 Created
        {
            "id": 1,
            "username": "username1",
            "password": "coolpw",
            "account": {
                "amount": 768
            },
            "links": {
                "href": "/users/1",
                "rel": "1",
                "type": "GET"
            }
        }

  - Above is an example of HATEOAS, we include a "links" attribute to our response that includes information about how to access the recently created resource
- There can be many links included, ranging from GET requests to accessing the resource to DELETE requests to delete the resource, as well as perhaps a range of requests to obtain related information
- These links can teach clients of your API how to use it
- Allows you to change your API as needed in the future, as clients can always access related information through the links attribute, even as they change

## There's More

- The RMM is not the end all be all of RESTful design
- Some consider Level 3 of the RMM is only the beginning of a RESTful API
- There's many features, such as support for other communication protocols like UDP
- Support for all of the HTTP verbs

## Conclusion

- Among many other more strict principles to maximize RESTfullness
- The point is not to confuse any API available over HTTP as a RESTful API
