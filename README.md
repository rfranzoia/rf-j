# RF-J - Simple Url Shortener

A simple URL Shortener implementation

Uses
   + Java 8
   + Spring Boot
   + Spring Data (JPA/Hibernate)
   + Docker / Docker Compose

     
 # How to use the Url Shortener
 
     - to create a shortened url open your browser at `http://<ip_address>:8080/api/v1/short/url`
        + the shortened url will start with `http://rf.j`, but that can be changed on code, just put the desired url in the BASE_URL constant.
        
     - to use a previously created shortened url open your browser at `http://<ip_address>:8080/<shortenedu_url>`,
       this will automatically redirect to the saved url
       
     - to list all previously saved/shortened urls `http://<ip_address>:8080/api/v1/short/`
     
     - to show statistics about what is stored `http://<ip_address>:8080/api/v1/short/stats`


# Configuring and Building

   - to build the docker image with the spring boot url  shorterner application run: `mvn clean package dockerfile:build`
   
   - to run everything you must:
     * install docker at target machine
     * download and run the mysql image from 
        + `docker pull mysql/mysql-server:5.7.24`
        + `docker run -p 3307:3306 --name mysql -d mysql/mysql-server:5.7.24`
     
     * run the database creation script
        + `docker exec -it mysql mysql -uroot -p`
        + `grant all privileges on *.* to 'root'@'%' identified by 'password';`
        + `create database shortener;`
        + `CREATE TABLE `short_url` (		  
          `id` char(8) NOT NULL,
		  `encoded_url` varchar(512) NOT NULL,
		  `protocol` varchar(45) NOT NULL,
		  `base_url` varchar(128) NOT NULL,
		  `url_path` varchar(1024) NOT NULL,
		  PRIMARY KEY (`id`),
		  KEY `SECONDARY` (`encoded_url`)
		) ENGINE=InnoDB DEFAULT CHARSET=latin1;`
	   + `create user shortener;`
	   + `grant all privileges on *.* to 'shortener'@'%' identified by 'Sh0rtener';`
        
     * run the command `docker run --name linked --link mysql:mysql -p 8080:8080 -d rf-j`
     

# Change Log

version 1.3.1
   - added statistics results (very simple implementation)
   - added saved url listing
   - code cleaning removed unused and non-English classes
   
version 1.3.0
   - added docker integration
     
version 1.2.0
   - added mySql database support
   - coded reorganized for a better maintenance
   - no protocol needed for URL saving (shortening)

version 1.0.1 
   - upgrade to spring boot 2.0

version 1.0.0 - initial version
   - no database
   - spring boot 1.56

