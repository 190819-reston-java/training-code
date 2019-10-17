# Web Services

## SOA – Service Oriented Architecture
  * See Open Group's introduction to SOA
  * See also Martin Fowler's "Service Oriented Ambiguity"
  * Services are programs that run independently, achieve some business logic, and communicate over a network
  * Service Oriented Architecture involves designing your app as a collection of these services working together
  
## MSA - MicroServices Architecture
  * See Open Group's chapter on MSA
  * MSA is also a contentious subject, with multiple interpretations.
  * Microservice Architecture is a subset of SOA, satisfying a few more conditions:
    * Microservices MUST satisfy the Single Responsiibility Principle (SRP) -- they do only one thing and do it well
    * Microservices cannot be composed of multiple other services
    * Microservices achieve scalability and resilience through independence (we can easily take down or spin up instances of each service)
    
## Comparison of typical enterprise SOA and typical MSA
  * Enterprise SOA has larger services that may have more than one responsibility
  * MSA has smaller services that satisfy SRP
  * Enterprise SOA communicates using SOAP, so each service has a WSDL for communicating with each other.  Secure and rigid communication rules.
  * MSA communicates with HTTP and consists of RESTful services.  "Smart endpoints, dumb pipes"
  * Enterprise SOA routes communication through a central bus
  * MSA uses service registries and discovery clients to allow communcation without centralized routing
  
# MSA
  
## Benefits of MSA (vs. Monolith)
  * Loosely coupled services
  * Modular
  * Fault tolerant (no Single Point of Failure)
  * Scalable : independent services easily horizontally scale, and we only scale the parts we need
  * Implementation agnostic : MS written in different languages and paradigms
  * Testable : test each service independently
  * Good for development in a large org : many small autonomous (agile, devops-y) teams maintain RESTful microservices
    * This is how FANG (Facebook, Amazon, Netflix, Google) does most development
  
## Drawbacks of MSA
  * *Network latency* and the "chattiness" of microservices
  * Distributed data storage means we make tradeoffs and settle for "eventual" consistent data
  * Monitoring and tracing errors is more difficult across a network
  * Deploying 100s of services can be difficult
  * Complexity/Refactoring : changes that touch one or two microservices are easier.  Changes that touch many microservices are much harder.
  
## Solutions/Mitigations of drawbacks
  * Chattiness reduced by following SRP and separation of concerns
    * If 2 microservices are constantly talking, refactor them to follow SRP
    * HTTP traffic can be reducing by replacing it with messaging queues (Rabbit, Kafka) when appropriate
  * Sharding databases, using shared caches, and other solutions exist for distributed storage, but they always involve tradeoffs
  * Spring Cloud Sleuth and Zipkin enable distributed logging and tracing
  * Docker, Kubernetes/Docker Swarm, and cloud platforms enable easier MSA deployment
  * Complexity mitigated by good design (a constant goal)
  
## Netflix OSS for Microservices
  * Eureka Server: Service Registry.  Microservices register their URI and status with Eureka.  Provides failover.
  * Eureka Client: Discovery Client.  Retrieves the registry from Eureka Server to locate multiple instances of any other service.
  * Ribbon: Load balancer.  Any service running Ribbon will balance its outgoing traffic between instances of other services.  Default is round-robin.
  * Zuul: Gateway.  Allows external entities to access resources within the MS network, and filters traffic coming from outside.
  * Hystrix: Circuit breaker.  Provides immediate fallback response from failing microservices; used to prevent cascading failures.
  * Feign: Http Client.  Allows microservices to easily send HTTP requests to other microservices
  
## Spring Cloud MSA tools
  * Config server: provides centralized and version controlled configuration for microservices
  * Spring REST and Spring Data: easily build a RESTful API
  * RabbitMQ: Messaging Queue -- broadcast information to all listening microservices instead of sending many HTTP requests

# SOAP
  * “Expose” and “Consume” Web Services
  * Simple Object Access Protocol
  * Protocol for XML based communication across the Internet
  * Platform and language-independent
  * Similar: Corba, Dcom, Java RMI
  * SOAP is pure XML and therefore language agnostic
  * Not tied to a specific transport protocol: HTTP, SMTP, FTP, MSNQ, IBM MQSeries, etc.

## SOAP w/HTTP
  * Messages sent within Http POST Requests
  * Http must set content type to text/xml

## SOAP Message
  * Envelope – (mandatory), defines start/end of message
  * Header – (optional), optional attributes to be used when processing message
  * Body – (mandatory), XML data with message to be sent
  * Fault – (optional), describes errors that may have occurred when processing
  * Defined in default namespace
  * for SOAP – www.w3.org/2001/12/soap-envelope
  * for encoding and datatypes – www.w3.org/2001/12/soap-encoding
  * Envelope packaging contents of message
  * Only one body element allowed
  * Changing SOAP version requires change of envelope
  * SOAP Header/Body != HTTP Header/Body: entire message goes inside Http Req/Resp body
  #### Message Structure
  ```xml
    <xml version=“1.0”?>
    <soap-env:Envelope xmlns=soap-env=”www.w3.org/2001/12/soap-envelope” soap-env:encodingStyle=”www.w3.org/2001/12/soap-encoding”>
      <soap-env:Header>
      </soal-env:Header>
      <soap-env:Body>
        <soap-env:Fault>
        </soap-env:Fault>
      </soap-env:Body>
    </soap-env:Envelope>
  ```

  #### Faults
  * One fault block per message
  * Optional
  * Success: 200-299 (HttpBinding)
  * Soap Fault: 500-599
  * Elements
    * `<faultCode>`
    * `<soap-env:versionMismatch>` - invalid namespace for env
    * `<soap-env:mustUnderstand>` - immediate child of header element not understood
    * `<soap-env:client>` - message was incorrectly formed
    * `<soap-env:Server>` - error with server
    * `<faultString>`
    * `<details>`
    
## WSDL
  * Web Service Description Language
  * XML file describing everything about the service
  * “Contract” or “Endpoint”
  * Like an interface
  * Contract first vs contract last
  * Two ways of creating a soap service
  * Did you write WSDL first, or Implementation (Java code) first?
  * Important WSDL Elements (definitions):
  * name (optional)
  * targetNamespace – logical namespace for info about service
  * xmlns – default wsdl namespace, http://schema.xmlsoap.org/wsdl
  * All WSDL elements go in this namespace
  * xmlns:xsd, xmlns:soap
  * Specifies soap-specific info and datatypes
    * types, port, message, porttype, operation, binding, service
    * types – any complex datatype used in document (not necessary if only simple types)
    * port – specify single endpoint as address for binding
    * message – define data elements for each operation (method params, return values)
    * porttype – defines operations that can be performed and the messages involved
    * operation – abstract description of action supported by service
    * binding – specify protocol and data format for operations and messages
    * service – specify port address(es) of binding
    
## Jax-WS – Java API for XML Web Services
  * This is to set up service providers + consumers
  * Annotation-based
  * Supported by open source framework Apache CXF (also supports other protocols)
  * Jax-B – Java Architecture for XML Binding
  * Marshalling – convert Java obj → XML file
  * Unmarshalling – convert XML → Java obj
  * WSDL Soap Binding styles
  * Use to translate WSDL binding to soap message body
  * Model: Literal (DOCUMENT) vs Encoded (RPC)
  * DOCUMENT – you define XML structure of message body (“message-oriented”)
  * RPC – request body must contain operation name and method parameters
  * Literal: contents conform to user-defined xsd
  * Encoded: uses xsd datatypes but body doesn't need to conform to user-defined xsd
  
# REST
  
## 6 traits of REST
  * Stateless
  * Cacheable
  * Client-Server
  * Layered Architecture
  * Uniform Interface
  * (optional) Code On-Demand

## Rest Services
  * Representational State Transfer
  * Stateless interactions
  * Creating Web APIs
  * (Typically) HTTP messaging
  * (Typically) Data exchanged by XML/JSON
  * Using simple url endpoints to connect to resources
  * Some Good Practices:
    * Validate all user input (mostly to avoid sql injection)
    * Check for malformed xml/json
    * Session-based authentication – validate user before allowing request
    * No sensitive information in url (user name, password, id, etc)
    * Restrict Http verbs
  
  ### Http Methods
  * Get, Post, Put, Delete, Head, Options, Connect, Trace
  * Know safe, idempotent, and cacheable methods.  See Wikipedia.
  #### Http Request
    * Verb – Http Method
    * URI – Uniform Resource Identifier, identifies resource on server
    * Version – Http version
    * Header – Meta data, key-value pairs, formatting, other details
    * Body – Message content or resource representation
  #### Http Response
    * Status – Indicates success or failure, between 100-599
    * Version
    * Header – Meta data, key-values (content length, timestamp, content type, etc)
    * Body
