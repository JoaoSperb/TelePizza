-- usuarios para os clientes
INSERT INTO usuarios (email, senha, perfil) VALUES ('huguinho.pato@email.com', 'HASH_DA_SENHA', 'CLIENTE');
INSERT INTO usuarios (email, senha, perfil) VALUES ('zezinho.pato@email.com', 'HASH_DA_SENHA', 'CLIENTE');
INSERT INTO usuarios (email, senha, perfil) VALUES ('tio_patas@telepizza.com', '$2a$10$rdIZtH2I9DZFsGNs5W3C9.H7HGxRHfO1yfI2jDix2qgtkJR23xFjq', 'ADMINISTRADOR');

-- Inserção dos clientes
INSERT INTO clientes(cpf, nome, celular, endereco, usuario_email) VALUES ('9001', 'Huguinho Pato', '51985744566', 'Rua das Flores, 100', 'huguinho.pato@email.com');
INSERT INTO clientes (cpf, nome, celular, endereco, usuario_email) VALUES ('9002', 'Luizinho Pato', '5199172079', 'Av. Central, 200', 'zezinho.pato@email.com');

-- Inserção dos ingredientes
INSERT INTO ingredientes (id, descricao) VALUES (1, 'Disco de pizza');
INSERT INTO ingredientes (id, descricao) VALUES (2, 'Porcao de tomate');
INSERT INTO ingredientes (id, descricao) VALUES (3, 'Porcao de mussarela');
INSERT INTO ingredientes (id, descricao) VALUES (4, 'Porcao de presunto');
INSERT INTO ingredientes (id, descricao) VALUES (5, 'Porcao de calabresa');
INSERT INTO ingredientes (id, descricao) VALUES (6, 'Molho de tomate (200ml)');
INSERT INTO ingredientes (id, descricao) VALUES (7, 'Porcao de azeitona');
INSERT INTO ingredientes (id, descricao) VALUES (8, 'Porcao de oregano');
INSERT INTO ingredientes (id, descricao) VALUES (9, 'Porcao de cebola');

-- Inserção dos itens de estoque
INSERT INTO itensEstoque (id, quantidade, ingrediente_id) VALUES (1, 30, 1);
INSERT INTO itensEstoque (id, quantidade, ingrediente_id) VALUES (2, 30, 2);
INSERT INTO itensEstoque (id, quantidade, ingrediente_id) VALUES (3, 30, 3);
INSERT INTO itensEstoque (id, quantidade, ingrediente_id) VALUES (4, 30, 4);
INSERT INTO itensEstoque (id, quantidade, ingrediente_id) VALUES (5, 30, 5);
INSERT INTO itensEstoque (id, quantidade, ingrediente_id) VALUES (6, 30, 6);
INSERT INTO itensEstoque (id, quantidade, ingrediente_id) VALUES (7, 30, 7);
INSERT INTO itensEstoque (id, quantidade, ingrediente_id) VALUES (8, 30, 8);
INSERT INTO itensEstoque (id, quantidade, ingrediente_id) VALUES (9, 30, 9);

-- Inserção das receitas 
INSERT INTO receitas (id, titulo) VALUES (1, 'Pizza calabresa');
INSERT INTO receitas (id, titulo) VALUES (2, 'Pizza queijo e presunto');
INSERT INTO receitas (id, titulo) VALUES (3, 'Pizza margherita');

-- Associação dos ingredientes à receita Pizza calabresa
INSERT INTO receita_ingrediente (receita_id, ingrediente_id) VALUES (1, 1); -- Disco de pizza
INSERT INTO receita_ingrediente (receita_id, ingrediente_id) VALUES (1, 6); -- Molho de tomate (200ml)
INSERT INTO receita_ingrediente (receita_id, ingrediente_id) VALUES (1, 3); -- Porcao de mussarela
INSERT INTO receita_ingrediente (receita_id, ingrediente_id) VALUES (1, 5); -- Porcao de calabresa
-- Associação dos ingredientes à receita Pizza queijo e presunto
INSERT INTO receita_ingrediente (receita_id, ingrediente_id) VALUES (2, 1); -- Disco de pizza
INSERT INTO receita_ingrediente (receita_id, ingrediente_id) VALUES (2, 6); -- Molho de tomate (200ml)
INSERT INTO receita_ingrediente (receita_id, ingrediente_id) VALUES (2, 3); -- Porcao de mussarela
INSERT INTO receita_ingrediente (receita_id, ingrediente_id) VALUES (2, 4); -- Porcao de presunto
-- Associação dos ingredientes à receita Pizza margherita
INSERT INTO receita_ingrediente (receita_id, ingrediente_id) VALUES (3, 1); -- Disco de pizza
INSERT INTO receita_ingrediente (receita_id, ingrediente_id) VALUES (3, 6); -- Molho de tomate (200ml)
INSERT INTO receita_ingrediente (receita_id, ingrediente_id) VALUES (3, 3); -- Porcao de mussarela
INSERT INTO receita_ingrediente (receita_id, ingrediente_id) VALUES (3, 8); -- Porcao de cebola

-- insercao dos produtos
INSERT INTO produtos (id,descricao,preco) VALUES (1,'Pizza calabresa',5500);
INSERT INTO produtos (id,descricao,preco) VALUES (2,'Pizza queijo e presunto',6000);
INSERT INTO produtos (id,descricao,preco) VALUES (3,'Pizza margherita',4000);

-- Associação dos produtos com as receitas
INSERT INTO produto_receita (produto_id,receita_id) VALUES(1,1);
INSERT INTO produto_receita (produto_id,receita_id) VALUES(2,2);
INSERT INTO produto_receita (produto_id,receita_id) VALUES(3,3);

--diferentes politicas de desconto
INSERT INTO politicas_desconto (codigo, descricao, corrente) VALUES ('SEM_DESCONTO', 'Sem desconto', true);
INSERT INTO politicas_desconto (codigo, descricao, corrente) VALUES ('FIDELIDADE', 'Desconto por fidelidade', false);
INSERT INTO politicas_desconto (codigo, descricao, corrente) VALUES ('POR_VOLUME', 'Desconto por volume', false);

-- Cardapio inicial corrente para permitir consulta no primeiro boot.
INSERT INTO cardapios (id,titulo,corrente) VALUES(1,'Cardapio de Agosto',TRUE);
INSERT INTO cardapios (id,titulo,corrente) VALUES(2,'Cardapio de Setembro',FALSE);

-- Associação dos cardapios com os produtos
INSERT INTO cardapio_produto (cardapio_id,produto_id) VALUES (1,1);
INSERT INTO cardapio_produto (cardapio_id,produto_id) VALUES (1,2);
INSERT INTO cardapio_produto (cardapio_id,produto_id) VALUES (1,3);

INSERT INTO cardapio_produto (cardapio_id,produto_id) VALUES (2,1);
INSERT INTO cardapio_produto (cardapio_id,produto_id) VALUES (2,3);