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

# Virtual Machines
 * An entire computer, but virtual.  Includes virtual resources (memory, storage, processor), full OS with filesystem, kernel, applications.
 * Can be built on top of the bare metal, with multiple virtual machines running on a single physical computer.  This is **Type 1 virtualization**.
 * Can be created on top of another running OS -- we have a **Host OS** on the bare metal running a virtual **Guest OS**.  This is **Type 2 virtualization**.
 * Managed by a **hypervisor**
 * EC2s are virtual machines provided by AWS in the cloud.

# Docker
  * Wildly popular tool used for DevOps.
  * The **Docker Daemon** runs on your machine and manages docker containers, runs the docker network, and builds docker images.  Start it with sudo service docker start
  * The first use case is to deploy your applications in **Docker Containers**, which allows you to run your application anywhere Docker runs.
  * Runs natively on Linux and has added support for Windows and OSX.
  * A step beyond mvn package in consistent deployment because it ensures the OS and environment are consistent across deployments, in addition to managing dependencies.
   * Reminder: dependency management tools just find and download versioned dependencies on your system.  While useful, mvn package may work differently on different operating systems or with different environments.
   
## Docker Container
 * A container is just a running process with an attached filesystem and additional encapsulation features.
 * Containers are similar to Virtual Machines, but much more lightweight.  Docker containers use the kernel of the Host OS and share read-only files between each other, so they use far fewer resources than similarly-configured VMs.
 * Containers allow us to deploy our apps in the same environment on many different machines -- each container has its own OS (minus kernel) and installed binaries and libraries (programs and resources).  We also set up the environment.
 * Unlike VMs, Containers don't have a set, provisioned amount of resources.  The resources used/available can change the same as they change for other processes.
 * Docker Containers are built from Docker Images
 
## Docker Image
 * A Docker image is a file that contains everything a container needs to run.
 * Images can include everything from the OS to specific applications, needed files, and environment variables
 * Docker provides versioning and git-like tools for images, so we can incrementally develop our images and track changes
 * Docker Hub provides GitHub-like functionality for images, and they provide many official images for users to build on.
 * Docker images are built from a Dockerfile in a Build Context.  The beginning of the Dockerfile should include a "FROM" where we specify the official image we're building on top of.  This will be the base layer of our image.
 
## Docker Image Layers
 * Images are built in read-only layers, so multiple docker containers that use the same layers can share resources
 * Each running Container has a read/write layer on top of the read-only image layers.  All the writing your running application does occurs in this top layer
 * Any files from the read-only layers that are changed are first copied to the read/write layer in that container.  We call this "Copy-On-Write"
 * When we build an image from a Dockerfile, new layers are produced with ADD, COPY, and RUN
 
 ## Docker Network
 * The docker daemon, by default, maintains all the running containers on a network on your computer.  We call this the **host** network type
 * We can also configure Docker to use a **distributed** network, making use of docker containers across multiple computers
 * If we want our docker container to be accessible outside of our machine, we need to run our container with a "--publish <port>:<port> command to set up port forwarding to the container.

## Docker Commands
 * Send commands to the docker daemon with the command ```docker <command>```
 * Commands to know:
  * build : builds an image from Dockerfile and context
  * run : creates a running container from an image.  Has important flags:
   * --publish `<hostport>:<containerport>` : forwards traffic hitting hostport to containerport
   * --detach : runs this container in the background
   * -it : pipes your stdin and stdout to the countainer, and gives you a nice shell to use inside the container
  * images : show all images available locally
  * ps : show all running containers
  * ps -la : show all containers running, stopped, and terminated
  * start / stop : start or stop a container
  * kill : terminate a container
 
## Dockerfile Syntax
 * Start with FROM, often (but not always) end with CMD.  Specify how to build an image
 * Only FROM, RUN, ADD, and COPY add layers to the image
 * Any command that adds layers will be cached and reused in future builds, if possible
 * Commands to know:
  * FROM `<image>` : specify the base image to build on top of.  Often an official image from DockerHub
  * RUN `<command>` : runs a command and saves the result as a new layer.  Examples:
   * RUN ```apt-get update && apt-get install <package>```
   * RUN ```mvn package```
  * COPY `<hostfile> <containerfile>` : copies a file from the build context in the host's filesystem into the image
  * ADD `<hostsource> <containerdestination>` : works similarly to COPY, but can take URLs and archived (.tar) files.
  * EXPOSE `<port>` : suggest a port to be published.  We still need to docker run with "-p `<port>:<port>`"
  * CMD `["<parts>", "<of>", "<command>"]` : sets a default command to run when every container built from this image starts up
