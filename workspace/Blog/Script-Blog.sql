use pdc
go

drop table dbo.mensajes_temas_blog
drop table dbo.temas_blog
drop procedure dbo.get_mensajes_tema_blog
drop procedure dbo.get_temas_blog
drop procedure dbo.ins_mensaje_tema_blog
go

/* --------------------------------------------------------
   Table: temas_blog
   -------------------------------------------------------- */
create table dbo.temas_blog
(
 nro_tema			integer			not null 
					constraint PK__temas_blog__END primary key,
 fecha_registro		smalldatetime	not null 
					constraint DF__temas_blog__fecha_registro__current_timestamp__END default current_timestamp,
 titulo_tema		varchar(100)	not null,
 titulo_res_tema	varchar(50)		not null,
 texto_tema			varchar(max)	not null,
 web_publ_tema		varchar(255)	null,
 fecha_ini_vig		date			not null,
 fecha_fin_vig		date		 	null,
 constraint CK__temas_blog__vigencia__END check (fecha_fin_vig is not null and fecha_ini_vig <= fecha_fin_vig or fecha_fin_vig is null)
)
go

/* --------------------------------------------------------
   Table: mensajes_temas_blog
   -------------------------------------------------------- */
create table dbo.mensajes_temas_blog
(
 nro_tema			integer			not null 
					constraint FK__mensajes_temas_blog__temas_blog__END references dbo.temas_blog,
 nro_mensaje		integer			not null,
 fecha_registro		smalldatetime	not null 
					constraint DF__mensajes_temas_blog__fecha_registro__current_timestamp__END default current_timestamp, 
 autor				varchar(100)	not null,
 e_mail_autor		varchar(100)	not null,
 texto_mensaje		varchar(255)	not null,
 constraint PK__mensajes_temas_blog__END primary key(nro_tema, nro_mensaje)
)
go

insert into dbo.temas_blog(nro_tema, titulo_tema, titulo_res_tema, texto_tema, web_publ_tema, fecha_ini_vig)
values(1, 'Hablemos sobre Supernovas', 'Supernovas', '<p>Una supernova (del lat&iacute;n nova, «nueva») es una explosi&oacute;n estelar que puede manifestarse de forma muy notable, incluso a simple vista, en lugares de la esfera celeste donde antes no se hab&iacute;a detectado nada en particular. Por esta raz&oacute;n, a eventos de esta naturaleza se los llam&oacute; inicialmente stellae novae («estrellas nuevas») o simplemente novae. Con el tiempo se hizo la distinci&oacute;n entre fen&oacute;menos aparentemente similares pero de luminosidad intr&iacute;nseca muy diferente; los menos luminosos continuaron llam&aacute;ndose novae (novas), en tanto que a los m&aacute;s luminosos se les agreg&oacute; el prefijo &quot;super-&quot;.</p>
<p>Este t&eacute;rmino fue utilizado desde la antig&uuml;edad para indicar la explosi&oacute;n de una estrella blanca y peque&ntilde;as en sus capas externas, las cuales producen una luminosidad que puede aumentar 100.000 veces su brillo original. Esta luminosidad dura unos pocos d&iacute;as y, en ocasiones, puede ser observada a simple vista desde la tierra. Al ver un nuevo resplandor en el cielo, los seres humanos cre&iacute;an que hab&iacute;a apaecido una nueva estrella. En el mes de agosto de 1975, apareci&oacute; una nova que pudo ser observada a simple vista desde la tierra, durante algunos d&iacute;as. Esta nova surgi&oacute; de la explosi&oacute;n de una gigante roja.</p>
<p>Las supernovas producen destellos de luz intens&iacute;simos que pueden durar desde varias semanas a varios meses. Se caracterizan por un r&aacute;pido aumento de la intensidad luminosa hasta alcanzar una magnitud absoluta mayor que el resto de la galaxia. Posteriormente su brillo decrece de forma m&aacute;s o menos suave hasta desaparecer completamente.</p>
<p>Se han propuesto varios escenarios para su origen. Pueden ser estrellas masivas que ya no pueden desarrollar reacciones termonucleares en su n&uacute;cleo, y que son incapaces de sostenerse por la presi&oacute;n de degeneraci&oacute;n de los electrones, lo que las lleva a contraerse repentinamente (colapsar) y generar, en el proceso, una fuerte emisi&oacute;n de energ&iacute;a. Otro proceso m&aacute;s violento a&uacute;n, capaz de generar destellos incluso mucho m&aacute;s intensos, puede suceder cuando una enana blanca miembro de un sistema binario cerrado, recibe suficiente masa de su compa&ntilde;era como para superar el l&iacute;mite de Chandrasekhar y proceder a la fusi&oacute;n instant&aacute;nea de todo su n&uacute;cleo: esto dispara una explosi&oacute;n termonuclear que expulsa casi todo, si no todo, el material que la formaba.</p>
<p>La explosi&oacute;n de supernova provoca la expulsi&oacute;n de las capas externas de la estrella por medio de poderosas ondas de choque, enriqueciendo el espacio que la rodea con elementos pesados. Los restos eventualmente componen nubes de polvo y gas. Cuando el frente de onda de la explosi&oacute;n alcanza otras nubes de gas y polvo cercanas, las comprime y puede desencadenar la formaci&oacute;n de nuevas nebulosas solares que originan, despu&eacute;s de cierto tiempo, nuevos sistemas estelares (quiz&aacute; con planetas, al estar las nebulosas enriquecidas con los elementos procedentes de la explosi&oacute;n).</p>
<p>Estos residuos estelares en expansi&oacute;n se denominan remanentes y pueden tener o no un objeto compacto en su interior. Dicho remanente terminar&aacute; por diluirse en el medio interestelar al cabo de millones de a&ntilde;os. Un ejemplo es RCW 86.</p>
<p>Las supernovas pueden liberar varias veces 1044 J de energ&iacute;a. Esto ha resultado en la adopci&oacute;n del foe (1044 J) como unidad est&aacute;ndar de energ&iacute;a en el estudio de supernovas.</p>', 'https://es.wikipedia.org/wiki/Supernova', getdate()),
(2, 'La Cruz del Sur', 'Crux', '<p>Crux (la Cruz), normalmente referida como la Cruz del Sur para contrastarla con la Cruz del Norte, es una de las m&aacute;s famosas constelaciones modernas a pesar de ser la m&aacute;s peque&ntilde;a de las 88 que integran la esfera celeste; seg&uacute;n los l&iacute;mites imaginarios impuestos por la Uni&oacute;n Astron&oacute;mica Internacional (UAI) en 1930, esta constelaci&oacute;n, con solo 68 grados cuadrados, cubre apenas 1/600 del cielo.</p>
<p>Es &uacute;til para la orientaci&oacute;n ya que permite determinar el punto cardinal sur: prolongando cuatro veces y media en l&iacute;nea recta el eje principal de la cruz, partiendo de su estrella m&aacute;s brillante «Acrux», el «pie» de la Cruz, se llega al polo sur celeste, el punto alrededor del cual gira en forma aparente la b&oacute;veda del cielo. Una vez hecha esta prolongaci&oacute;n, basta bajar una vertical hacia la l&iacute;nea del horizonte y all&iacute; se encuentra con bastante precisi&oacute;n el sur geogr&aacute;fico. Si bien por su proximidad al polo sur celeste, la Cruz del Sur gira alrededor del mismo en forma ostensible durante el transcurso de la noche, no importa su posici&oacute;n para este procedimiento de localizaci&oacute;n, ya que su brazo mayor, al girar alrededor del polo celeste, siempre determina el lugar del mismo.</p>
<p>La Cruz del Sur limita en tres de sus lados con la constelaci&oacute;n Centaurus mientras que al sur lo hace con la de la Musca. Los griegos antiguos la crearon como parte de Centaurus, pero fue definida como un patr&oacute;n estelar independiente en el siglo XVI, despu&eacute;s de la expedici&oacute;n de Am&eacute;rico Vespucio a Sudam&eacute;rica en 1501. Vespucio traz&oacute; un mapa tanto de las dos estrellas Alpha Centauri y Beta Centauri como de las estrellas de la Cruz. Aunque los griegos antiguos conocieron estas estrellas, la precesi&oacute;n gradual las habr&iacute;a puesto debajo del horizonte europeo antes de la era cristiana, de modo que fueron olvidadas. Es probable que hacia el a&ntilde;o 5000 a. C., al final de la &uacute;ltima era glacial, Centaurus y la Cruz del Sur fueran visibles sobre el horizonte en la medianoche de primavera en la latitud del centro de Europa.</p>', 'http://es.wikipedia.org/wiki/Crux', getdate()),
(3, 'Nebulosa de Ori&oacute;n', 'Nebulosa de Ori&oacute;n', '<p>La nebulosa de Ori&oacute;n, tambi&eacute;n conocida como Messier 42, M42, o NGC 1976, es una nebulosa difusa situada al sur del Cintur&oacute;n de Ori&oacute;n. Es una de las nebulosas m&aacute;s brillantes que existen, y puede ser observada a simple vista sobre el cielo nocturno. Est&aacute; situada a 1.270±76 a&ntilde;os luz de la Tierra, y posee un di&aacute;metro aproximado de 24 a&ntilde;os luz. Algunos documentos se refieren a ella como la Gran Nebulosa de Ori&oacute;n, y los textos m&aacute;s antiguos la denominan Ensis, palabra latina que significa &quot;espada&quot;, nombre que tambi&eacute;n recibe la estrella Eta Orionis, que desde la Tierra se observa muy pr&oacute;xima a la nebulosa.</p>
<p>La nebulosa de Ori&oacute;n es uno de los objetos astron&oacute;micos m&aacute;s fotografiados, examinados, e investigados. De ella se ha obtenido informaci&oacute;n determinante acerca de la formaci&oacute;n de estrellas y planetas a partir de nubes de polvo y gas en colisi&oacute;n. Los astr&oacute;nomos han observado en sus entra&ntilde;as discos protoplanetarios, enanas marrones, fuertes turbulencias en el movimiento de part&iacute;culas de gas y efectos fotoionizantes cerca de estrellas muy masivas pr&oacute;ximas a la nebulosa.</p>', 'http://es.wikipedia.org/wiki/Nebulosa_de_Ori%C3%B3n', getdate())
go

/* --------------------------------------------------------
   Procedure: get_temas_blog
   -------------------------------------------------------- */
create procedure dbo.get_temas_blog
(
 @nro_tema	integer	 = null
)
as
begin

  if @nro_tema = 0
     set @nro_tema = null

  select titulo_tema     = titulo_tema,
         titulo_res_tema = titulo_res_tema,
         texto_tema      = texto_tema, 
		 web_publ_tema   = web_publ_tema,
		 fecha_registro  = convert(varchar(10), fecha_registro, 103),
		 tema_actual     = case when nro_tema = @nro_tema
		                        then 'S'
								else 'N'
						   end,
         nro_tema        = nro_tema
    from dbo.temas_blog (nolock)
   where  fecha_ini_vig  <= getdate()
     and (fecha_fin_vig >= getdate()
      or  fecha_fin_vig is null)
   order by tema_actual desc,
            titulo_res_tema

end
go

-- execute dbo.get_temas_blog
-- execute dbo.get_temas_blog @nro_tema=2


/* --------------------------------------------------------
   Procedure: get_mensajes_tema_blog
   -------------------------------------------------------- */
create procedure dbo.get_mensajes_tema_blog
(
 @nro_tema	integer
)
as
begin

  select fecha_registro = convert(varchar(10), fecha_registro, 103), 
         autor          = autor,
         e_mail_autor   = e_mail_autor,
         texto_mensaje  = texto_mensaje,
         nro_tema       = nro_tema,
         nro_mensaje    = nro_mensaje
    from dbo.mensajes_temas_blog (nolock)
   where nro_tema = @nro_tema

end
go

-- execute dbo.get_mensajes_tema_blog @nro_tema=1

/* --------------------------------------------------------
   Procedure: ins_mensaje_tema_blog
   -------------------------------------------------------- */

create procedure dbo.ins_mensaje_tema_blog
(
 @nro_tema		integer,
 @autor			varchar(100),
 @e_mail_autor	varchar(100),
 @texto_mensaje	varchar(255)
)
as
begin

  declare @nro_mensaje integer

  select @nro_mensaje = isnull(max(nro_mensaje), 0) + 1
    from dbo.mensajes_temas_blog (tablockx)
   where nro_tema = @nro_tema

  insert into dbo.mensajes_temas_blog(nro_tema, nro_mensaje, autor, e_mail_autor, texto_mensaje)
  values(@nro_tema, @nro_mensaje, @autor, @e_mail_autor, @texto_mensaje)

end
go

-- execute dbo.ins_mensaje_tema_blog @nro_tema=1, @autor='Mariela', @e_mail_autor='mpastarini@ubp.edu.ar', @texto_mensaje='Un comentario'

grant execute on dbo.get_temas_blog to public
grant execute on dbo.get_mensajes_tema_blog to public
grant execute on dbo.ins_mensaje_tema_blog to public
go


select * from mensajes_temas_blog