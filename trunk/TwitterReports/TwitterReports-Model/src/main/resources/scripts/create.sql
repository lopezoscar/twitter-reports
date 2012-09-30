
CREATE  TABLE `twitterreports`.`Projects` (

  `proj_id` BIGINT NOT NULL AUTO_INCREMENT ,

  `proj_name` VARCHAR(255) NULL ,

  `proj_add` DATETIME NULL ,

  PRIMARY KEY (`proj_id`) );


  CREATE  TABLE `twitterreports`.`Keywords` (

  `key_id` BIGINT NOT NULL AUTO_INCREMENT ,

  `key_text` VARCHAR(45) NULL ,

  `proj_id` BIGINT NULL ,

  PRIMARY KEY (`key_id`) );

