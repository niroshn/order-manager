CREATE DATABASE sysco;
#Create Testuser
CREATE USER 'omadmin'@'localhost' IDENTIFIED BY '12345';
GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP ON *.* TO 'dev'@'localhost';
