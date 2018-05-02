use pdc
go

/*
drop table dbo.sugerencias
drop table dbo.temas_servicios
*/

/* -------------------------------------------
   Tabla: temas_servicios
   ------------------------------------------- */
create table dbo.temas_servicios
(
 cod_tipo_servicio		varchar(3)		not null,
 nro_tema				tinyint			not null,
 tema					varchar(255)	not null,
 constraint PK__temas_servicios__END 
			primary key(cod_tipo_servicio, nro_tema)
)
go

insert into dbo.temas_servicios(cod_tipo_servicio, nro_tema, tema) 
values('NP', 1, 'Inscripción / Cursación'),
      ('NP', 2, 'Exámenes finales'),
      ('NP', 3, 'Documentación'),
      ('NP', 4, 'Materiales de Estudio'),
      ('NP', 5, 'Servicios Tecnológicos'),
      ('NP', 6,'Administración'),
      ('NP', 7,'Clases Presenciales'),
      ('NP', 8,'Clases en vivo'),
      ('NP', 9,'Tutorías'),
      ('NP', 10,'Tutores Guías'),
      ('NP', 11,'Centro de Educación a Distancia'),
      ('NP', 12,'Pasantías'),
      ('NP', 13,'Graduados'),
      ('NP', 14,'Envíos'),
      ('NP', 15,'Otros'),
      ('PR', 1,'Inscripción / Cursación'),
      ('PR', 2,'Exámenes finales'),
      ('PR', 3,'Documentación'),
      ('PR', 4,'Administración'),
      ('PR', 5,'Materiales de Estudio'),
      ('PR', 6,'Docentes'),
      ('PR', 7,'Laboratorios'),
      ('PR', 8,'Bedelía'),
      ('PR', 9,'Pasantías'),
      ('PR', 10,'Graduados'),
      ('PR', 11,'Comunicación Interna'),
      ('PR', 12,'Biblioteca'),
      ('PR', 13,'Otros'),
      ('ISG', 1,'Cantina'),
      ('ISG', 2,'Fotocopiadora'),
      ('ISG', 3,'Limpieza'),
      ('ISG', 4,'Iluminación'),
      ('ISG', 5,'Seguridad'),
      ('ISG', 6,'e-mail'),
      ('ISG', 7,'Infraestructura Edilicia'),
      ('ISG', 8,'MiUBP'),
      ('ISG', 9,'Infraestructura Tecnológica'),
      ('ISG', 10,'Otros'),
      ('OT', 1,'Relaciones Internacionales'),
      ('OT', 2,'Actividades Deportivas'),
      ('OT', 3,'Actividades de Arte y Cultura'),
      ('OT', 4,'Otros')
go

/* -------------------------------------------
   Tabla: sugerencias
   ------------------------------------------- */
create table dbo.sugerencias
(
 nro_sugerencia			integer			not null
						constraint PK__sugerencias__END primary key,	
 cod_tipo_servicio		varchar(3)		not null,
 nro_tema				tinyint			not null,
 e_mail					varchar(255)	null,
 sugerencia				varchar(max)	not null,
 constraint FK__sugerencias__temas_servicios__END
			foreign key(cod_tipo_servicio, nro_tema) references dbo.temas_servicios
)
go

/* -------------------------------------------
   Consulta de temas de un servicio
   ------------------------------------------- */
declare @cod_tipo_servicio varchar(3)	= 'NP'

select tema,
       cod_tipo_servicio,
	   nro_tema
  from dbo.temas_servicios (nolock)
 where cod_tipo_servicio = @cod_tipo_servicio
 order by tema
go

/* -------------------------------------------
   Procedure: ins_sugerencia
   ------------------------------------------- */
create procedure dbo.ins_sugerencia
(
 @cod_tipo_servicio		varchar(3),
 @nro_tema				tinyint,
 @e_mail				varchar(255)	= null,
 @sugerencia			varchar(max)
)
as
begin

  declare @nro_sugerencia integer

  select @nro_sugerencia = isnull(max(nro_sugerencia), 0) + 1
    from dbo.sugerencias (tablockx)

  insert into dbo.sugerencias(nro_sugerencia, cod_tipo_servicio, nro_tema, e_mail, sugerencia)
  values(@nro_sugerencia, @cod_tipo_servicio, @nro_tema, @e_mail, @sugerencia)
  
 end
 go 
 
