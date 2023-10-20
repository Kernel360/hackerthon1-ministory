-- auto-ddl: create 으로 만든 table에 데이터 넣을 때
--  user
INSERT INTO user
VALUES (1, 'seoul', '1999-03-03', 'imgeim@geimimgei',  'shshshshsh.com', 0, 'asd', '0000');
INSERT INTO user
VALUES (2, 'seoul', '1990-03-03', 'hihihih@imgeimgei',  '222shshsh.com', 0, '222', '1111');
INSERT INTO user
VALUES (3, 'seoul', '2000-03-03', 'hihihihi@mgeimgei',  '333shshsh.com', 0, '333', '1111');
INSERT INTO user
VALUES (4, 'seoul', '2003-03-03', 'hihihihim@geimgei',  '444shshsh.com', 0, '444', '1111');

# category
# Hibernate: create table category (category_id bigint not null auto_increment, title varchar(255), user_id bigint, primary key (category_id)) engine=InnoDB
INSERT INTO category
VALUES (1, '수햑', 1);
INSERT INTO category
VALUES (2, '수햑장', 1);
INSERT INTO category
VALUES (3, '수햑최고야', 1);
INSERT INTO category
VALUES (4, '수햑4', 1);
INSERT INTO category
VALUES (5, '수햑5', 1);
INSERT INTO category
VALUES (6, '수햑6', 1);

INSERT INTO category
VALUES (7, '나는 국어', 2);
INSERT INTO category
VALUES (8, '나는 국어2222', 2);
INSERT INTO category
VALUES (9, '나는 국어33333', 2);
INSERT INTO category
VALUES (10, '나는 국어4444', 2);
INSERT INTO category
VALUES (11, '나는 국어55555', 2);
INSERT INTO category
VALUES (12, '나는 국어6666', 2);

INSERT INTO category
VALUES (13, '나는 컴퓨터111',  4);
INSERT INTO category
VALUES (14, '나는 컴퓨터222',  4);
INSERT INTO category
VALUES (15, '나는 컴퓨터333',  4);
INSERT INTO category
VALUES (16, '나는 컴퓨터444',  4);
INSERT INTO category
VALUES (17, '나는 컴퓨터555',  4);
INSERT INTO category
VALUES (18, '나는 컴퓨터666',  4);
INSERT INTO category
VALUES (19, '나는 컴퓨터777',  4);
INSERT INTO category
VALUES (20, '나는 컴퓨터888',  4);



-- create-table로 만든 table에 데이터 넣을 때
-- --  user
-- INSERT INTO user
-- VALUES (1, 'asd', '1999-03-03', 'imgeimgeimimgei',  'shsh@shshsh.com', '0000', 0, 'seoul');
-- INSERT INTO user
-- VALUES (2, '222', '1990-03-03', 'hihihihimgeimgei',  '222@shshsh.com', '1111', 0, 'seoul');
-- INSERT INTO user
-- VALUES (3, '333', '2000-03-03', 'hihihihimgeimgei',  '333@shshsh.com', '1111', 0, 'seoul');
-- INSERT INTO user
-- VALUES (4, '444', '2003-03-03', 'hihihihimgeimgei',  '444@shshsh.com', '1111', 0, 'seoul');
--
-- # category
-- INSERT INTO category
-- VALUES (1, 1, '수햑');
-- INSERT INTO category
-- VALUES (2, 1, '수햑장');
-- INSERT INTO category
-- VALUES (3, 1, '수햑최고야');
-- INSERT INTO category
-- VALUES (4, 1, '수햑4');
-- INSERT INTO category
-- VALUES (5, 1, '수햑5');
-- INSERT INTO category
-- VALUES (6, 1, '수햑6');
--
-- INSERT INTO category
-- VALUES (7, 2, '나는 국어');
-- INSERT INTO category
-- VALUES (8, 2, '나는 국어2222');
-- INSERT INTO category
-- VALUES (9, 2, '나는 국어33333');
-- INSERT INTO category
-- VALUES (10, 2, '나는 국어4444');
-- INSERT INTO category
-- VALUES (11, 2, '나는 국어55555');
-- INSERT INTO category
-- VALUES (12, 2, '나는 국어6666');
--
-- INSERT INTO category
-- VALUES (13, 4, '나는 컴퓨터111');
-- INSERT INTO category
-- VALUES (14, 4, '나는 컴퓨터222');
-- INSERT INTO category
-- VALUES (15, 4, '나는 컴퓨터333');
-- INSERT INTO category
-- VALUES (16, 4, '나는 컴퓨터444');
-- INSERT INTO category
-- VALUES (17, 4, '나는 컴퓨터555');
-- INSERT INTO category
-- VALUES (18, 4, '나는 컴퓨터666');
-- INSERT INTO category
-- VALUES (19, 4, '나는 컴퓨터777');
-- INSERT INTO category
-- VALUES (20, 4, '나는 컴퓨터888');
--
-- # post
-- INSERT INTO post
-- VALUES (1, 2, 1, '나는 수햑장의 첫글', '룰루랄라 집에 가고 싶다', '2023-04-04 00:00:00', '2023-04-10 00:00:00', 10, 0, 0);
-- INSERT INTO post
-- VALUES (2, 19, 4, '나는 유저4의 카테19의 글', '룰루랄라 집에 가고 싶다', '2023-04-04 00:00:00', '2023-04-10 00:00:00', 10, 0, 0);
-- INSERT INTO post
-- VALUES (3, 2, 1, '나는 수햑장의 두번째글', '룰루랄라 집에 가고 싶다', '2023-04-07 00:00:00', '2023-04-10 00:00:00', 10, 0, 0);
-- INSERT INTO post
-- VALUES (4, 12, 2, '나는 국어6의 첫글', '룰루랄라 집에 가고 싶다', '2023-04-04 00:00:00', '2023-04-10 00:00:00', 10, 0, 0);
--
-- # comment
-- INSERT INTO comment
-- VALUES (1, 1, 1, '내글이지만 너무 재미있다.', '2023-04-09 00:00:00', '2023-04-10 00:00:00', 1);
-- INSERT INTO comment
-- VALUES (2, 2, 1, '예예.', '2023-04-09 12:00:00', '2023-04-10 00:00:00', 1);
-- INSERT INTO comment
-- VALUES (3, 4, 4, '너무 재미있어요.', '2023-04-09 00:00:00', '2023-04-10 00:00:00', 3);
-- INSERT INTO comment
-- VALUES (4, 2, 4, '감사합니다..', '2023-04-09 00:00:00', '2023-04-10 00:00:00', 3);
--
