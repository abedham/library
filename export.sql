--------------------------------------------------------
--  File created - «·«À‰Ì‰-œÌ”„»—-12-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence BOOK_ID
--------------------------------------------------------

   CREATE SEQUENCE  "D_PROJECT"."BOOK_ID"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 87 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DBOBJECTID_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "D_PROJECT"."DBOBJECTID_SEQUENCE"  MINVALUE 1 MAXVALUE 999999999999999999999999 INCREMENT BY 50 START WITH 1 CACHE 50 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence EMP_ID
--------------------------------------------------------

   CREATE SEQUENCE  "D_PROJECT"."EMP_ID"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 77 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence MEM_ID
--------------------------------------------------------

   CREATE SEQUENCE  "D_PROJECT"."MEM_ID"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 43 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence PUB_ID
--------------------------------------------------------

   CREATE SEQUENCE  "D_PROJECT"."PUB_ID"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 61 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEC_ID
--------------------------------------------------------

   CREATE SEQUENCE  "D_PROJECT"."SEC_ID"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 61 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table AUTHOR_BOOK
--------------------------------------------------------

  CREATE TABLE "D_PROJECT"."AUTHOR_BOOK" 
   (	"AUTHOR_NAME" VARCHAR2(20 BYTE), 
	"BOOK_ID" NUMBER(6,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table BOOK
--------------------------------------------------------

  CREATE TABLE "D_PROJECT"."BOOK" 
   (	"BOOK_ID" NUMBER(6,0), 
	"TITLE" VARCHAR2(30 BYTE), 
	"AVAILABLE" NUMBER(1,0), 
	"SEC_ID" NUMBER(6,0), 
	"PUB_ID" NUMBER(6,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table BORROW
--------------------------------------------------------

  CREATE TABLE "D_PROJECT"."BORROW" 
   (	"EMP_ID" NUMBER(6,0), 
	"MEM_ID" NUMBER(6,0), 
	"BOOK_ID" NUMBER(6,0), 
	"CUR_DATE" VARCHAR2(10 BYTE), 
	"EXPIRE_DATE" VARCHAR2(10 BYTE), 
	"RETURNED" NUMBER(1,0) DEFAULT 0
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table EMPLOYEE
--------------------------------------------------------

  CREATE TABLE "D_PROJECT"."EMPLOYEE" 
   (	"EMP_ID" NUMBER(6,0), 
	"NAME" VARCHAR2(70 BYTE), 
	"ISADMIN" NUMBER(1,0), 
	"ADDRESS" VARCHAR2(20 BYTE), 
	"EMAIL" VARCHAR2(20 BYTE), 
	"SALARY" NUMBER(4,0), 
	"PASSWORD" VARCHAR2(150 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MEMBER
--------------------------------------------------------

  CREATE TABLE "D_PROJECT"."MEMBER" 
   (	"MEM_ID" NUMBER(6,0), 
	"NAME" VARCHAR2(80 BYTE), 
	"EMAIL" VARCHAR2(50 BYTE), 
	"ADDRESS" VARCHAR2(80 BYTE), 
	"EXPIRE_DATE" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PHONE_NUMBER
--------------------------------------------------------

  CREATE TABLE "D_PROJECT"."PHONE_NUMBER" 
   (	"MEM_ID" NUMBER(6,0), 
	"PHONE" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PUBLISHER
--------------------------------------------------------

  CREATE TABLE "D_PROJECT"."PUBLISHER" 
   (	"PUB_ID" NUMBER(6,0), 
	"NAME" VARCHAR2(12 BYTE), 
	"ADDRESS" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table REG_BOOK
--------------------------------------------------------

  CREATE TABLE "D_PROJECT"."REG_BOOK" 
   (	"EMP_ID" NUMBER(6,0), 
	"BOOK_ID" NUMBER(6,0), 
	"CUR_DATE" VARCHAR2(10 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table REG_MEMBER
--------------------------------------------------------

  CREATE TABLE "D_PROJECT"."REG_MEMBER" 
   (	"EMP_ID" NUMBER(6,0), 
	"MEM_ID" NUMBER(6,0), 
	"CUR_DATE" VARCHAR2(10 BYTE), 
	"EXPIRE_DATE" VARCHAR2(10 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table SECTION
--------------------------------------------------------

  CREATE TABLE "D_PROJECT"."SECTION" 
   (	"SEC_ID" NUMBER(6,0), 
	"NAME" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for View EMP_BOOKS
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "D_PROJECT"."EMP_BOOKS" ("BOOK_ID", "TITLE", "AVAILABLE", "SEC_NAME", "PUB_NAME", "EMP_NAME", "CUR_DATE") AS 
  SELECT distinct BOOK.BOOK_ID, BOOK.TITLE, BOOK.AVAILABLE, SECTION.NAME SEC_NAME, PUBLISHER.NAME PUB_NAME,
    EMPLOYEE.NAME EMP_NAME , REG_BOOK.CUR_DATE 
      FROM ((((BOOK LEFT JOIN SECTION ON BOOK.SEC_ID = SECTION.SEC_ID)
        LEFT JOIN PUBLISHER ON BOOK.PUB_ID = PUBLISHER.PUB_ID)
          LEFT JOIN REG_BOOK ON REG_BOOK.BOOK_ID=REG_BOOK.BOOK_ID)
            LEFT JOIN EMPLOYEE ON EMPLOYEE.EMP_ID=REG_BOOK.EMP_ID);
--------------------------------------------------------
--  DDL for View MEMBER_BOOKS
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "D_PROJECT"."MEMBER_BOOKS" ("MEM_ID", "BOOK_ID", "TITLE", "CUR_DATE", "EXPIRE_DATE", "RETURNED") AS 
  select mem_id, book_id, title,cur_date, expire_date, returned from BOOK NATURAL join BORROW;
REM INSERTING into D_PROJECT.AUTHOR_BOOK
SET DEFINE OFF;
Insert into D_PROJECT.AUTHOR_BOOK (AUTHOR_NAME,BOOK_ID) values ('Ahmed El Desoky',67);
REM INSERTING into D_PROJECT.BOOK
SET DEFINE OFF;
Insert into D_PROJECT.BOOK (BOOK_ID,TITLE,AVAILABLE,SEC_ID,PUB_ID) values (67,'Islamic History',1,41,41);
REM INSERTING into D_PROJECT.BORROW
SET DEFINE OFF;
REM INSERTING into D_PROJECT.EMPLOYEE
SET DEFINE OFF;
Insert into D_PROJECT.EMPLOYEE (EMP_ID,NAME,ISADMIN,ADDRESS,EMAIL,SALARY,PASSWORD) values (58,'Mohammed',1,'nasser','moh@htotmail.com',9999,'e10adc3949ba59abbe56e057f20f883e');
Insert into D_PROJECT.EMPLOYEE (EMP_ID,NAME,ISADMIN,ADDRESS,EMAIL,SALARY,PASSWORD) values (59,'rami',0,'remal','rm@gmail.com',454,'e10adc3949ba59abbe56e057f20f883e');
Insert into D_PROJECT.EMPLOYEE (EMP_ID,NAME,ISADMIN,ADDRESS,EMAIL,SALARY,PASSWORD) values (57,'AbdelRahman',1,'Mokhabarat','abed.ha15@gmail.com',9000,'202cb962ac59075b964b07152d234b70');
REM INSERTING into D_PROJECT.MEMBER
SET DEFINE OFF;
Insert into D_PROJECT.MEMBER (MEM_ID,NAME,EMAIL,ADDRESS,EXPIRE_DATE) values (23,'Jameel','jam@hotmil.com','Ramallah','2017-12-13');
REM INSERTING into D_PROJECT.PHONE_NUMBER
SET DEFINE OFF;
Insert into D_PROJECT.PHONE_NUMBER (MEM_ID,PHONE) values (23,'+972597868282');
REM INSERTING into D_PROJECT.PUBLISHER
SET DEFINE OFF;
Insert into D_PROJECT.PUBLISHER (PUB_ID,NAME,ADDRESS) values (41,'Al_Salam','Gaza');
REM INSERTING into D_PROJECT.REG_BOOK
SET DEFINE OFF;
Insert into D_PROJECT.REG_BOOK (EMP_ID,BOOK_ID,CUR_DATE) values (57,67,'13/12/16');
REM INSERTING into D_PROJECT.REG_MEMBER
SET DEFINE OFF;
Insert into D_PROJECT.REG_MEMBER (EMP_ID,MEM_ID,CUR_DATE,EXPIRE_DATE) values (57,23,'13/12/16','2017-12-13');
REM INSERTING into D_PROJECT.SECTION
SET DEFINE OFF;
Insert into D_PROJECT.SECTION (SEC_ID,NAME) values (41,'History');
--------------------------------------------------------
--  DDL for Index SYS_C007303
--------------------------------------------------------

  CREATE UNIQUE INDEX "D_PROJECT"."SYS_C007303" ON "D_PROJECT"."MEMBER" ("MEM_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007304
--------------------------------------------------------

  CREATE UNIQUE INDEX "D_PROJECT"."SYS_C007304" ON "D_PROJECT"."PHONE_NUMBER" ("MEM_ID", "PHONE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007306
--------------------------------------------------------

  CREATE UNIQUE INDEX "D_PROJECT"."SYS_C007306" ON "D_PROJECT"."REG_MEMBER" ("EMP_ID", "CUR_DATE", "EXPIRE_DATE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007302
--------------------------------------------------------

  CREATE UNIQUE INDEX "D_PROJECT"."SYS_C007302" ON "D_PROJECT"."EMPLOYEE" ("EMP_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007307
--------------------------------------------------------

  CREATE UNIQUE INDEX "D_PROJECT"."SYS_C007307" ON "D_PROJECT"."BOOK" ("BOOK_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007310
--------------------------------------------------------

  CREATE UNIQUE INDEX "D_PROJECT"."SYS_C007310" ON "D_PROJECT"."BORROW" ("EMP_ID", "MEM_ID", "BOOK_ID", "CUR_DATE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007305
--------------------------------------------------------

  CREATE UNIQUE INDEX "D_PROJECT"."SYS_C007305" ON "D_PROJECT"."PUBLISHER" ("PUB_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007313
--------------------------------------------------------

  CREATE UNIQUE INDEX "D_PROJECT"."SYS_C007313" ON "D_PROJECT"."REG_BOOK" ("EMP_ID", "BOOK_ID", "CUR_DATE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007312
--------------------------------------------------------

  CREATE UNIQUE INDEX "D_PROJECT"."SYS_C007312" ON "D_PROJECT"."AUTHOR_BOOK" ("BOOK_ID", "AUTHOR_NAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007311
--------------------------------------------------------

  CREATE UNIQUE INDEX "D_PROJECT"."SYS_C007311" ON "D_PROJECT"."SECTION" ("SEC_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table REG_MEMBER
--------------------------------------------------------

  ALTER TABLE "D_PROJECT"."REG_MEMBER" ADD PRIMARY KEY ("EMP_ID", "CUR_DATE", "EXPIRE_DATE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table BOOK
--------------------------------------------------------

  ALTER TABLE "D_PROJECT"."BOOK" MODIFY ("TITLE" NOT NULL ENABLE);
  ALTER TABLE "D_PROJECT"."BOOK" ADD PRIMARY KEY ("BOOK_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PHONE_NUMBER
--------------------------------------------------------

  ALTER TABLE "D_PROJECT"."PHONE_NUMBER" ADD PRIMARY KEY ("MEM_ID", "PHONE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table SECTION
--------------------------------------------------------

  ALTER TABLE "D_PROJECT"."SECTION" ADD PRIMARY KEY ("SEC_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table BORROW
--------------------------------------------------------

  ALTER TABLE "D_PROJECT"."BORROW" MODIFY ("RETURNED" NOT NULL ENABLE);
  ALTER TABLE "D_PROJECT"."BORROW" ADD PRIMARY KEY ("EMP_ID", "MEM_ID", "BOOK_ID", "CUR_DATE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PUBLISHER
--------------------------------------------------------

  ALTER TABLE "D_PROJECT"."PUBLISHER" ADD PRIMARY KEY ("PUB_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table AUTHOR_BOOK
--------------------------------------------------------

  ALTER TABLE "D_PROJECT"."AUTHOR_BOOK" ADD PRIMARY KEY ("BOOK_ID", "AUTHOR_NAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table REG_BOOK
--------------------------------------------------------

  ALTER TABLE "D_PROJECT"."REG_BOOK" ADD PRIMARY KEY ("EMP_ID", "BOOK_ID", "CUR_DATE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table MEMBER
--------------------------------------------------------

  ALTER TABLE "D_PROJECT"."MEMBER" ADD PRIMARY KEY ("MEM_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table EMPLOYEE
--------------------------------------------------------

  ALTER TABLE "D_PROJECT"."EMPLOYEE" ADD PRIMARY KEY ("EMP_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table AUTHOR_BOOK
--------------------------------------------------------

  ALTER TABLE "D_PROJECT"."AUTHOR_BOOK" ADD FOREIGN KEY ("BOOK_ID")
	  REFERENCES "D_PROJECT"."BOOK" ("BOOK_ID") ON DELETE SET NULL ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BOOK
--------------------------------------------------------

  ALTER TABLE "D_PROJECT"."BOOK" ADD CONSTRAINT "FK_PUBBOOK" FOREIGN KEY ("PUB_ID")
	  REFERENCES "D_PROJECT"."PUBLISHER" ("PUB_ID") ENABLE;
  ALTER TABLE "D_PROJECT"."BOOK" ADD FOREIGN KEY ("SEC_ID")
	  REFERENCES "D_PROJECT"."SECTION" ("SEC_ID") ON DELETE SET NULL ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BORROW
--------------------------------------------------------

  ALTER TABLE "D_PROJECT"."BORROW" ADD FOREIGN KEY ("BOOK_ID")
	  REFERENCES "D_PROJECT"."BOOK" ("BOOK_ID") ON DELETE SET NULL ENABLE;
  ALTER TABLE "D_PROJECT"."BORROW" ADD FOREIGN KEY ("EMP_ID")
	  REFERENCES "D_PROJECT"."EMPLOYEE" ("EMP_ID") ON DELETE SET NULL ENABLE;
  ALTER TABLE "D_PROJECT"."BORROW" ADD FOREIGN KEY ("MEM_ID")
	  REFERENCES "D_PROJECT"."MEMBER" ("MEM_ID") ON DELETE SET NULL ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PHONE_NUMBER
--------------------------------------------------------

  ALTER TABLE "D_PROJECT"."PHONE_NUMBER" ADD FOREIGN KEY ("MEM_ID")
	  REFERENCES "D_PROJECT"."MEMBER" ("MEM_ID") ON DELETE SET NULL ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table REG_BOOK
--------------------------------------------------------

  ALTER TABLE "D_PROJECT"."REG_BOOK" ADD FOREIGN KEY ("BOOK_ID")
	  REFERENCES "D_PROJECT"."BOOK" ("BOOK_ID") ON DELETE SET NULL ENABLE;
  ALTER TABLE "D_PROJECT"."REG_BOOK" ADD FOREIGN KEY ("EMP_ID")
	  REFERENCES "D_PROJECT"."EMPLOYEE" ("EMP_ID") ON DELETE SET NULL ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table REG_MEMBER
--------------------------------------------------------

  ALTER TABLE "D_PROJECT"."REG_MEMBER" ADD FOREIGN KEY ("EMP_ID")
	  REFERENCES "D_PROJECT"."EMPLOYEE" ("EMP_ID") ON DELETE SET NULL ENABLE;
  ALTER TABLE "D_PROJECT"."REG_MEMBER" ADD FOREIGN KEY ("MEM_ID")
	  REFERENCES "D_PROJECT"."MEMBER" ("MEM_ID") ON DELETE SET NULL ENABLE;
--------------------------------------------------------
--  DDL for Procedure ADD_AUTHOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "D_PROJECT"."ADD_AUTHOR" (name in varchar2) is 
b_id number(6);
begin 
SELECT  BOOK_ID.CURRVAL into b_id FROM dual;
insert into Author_Book VALUES(name , b_id);
end;

/
--------------------------------------------------------
--  DDL for Procedure ADDBOOK
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "D_PROJECT"."ADDBOOK" (title in varchar2 , available in number , sec_id in number ,
Pub_id in number ,Author_name in varchar2 , Emp_id in number , b_id out number    ) is

begin
insert into BOOK VALUES(book_id.NEXTVAL , title ,available , sec_id ,Pub_id);
select book_id.CURRVAL into b_id from dual ;
insert into Author_Book VALUES (Author_name ,book_id.CURRVAL );
insert into Reg_Book VALUES(Emp_id ,book_id.CURRVAL ,sysdate );

end;

/
--------------------------------------------------------
--  DDL for Procedure ADD_EMP
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "D_PROJECT"."ADD_EMP" 
(name in varchar , isAdmin in varchar , address in varchar , email in varchar, salary in number,e_id out number,pass in varchar2) is

begin 
insert into EMPLOYEE VALUES (emp_id.NEXTVAL ,name , isAdmin ,address , email, salary ,pass);
select emp_id.currval into e_id from dual;
end;

/
--------------------------------------------------------
--  DDL for Procedure ADDMEMBER
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "D_PROJECT"."ADDMEMBER" (name in varchar2 , email in varchar2 , phone in varchar2 ,
 Emp_id in number , address in varchar2 , expire_date in varchar2 , member_id out number  ) is

begin
insert into MEMBER VALUES(Mem_id.NEXTVAL , name , email , address ,expire_date  );
select Mem_id.CURRVAL into member_id from dual;
insert into Phone_number VALUES (Mem_id.CURRVAL ,phone );
insert into Reg_Member VALUES (Emp_id ,Mem_id.CURRVAL ,sysdate , expire_date  );

end;

/
--------------------------------------------------------
--  DDL for Procedure ADD_PUBLISHER
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "D_PROJECT"."ADD_PUBLISHER" (name varchar2 , address varchar2,publisher_id out number) is

begin 
INSERT into PUBLISHER VALUES(PUB_ID.NEXTVAL , name , address);
select PUB_ID.currval into publisher_id from dual;
end;

/
--------------------------------------------------------
--  DDL for Procedure ADD_SECTION
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "D_PROJECT"."ADD_SECTION" (name in VARCHAR2,section_id out number) is
begin
insert into section values(sec_id.NEXTVAL  , name);
select sec_id.currval into section_id from dual;
end;

/
--------------------------------------------------------
--  DDL for Procedure BORROW_BOOK
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "D_PROJECT"."BORROW_BOOK" (emp_id in number , mem_id in number , bookid in number , expire_date in varchar2) is
begin 
insert into borrow values(emp_id ,mem_id ,bookid ,sysdate ,  expire_date, 0);
update BOOK set AVAILABLE=0 where BOOK_ID= bookid;
end;

/
--------------------------------------------------------
--  DDL for Procedure RETURN_BOOK
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "D_PROJECT"."RETURN_BOOK" (bookID number, MEMBER_ID number) IS
begin
update BORROW set returned=1 where mem_id=MEMBER_ID and BOOK_ID=bookID;
update BOOK set AVAILABLE=1 where BOOK_ID=bookID;
end;

/
