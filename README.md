# Getting Started

* Starting Application
    * @SpringBootApplication - It is combination of
        * @Configuration - Marks a class as a source of bean definitions for the Spring application context
        * @EnableAutoConfiguration - Automatically configures Spring application context based on the dependencies in the classpath.
        * @ComponentScan - Enables Spring to scan for components (beans) in the specified package and register them in the application context.Detects classes annotated with @Component, @Service, @Repository, and @Controller.
    * SpringApplication.run(Application.class, args);
* Dependency Injection
    * @component - key annotations in Spring to mark a class as a Spring-managed bean
    * @Primary - indicate that a specific bean should be given preference when multiple beans of the same type exist in the application context
    * @Qualifier - To select a specific bean when multiple beans of the same type exist.
    * @Autowire - It is used to enable dependency injection.
* Controller
  * @Controller - It is used to define a class as a Spring MVC controller.
  * @RestController - It combines the functionality of a @Controller and @ResponseBody annotations
  * @ResponseBody -  It is used to indicate that the return value of a method should be written directly to the HTTP response body.
* Model
  * @Data - When we need both @Getter and @Setter
  * Constructor
    * AllArgsConstructor
    * NoArgsConstructor
  * To format data 
    * @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
* Service
  * @Service - It mark a class as a service layer component. It does contain @Component annotation as well. 
* CRUD Operation
  * Get
    * @PathVariable - to get input from url Path, and @RequestMapping("product/{productId}")
    * @RequestParam("id") - to get input from query param url
  * POST
    * @RequestBody - to get input object from POST request using request Body.
* Status Code
  * USe ResponseEntity to send data along with status codes
  * Status codes used
    * 200 - OK
    * 404 - NOT_FOUND
* To enable cross origin resource sharing use @CrossOrigin
* Spring Security
