-- 시퀀스
DROP SEQUENCE GESIPAN_SEQ ;
CREATE SEQUENCE GESIPAN_SEQ NOCACHE;

-- 테이블
DROP TABLE GESIPAN;
CREATE TABLE GESIPAN(
    GESIPAN_NO NUMBER NOT NULL, -- 순번
    TITLE    VARCHAR2(100 BYTE) NOT NULL,
    EDITOR    VARCHAR2(100 BYTE) NOT NULL, -- 작성자
    CONTENT  VARCHAR2(400 BYTE), -- 내용
    CREATE_DATE DATE, -- 작성일 
    CONSTRAINT PK_GESIPAN PRIMARY KEY (GESIPAN_NO)
);
COMMIT

