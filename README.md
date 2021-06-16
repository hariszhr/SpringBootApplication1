**JukeBox API**
----
  Returns a paginated list of jukeboxe names/id that suppport a given "setting_id"
   
  * Generate jar
  `mvn -U clean install`
  
  * Run via Docker
  `docker-compose up`
  
  * Run locally
  `java -jar target/SpringBootApplication1-0.0.1-SNAPSHOT.jar`


* **URL**

  url:8080/touchtunes/tech-assignment/jukeboxes?settingId=53a7d3ae-0fc4-4f36-889a-683aa46eb33d&model=abcdef&offset=1&limit=20

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `settingId=[string]` setting id from JukeBox setting data
   
   **Optional:**
 
   `model=[string]` Model name of the JukeBox
   
   `offset=[integer]` Specifies at what index start the page
   
   `limit=[integer]` Specifies the page size

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[{"name":"60c6ed35907f3077c726cf26"},{"name":"60c6ed35ce37f288177b9043"},{"name":"60c6ed35439f497d7570245d"},{"name":"60c6ed3559090fb6c403d1e7"}]`
 
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{"timestamp":"2021-06-16T05:35:18.848+00:00","status":404,"error":"Not Found","path":"//touchtunes/tech-assignment/jukeboxes"}`


  * **Code:** 400 BAD REQUEST <br />
    **Content:** `{"timestamp":"2021-06-16T05:35:42.871+00:00","status":400,"error":"Bad Request","path":"//touchtunes/tech-assignment/jukeboxes"}`
    

  * **Code:** 500 INTERNAL SERVER ERROR <br />
    **Content:** `{"timestamp": "2021-06-16T05:39:12.287+00:00","status": 500,"error": "Internal Server Error","trace": "java.io.IOException: Response{protocol=h2, code=404, message=, url=https://api.json-generator.com/templates/Nl1QF3waI8-1PPP/data}...`
