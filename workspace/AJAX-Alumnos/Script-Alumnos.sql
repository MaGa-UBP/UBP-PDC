use pdc
go

drop table dbo.matriculas
drop table dbo.alumnos
drop table dbo.carreras
go

create table dbo.carreras
(
 nro_carrera		smallint		not null
					constraint PK__carreras__END primary key,
 nom_carrera		varchar(255)	not null,
 plan_carrera		smallint		not null,
 modalidad_carrera	varchar(3)		not null
					constraint CK__carreras__modalidad_carrera__END check(modalidad_carrera in ('PR', 'D', 'SP'))
)
go

insert into dbo.carreras(nro_carrera, nom_carrera, plan_carrera, modalidad_carrera)
values(1, 'INGENIERIA INFORMATICA', 2003, 'PR'),
      (2, 'LICENCIATURA EN ADMINISTRACION', 2008, 'D'),
	  (3, 'CONTADOR PÚBLICO', 2010, 'D'),
	  (4, 'ABOGACÍA', 2003, 'PR')
go

create table dbo.alumnos
(
 nro_leg_alumno		integer			not null
					constraint PK__alumnos__END primary key,
 apellido			varchar(100)	not null,
 nombre				varchar(255)	not null,
 cod_tipo_documento	varchar(6)		not null
					constraint CK__alumnos__cod_tipo_documento__END check(cod_tipo_documento in('DNI', 'PAS', 'CI', 'LE', 'LC')),
 nro_documento		varchar(20)		not null,
 constraint UK__alumnos__END unique(cod_tipo_documento, nro_documento)
)
go

insert into dbo.alumnos(nro_leg_alumno, apellido, nombre, cod_tipo_documento, nro_documento)
values(1, 'APELLIDO1', 'NOMBRE1', 'DNI', '00000001'),
      (2, 'APELLIDO2', 'NOMBRE2', 'DNI', '00000002'),
	  (3, 'APELLIDO3', 'NOMBRE3', 'DNI', '00000003'),
	  (4, 'APELLIDO4', 'NOMBRE4', 'DNI', '00000004'),
	  (5, 'APELLIDO5', 'NOMBRE5', 'DNI', '00000005'),
	  (6, 'APELLIDO6', 'NOMBRE6', 'DNI', '00000006'),
	  (7, 'APELLIDO7', 'NOMBRE7', 'DNI', '00000007'),
	  (8, 'APELLIDO8', 'NOMBRE8', 'DNI', '00000008') 
go

create table dbo.matriculas
(
 nro_carrera		smallint		not null
					constraint FK__matriculas__carreras__END references dbo.carreras,
 nro_leg_alumno		integer			not null
 					constraint FK__matriculas__alumnos__END references dbo.alumnos,
 constraint PK__matriculas__END primary key(nro_carrera, nro_leg_alumno)
)
go

insert into dbo.matriculas(nro_carrera, nro_leg_alumno)
values(1, 1),
      (1, 2),
	  (1, 3),
	  (2, 4),
	  (3, 4),
	  (3, 5),
	  (3, 6),
	  (4, 7),
	  (4, 8)
go

-- Para la lista de carreras
select nro_carrera = -1,
       carrera     = 'Todas las carreras',
	   nro_orden   = 1
 union
select nro_carrera = nro_carrera,
       carrera     = nom_carrera + ' (' + convert(varchar(5), plan_carrera) + ') ' +
	                 case modalidad_carrera
					      when 'PR'
						  then 'Pres.'
						  when 'D'
						  then 'Dist.'
						  else 'Semi-Pres.'
				    end,
	   nro_orden   = 2
  from dbo.carreras (nolock)
 order by nro_orden,
          carrera

-- Para el resultado de la búsqueda
-- OJO: La declaración de la variable solo es a lo fines de probar la consulta
--      Deben adaptar la consulta para que sea ejecutada desde Java
declare @nro_carrera smallint = 1

select nro_leg_alumno = m.nro_leg_alumno,
       nom_alumno     = upper(a.apellido + ', ' + a.nombre),
	   documento      = a.cod_tipo_documento + '-' + a.nro_documento,
	   nro_carrera    = m.nro_carrera,
       carrera        = c.nom_carrera + ' (' + convert(varchar(5), c.plan_carrera) + ') ' +
	                    case c.modalidad_carrera
					         when 'PR'
						     then 'Pres.'
						     when 'D'
						     then 'Dist.'
						     else 'Semi-Pres.'
				        end
  from dbo.matriculas m (nolock)
       join dbo.carreras c (nolock)
	     on m.nro_carrera    = c.nro_carrera
	   join dbo.alumnos a (nolock)
	     on m.nro_leg_alumno = a.nro_leg_alumno
 where (@nro_carrera  = -1
    or  m.nro_carrera = @nro_carrera) 
 order by carrera,
          a.apellido,
		  a.nombre
