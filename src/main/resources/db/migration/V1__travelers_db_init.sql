-- create if not exists database travelers;

create table travelers.`user` (
	`id` int not null auto_increment,
    `username` varchar(130) not null,
    `email` varchar(130) not null unique,
    `password` varchar(220) not null,
    `first_name` varchar(130) not null,
	`last_name` varchar(130) not null,
	`is_active` bit not null,
    primary key (`id`)
) ENGINE=InnoDB;


create table travelers.`country` (
	`id` int not null auto_increment,
    `name` varchar(220) not null unique,
    `country_code` varchar(10) not null unique,
    primary key (`id`)
) ENGINE=InnoDB;


create table travelers.`city` (
	`id` int not null auto_increment,
    `name` varchar(220) not null,
    `country_id` int not null,
    primary key (`id`),
    constraint `fk_country_id` foreign key (`country_id`) references `country` (`id`)
) ENGINE=InnoDB;


create table travelers.`adventure` (
	`id` int not null auto_increment,
    `name` varchar(220) not null,
	`user_id` int not null,
    `city_id` int not null,
    `time` datetime not null, 
	`tip` varchar(2500),
	`last_updated` datetime not null, 
	`is_deleted` bit not null,
    primary key (`id`),
    constraint `fk_city_id` foreign key (`city_id`) references `city` (`id`),
	constraint `fk_user_id` foreign key (`user_id`) references `user` (`id`)
) ENGINE=InnoDB;

