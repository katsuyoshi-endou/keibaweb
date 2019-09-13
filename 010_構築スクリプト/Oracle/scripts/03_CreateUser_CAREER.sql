CREATE USER CAREER
IDENTIFIED BY "CAREER"
DEFAULT TABLESPACE CAREER
TEMPORARY TABLESPACE TEMPORARY
PROFILE DEFAULT
/
GRANT CONNECT TO CAREER WITH ADMIN OPTION
/
GRANT RESOURCE TO CAREER WITH ADMIN OPTION
/
GRANT CREATE VIEW TO CAREER WITH ADMIN OPTION
/
GRANT UNLIMITED TABLESPACE TO CAREER WITH ADMIN OPTION
/
GRANT READ ON DIRECTORY LY_DMP_DIR TO CAREER
/
GRANT WRITE ON DIRECTORY LY_DMP_DIR TO CAREER
/
GRANT CREATE DATABASE LINK TO CAREER
/

exit
