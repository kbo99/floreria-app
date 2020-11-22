INSERT INTO `floreria_app`.`grupo` (`grp_id`, `grp_nombre`, `grp_desc`, `grp_estatus`) VALUES ('7', 'ROLE_CLIENTES', 'Administracion de Clientes', 'A');

INSERT INTO `floreria_app`.`menus` (`men_id`, `grp_id`, `path`, `title`, `icon`, `type`, `badgeType`, `badgeValue`, `active`, `bookmark`, `orden`, `subMenu`) VALUES (11, 7, '', 'Clientes', 'plus','sub', '', '', '0', '0', 3,  '0');
INSERT INTO `floreria_app`.`menus` (`men_id`, `grp_id`, `path`, `title`, `icon`, `type`, `badgeType`, `badgeValue`, `active`, `bookmark`, `orden`, `subMenu`) VALUES (12, 7, '/clientes/new-persona', 'Nuevo Cliente', '','link', '', '', '0', '0', 1,  '1');
INSERT INTO `floreria_app`.`menus` (`men_id`, `grp_id`, `path`, `title`, `icon`, `type`, `badgeType`, `badgeValue`, `active`, `bookmark`, `orden`, `subMenu`) VALUES (13, 7, '/clientes/busca-cliente', 'Busca Cliente', '','link', '', '', '0', '0', 2,  '1');


INSERT INTO `floreria_app`.`usu_grupo`(`usu_id`,`grp_id`) VALUES(1,7);

INSERT INTO `floreria_app`.`sub_menus`(`sum_id`,`men_id`,`sub_men_id`) VALUES (8, 11,12);
INSERT INTO `floreria_app`.`sub_menus`(`sum_id`,`men_id`,`sub_men_id`) VALUES (9, 11,13);


INSERT INTO `floreria_app`.`region_pais` (`rep_id`, `rep_nombre`, `rep_desc`) VALUES ('1', 'Local', 'Local');
INSERT INTO `floreria_app`.`pais` (`pai_id`, `pai_nombre`, `pai_abre`, `rep_id`) VALUES ('1', 'Mexico', 'MX', '1');
