CREATE schema SHOPPING

create table SHOPPING.shopping
(
 idShopping int identity,
 nome varchar(150) not null,
 CEP varchar(10) not null,
 NumeroRua varchar(4) not null,
 primary key(idShopping, NumeroRua)
);

select * from SHOPPING.shopping

drop table SHOPPING.shopping

sp_help 'SHOPPING.shopping'


