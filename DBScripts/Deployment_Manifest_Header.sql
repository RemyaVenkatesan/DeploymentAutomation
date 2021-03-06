--------------------------------------------------------
--  File created - Tuesday-June-14-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DEPLOYMENT_MANIFEST_HEADER
--------------------------------------------------------

  CREATE TABLE "RELAUT"."DEPLOYMENT_MANIFEST_HEADER" 
   (	"DEPLOYMENT_NAME" VARCHAR2(50 BYTE), 
	"DEPLOYMENT_ID" NUMBER, 
	"DEPLOY_DATE" DATE, 
	"ENVIRONMENT_ID" NUMBER, 
	"TAG" VARCHAR2(50 BYTE), 
	"ARCHIVE_FLAG" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index DEPLOYMENT_MANIFEST_HEADE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "RELAUT"."DEPLOYMENT_MANIFEST_HEADE_PK" ON "RELAUT"."DEPLOYMENT_MANIFEST_HEADER" ("DEPLOYMENT_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table DEPLOYMENT_MANIFEST_HEADER
--------------------------------------------------------

  ALTER TABLE "RELAUT"."DEPLOYMENT_MANIFEST_HEADER" ADD CONSTRAINT "DEPLOYMENT_MANIFEST_HEADE_PK" PRIMARY KEY ("DEPLOYMENT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "RELAUT"."DEPLOYMENT_MANIFEST_HEADER" MODIFY ("DEPLOYMENT_ID" NOT NULL ENABLE);
