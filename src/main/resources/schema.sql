drop table if exists Produto;

CREATE TABLE Produto(
    codigo bigint not null auto_increment,
    nome varchar(50) not null,
    valor double not null,
    quantidade int,
    primary key(codigo));