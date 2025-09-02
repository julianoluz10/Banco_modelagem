--DML (Data Manipulation Language)
-- INSERT(Cadastrar)
--UPDATE(Atualizar)
--DELETE(Apagar)

--OPCIONAL 
--SET search_path TO clinica;
-- clinica.paciente->pacienete

--INSERT INTO <SCHEMA>.<TABELA>(<colunas>)VALUES
INSERT INTO  clinica.medico(nome, especialidade, crm) VALUES
('Juliano', 'Ortopedia','123456'),
('Ariel', 'Cardiologia','789563'),
('Vinicio','pediatra','159753')

--DQL(Data Query Language)-Linguagem de Consulta
--de Dados
--SELECT
--SELECT<QUAIS_COLUNAS> FROM <SCHEMA>.<TABELA>

SELECT * FROM clinica.medico;

INSERT INTO clinica.paciente(nome, idade, data_nascimento)
VALUES
('FULANO',35, '2002-07-25')

SELECT *FROM clinica.paciente;

INSERT INTO clinica.clinica(nome, descricao, endereco)
VALUES
('Clinica Sao Caetano', 'A clinica do ABC', 'rua niteroi')

SELECT *FROM clinica.clinica;

INSERT INTO clinica.consulta(data, valor, id_medico, id_clinica, id_paciente)
VALUES
('2025-08-28 09:30:00-03', 350.52,1,1,2)

SELECT *FROM clinica.consulta;

--UPDATE
UPDATE clinica.consulta
SET
valor =250.20,
data= '2025-09-03 08:30:00 -03'
WHERE id_medico=1;

--DELETE 
DELETE FROM clinica.medico
WHERE nome='vinicio';