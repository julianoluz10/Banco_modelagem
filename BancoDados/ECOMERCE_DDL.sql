--DDL - CRIAR.create(schema, tabela)
CREATE SCHEMA ECOMERCE;

--CREATE TABLE <SCHEMA>.<NOME_DA_TABELA>
CREATE TABLE ecomerce.produto(
	--informar colunas
	--NOME_DA_COLUNA TIPO_DE_DADO
	--PRIMARY KEY-CHAVE PRIMARIA
	--GENERATED ALWAYS AS IDENTITY-A CHAVE PRIMARIA E CRIADA 
	--AUTOMATICAMENTE

	id_produto int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome_produto TEXT,
	descricao TEXT,
	preco NUMERIC(10,4),
	estoque_disponivel INT NOT NULL,
	imagem_url text
);
CREATE TABLE ecomerce.cliente(
	id_cliente INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome TEXT NOT NULL,
	email TEXT NOT NULL,
	senha TEXT NOT NULL,
	telefone INT NOT NULL,
	data_cadastro TIMESTAMPTZ
	
);
CREATE TABLE ecomerce.pedido(
	id_pedido INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	data_pedido TIMESTAMPTZ,
	valor_total NUMERIC(10,4) NOT NULL,
	status TEXT NOT NULL,
	id_cliente INT NOT NULL,
	FOREIGN KEY (id_cliente)
	REFERENCES ecomerce.cliente
);
CREATE TABLE ecomerce.pagamento(
	id_pagamento INT  PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	id_pedido INT NOT NULL ,
	FOREIGN KEY(id_pedido)
	REFERENCES ecomerce.pedido,
	forma_pagamento TEXT,
	status TEXT,
	data_pagamento DATE
);
CREATE TABLE ecomerce.item_pedido(
	item_id  INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	item_pedido TEXT,
	id_pedido INT NOT NULL,
	FOREIGN KEY(id_pedido)
	REFERENCES ecomerce.pedido,
	id_produto INT NOT NULL,
	FOREIGN KEY(id_produto)
	REFERENCES ecomerce.produto
)



