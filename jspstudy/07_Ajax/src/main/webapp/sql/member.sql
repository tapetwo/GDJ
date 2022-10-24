DROP SEQUENCE MEMBER_SEQ;
CREATE SEQUENCE MEMBER_SEQ NOCACHE;

DROP TABLE MEMBER;
CREATE TABLE MEMBER (
	MEMBER_NO NUMBER NOT NULL,
	ID VARCHAR2(20 BYTE)NOT NULL UNIQUE,
	NAME VARCHAR2(20 BYTE),
	GENDER VARCHAR2(2 BYTE),
	GRADE VARCHAR2(10 BYTE),
	ADDRESS VARCHAR2(100 BYTE),
	CONSTRAINT PK_MEMBER PRIMARY KEY(MEMBER_NO)

);
	
INSERT INTO MEMBER VALUES(MEMBER_SEQ.NEXTVAL,'user1','회원1','F','gold','jeju');
INSERT INTO MEMBER VALUES(MEMBER_SEQ.NEXTVAL,'user2','회원2','M','silver','seoul');
INSERT INTO MEMBER VALUES(MEMBER_SEQ.NEXTVAL,'user3','회원3','F','bronze','yeosu');
COMMIT
