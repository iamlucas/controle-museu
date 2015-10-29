-- --------------------------------------------------------
-- Servidor:                     mysql.asgardprint.com.br
-- Versão do servidor:           5.6.27-log - Source distribution
-- OS do Servidor:               Linux
-- HeidiSQL Versão:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura do banco de dados para asgardprint01
DROP DATABASE IF EXISTS `asgardprint01`;
CREATE DATABASE IF NOT EXISTS `asgardprint01` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `asgardprint01`;


-- Copiando estrutura para tabela asgardprint01.emprestimo
DROP TABLE IF EXISTS `emprestimo`;
CREATE TABLE IF NOT EXISTS `emprestimo` (
  `emprestimo_id` int(11) NOT NULL AUTO_INCREMENT,
  `obra_id` int(11) DEFAULT NULL,
  `local_emprestimo_id` int(11) DEFAULT NULL,
  `emprestimo_sysdata` datetime DEFAULT CURRENT_TIMESTAMP,
  `emprestimo_locatario` varchar(75) DEFAULT NULL,
  `emprestimo_data_saida` date DEFAULT NULL,
  `emprestimo_previsao_devolucao` date DEFAULT NULL,
  `emprestimo_data_devolucao` date DEFAULT NULL,
  PRIMARY KEY (`emprestimo_id`),
  KEY `obra_id_local_emprestimo_id` (`obra_id`,`local_emprestimo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela asgardprint01.emprestimo: ~1 rows (aproximadamente)
DELETE FROM `emprestimo`;
/*!40000 ALTER TABLE `emprestimo` DISABLE KEYS */;
INSERT INTO `emprestimo` (`emprestimo_id`, `obra_id`, `local_emprestimo_id`, `emprestimo_sysdata`, `emprestimo_locatario`, `emprestimo_data_saida`, `emprestimo_previsao_devolucao`, `emprestimo_data_devolucao`) VALUES
	(1, 1, 1, '2015-10-25 18:47:57', 'Sr. Fatec', '2015-10-30', '2015-11-30', '0000-00-00'),
	(3, 1, 1, '2015-10-25 18:55:11', 'Sr. Fatec', '2015-10-25', '2015-10-25', '2015-10-25');
/*!40000 ALTER TABLE `emprestimo` ENABLE KEYS */;


-- Copiando estrutura para tabela asgardprint01.ingresso
DROP TABLE IF EXISTS `ingresso`;
CREATE TABLE IF NOT EXISTS `ingresso` (
  `ingresso_id` int(11) NOT NULL,
  `ingresso_obra_id` int(11) NOT NULL,
  `ingresso_obra_nome` varchar(75) NOT NULL,
  `ingresso_obra_valor` varchar(11) NOT NULL,
  `ingresso_desconto` varchar(11) NOT NULL,
  `ingresso_pagar_valor` double(11,2) NOT NULL,
  `ingresso_meiaentrada` tinyint(1) NOT NULL,
  `ingresso_gratuito` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela asgardprint01.ingresso: ~0 rows (aproximadamente)
DELETE FROM `ingresso`;
/*!40000 ALTER TABLE `ingresso` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingresso` ENABLE KEYS */;


-- Copiando estrutura para tabela asgardprint01.local_emprestimo
DROP TABLE IF EXISTS `local_emprestimo`;
CREATE TABLE IF NOT EXISTS `local_emprestimo` (
  `local_emprestimo_id` int(11) NOT NULL AUTO_INCREMENT,
  `local_emprestimo_sysdata` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `local_emprestimo_nome` varchar(75) NOT NULL,
  `local_emprestimo_email` varchar(75) NOT NULL,
  `local_emprestimo_telefone` varchar(40) NOT NULL,
  `local_emprestimo_responsavel` varchar(75) NOT NULL,
  `local_emprestimo_cep` varchar(9) NOT NULL,
  `local_emprestimo_tipo_logradouro` varchar(15) NOT NULL DEFAULT 'RUA',
  `local_emprestimo_logradouro` varchar(75) NOT NULL,
  `local_emprestimo_numero` varchar(5) NOT NULL,
  `local_emprestimo_complemento` varchar(40) NOT NULL,
  `local_emprestimo_bairro` varchar(50) NOT NULL,
  `local_emprestimo_cidade` varchar(35) NOT NULL DEFAULT 'São Paulo',
  `local_emprestimo_uf` char(2) NOT NULL DEFAULT 'SP',
  `local_emprestimo_ativo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`local_emprestimo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela asgardprint01.local_emprestimo: ~12 rows (aproximadamente)
DELETE FROM `local_emprestimo`;
/*!40000 ALTER TABLE `local_emprestimo` DISABLE KEYS */;
INSERT INTO `local_emprestimo` (`local_emprestimo_id`, `local_emprestimo_sysdata`, `local_emprestimo_nome`, `local_emprestimo_email`, `local_emprestimo_telefone`, `local_emprestimo_responsavel`, `local_emprestimo_cep`, `local_emprestimo_tipo_logradouro`, `local_emprestimo_logradouro`, `local_emprestimo_numero`, `local_emprestimo_complemento`, `local_emprestimo_bairro`, `local_emprestimo_cidade`, `local_emprestimo_uf`, `local_emprestimo_ativo`) VALUES
	(5, '2015-10-25 16:57:05', 'FATEC Zona Leste', 'teste@fatec.com.br', 'FATEC Zona Leste', 'Sr. Fatec', '03030-100', 'Avenida', 'Aguia de Haia', '', '', 'Arthur Alvim', 'São Paulo', 'SP', 1),
	(6, '2015-10-25 17:00:11', 'FATEC Zona Sul', 'teste@fatec.com.br', '(11) 99999-9999', 'Sr. Fatec', '03030-100', 'Avenida', 'Aguia de Haia', '', '', 'Arthur Alvim', 'São Paulo', 'SP', 1),
	(8, '2015-10-26 23:44:17', 'Fatex Legal 2', 'fatter@fatec.com', '(99) 9999-99999', 'Cyrax', '11101-001', 'Avenida', 'dos fatecanos', '919', 'Casa', 'Jardim Estudantil', 'São Paulo', 'SP', 1),
	(9, '2015-10-26 23:44:17', 'Fatec Zona', 'fatter@fatec.com', '(99) 9999-99999', 'Cyrax', '11101-001', 'Avenida', 'dos fatecanos', '919', 'Casa', 'Jardim Estudantil', 'São Paulo', 'SP', 1),
	(10, '2015-10-26 23:44:17', 'Fatec Especial', 'fatter@fatec.com', '(99) 9999-99999', 'Cyrax', '11101-001', 'Rua', 'dos fatecanos', '919', 'Casa', 'Jardim Estudantil', 'São Paulo', 'SP', 1),
	(11, '2015-10-26 23:44:17', 'Fatec ADS', 'fatter@fatec.com', '(99) 9999-99999', 'Cyrax', '11101-001', 'Avenida', 'dos fatecanos', '919', 'Casa', 'Jardim Estudantil', 'São Paulo', 'SP', 1),
	(12, '2015-10-26 23:44:17', 'FateX 10', 'fatter@fatec.com', '(99) 9999-99999', 'Cyrax', '11101-001', 'Avenida', 'dos fatecanos', '919', 'Casa', 'Jardim Estudantil', 'São Paulo', 'SP', 1),
	(13, '2015-10-26 23:44:17', 'FateX 15', 'fatter@fatec.com', '(99) 9999-99999', 'Cyrax', '11101-001', 'Avenida', 'dos fatecanos', '919', 'Casa', 'Jardim Estudantil', 'São Paulo', 'SP', 1),
	(15, '2015-10-26 23:59:43', '15000 Fatec Local', 'fatter@fatec.com', '(99) 9999-99999', 'Cyrax', '11101-001', 'Avenida', 'dos fatecanos', '919', 'Casa', 'Jardim Estudantil', 'São Paulo', 'SP', 1),
	(16, '2015-10-26 23:44:17', 'Fatec ADS', 'fatter@fatec.com', '(99) 9999-99999', 'Cyrax', '11101-001', 'Avenida', 'dos fatecanos', '919', 'Casa', 'Jardim Estudantil', 'São Paulo', 'SP', 1),
	(17, '2015-10-26 23:59:43', '77000 Fatec Local', 'fatter@fatec.com', '(99) 9999-99999', 'Cyrax', '11101-001', 'Avenida', 'dos fatecanos', '919', 'Casa', 'Jardim Estudantil', 'São Paulo', 'SP', 1),
	(18, '2015-10-26 23:59:43', '1131000 Fatec Local', 'fatter@fatec.com', '(99) 9999-99999', 'Cyrax', '11101-001', 'Avenida', 'dos fatecanos', '919', 'Casa', 'Jardim Estudantil', 'São Paulo', 'SP', 1),
	(19, '2015-10-26 23:59:43', '1131 Fatec Local', 'fatter@fatec.com', '(99) 9999-99999', 'Cyrax', '11101-001', 'Avenida', 'dos fatecanos', '919', 'Casa', 'Jardim Estudantil', 'São Paulo', 'SP', 1),
	(20, '2015-10-29 01:09:30', 'Local de Emprestimo do Rafael', 'rafael@fatec.com.br', '(11) 9191-91919', 'Rafael', '03030-303', 'Avenida', 'do Oratório', '9999a', 'Casa', 'Jardim dos Formulários', 'São Paulo', 'SP', 1);
/*!40000 ALTER TABLE `local_emprestimo` ENABLE KEYS */;


-- Copiando estrutura para tabela asgardprint01.obra
DROP TABLE IF EXISTS `obra`;
CREATE TABLE IF NOT EXISTS `obra` (
  `obra_id` int(11) NOT NULL AUTO_INCREMENT,
  `obra_sysdata` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `obra_nome` varchar(75) NOT NULL,
  `obra_autor` varchar(75) NOT NULL,
  `obra_data` date NOT NULL,
  `obra_biografia` text NOT NULL,
  `obra_tipo` varchar(40) NOT NULL,
  `obra_categoria` varchar(40) NOT NULL,
  `obra_localizacao` varchar(75) NOT NULL,
  `obra_disponibilidade` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`obra_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela asgardprint01.obra: ~4 rows (aproximadamente)
DELETE FROM `obra`;
/*!40000 ALTER TABLE `obra` DISABLE KEYS */;
INSERT INTO `obra` (`obra_id`, `obra_sysdata`, `obra_nome`, `obra_autor`, `obra_data`, `obra_biografia`, `obra_tipo`, `obra_categoria`, `obra_localizacao`, `obra_disponibilidade`) VALUES
	(1, '2015-10-27 17:45:56', '2', '2', '2015-10-27', '2', '2', '2', '2', 0),
	(2, '2015-10-27 18:24:03', 'Rafael', 'Obra Legal', '2010-10-10', 'epa lele			', 'Pintura', 'Moderna', 'Salao Principal', 1),
	(3, '2015-10-29 17:16:32', 'Opan', 'eita', '2010-10-10', 'Legl', 'Pintura', 'Barroca', 'Salao Principal', 1),
	(4, '2015-10-29 17:18:55', 'Teste 3', 'teste', '2010-10-10', 'legal legal', 'Pintura', 'Barroca', 'Salao Principal', 1);
/*!40000 ALTER TABLE `obra` ENABLE KEYS */;


-- Copiando estrutura para tabela asgardprint01.visitante
DROP TABLE IF EXISTS `visitante`;
CREATE TABLE IF NOT EXISTS `visitante` (
  `visitante_id` int(11) NOT NULL AUTO_INCREMENT,
  `visitante_sysdata` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `visitante_cpf` varchar(14) NOT NULL DEFAULT '',
  `visitante_nacionalidade` varchar(50) NOT NULL,
  `visitante_idade` int(3) NOT NULL DEFAULT '0',
  `visitante_sexo` varchar(10) NOT NULL,
  `visitante_grau_instrucao` varchar(40) NOT NULL,
  `visitante_meio_transporte` varchar(40) NOT NULL,
  `visitante_ativo` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`visitante_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela asgardprint01.visitante: ~2 rows (aproximadamente)
DELETE FROM `visitante`;
/*!40000 ALTER TABLE `visitante` DISABLE KEYS */;
INSERT INTO `visitante` (`visitante_id`, `visitante_sysdata`, `visitante_cpf`, `visitante_nacionalidade`, `visitante_idade`, `visitante_sexo`, `visitante_grau_instrucao`, `visitante_meio_transporte`, `visitante_ativo`) VALUES
	(3, '2015-10-29 17:13:01', '111.111.111-11', 'Outros', 100, 'Masculino', 'Analfabeto', 'Coletivo privado', 1),
	(4, '2015-10-29 17:13:14', '222.222.222-22', 'Outros', 20, 'Feminino', 'Fundamental completo', 'Próprio', 1);
/*!40000 ALTER TABLE `visitante` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
