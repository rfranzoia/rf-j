# RFj - Url Shortner
Simple URL Shortner implementation

Uses
   + Java 8
   + Spring Boot
   + Spring Data (JPA/Hibernate)
   + Docker

     
 # HOW TO USE THE URL SHORTENER
 
     - to create a shortened url open your browser at `http://<ip_address>:8080/api/short/url`
        + the shortened url will start with `http://rf.j`, but that can be changed on code, just put the desired url in the BASE_URL constant.
        
     - to use a previously created shortened url open your browser at `http://<ip_address>:8080/<shortenedu_url>`,
       this will automatically redirect to the saved url
     
# Change Log

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
     