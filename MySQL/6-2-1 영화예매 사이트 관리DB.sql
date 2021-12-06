/*	영화티켓 예매 사이트를 구축하기 위한 ERD 설계
CGV, 롯데시네마 참고 
*/
CREATE database cgv;
use cgv;
DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
	`mo_num`	int	NOT NULL,
	`mo_title`	varchar(50)	NULL,
	`mo_age`	varchar(50)	NULL,
	`mo_runtime`	int	NULL,
	`mo_date`	date	NULL,
	`mo_detail`	longtext	NULL
);

DROP TABLE IF EXISTS `movie_genre`;

CREATE TABLE `movie_genre` (
	`mg_num`	int	NOT NULL,
	`mg_mo_num`	int	NOT NULL,
	`mg_ge_name`	varchar(50)	NOT NULL
);

DROP TABLE IF EXISTS `genre`;

CREATE TABLE `genre` (
	`ge_name`	varchar(50)	NOT NULL
);

DROP TABLE IF EXISTS `character`;

CREATE TABLE `character` (
	`ch_num`	int	NOT NULL,
	`ch_name`	varchar(50)	NULL,
	`ch_birthday`	varchar(10)	NULL,
	`ch_nationality`	varchar(50)	NULL,
	`ch_job`	varchar(50)	NULL
);

DROP TABLE IF EXISTS `participation`;

CREATE TABLE `participation` (
	`pt_num`	int	NOT NULL,
	`pt_ch_num`	int	NOT NULL,
	`pt_mo_num`	int	NOT NULL,
	`pt_role`	varchar(50)	NULL
);

DROP TABLE IF EXISTS `theater`;

CREATE TABLE `theater` (
	`th_num`	int	NOT NULL,
	`th_area`	varchar(50)	NULL,
	`th_name`	varchar(50)	NULL,
	`th_address`	varchar(50)	NULL,
	`th_traffic`	longtext	NULL,
	`th_parking`	longtext	NULL,
	`th_room_count`	int	NULL,
	`th_seat_count`	int	NULL
);

DROP TABLE IF EXISTS `seat`;

CREATE TABLE `seat` (
	`st_num`	int	NOT NULL,
	`st_name`	char(3)	NULL,
	`st_th_num`	int	NOT NULL,
	`st_room_num`	int	NULL,
	`st_state`	varchar(50)	NULL,
	`st_type`	varchar(50)	NULL
);

DROP TABLE IF EXISTS `schedule`;

CREATE TABLE `schedule` (
	`sc_num`	int	NOT NULL,
	`sc_mo_num`	int	NOT NULL,
	`sc_th_num`	int	NOT NULL,
	`sc_date`	date	NULL,
	`sc_time`	varchar(5)	NULL,
	`sc_room_num`	int	NULL,
	`sc_option`	varchar(10)	NULL,
	`sc_total_seat`	int	NULL,
	`sc_seat`	int	NULL
);

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(50)	NOT NULL,
	`me_pw`	varchar(255)	NULL
);

DROP TABLE IF EXISTS `ticketing`;

CREATE TABLE `ticketing` (
	`tk_num`	varchar(10)	NOT NULL,
	`tk_me_id`	varchar(50)	NOT NULL,
	`tk_sc_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `ticketing_list`;

CREATE TABLE `ticketing_list` (
	`tl_num`	int	NOT NULL,
	`tl_tk_num`	varchar(10)	NOT NULL,
	`tl_st_num`	int	NOT NULL
);

ALTER TABLE `movie` ADD CONSTRAINT `PK_MOVIE` PRIMARY KEY (
	`mo_num`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `PK_MOVIE_GENRE` PRIMARY KEY (
	`mg_num`
);

ALTER TABLE `genre` ADD CONSTRAINT `PK_GENRE` PRIMARY KEY (
	`ge_name`
);

ALTER TABLE `character` ADD CONSTRAINT `PK_CHARACTER` PRIMARY KEY (
	`ch_num`
);

ALTER TABLE `participation` ADD CONSTRAINT `PK_PARTICIPATION` PRIMARY KEY (
	`pt_num`
);

ALTER TABLE `theater` ADD CONSTRAINT `PK_THEATER` PRIMARY KEY (
	`th_num`
);

ALTER TABLE `seat` ADD CONSTRAINT `PK_SEAT` PRIMARY KEY (
	`st_num`
);

ALTER TABLE `schedule` ADD CONSTRAINT `PK_SCHEDULE` PRIMARY KEY (
	`sc_num`
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_id`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `PK_TICKETING` PRIMARY KEY (
	`tk_num`
);

ALTER TABLE `ticketing_list` ADD CONSTRAINT `PK_TICKETING_LIST` PRIMARY KEY (
	`tl_num`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `FK_movie_TO_movie_genre_1` FOREIGN KEY (
	`mg_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `FK_genre_TO_movie_genre_1` FOREIGN KEY (
	`mg_ge_name`
)
REFERENCES `genre` (
	`ge_name`
);

ALTER TABLE `participation` ADD CONSTRAINT `FK_character_TO_participation_1` FOREIGN KEY (
	`pt_ch_num`
)
REFERENCES `character` (
	`ch_num`
);

ALTER TABLE `participation` ADD CONSTRAINT `FK_movie_TO_participation_1` FOREIGN KEY (
	`pt_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `seat` ADD CONSTRAINT `FK_theater_TO_seat_1` FOREIGN KEY (
	`st_th_num`
)
REFERENCES `theater` (
	`th_num`
);

ALTER TABLE `schedule` ADD CONSTRAINT `FK_movie_TO_schedule_1` FOREIGN KEY (
	`sc_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `schedule` ADD CONSTRAINT `FK_theater_TO_schedule_1` FOREIGN KEY (
	`sc_th_num`
)
REFERENCES `theater` (
	`th_num`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `FK_member_TO_ticketing_1` FOREIGN KEY (
	`tk_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `FK_schedule_TO_ticketing_1` FOREIGN KEY (
	`tk_sc_num`
)
REFERENCES `schedule` (
	`sc_num`
);

ALTER TABLE `ticketing_list` ADD CONSTRAINT `FK_ticketing_TO_ticketing_list_1` FOREIGN KEY (
	`tl_tk_num`
)
REFERENCES `ticketing` (
	`tk_num`
);

ALTER TABLE `ticketing_list` ADD CONSTRAINT `FK_seat_TO_ticketing_list_1` FOREIGN KEY (
	`tl_st_num`
)
REFERENCES `seat` (
	`st_num`
);

