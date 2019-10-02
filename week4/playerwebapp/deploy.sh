#!/bin/bash

git pull
mvn clean package
sudo rm -f /var/lib/tomcat/webapps/*.war
sudo cp target/*.war /var/lib/tomcat/webapps/
sudo service tomcat restart
