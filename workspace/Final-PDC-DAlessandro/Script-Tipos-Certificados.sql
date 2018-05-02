use pdc
go

-- drop table dbo.tipos_certificados

/* -------------------------------------------------
   Tabla: tipos_certificados
   ------------------------------------------------- */
create table dbo.tipos_certificados
(
 cod_grupo				varchar(3)		not null,
 nro_tipo_certificado	tinyint			not null,
 desc_tipo_certificado	varchar(255)	not null,
 constraint PK__tipos_certificados__END
			primary key(cod_grupo, nro_tipo_certificado)
)
go

insert into dbo.tipos_certificados(cod_grupo, nro_tipo_certificado, desc_tipo_certificado) 
values('ALU', 1, 'Certificado de alumno regular con horario de clases')
insert into dbo.tipos_certificados(cod_grupo, nro_tipo_certificado, desc_tipo_certificado) 
values('ALU', 2, 'Certificado de entrega de actividades parciales obligatorias')
insert into dbo.tipos_certificados(cod_grupo, nro_tipo_certificado, desc_tipo_certificado) 
values('ALU', 3, 'Certificado de horarios de clases')
insert into dbo.tipos_certificados(cod_grupo, nro_tipo_certificado, desc_tipo_certificado) 
values('ALU', 4, 'Certificado de ingresante matriculado')
insert into dbo.tipos_certificados(cod_grupo, nro_tipo_certificado, desc_tipo_certificado) 
values('ALU', 5, 'Certificado de ingresante preinscripto')
insert into dbo.tipos_certificados(cod_grupo, nro_tipo_certificado, desc_tipo_certificado) 
values('ALU', 6, 'Certificado de inscripción a exámenes finales')
insert into dbo.tipos_certificados(cod_grupo, nro_tipo_certificado, desc_tipo_certificado) 
values('ALU', 7, 'Certificado de materias aprobadas')
insert into dbo.tipos_certificados(cod_grupo, nro_tipo_certificado, desc_tipo_certificado) 
values('ALU', 8, 'Certificado de situación académica')
insert into dbo.tipos_certificados(cod_grupo, nro_tipo_certificado, desc_tipo_certificado) 
values('ALU', 9, 'Certificado de asistencia a coloquio de promoción')
insert into dbo.tipos_certificados(cod_grupo, nro_tipo_certificado, desc_tipo_certificado) 
values('ALU', 10, 'Certificado de asistencia a evaluaciones parciales')
insert into dbo.tipos_certificados(cod_grupo, nro_tipo_certificado, desc_tipo_certificado) 
values('ALU', 11, 'Certificado de asistencia a evaluaciones parciales con nota')
insert into dbo.tipos_certificados(cod_grupo, nro_tipo_certificado, desc_tipo_certificado) 
values('DOC', 1, 'Certificado de asistencia a actividades de exámenes finales')
insert into dbo.tipos_certificados(cod_grupo, nro_tipo_certificado, desc_tipo_certificado) 
values('DOC', 2, 'Certificado de horario de clases')
go

/* -------------------------------------------------
   Consulta de tipos de certificados
   ------------------------------------------------- */
declare @cod_grupo varchar(3) = 'DOC'

select desc_tipo_certificado,
       nro_tipo_certificado
  from dbo.tipos_certificados (nolock)
 where cod_grupo = @cod_grupo
go

/* -------------------------------------------------
   Procedimiento: del_tipo_certificado
   ------------------------------------------------- */
create procedure dbo.del_tipo_certificado
(
 @cod_grupo				varchar(3),
 @nro_tipo_certificado	tinyint
)
as
begin

  delete
    from dbo.tipos_certificados
   where cod_grupo            = @cod_grupo
     and nro_tipo_certificado = @nro_tipo_certificado

end
go

-- execute dbo.del_tipo_certificado @cod_grupo='DOC', @nro_tipo_certificado=3
