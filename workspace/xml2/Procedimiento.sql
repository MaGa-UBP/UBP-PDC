use pdc
go

drop table dbo.vuelos
go

create table dbo.vuelos
(
 nro_vuelo				integer			not null identity(1, 1)
						constraint PK__vuelos__END primary key,
 origen					varchar(3)		not null,
 destino				varchar(3)		not null,
 fecha_vuelo			smalldatetime	not null,
 cant_asientos_libres	tinyint			not null,
 constraint UK__vuelos__END unique (origen, destino, fecha_vuelo)
)
go

insert dbo.vuelos(origen, destino, fecha_vuelo, cant_asientos_libres)
values('B', 'K', '07 Ene 2015 10:00AM', 20)
insert dbo.vuelos(origen, destino, fecha_vuelo, cant_asientos_libres)
values('B', 'H', '07 Ene 2015 10:30AM', 0)
insert dbo.vuelos(origen, destino, fecha_vuelo, cant_asientos_libres)
values('B', 'U', '07 Ene 2015 11:00AM', 5)
insert dbo.vuelos(origen, destino, fecha_vuelo, cant_asientos_libres)
values('B', 'X', '07 Ene 2015 5:00AM', 2)
insert dbo.vuelos(origen, destino, fecha_vuelo, cant_asientos_libres)
values('B', 'K', '07 Mar 2015 10:00AM', 20)
insert dbo.vuelos(origen, destino, fecha_vuelo, cant_asientos_libres)
values('B', 'H', '07 Mar 2015 10:30AM', 7)
insert dbo.vuelos(origen, destino, fecha_vuelo, cant_asientos_libres)
values('B', 'U', '07 Mar 2015 11:00AM', 0)
insert dbo.vuelos(origen, destino, fecha_vuelo, cant_asientos_libres)
values('B', 'X', '07 Mar 2015 5:00AM', 9)
insert dbo.vuelos(origen, destino, fecha_vuelo, cant_asientos_libres)
values('X', 'B', '09 Mar 2015 11:00AM', 10)
insert dbo.vuelos(origen, destino, fecha_vuelo, cant_asientos_libres)
values('X', 'K', '09 Mar 2015 5:00PM', 50)
insert dbo.vuelos(origen, destino, fecha_vuelo, cant_asientos_libres)
values('X', 'H', '09 Mar 2015 5:00AM', 0)
insert dbo.vuelos(origen, destino, fecha_vuelo, cant_asientos_libres)
values('X', 'U', '09 Mar 2015 10:00AM', 40)
insert dbo.vuelos(origen, destino, fecha_vuelo, cant_asientos_libres)
values('X', 'W', '09 Mar 2015 12:00AM', 12)
insert dbo.vuelos(origen, destino, fecha_vuelo, cant_asientos_libres)
values('X', 'B', '04 Abr 2015 11:00AM', 10)
insert dbo.vuelos(origen, destino, fecha_vuelo, cant_asientos_libres)
values('X', 'K', 'Abr 04 2015 5:00PM', 50)
insert dbo.vuelos(origen, destino, fecha_vuelo, cant_asientos_libres)
values('X', 'H', 'Abr 04 2015 5:00AM', 0)
insert dbo.vuelos(origen, destino, fecha_vuelo, cant_asientos_libres)
values('X', 'U', '04 Abr 2015 10:00AM', 40)
insert dbo.vuelos(origen, destino, fecha_vuelo, cant_asientos_libres)
values('X', 'W', '04 Abr 2015 12:00AM', 12)
go

create procedure dbo.get_vuelos
(
 @origen			varchar(3),
 @destino			varchar(3),
 @fecha_desde		varchar(10),
 @fecha_hasta		varchar(10),
 @cant_pasajeros	tinyint
)
as
begin

 select fecha_hora_vuelo     = convert(varchar(10), fecha_vuelo, 103) + ' ' + convert(varchar(5), fecha_vuelo, 108),
        cant_asientos_libres = cant_asientos_libres,
		origen               = origen,
		destino              = destino,
        nro_vuelo            = nro_vuelo
   from dbo.vuelos (nolock)
  where origen                = @origen
    and destino               = @destino 
	and convert(varchar(10), fecha_vuelo, 112)
	                         between convert(varchar(10), convert(smalldatetime, @fecha_desde, 103), 112) and convert(varchar(10), convert(smalldatetime, @fecha_hasta, 103), 112)
    and cant_asientos_libres >= @cant_pasajeros

end
go

-- execute dbo.get_vuelos 'B', 'K', '01/01/2015', '20/03/2015', 3
