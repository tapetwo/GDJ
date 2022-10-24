-- 시퀀스
DROP SEQUENCE BOARD_SEQ ;
CREATE SEQUENCE BOARD_SEQ NOCACHE;

-- 테이블
DROP TABLE BOARD;
CREATE TABLE BOARD(
    BOARD_NO NUMBER NOT NULL,
    TITLE    VARCHAR2(100 BYTE) NOT NULL,
    CONTENT  VARCHAR2(400 BYTE),
    CREATE_DATE DATE,
    CONSTRAINT PK_BOARD PRIMARY KEY (BOARD_NO)
);

-- 행
INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, '공지', '불났다',SYSDATE);
INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, '긴급공지', '다 날아갔다',SYSDATE);
COMMIT;
