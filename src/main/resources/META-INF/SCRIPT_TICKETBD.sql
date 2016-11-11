
CREATE TABLE "USUARIOS"(
	"CPF" BIGINT PRIMARY KEY NOT NULL,
	"NOME" VARCHAR(50) NOT NULL,
 	"SOBRENOME" VARCHAR(50) NOT NULL,
	"EMAIL" VARCHAR(50) NOT NULL,
	"SENHA" VARCHAR(50) NOT NULL,
	"SEXO" CHAR ,
	"RG" BIGINT NOT NULL,
	"NACIONALIDADE" VARCHAR(50),
	"TIPO_USUARIO" INT NOT NULL,
	"STATUS" BOOLEAN NOT NULL,
	"DTCADASTRO" DATE  NOT NULL
);

CREATE TABLE "EVENTOS"(
	"ID_EVENTO" BIGINT NOT NULL PRIMARY KEY,
	"NOME_EVENTO" VARCHAR(50) NOT NULL,
	"LOCAL_EVENTO" VARCHAR(50) NOT NULL,
	"DT_EVENTO" DATE NOT NULL,
	"DT_CADASTRO_EVENTO" DATE NOT NULL,
	"STATUS" BOOLEAN NOT NULL	
);

CREATE TABLE "TELEFONES"(
	"ID_TELEFONE" BIGINT NOT NULL PRIMARY KEY,
	"DESCRICAO" VARCHAR(50) NOT NULL,
	"USUARIO_EVENTO" BIGINT NOT NULL,
	"DT_CADASTRO" DATE NOT NULL,
	"STATUS" BOOLEAN NOT NULL	
);
alter table "TELEFONES" add foreign key ("USUARIO_EVENTO") references "USUARIOS"(CPF);
alter table "TELEFONES" add foreign key ("USUARIO_EVENTO") references "EVENTOS"(ID_EVENTO);


CREATE TABLE "ENDERECOS"(
	"ID_ENDERECO" BIGINT NOT NULL PRIMARY KEY,
	"LOGRADOURO" VARCHAR(200) NOT NULL,
	"NUMERO" VARCHAR(20) NOT NULL,
	"COMPLEMENTO" VARCHAR(50),
	"BAIRRO" VARCHAR(100) NOT NULL,
	"CIDADE" VARCHAR(100) NOT NULL,	
	"ESTADO" VARCHAR(2) NOT NULL,
	"CEP" BIGINT NOT NULL,
	"USUARIO_EVENTO" BIGINT NOT NULL,
	"DT_CADASTRO" DATE NOT NULL,
	"STATUS" BOOLEAN NOT NULL	
);
alter table "ENDERECOS" add foreign key ("USUARIO_EVENTO") references "USUARIOS"(CPF);
alter table "ENDERECOS" add foreign key ("USUARIO_EVENTO") references "EVENTOS"(ID_EVENTO);

CREATE TABLE "TIPO_SETOR"(
	"ID_TIPO_SETOR" BIGINT NOT NULL PRIMARY KEY,
	"ID_EVENTO" BIGINT NOT NULL,
	"NOME_SETOR" VARCHAR(200) NOT NULL,
	"CAPACIDADE" INT NOT NULL,
	"VENDIDOS" INT NOT NULL,
	"PRECO" FLOAT NOT NULL,
	"DT_CADASTRO" DATE NOT NULL,
	"STATUS" BOOLEAN NOT NULL	
);
alter table "TIPO_SETOR" add foreign key ("ID_EVENTO") references "EVENTOS"(ID_EVENTO);

CREATE TABLE "VENDAS"(
	"ID_VENDA" BIGINT NOT NULL PRIMARY KEY,
	"ID_TIPO_SETOR" BIGINT NOT NULL,
	"USUARIO" BIGINT NOT NULL,
	"QUANTIDADE" INT NOT NULL,
	"DT_CADASTRO" DATE NOT NULL,
	"STATUS" BOOLEAN NOT NULL	
);
alter table "VENDAS" add foreign key ("ID_TIPO_SETOR") references "TIPO_SETOR"(ID_TIPO_SETOR);
alter table "VENDAS" add foreign key ("USUARIO") references "USUARIOS"(CPF)