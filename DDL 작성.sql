#DDL 작성
#CREATE DATABASE TimeTable_Maker_db;
USE TimeTable_Maker_db;

DROP TABLE IF EXISTS timetable_class;
DROP TABLE IF EXISTS user_slot_candidates;
DROP TABLE IF EXISTS user_selection_slot;
DROP TABLE IF EXISTS user_option;
DROP TABLE IF EXISTS timetable;
DROP TABLE IF EXISTS subject_class;
DROP TABLE IF EXISTS `subject`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS dept;

CREATE TABLE dept(
	dept_cd VARCHAR(255) NOT NULL PRIMARY KEY,
	dept_name VARCHAR(255) NOT NULL,
	campus_cd VARCHAR(255) NOT NULL, 
	CHECK(campus_cd IN('서울', '안성'))
);
	 

CREATE TABLE `subject`(
	subject_cd VARCHAR(255) NOT NULL PRIMARY KEY,
	subject_name VARCHAR(255) NOT NULL,
	dept_cd VARCHAR(255) NOT NULL,
	credit INT NOT NULL,
	FOREIGN KEY (dept_cd) REFERENCES dept(dept_cd)
);

CREATE TABLE subject_class(
	class_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	subject_cd VARCHAR(255) NOT NULL,
	section_no VARCHAR(255) NOT NULL,
	prof_name VARCHAR(255),
	lang_type VARCHAR(255) NOT NULL, 
	CHECK(lang_type IN('한국어', '영어')),
	class_type VARCHAR(255) NOT NULL, 
	CHECK(class_type IN('대면', '비대면', '혼합')),
	day_of_week VARCHAR(255) NOT NULL,
	start_time TIME NOT NULL,
	end_time TIME NOT NULL,
	room VARCHAR(255),
	FOREIGN KEY (subject_cd) REFERENCES `subject`(subject_cd)
);

CREATE TABLE `user`(
	user_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	email VARCHAR(255) NOT NULL,
	`password` VARCHAR(255) NOT NULL,
	`name` VARCHAR(255) NOT NULL
);

CREATE TABLE user_option(
	user_option_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	user_id BIGINT NOT NULL,
	avoid_days VARCHAR(255),
	max_gap_time INT,
	preferred_days_off VARCHAR(255),
	avoid_time_start TIME,
	avoid_time_end TIME,
	prefer_online TINYINT(1),
	FOREIGN KEY (user_id) REFERENCES `user`(user_id)
);

CREATE TABLE user_selection_slot(
	slot_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	user_id BIGINT NOT NULL,
	slot_no INT NOT NULL,
	FOREIGN KEY (user_id) REFERENCES `user`(user_id)
);

CREATE TABLE user_slot_candidates(
	candidate_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	slot_id BIGINT NOT NULL,
	class_id BIGINT NOT NULL,
	FOREIGN KEY (slot_id) REFERENCES user_selection_slot(slot_id),
	FOREIGN KEY (class_id) REFERENCES subject_class(class_id)
);

CREATE TABLE timetable(
	timetable_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	user_id BIGINT NOT NULL,
	timetable_name VARCHAR(255) NOT NULL,
	created_at DATETIME NOT NULL,
	FOREIGN KEY (user_id) REFERENCES `user`(user_id)
);

CREATE TABLE timetable_class(
	timetable_class_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	timetable_id BIGINT NOT NULL,
	class_id BIGINT NOT NULL,
	FOREIGN KEY (timetable_id) REFERENCES timetable(timetable_id),
	FOREIGN KEY (class_id) REFERENCES subject_class(class_id)
);

