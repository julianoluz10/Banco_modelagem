-- E um comentario!

--DDL - CRIAR-Create(Schemea,Tabela)
CREATE SCHEMA clinica;
--CREATE TABLE <SCHEMA>.<NOME_DA_TABELA>
CREATE TABLE clinica.medico (
	--Informar colunas
	--NOME_DA_COLUNA TIPO_DE_DADO
	--PRIMARY KEY-CHAVE PRIMARIA
	--GENERATED ALWAYS AS IDENTITY-A CHAVE PRIMARIA E CRIADA 
	--AUTOMATICAMENTE
	id_medico INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome TEXT NOT NULL,
	crm TEXT NOT NULL,
	especialidade TEXT NOT NULL
);
CREATE TABLE clinica.paciente(
	id_paciente INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome TEXT NOT NULL,
	idade INT NOT NULL,
	data_nascimento DATE NOT NULL
	
);
CREATE TABLE clinica.clinica(
	id_clinica INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome TEXT NOT NULL,
	descricao TEXT NOT NULL,
	endereco TEXT
);

CREATE TABLE clinica.consulta(
	id_consulta INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	data TIMESTAMPTZ NOT NULL,
	valor NUMERIC(10, 4),
	--maneira extensa
	id_medico INT NOT NULL,
	FOREIGN KEY (id_medico) 
	REFERENCES clinica.medico(id_medico),
	--maneira abreviada
	id_clinica INT NOT NULL REFERENCES clinica.clinica(id_clinica),
	id_paciente INT NOT NULL REFERENCES clinica.paciente(id_paciente)
);

--ALTER - ALTERAR A TABELA
--ALTER TABLE clinica.paciente

--ADD COLUMN cpf VARCHAR(14);
--UNIQUE - IMPEDE QUE SEJA CADASTRADO ALGO QUE JA EXISTE NO BANCO

--renomear tabela
--ALTER TABLE clinica.paciente;
--RENAME TO clinica.novopaciente;
--DROP COLUMN cpf;

--TRUNCATE-LIMPA A TABELA
--TRUNCATE TABLE clinica.consulta RESTART IDENTITY;


--RESTART IDENTITY;
--RESTART IDENTITY -REINICIA A SEQUENCIA;

--Apagar Tabela - DROP


/*
DROP TABLE clinica.consulta;
DROP TABLE clinica.clinica;
DROP TABLE clinica.paciente;
DROP TABLE clinica.medico;
*/