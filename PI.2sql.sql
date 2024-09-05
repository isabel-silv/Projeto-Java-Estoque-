use PI;
CREATE TABLE `funcionario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `id_permissao` int NOT NULL,
  PRIMARY KEY (`id`)
  );
  CREATE TABLE `produto` (

`codigo` int DEFAULT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `valor` decimal(5,2) DEFAULT NULL,
  `quantidadeEstoque` int DEFAULT NULL,
  `data` date DEFAULT NULL,
   `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
  );
  
  INSERT INTO `funcionario` VALUES (1,'Jorge','senha123',1),(2,'camila','senha123',2),(3,'pedro','senha123',3);


