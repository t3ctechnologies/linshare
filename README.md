
# LinShare

## Table of Contents

- [Pre-Requisite](#prerequisite)
- [Eclipse Plugin](#eclipseplugin)


## PreRequisite

1. Eclipse Neon
2. Git Client
3. MySQl workbench 6.3 and MongoDb 3.4
4. Java SDK 8 


## EclipsePlugin
* eGit 
* Maven 3.5.0 Integration for Eclipse
* Run-jetty-Run

### SET SYSTEM ENVIRONMENT for the following

	a)	git 	eg:- variable : path   				value  : C:\Program Files\Git\bin
	b)  maven        variable : path   				value  : I:\maven\apache-maven-3.5.0\bin
	c)  mongo        variable : path   				value  : C:\Program Files\MongoDB\Server\3.4\bin
	d)  project      variable : LINSHARE_HOME   	value  : H:\MyWorkspace   (Eclipse workspace)


### Steps to config Dev Environment

1) Download code base from BitBucket repository (We have updated library's and Java Version)

2) Go to Mysql and create an user = "linshare" password = "linshare" 
	a) Create two schemas  named 
		1) linshare 
		2) linshare_data 
	b) Import self contained file  (eg:- linshare_schemas.sql) to the db "linshare".

3)	Open Eclipse Workspace and create a repository ‘configurations’. 
	
	Under that create a folder my_conf1.
	
	Then go to your linshare source code (\src\main\resources) and copy the linshare.properties.sample and put it into my_conf1 and rename it as linshare.properties
	
	And copy the log4j.properties from the source code(\src\main\resources) and paste into my_conf1.
	
	And create a folder with name ‘projects’ under my_conf1 and paste linshare project there also with name linshare.

	
4)	Go to Eclipse and configure jetty and maven 
		
		For maven 
		* set goal : jetty:run
		* profile : h2,local
		
		Set environement Variable
		* LINSHARE_HOME  Value : ${workspace}  
		For example:- H:\MyWorkspace    (Eclpise Workspace) for both maven and jetty
	

		And set jetty context : /linshare 
		Set : VM argument :   

			-Dlog4j.configuration=file:${workspace_loc}/configurations/my_conf1/log4j.properties                   
			-Dlinshare.config.path=file:${workspace_loc}/configurations/my_conf1
			-XX:MaxPermSize=256m -Djava.awt.headless=true -Xms512m -Xmx1538m  -XX:-      UseSplitVerifier
			
			
			Hint: in the above arguments ${workspace_loc} this is nothing but eclipse workspace.


6) Install apache http server
 
 	Download "http://www.apachehaus.com/cgi-bin/download.plx?dli=kVFbQRWaNNjTqJ1KatmWSBlVOpkVFVFdUNzayEWQ"

	unzip it to any drive as root directory , eg:-  c:\Apache24
	
	Go to its bin through cmd prompt and execute httpd.exe

	And go conf/httpd.conf in apache24 and edit the page as follows:

	Search for mod_proxy.so and uncomment that line.

	Search for headers_module and uncomment it.
	
	Search for mod_proxy_http.so and uncomment it.
	
	Search for mod_proxy_http2.so and uncomment it.
	
	Search for DocumentRoot “${SRVROOT}/htdocs” and comment it (add # in the beginning of that line).
	
	At the bottom of the file add the following as a new line :


		<VirtualHost *:80>
			ServerName linshare-user.local
			DocumentRoot "${SRVROOT}/htdocs/linshare-ui-user"
			<Location /linshare>
    			ProxyPass http://127.0.0.1:8080/linshare
    			ProxyPassReverse http://127.0.0.1:8080/linshare
    			ProxyPassReverseCookiePath /linshare /

    			# Workaround to remove httpOnly flag (could also be done with tomcat)
    			Header edit Set-Cookie "(JSESSIONID=.*); Path.*" "$1; Path=/"
    			# For https, you should add Secure flag.
    			# Header edit Set-Cookie "(JSESSIONID=.*); Path.*" "$1; Path=/; Secure"

    			#This header is added to avoid the JSON cache issue on IE.
    			Header set Cache-Control "max-age=0,no-cache,no-store"
			</Location>
		</Virtualhost>




7) Download 
 	
 	"http://download.linshare.org/service/local/artifact/maven/content?r=linshare-releases&g=org.linagora.linshare&a=linshare-ui-user&v=2.0.0&p=tar.bz2"

	and extract linshare-ui-user folder in the archive to Apache24\htdocs folder.


Installation and setting up is done here.

## To Run:

	a)  Ensure MySQL is running in system services.
	
	b)  Start the mongodb.
		
		Go to cmd prompt enter into its bin and run mongod.exe.
	
	c)  Go to eclipse and right click the project, select Run As -> maven build.
	
	d)  Start webserver.
	
		Go to cmd prompt and go Apache24 bin and execute httpd.exe. 
	
	g)  Go to browser and enter  "http://localhost" 
	
	h)  To login Use the following credentials
	
		User :  "root@localhost.localdomain" 
		
		Password : adminlinshare








	