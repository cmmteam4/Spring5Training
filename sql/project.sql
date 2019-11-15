SELECT `employee`.`emp_id`,
    `employee`.`age`,
    `employee`.`created_date`,
    `employee`.`date_of_birth`,
    `employee`.`def_flg`,
    `employee`.`employee_id`,
    `employee`.`employee_name`,
    `employee`.`gender`,
    `employee`.`note`,
    `employee`.`password`,
    `employee`.`updated_date`
FROM `employee_spring`.`employee` where `employee`.`age` LIKE 25 OR `employee`.`employee_name` LIKE "%cho%" OR  `employee`.`date_of_birth` LIKE  "%1980%";
