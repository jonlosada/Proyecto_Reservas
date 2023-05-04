


--//////////////////////TRIGGER UPDATE USUARIO///////////////////////--

DELIMITER $$
CREATE TRIGGER usuario_alterado
before update 
on usuario for each ROW
begin
insert into antiguos_datos_alterados values(old.dni,old.nombre,old.apellido1,old.apellido2,old.telefono,old.email,SYSDATE())
end;

--////////////////////TRIGGER DELETE RESERVA////////////////////////--

DELIMITER $$
create TRIGGER reserva_eliminada
before delete 
on reserva for each ROW
begin
insert into antiguos_datos_eliminados values(old.cod_re,old.fech_ida,old.fech_vuelta,old.dni_usuario,old.cod_al,old.cod_tra,sysdate())
end;

--////////PROCEDIMIENTO//////////--

DELIMITER$$
drop PROCEDURE if EXISTS usuario_reserva$$
create PROCEDURE usuario_reserva()
BEGIN
select u.*,r.cod_r,r.fech_ida,r.fech_vuelta from usuario u,reserva r
where u.dni=r.dni_usuario  
end$$