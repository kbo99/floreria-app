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


INSERT INTO `floreria_app`.`tipo_movimiento_prod`
(`tmp_id`,
`tmp_desc`,
`tmp_suma`)
VALUES
(1,
'Ingreso Nuevo Insumo',
'V');

INSERT INTO `floreria_app`.`tipo_movimiento_prod`
(`tmp_id`,
`tmp_desc`,
`tmp_suma`)
VALUES
(2,
'Ingreso Insumo',
'V');

INSERT INTO `floreria_app`.`tipo_movimiento_prod`
(`tmp_id`,
`tmp_desc`,
`tmp_suma`)
VALUES
(3,
'Salida Insumo Check Inventario',
'F');


INSERT INTO `floreria_app`.`tipo_movimiento_prod`
(`tmp_id`,
`tmp_desc`,
`tmp_suma`)
VALUES
(4,
'Ingreso Insumo Check Inventario',
'V');

INSERT INTO `floreria_app`.`tipo_movimiento_prod`
(`tmp_id`,
`tmp_desc`,
`tmp_suma`)
VALUES
(5,
'Salida Insumo Venta',
'F');


INSERT INTO `floreria_app`.`tipo_movimiento_prod`
(`tmp_id`,
`tmp_desc`,
`tmp_suma`)
VALUES
(6,
'Salida Insumo Merma',
'F');

INSERT INTO `floreria_app`.`tipo_movimiento_prod`
(`tmp_id`,
`tmp_desc`,
`tmp_suma`)
VALUES
(7,
'Salida Insumo Transalado',
'F');
