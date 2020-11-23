USE rooster;

CREATE TABLE mcs(
	id int not null primary key auto_increment,
    names varchar(20),
    aka varchar(20),
    edad int
);

INSERT INTO mcs(names, aka, edad) VALUES("PERCY ROJAS", "rizoMC", 21);
select *from mcs;

CREATE TABLE puntos(
	id int not null primary key auto_increment,
    puntos int,
    collective_id int,
    mcs_id int
);

insert into puntos(puntos, collective_id, mcs_id) VALUES(40,2,3);

select *from puntos;

select m.names, m.aka, SUM(p.puntos) as puntajeTotal from puntos p
inner join mcs m ON p.mcs_id = m.id
where p.id=3;

CREATE TABLE collective(
	id int not null primary key auto_increment,
    names varchar(40),
    location varchar(100),
    organizator varchar(50)
);
select *from collective;

INSERT INTO collective(names, location, organizator) VALUES("COLECTIVO UTP", "Centro de Lima, Lima", "Cesar");
INSERT INTO collective(names, location, organizator) VALUES("COLECTIVO SUPREMACIA", "Miraflores, Lima", "Cesar");





