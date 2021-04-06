CREATE DATABASE chooseme;

USE chooseme;


CREATE TABLE users (
    `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    user_photo LONGBLOB,
    user_photo_google VARCHAR(50),
    `user_name` VARCHAR(50) NOT NULL UNIQUE, 
    email VARCHAR(100) NOT NULL UNIQUE,
    `password` VARCHAR(50) NOT NULL,
    active TINYINT(1) NOT NULL DEFAULT 1,
    `name` VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    points INTEGER NOT NULL DEFAULT 0,
    google_account VARCHAR(100),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'yyyy,mm,dd  hh:mm:ss',
    MODIFIED_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`user_id`)
);

CREATE TABLE reviwers (

    reviewer_id int (10) unsigned NOT NULL AUTO_INCREMENT,
    `user_name` VARCHAR(50) NOT NULL UNIQUE,
    `user_id` int(10) unsigned NOT NULL,
    reviewer TINYINT(1) NOT NULL DEFAULT 1,
    PRIMARY KEY (reviewer_id)

);

CREATE TABLE scores(
    score_id int(10) unsigned NOT NULL AUTO_INCREMENT,
    score int(10) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'yyyy,mm,dd  hh:mm:ss',
    PRIMARY KEY (score_id)
);

CREATE TABLE user_scores (
    user_scores_id int(10) unsigned NOT NULL AUTO_INCREMENT,
    user_id int(10) not null,
    score_id int(10) not null,
   
    PRIMARY KEY (user_scores_id)
);

CREATE TABLE product_scores (
    product_scores_id  int(10) unsigned NOT NULL AUTO_INCREMENT,
    product_id int(10) NOT NULL,
    score_id int(10) NOT NULL,
    PRIMARY KEY (product_scores_id)
);

CREATE TABLE types (
    type_id int(10) unsigned NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(20) NOT NULL DEFAULT 'NONE',
    PRIMARY KEY (type_id)
);

CREATE TABLE product_types(
    product_types_id int(10) unsigned NOT NULL AUTO_INCREMENT,
    product_id int(10) unsigned NOT NULL,
    type_id int(10) unsigned NOT NULL,
    PRIMARY KEY (product_types_id)

);

CREATE TABLE comments (
    comment_id int(10) unsigned NOT NULL AUTO_INCREMENT,
    reviewer_id int(10) unsigned NOT NULL,
    product_id int(10) unsigned NOT NULL,
    comment VARCHAR(400) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'yyyy,mm,dd  hh:mm:ss',
    PRIMARY KEY (comment_id)
);

CREATE TABLE impressions(
    impressions_id int(10) unsigned NOT NULL AUTO_INCREMENT,
    comment_id int(10) unsigned NOT NULL,
    `user_id` int(10) unsigned NOT NULL,
    impression VARCHAR(400) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'yyyy,mm,dd  hh:mm:ss',
    PRIMARY KEY (impressions_id)
);


CREATE TABLE products (
    product_id int(10) unsigned NOT NULL AUTO_INCREMENT,
    reviewer_id int(10) unsigned NOT NULL,
    photo LONGBLOB,
    brand VARCHAR(50) NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    price DOUBLE(9,2),
    active TINYINT(1) NOT NULL DEFAULT 1,
    verified TINYINT(1) NOT NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'yyyy,mm,dd  hh:mm:ss',
    PRIMARY KEY (product_id)
);
