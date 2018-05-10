use das
go

drop table dbo.videos
drop table dbo.idiomas_categorias_videos
drop table dbo.categorias_videos
drop table dbo.idiomas
go

create table dbo.idiomas
(
 idioma			varchar(2)		not null
				constraint PK__idiomas__END primary key,
 desc_idioma	varchar(50)		not null,
 nro_orden		tinyint			not null
				constraint UK__idiomas__END unique
)
go

insert into dbo.idiomas(idioma, desc_idioma, nro_orden)
values('es', 'Español', 1),
      ('en', 'Inglés', 2)
go

/* ----------------------------------------------
   Tabla: categorias_videos
   ---------------------------------------------- */
create table dbo.categorias_videos
(
 nro_categoria		tinyint			not null,
 desc_categoria		varchar(50)		not null
 constraint PK__categorias_videos__END
			primary key (nro_categoria)
);
go

insert into dbo.categorias_videos(nro_categoria, desc_categoria)
values(1, 'BLUE'),  
      (2, 'CLÁSICA'),  
      (3, 'COUNTRY'),  
      (4, 'FUNK'),  
      (5, 'HIP HOP'),  
      (6, 'JAZZ'),  
      (7, 'POP'),
      (8, 'ROCK'),
      (9, 'ROCK ALTERNATIVO');
go

/* ----------------------------------------------
   Tabla: idiomas_categorias_videos
   ---------------------------------------------- */
create table dbo.idiomas_categorias_videos
(
 nro_categoria		tinyint			not null,
 idioma				varchar(2)		not null,
 nom_categoria		nvarchar(50)	not null
 constraint PK__idiomas_categorias_videos__END
			primary key (nro_categoria, idioma)
);
go

insert into dbo.idiomas_categorias_videos(nro_categoria, idioma, nom_categoria)
values(1, 'es', 'BLUE'),  
      (2, 'es', 'CLÁSICA'),  
      (3, 'es', 'COUNTRY'),  
      (4, 'es', 'FUNK'),  
      (5, 'es', 'HIP HOP'),  
      (6, 'es', 'JAZZ'),  
      (7, 'es', 'POP'),
      (8, 'es', 'ROCK'),
      (9, 'es', 'ROCK ALTERNATIVO'),
      (1, 'en', 'BLUE'),  
      (2, 'en', 'CLASSIC'),  
      (3, 'en', 'COUNTRY'),  
      (4, 'en', 'FUNK'),  
      (5, 'en', 'HIP HOP'),  
      (6, 'en', 'JAZZ'),  
      (7, 'en', 'POP'),
      (8, 'en', 'ROCK'),
      (9, 'en', 'ALTERNATIVE ROCK');
go

/* ----------------------------------------------
   Tabla: videos
   ---------------------------------------------- */
create table dbo.videos
(
 nro_video			integer			not null identity(1,1),
 titulo				varchar(255)	not null,
 cantante			varchar(255)	not null,
 nro_categoria		tinyint			not null,
 link_video			varchar(255)	not null,
 constraint PK__videos__END
			primary key (nro_video),
 constraint FK__videos__categorias_videos__END
			foreign key (nro_categoria)
			references dbo.categorias_videos
);
go
    
insert into dbo.videos(titulo, cantante, nro_categoria, link_video)
values('Patience', 'Guns N'' Roses', 8, 'https://www.youtube.com/embed/ErvgV4P6Fzc'),
      ('Paradise City', 'Guns N'' Roses', 8, 'https://www.youtube.com/embed/Rbm6GXllBiw'),
      ('Smells Like Teen Spirit', 'Nirvana', 8, 'https://www.youtube.com/embed/hTWKbfoikeg'),
      ('Come As You Are', 'Nirvana', 8, 'https://www.youtube.com/embed/vabnZ9-ex7o'),
      ('Creep', 'Radiohead', 9, 'https://www.youtube.com/embed/XFkzRNyygfk'),
      ('The Reason', 'Hoobastank', 9, 'https://www.youtube.com/embed/fV4DiAyExN0'),
      ('Layla (acoustic)', 'Eric Clapton', 1, 'https://www.youtube.com/embed/Q_L-0Ryhmic'),
      ('Tears In Heaven', 'Eric Clapton', 1, 'https://www.youtube.com/embed/JxPj3GAYYZ0'),
      ('Uptown Funk ft. Bruno Mars', 'Mark Ronson', 4, 'https://www.youtube.com/embed/OPf0YbXqDm0'),
      ('Happy', 'Pharrell Williams', 4, 'https://www.youtube.com/embed/y6Sxv-sUYtM'),
      ('When I Was Your Man', 'Bruno Mars', 7, 'https://www.youtube.com/embed/ekzHIouo8Q4'),
      ('Let Her Go', 'Passenger', 7, 'https://www.youtube.com/embed/RBumgq5yVrA'),
      ('Nothing Compares 2U', 'Sinéad O''Connor', 7, 'https://www.youtube.com/embed/iUiTQvT0W_0');
go

/* ----------------------------------------------
   Consulta: idiomas
   ---------------------------------------------- */
select idioma
  from dbo.idiomas (nolock)
 order by nro_orden
go

/* ----------------------------------------------
   Procedimiento: get_categorias_videos_x_idioma
   ---------------------------------------------- */
create or alter procedure dbo.get_categorias_videos_x_idioma
(
 @idioma	varchar(2)
)
as
begin

  select nom_categoria = ic.nom_categoria,
         nro_categoria = ic.nro_categoria
	from dbo.idiomas_categorias_videos ic (nolock)
   where ic.idioma = @idioma
   order by ic.nom_categoria

end;
go

-- execute dbo.get_categorias_videos_x_idioma 'es'

/* ----------------------------------------------
   Procedimiento: get_videos
   ---------------------------------------------- */
create or alter procedure dbo.get_videos
(
 @nro_categoria		tinyint			= null,
 @idioma			varchar(2),
 @string_busqueda	varchar(255)	= null
)
as
begin

  if @nro_categoria = 0
     set @nro_categoria = null

  select c.nom_categoria,
         v.nro_categoria,
         v.titulo,
  	     v.cantante,
  	     v.link_video,
  	     v.nro_video
    from dbo.videos v (nolock)
         join dbo.idiomas_categorias_videos c (nolock)
  	       on v.nro_categoria = c.nro_categoria
  		  and c.idioma        = @idioma
   where (@nro_categoria  is null
      or  c.nro_categoria = @nro_categoria)
     and  v.titulo + ' ' + v.cantante + ' ' + v.titulo like '%' + isnull(ltrim(rtrim(@string_busqueda)), '') + '%' 
   order by c.nom_categoria,
            v.titulo;

end
go

-- execute dbo.get_videos @idioma='es'
