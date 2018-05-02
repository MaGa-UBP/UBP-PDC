use pdc
go

/* ------------------------------------------
   Tabla: grupos_atencion
   ------------------------------------------ */
create table dbo.grupos_atencion
(
 nro_grupo_atencion		smallint		not null
						constraint PK__grupos_atencion__END primary key,
 nom_grupo_atencion		varchar(100)	not null
);
go

insert into dbo.grupos_atencion(nro_grupo_atencion, nom_grupo_atencion)
values(1, 'ADMINISTRACIÓN'),(2, 'BEDELÍA'),(3, 'BIBLIOTECA'),(4, 'INFORMES'),(5, 'TUTORÍA GUÍA');
go

/* ------------------------------------------
   Tabla: temas_atencion
   ------------------------------------------ */
create table dbo.temas_atencion
(
 nro_tema				smallint		not null,
 nro_grupo_atencion		smallint		null
						constraint FK__temas_atencion__grupos_atencion__END references dbo.grupos_atencion,
 desc_tema				varchar(255)	not null,
 vigente				char(1)			not null
						constraint CK__temas_atencion__vigente__END check (vigente in ('S', 'N'))
						constraint DF__temas_atencion__vigente__S__END default 'S'
);
go

insert into dbo.temas_atencion(nro_tema, nro_grupo_atencion, desc_tema, vigente)
values(1, 1, 'Pago de aranceles', 'S'),
      (2, 1, 'Generación de deuda', 'S'),
      (3, null, 'Asesoramiento', 'S'),
      (4, 1, 'Consulta de deuda', 'S'),
      (5, 2, 'Baja de carrera', 'S'),
      (6, 2, 'Baja de materia', 'S'),
      (7, 2, 'Entrega de evaluaciones', 'S'),
      (8, 2, 'Comunicación con tutores', 'S'),
      (9, null, 'Soporte', 'S');
go

/* ------------------------------------------
   Consulta de grupos_atencion
   ------------------------------------------ */
select nro_grupo_atencion,
       nom_grupo_atencion
  from dbo.grupos_atencion (nolock)
 order by nom_grupo_atencion
go

/* ------------------------------------------
   Procedimiento: get_temas_atencion
   ------------------------------------------ */
create procedure dbo.get_temas_atencion
as
begin

  select nro_tema,
         nro_grupo_atencion,
		 desc_tema,
		 vigente
	from dbo.temas_atencion (nolock)

end
go

-- execute dbo.get_temas_atencion

/* ------------------------------------------
   Actualización de un tema
   ------------------------------------------ */
declare @nro_tema			smallint	 = 1,
        @nro_grupo_atencion	smallint	 = null,
        @desc_tema			varchar(255) = 'TEXTO',
		@vigente			char(1)		 = 'S'

update t
   set nro_grupo_atencion = @nro_grupo_atencion,
       desc_tema          = @desc_tema, 
	   vigente            = @vigente
  from dbo.temas_atencion t
 where nro_tema = @nro_tema
go

