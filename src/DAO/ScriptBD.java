//   a-Entregue o script de criação do BD.
//
//
//CREATE TABLE ferramentas (
//  id INT AUTO_INCREMENT PRIMARY KEY,
//  nome VARCHAR(255) NOT NULL,
//  marca VARCHAR(255) NOT NULL,
//  custo DECIMAL(10, 2) NOT NULL
//);
//
//
//CREATE TABLE amigos (
//  id INT AUTO_INCREMENT PRIMARY KEY,
//  nome VARCHAR(255) NOT NULL,
//  telefone VARCHAR(20) NOT NULL
//);
//
//CREATE TABLE emprestimos (
//  id INT AUTO_INCREMENT PRIMARY KEY,
//  amigo_id INT NOT NULL,
//  ferramenta_id INT NOT NULL,
//  data_emprestimo DATE NOT NULL,
//  data_devolucao DATE,
//  FOREIGN KEY (amigo_id) REFERENCES amigos(id),
//  FOREIGN KEY (ferramenta_id) REFERENCES ferramentas(id)
//);
//
//	b- Faça e entregue os scripts de inserção de dados, no mínimo 2 linhas para cada tabela. 
//
//
//
//INSERT INTO ferramentas (nome, marca, custo) VALUES
//  ('Martelo', 'Marca A', 19.99),
//  ('Chave de Fenda', 'Marca B', 9.99),
//  ('Serra Elétrica', 'Marca C', 129.99);
//
//
//INSERT INTO amigos (nome, telefone) VALUES
//  ('João', '1234567890'),
//  ('Maria', '9876543210'),
//  ('Pedro', '5555555555');
//
//
//INSERT INTO emprestimos (amigo_id, ferramenta_id, data_emprestimo, data_devolucao) VALUES
//  (1, 1, '2023-05-10', '2023-05-15'),
//  (1, 2, '2023-05-12', NULL),
//  (2, 3, '2023-05-14', NULL);

