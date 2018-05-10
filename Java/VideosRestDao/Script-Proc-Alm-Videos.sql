use das
go

create or alter procedure dbo.get_videos 
(
 @nro_categoria		tinyint			= null,
 @string_busqueda	varchar(255)	= null
)
as
begin

   select c.nom_categoria, 
          v.nro_categoria,
          v.titulo,
	      v.cantante,
	      v.link_video,
	      v.nro_video
     from dbo.videos v (nolock)
          join dbo.categorias_videos c (nolock)
	        on v.nro_categoria = c.nro_categoria
    where (@nro_categoria is null
       or  v.nro_categoria = @nro_categoria)
      and  v.titulo + ' ' + v.cantante + ' ' + v.titulo like '%' + isnull(ltrim(rtrim(@string_busqueda)), '') + '%'
    order by c.nom_categoria,
             v.titulo

end
go

execute dbo.get_videos 