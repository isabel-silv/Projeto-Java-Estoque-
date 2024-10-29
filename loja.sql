USE loja;
CREATE TABLE usuario (
  `usuario` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
   `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
  );
  
  CREATE TABLE `produtos` (
`codigo` int DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `valor` decimal(5,2) DEFAULT NULL,
  `quantidadeEstoque` int DEFAULT NULL,
  `data` varchar(255) DEFAULT NULL,
   `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
  );