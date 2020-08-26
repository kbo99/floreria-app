INSERT INTO `floreria_app`.`persona` (`per_id`, `per_nombre`, `per_ape_mat`, `per_ape_pate`, `per_email`, `per_falta`, `per_telefono`, `per_rfc`) 
VALUES ('1', 'Giovanni', 'Mendoza','de Jesus',  'gdejesus@patito.com', '2020-03-25', '5560704757','JEMG850325S38');
INSERT INTO `floreria_app`.`usuario` (`usu_id`, `usu_usuario`, `usu_password`, `usu_estatus`, `per_id`) 
VALUES ('1', 'gdejesus', '$2a$10$hrZ1YZDX2rkXAUtCJzcFmurV7UBUM5JCyIyzulbtIsqK5ZgmIb3F2', 'AC', '1');


INSERT INTO `floreria_app`.`grupo` (`grp_id`, `grp_nombre`, `grp_desc`, `grp_estatus`) VALUES ('1', 'ROLE_ADMIN', 'Administrador', 'A');
INSERT INTO `floreria_app`.`grupo` (`grp_id`, `grp_nombre`, `grp_desc`, `grp_estatus`) VALUES ('2', 'ROLE_USUARIO', 'Usuario', 'A');
INSERT INTO `floreria_app`.`grupo` (`grp_id`, `grp_nombre`, `grp_desc`, `grp_estatus`) VALUES ('3', 'ROLE_CLIENTE', 'Cliente', 'A');

INSERT INTO `floreria_app`.`usu_grupo`(`usu_id`,`grp_id`) VALUES(1,1);
INSERT INTO `floreria_app`.`usu_grupo`(`usu_id`,`grp_id`) VALUES(1,2);
INSERT INTO `floreria_app`.`usu_grupo`(`usu_id`,`grp_id`) VALUES(1,3);