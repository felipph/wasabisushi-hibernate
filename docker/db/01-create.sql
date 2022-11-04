USE wasabisushi;

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `cpf` varchar(45) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  `n_cartao` varchar(45) NOT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `produto`;
CREATE TABLE `produto` (
  `idProduto` int NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `preco` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProduto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `pedido`;
CREATE TABLE `pedido` (
  `idPedido` int NOT NULL,
  `idCliente` int NOT NULL,
  `idProduto` int NOT NULL,
  `valorTotal` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPedido`),
  KEY `idCliente_idx` (`idCliente`),
  KEY `idProduto_idx` (`idProduto`),
  CONSTRAINT `idCliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `idProduto` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`idProduto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

GRANT ALL ON *.* TO 'root'@'%';