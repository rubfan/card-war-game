INSERT INTO `Card_Impact`
    (`id`, `card_id`, `card_group_id`,
    `p1_building_id`, `p2_building_id`,
    `p1_building_number`, `p2_building_number`,
    `p1_resource_id`, `p2_resource_id`,
    `p1_resource_number`, `p2_resource_number`,
    `p1_upgrade_id`, `p2_upgrade_id`,
    `p1_upgrade_number`, `p2_upgrade_number`,
    `necessary_building_id`, `necessary_upgrade_id`,
    `necessary_building_number`, `necessary_upgrade_number`)
VALUES
    (1,1,1,1,NULL,2,NULL ,1,NULL ,100,NULL ,NULL ,NULL ,NULL ,NULL ,NULL ,NULL ,NULL ,NULL ),
    (2,1,1,2,NULL,3,NULL ,2,NULL ,10,NULL ,NULL ,NULL ,NULL ,NULL ,NULL ,NULL ,NULL ,NULL ),
    (3,2,1,1,NULL,1,NULL ,5,NULL ,20,NULL ,NULL ,NULL ,NULL ,NULL ,NULL ,NULL ,NULL ,NULL );