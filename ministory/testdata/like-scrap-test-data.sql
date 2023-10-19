DROP DATABASE mini_story;

CREATE DATABASE mini_story;

USE mini_story;


CREATE TABLE `user` (
                        `user_id`	BIGINT(32)	NOT NULL,
                        `nickname`	VARCHAR(10)	NOT NULL,
                        `birthday`	TIMESTAMP(6)	NULL,
                        `image_path`	TEXT(200)	NULL,
                        `email`	VARCHAR(100)	NOT NULL,
                        `password`	VARCHAR(40)	NOT NULL,
                        `is_social`	TINYINT(2)	NOT NULL,
                        `address`	VARCHAR(20)	NOT NULL
);

CREATE TABLE `category` (
                            `category_id`	BIGINT(32)	NOT NULL,
                            `user_id`	BIGINT(32)	NOT NULL,
                            `title`	VARCHAR(40)	NOT NULL
);

CREATE TABLE `post` (
                        `post_id`	BIGINT(32)	NOT NULL,
                        `category_id`	BIGINT(32)	NOT NULL,
                        `user_id`	BIGINT(32)	NOT NULL,
                        `title`	VARCHAR(40)	NOT NULL,
                        `html_content`	TEXT(1000)	NULL,
                        `markdown_content`	TEXT(1000)	NULL,
                        `created_at`	TIMESTAMP(6)	NOT NULL,
                        `modified_at`	TIMESTAMP(6)	NULL,
                        `view_count`	BIGINT(32)	NOT NULL,
                        `like_count`	BIGINT(32)	NOT NULL,
                        `scrap_count`	BIGINT(32)	NOT NULL
);

CREATE TABLE `comment` (
                           `comment_id`	BIGINT(32)	NOT NULL,
                           `user_id`	BIGINT(32)	NOT NULL,
                           `post_id`	BIGINT(32)	NOT NULL,
                           `content`	TEXT(200)	NOT NULL,
                           `created_at`	TIMESTAMP(6)	NOT NULL,
                           `modified_at`	TIMESTAMP(6)	NULL,
                           `parent_id`	BIGINT(32)	NOT NULL
);

CREATE TABLE `likes` (
                         `like_id`	BIGINT(32)	NOT NULL,
                         `user_id`	BIGINT(32)	NOT NULL,
                         `post_id`	BIGINT(32)	NOT NULL
);

CREATE TABLE `scrap` (
                         `scrap_id`	BIGINT(32)	NOT NULL,
                         `user_id`	BIGINT(32)	NOT NULL,
                         `post_id`	BIGINT(32)	NOT NULL
);

CREATE TABLE `notify` (
                          `notify_id`	BIGINT(32)	NOT NULL,
                          `user_id`	BIGINT(32)	NOT NULL,
                          `parent_id`	BIGINT(32)	NULL,
                          `notify_type`	VARCHAR(20)	NULL,
                          `notify_title`	VARCHAR(20)	NOT NULL,
                          `notify_content`	TEXT(200)	NULL,
                          `created_at`	TIMESTAMP(6)	NULL,
                          `notify_url`	VARCHAR(40)	NOT NULL,
                          `is_checked`	TINYINT(2)	NOT NULL,
                          `checked_at`	TIMESTAMP(6)	NULL
);

ALTER TABLE `user` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
                                                         `user_id`
    );

ALTER TABLE `category` ADD CONSTRAINT `PK_CATEGORY` PRIMARY KEY (
                                                                 `category_id`
    );

ALTER TABLE `post` ADD CONSTRAINT `PK_POST` PRIMARY KEY (
                                                         `post_id`
    );

ALTER TABLE `comment` ADD CONSTRAINT `PK_COMMENT` PRIMARY KEY (
                                                               `comment_id`
    );

ALTER TABLE `likes` ADD CONSTRAINT `PK_LIKES` PRIMARY KEY (
                                                           `like_id`
    );

ALTER TABLE `scrap` ADD CONSTRAINT `PK_SCRAP` PRIMARY KEY (
                                                           `scrap_id`
    );

ALTER TABLE `notify` ADD CONSTRAINT `PK_NOTIFY` PRIMARY KEY (
                                                             `notify_id`
    );



INSERT INTO user
VALUES (1, '유저1닉네임', '1999-03-03', 'imgeimgeimimgei',  'shsh@shshsh.com', '0000', 1, 'seoul');
INSERT INTO user
VALUES (2, '유저2닉네임', '1990-03-03', 'hihihihimgeimgei',  '222@shshsh.com', '1111', 1, 'seoul');
INSERT INTO user
VALUES (3, '유저3닉네임', '2000-03-03', 'hihihihimgeimgei',  '333@shshsh.com', '1111', 0, 'seoul');
INSERT INTO user
VALUES (4, '유저4닉네임', '2003-03-03', 'hihihihimgeimgei',  '444@shshsh.com', '1111', 0, 'seoul');

# category
INSERT INTO category
VALUES (1, 1, '수햑');
INSERT INTO category
VALUES (2, 1, '수햑장');
INSERT INTO category
VALUES (3, 1, '수햑최고야');
INSERT INTO category
VALUES (4, 1, '수햑4');
INSERT INTO category
VALUES (5, 1, '수햑5');
INSERT INTO category
VALUES (6, 1, '수햑6');

INSERT INTO category
VALUES (7, 2, '나는 국어');
INSERT INTO category
VALUES (8, 2, '나는 국어2222');
INSERT INTO category
VALUES (9, 2, '나는 국어33333');
INSERT INTO category
VALUES (10, 2, '나는 국어4444');
INSERT INTO category
VALUES (11, 2, '나는 국어55555');
INSERT INTO category
VALUES (12, 2, '나는 국어6666');

INSERT INTO category
VALUES (13, 4, '나는 컴퓨터111');
INSERT INTO category
VALUES (14, 4, '나는 컴퓨터222');
INSERT INTO category
VALUES (15, 4, '나는 컴퓨터333');
INSERT INTO category
VALUES (16, 4, '나는 컴퓨터444');
INSERT INTO category
VALUES (17, 4, '나는 컴퓨터555');
INSERT INTO category
VALUES (18, 4, '나는 컴퓨터666');
INSERT INTO category
VALUES (19, 4, '나는 컴퓨터777');
INSERT INTO category
VALUES (20, 4, '나는 컴퓨터888');

# post
INSERT INTO post
VALUES (1, 2, 1, '나는 수햑장의 첫글', '룰루랄라 집에 가고 싶다', '룰', '2023-04-04 00:00:00', '2023-04-10 00:00:00', 10, 111, 11);
INSERT INTO post
VALUES (2, 19, 4, '나는 유저4의 카테19의 글', '룰루랄라 집에 가고 싶다', '루', '2023-04-04 00:00:00', '2023-04-10 00:00:00', 10, 222, 22);
INSERT INTO post
VALUES (3, 2, 1, '나는 수햑장의 두번째글', '룰루랄라 집에 가고 싶다', '랄', '2023-04-07 00:00:00', '2023-04-10 00:00:00', 10, 33, 333);
INSERT INTO post
VALUES (4, 12, 2, '나는 국어6의 첫 번째 글', '룰루랄라 집에 가고 싶다', '라', '2023-04-04 00:00:00', '2023-04-10 00:00:00', 10, 11, 101);
INSERT INTO post
VALUES (5, 13, 2, '나는 국어6의 두 번째 글', '으랏차차 집에 가고 싶다', '으', '2023-04-05 00:00:00', '2023-04-11 00:00:00', 20, 22, 202);
INSERT INTO post
VALUES (6, 12, 2, '나는 국어6의 세 번째 글', '으랏차라 집에 가고 싶다', '랏', '2023-04-06 00:00:00', '2023-04-12 00:00:00', 30, 33, 303);

# comment
INSERT INTO comment
VALUES (1, 1, 1, '내글이지만 너무 재미있다.', '2023-04-09 00:00:00', '2023-04-10 00:00:00', 1);
INSERT INTO comment
VALUES (2, 2, 1, '예예.', '2023-04-09 12:00:00', '2023-04-10 00:00:00', 1);
INSERT INTO comment
VALUES (3, 4, 4, '너무 재미있어요.', '2023-04-09 00:00:00', '2023-04-10 00:00:00', 3);
INSERT INTO comment
VALUES (4, 2, 4, '감사합니다..', '2023-04-09 00:00:00', '2023-04-10 00:00:00', 3);

INSERT INTO likes
VALUES (11, 1, 1);
INSERT INTO likes
VALUES (22, 2, 2);
INSERT INTO likes
VALUES (33, 3, 3);
INSERT INTO likes
VALUES (44, 4, 4);
INSERT INTO likes
VALUES (55, 2, 4);
INSERT INTO likes
VALUES (66, 1, 4);

INSERT INTO scrap
VALUES (111, 1, 1);
INSERT INTO scrap
VALUES (222, 2, 2);
INSERT INTO scrap
VALUES (333, 3, 3);
INSERT INTO scrap
VALUES (444, 4, 4);
INSERT INTO scrap
VALUES (555, 2, 3);
INSERT INTO scrap
VALUES (666, 2, 4);
INSERT INTO scrap
VALUES (777, 1, 3);
INSERT INTO scrap
VALUES (888, 1, 4);