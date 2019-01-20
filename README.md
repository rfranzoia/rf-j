# RFj - Url Shortner
Simple URL Shortner implementation

Uses
   + Java 8
   + Spring Boot
   + Hibernate (future use)
   + Spring Data (future use)

     
 # HOW TO USE THE URL SHORTENER
 
     - to create a shortened url open your browser at http://<ip_address>:8080/api/short/url
     - to use a previously created shortened url http://<ip_address>:8080/<shortenedu_url>, this will automatically redirect to the saved url
     
version 1.0.0 - initial version
   - no database
   - spring boot 1.56

version 1.0.1 
   - upgrade to spring boot 2.0

version 1.2.0
   - added mySql database support
   - coded reorganized for a better maintenance
   - no protocol needed for URL saving (shortening)


version 1.3.0
   - added docker integration
   - to build the docker image with the spring boot url  shorterner application run: `mvn clean package dockerfile:build`
   - to run everything you must:
     - install docker at target machine
     - download the mysql image from 
     - run the database creation script (instructions on the script file)
     - run the command `docker run --name linked --link mysql:mysql -p 8080:8080 -d rf-j`