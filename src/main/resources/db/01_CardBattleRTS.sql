CREATE TABLE `User` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(16) NOT NULL UNIQUE,
	`password` varchar(16) NOT NULL,
	`token` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Account` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`user_id` INT NOT NULL,
	`room_id` INT,
	`start_game_time` DATETIME,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Room` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`description` varchar(128) NOT NULL,

	PRIMARY KEY (`id`)
);

CREATE TABLE `Account_Building` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`account_id` INT NOT NULL,
	`building_id` INT NOT NULL,
	`number` FLOAT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Account_Resource` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`account_id` INT NOT NULL,
	`resource_id` INT NOT NULL,
	`number` FLOAT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Account_Upgrade` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`account_id` INT NOT NULL,
	`upgrade_id` INT NOT NULL,
	`number` FLOAT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Account_Achievement` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`account_id` INT NOT NULL,
	`achievement_id` INT NOT NULL,
	`number` FLOAT NOT NULL default 0,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Message` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`text` varchar(128) NOT NULL,
	`from_account_id` INT NOT NULL,
	`to_account_id` INT NOT NULL,
	`time` DATETIME NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Notification` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`description` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Building` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`description` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Resource` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`description` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Upgrade` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`description` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Achievement` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`description` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Card` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`description` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Card_Group` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`description` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Card_Impact` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`card_id` INT NOT NULL,
	`card_group_id` INT NOT NULL,
	`p1_building_id` INT,
	`p2_building_id` INT,
	`p1_building_number` FLOAT,
	`p2_building_number` FLOAT,
	`p1_resource_id` INT,
	`p2_resource_id` INT,
	`p1_resource_number` FLOAT,
	`p2_resource_number` FLOAT,
	`p1_upgrade_id` INT,
	`p2_upgrade_id` INT,
	`p1_upgrade_number` FLOAT,
	`p2_upgrade_number` FLOAT,
	`necessary_building_id` INT,
	`necessary_upgrade_id` INT,
	`necessary_building_number` FLOAT,
	`necessary_upgrade_number` FLOAT,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Trigger_Notification` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`notification_id` INT NOT NULL,
	`building_id` INT,
	`resource_id` INT,
	`upgrade_id` INT,
	`building_number` FLOAT,
	`resource_number` FLOAT,
	`upgrade_number` FLOAT,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Upgrade_Building` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`upgrade_id` INT NOT NULL,
	`building_id` INT,
	`percent` FLOAT,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Building_Resource` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`building_id` INT NOT NULL,
	`resource_id` INT NOT NULL,
	`number_per_sec` FLOAT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Trigger_Achievement` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`achievement_id` INT NOT NULL,
	`building_id` INT,
	`resource_id` INT,
	`upgrade_id` INT,
	`building_number` INT,
	`resource_number` INT,
	`upgrade_number` INT,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Account_Notification` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`account_id` INT NOT NULL,
	`notification_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);