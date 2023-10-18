DROP DATABASE mini_story;

CREATE DATABASE mini_story;

USE mini_story;


CREATE TABLE `user`
(
    `user_id`    BIGINT(32)   NOT NULL auto_increment,
    `nickname`   VARCHAR(10)  NOT NULL,
    `birthday`   TIMESTAMP(6) NULL,
    `image_path` TEXT(200)    NULL,
    `email`      VARCHAR(100) NOT NULL,
    `password`   VARCHAR(40)  NOT NULL,
    `is_social`  TINYINT(2)   NOT NULL,
    `address`    VARCHAR(20)  NOT NULL
);

CREATE TABLE `category`
(
    `category_id` BIGINT(32)  NOT NULL,
    `user_id`     BIGINT(32)  NOT NULL,
    `title`       VARCHAR(40) NOT NULL
);

CREATE TABLE `post`
(
    `post_id`     BIGINT(32)   NOT NULL,
    `category_id` BIGINT(32)   NOT NULL,
    `user_id`     BIGINT(32)   NOT NULL,
    `title`       VARCHAR(40)  NOT NULL,
    `content`     TEXT(1000)   NULL,
    `created_at`  TIMESTAMP(6) NOT NULL,
    `modified_at` TIMESTAMP(6) NULL,
    `view_count`  BIGINT(32)   NOT NULL,
    `like_count`  BIGINT(32)   NOT NULL,
    `scrap_count` BIGINT(32)   NOT NULL
);

CREATE TABLE `comment`
(
    `comment_id`  BIGINT(32)   NOT NULL,
    `user_id`     BIGINT(32)   NOT NULL,
    `post_id`     BIGINT(32)   NOT NULL,
    `content`     TEXT(200)    NOT NULL,
    `created_at`  TIMESTAMP(6) NOT NULL,
    `modified_at` TIMESTAMP(6) NULL,
    `parent_id`   BIGINT(32)   NOT NULL
);

CREATE TABLE `likes`
(
    `like_id` BIGINT(32) NOT NULL,
    `user_id` BIGINT(32) NOT NULL,
    `post_id` BIGINT(32) NOT NULL
);

CREATE TABLE `scrap`
(
    `scrap_id` BIGINT(32) NOT NULL,
    `user_id`  BIGINT(32) NOT NULL,
    `post_id`  BIGINT(32) NOT NULL
);

CREATE TABLE `notify`
(
    `notify_id`      BIGINT(32)   NOT NULL,
    `user_id`        BIGINT(32)   NOT NULL,
    `parent_id`      BIGINT(32)   NULL,
    `notify_type`    VARCHAR(20)  NULL,
    `notify_title`   VARCHAR(20)  NOT NULL,
    `notify_content` TEXT(200)    NULL,
    `created_at`     TIMESTAMP(6) NULL,
    `notify_url`     VARCHAR(40)  NOT NULL,
    `is_checked`     TINYINT(2)   NOT NULL,
    `checked_at`     TIMESTAMP(6) NULL
);

ALTER TABLE `user`
    ADD CONSTRAINT `PK_USER` PRIMARY KEY (
                                          `user_id`
        );

ALTER TABLE `category`
    ADD CONSTRAINT `PK_CATEGORY` PRIMARY KEY (
                                              `category_id`
        );

ALTER TABLE `post`
    ADD CONSTRAINT `PK_POST` PRIMARY KEY (
                                          `post_id`
        );

ALTER TABLE `comment`
    ADD CONSTRAINT `PK_COMMENT` PRIMARY KEY (
                                             `comment_id`
        );

ALTER TABLE `likes`
    ADD CONSTRAINT `PK_LIKES` PRIMARY KEY (
                                           `like_id`
        );

ALTER TABLE `scrap`
    ADD CONSTRAINT `PK_SCRAP` PRIMARY KEY (
                                           `scrap_id`
        );

ALTER TABLE `notify`
    ADD CONSTRAINT `PK_NOTIFY` PRIMARY KEY (
                                            `notify_id`
        );

