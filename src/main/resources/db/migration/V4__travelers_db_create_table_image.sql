
create table travelers.`image` (
	`id` int not null auto_increment,
    `title` varchar(220),
    `type` varchar(220),
    `source` BLOB(1000),
    `adventure_id` int not null,
    primary key (`id`),
    constraint `fk_adventure_id` foreign key (`adventure_id`) references `adventure` (`id`)
) ENGINE=InnoDB;
