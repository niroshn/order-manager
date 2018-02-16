CREATE DATABASE sysco;
#Create Testuser
CREATE USER 'omadmin'@'localhost' IDENTIFIED BY '';
GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP ON *.* TO 'dev'@'localhost';
