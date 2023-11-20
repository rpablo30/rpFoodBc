-- Criação da tabela de produtos
CREATE TABLE produtos (
    id INT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10, 2) NOT NULL,
    opcionais INT,
    imagem VARCHAR(255),
    categoria VARCHAR(255)
);

-- Inserção de dados na tabela de produtos
INSERT INTO produtos (id, nome, descricao, preco, opcionais, imagem, categoria) VALUES
    (101, 'Antártica 350ml', 'Latinha', 2.5, 0, 'assets/img/theme/antartica350ml.jpg', 'Refrigerantes'),
    (102, 'Coca RETORNÁVEL 2L', '2L', 8, 0, 'assets/img/theme/cocaretornavel2l.jpg', 'Refrigerantes'),
    (103, 'Sukita 200ml', 'garrafa', 2.5, 0, 'assets/img/theme/sukita200ml.jpg', 'Refrigerantes'),
    (104, 'Coca Cola 250ml', 'garrafa', 3.5, 0, 'assets/img/theme/cocacoca250ml.jpg', 'Refrigerantes'),
    (105, 'Coca Cola 350ml', 'Latinha', 4.5, 0, 'assets/img/theme/cocacola350ml.jpg', 'Refrigerantes'),
    (106, 'Fanta uva 350ml', 'Latinha', 4.5, 0, 'assets/img/theme/fantauva.jpg', 'Refrigerantes'),
    (107, 'Fanta Laranja 350ml', 'Latinha', 4.5, 0, 'assets/img/theme/faltalaranja350ml.jpg', 'Refrigerantes'),
    (108, 'Pepsi 200ml', 'garrafa', 2.5, 0, 'assets/img/theme/pepsi200ml.jpg', 'Refrigerantes'),
    (109, 'Antártica 200ml', 'garrafa', 2.5, 0, 'assets/img/theme/antartica200ml.jpg', 'Refrigerantes'),
    (110, 'Água Sem Gás', 'garrafa', 1.5, 0, 'assets/img/theme/aguasemgas.jpg', 'Refrigerantes'),
    (111, 'Água com Gás', 'garrafa', 3, 0, 'assets/img/theme/aguacomgas.jpg', 'Refrigerantes'),
    (112, 'Antártica 1L', 'Sem descrição', 6, 0, 'assets/img/theme/antartica1l.jpg', 'Refrigerantes'),
    (113, 'Coca cola Retornável 1L', 'Retornável de vidro', 5, 0, 'assets/img/theme/cocacolaretornavel1l.jpg', 'Refrigerantes'),
    (114, 'Coca cola 1,5L Pet', 'Não retornável', 8, 0, 'assets/img/theme/cocacolaretornavel1e5l.jpg', 'Refrigerantes'),
    (115, 'Coca cola Zero 1,5L Pet', 'Não retornável', 8, 0, 'assets/img/theme/cocacolazero1e5lpet.jpg', 'Refrigerantes'),
    (201, 'Pastel com 3 MEDIDAS', 'Escolha três medidas de sabores iguais ou diferentes.', 8, 3, 'assets/img/theme/pastelcom3med.jpg', 'Pasteis'),
    (202, 'Pastel com 7 MEDIDAS BigPastel', 'Escolha Sete medidas de sabores iguais ou diferentes.', 12, 3, 'assets/img/theme/pastelcom7medBigPastel.jpg', 'Pasteis'),
    (203, 'Pastel com 5 MEDIDAS', 'Escolha Cinco medidas de sabores iguais ou diferentes.', 10, 3, 'assets/img/theme/pastelcom5med.jpg', 'Pasteis'),
    (204, 'Pastel Doce', '3 medidas', 8, 0, 'assets/img/theme/pasteldoce.jpg', 'Pasteis'),
    (301, 'Cachorro Quente Gourmet', 'Pão artesanal, salsicha premium, queijo cheddar, cebola caramelizada, molho especial.', 12, 0, 'assets/img/theme/cachorroquentegourmet.jpg', 'CachorrosQuentes'),
    (302, 'Cachorro Quente Tradicional', 'Pão, salsicha, ketchup e mostarda.', 5, 0, 'assets/img/theme/cachorroquentetradicional.jpg', 'CachorrosQuentes'),
    (303, 'hotdog 60cm', 'aklçsdçfj asdçlf', 16.00, NULL, 'assets/img/theme/cachorroquente60cm.jpg', 'CachorrosQuentes'),
    (401, 'Batata Frita Gourmet', 'Porção de batata frita Gourmet.', 6, 0, 'assets/img/theme/batataGourmet.jpg', 'BatataFrita'),
    (402, 'Batata Frita Tradicional', 'Porção de batata frita Tradicional.', 8, 0, 'assets/img/theme/BatataTradicional.jpg', 'BatataFrita'),
    (403, 'Batata Frita Tradicional Grande', 'Porção de batata frita grande.', 8, 0, 'assets/img/theme/BatataTradicionalG.jpg', 'BatataFrita'),
    (501, 'Coxinha', 'Coxinha de frango.', 3.5, 0, 'assets/img/theme/coxinhaDeFrango.jpg', 'Salgados'),
    (502, 'Coxinha grande', 'Coxinha de frango grande.', 5, 0, 'assets/img/theme/coxinhaGrande.jpg', 'Salgados'),
    (503, 'Coxinha de Catupiry', 'Coxinha de Catupiry.', 4, 0, 'assets/img/theme/coxinhaDeCatupiry.jpg', 'Salgados'),
    (504, 'Enroladinho de Salsicha', 'Enroladinho de salsicha.', 2.5, 0, 'assets/img/theme/enroladinhoDeSalsicha.jpg', 'Salgados'),
    (601, 'Esfiha de Carne', 'Esfiha de carne.', 3, 0, 'assets/img/theme/esfihaDeCarne.jpg', 'Salgados'),
    (602, 'Esfiha de Frango', 'Esfiha de frango.', 3, 0, 'assets/img/theme/esfihaDeFrango.jpg', 'Salgados'),
    (603, 'Esfiha de Queijo', 'Esfiha de queijo.', 3, 0, 'assets/img/theme/esfihaDeQueijo.jpg', 'Salgados'),
    (604, 'Esfiha de Calabresa', 'Esfiha de calabresa.', 3, 0, 'assets/img/theme/esfihaDeCalabresa.jpg', 'Salgados'),
    (701, 'Pizza Calabresa', 'Pizza de calabresa com cebola e azeitonas.', 20, 0, 'assets/img/theme/pizzaCalabresa.jpg', 'Pizzas'),
    (702, 'Pizza Marguerita', 'Pizza com molho de tomate, muçarela e manjericão.', 18, 0, 'assets/img/theme/pizzaMarguerita.jpg', 'Pizzas'),
    (703, 'Pizza Frango com Catupiry', 'Pizza de frango com catupiry.', 22, 0, 'assets/img/theme/pizzaFrangoCatupiry.jpg', 'Pizzas'),
    (704, 'Pizza Quatro Queijos', 'Pizza quatro queijos.', 24, 0, 'assets/img/theme/pizza4queijos.jpg', 'Pizzas');

-- Criação da tabela de clientes
CREATE TABLE clientes (
    id INT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL
);

-- Inserção de dados na tabela de clientes
INSERT INTO clientes (id, nome, email, telefone, endereco, senha) VALUES
    (1, 'João Silvaa', 'joao123@email.com', '12389701234', 'Rua A, 123', '123'),
    (2, 'Maria Oliveira', 'maria456@email.com', '987654321', 'Avenida B, 456', '456'),
    (3, 'Carlos Santos', 'carlos789@email.com', '789012345', 'Rua C, 789', '789'),
    (4, 'Ana Souza', 'ana@email.com', '654321098', 'Avenida D, 987', '987');

-- Criação da tabela de pedidos
CREATE TABLE pedidos (
    id INT PRIMARY KEY,
    id_cliente INT,
    data_pedido DATE,
    total_pedido DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id)
);

-- Inserção de dados na tabela de pedidos
INSERT INTO pedidos (id, id_cliente, data_pedido, total_pedido) VALUES
    (1, 1, '2023-11-14', 15.50),
    (2, 2, '2023-11-14', 30.00),
    (3, 3, '2023-11-14', 25.00),
    (4, 4, '2023-11-14', 18.00);

-- Criação da tabela de itens_pedido
CREATE TABLE itens_pedido (
    id_pedido INT,
    id_produto INT,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_pedido) REFERENCES pedidos(id),
    FOREIGN KEY (id_produto) REFERENCES produtos(id),
    PRIMARY KEY (id_pedido, id_produto)
);

-- Inserção de dados na tabela de itens_pedido
INSERT INTO itens_pedido (id_pedido, id_produto, quantidade, preco_unitario) VALUES
    (1, 101, 2, 5.00),
    (1, 201, 1, 8.00),
    (2, 105, 3, 13.50),
    (2, 301, 1, 12.00),
    (3, 502, 2, 10.00),
    (4, 701, 1, 20.00),
    (4, 503, 3, 9.00);
