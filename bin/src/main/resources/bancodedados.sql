Create database brinquedoHistoria;
use database brinquedoHistoria;
CREATE TABLE tb_brinquedo (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome_produto VARCHAR(100) NOT NULL,
    descricao_produto TEXT,
    valor_produto DOUBLE NOT NULL,
    avaliacao_produto INT,
    url_imagem VARCHAR(255),
    quantidade BIGINT,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE usuario (
        id BIGINT PRIMARY KEY AUTO_INCREMENT,
        nome_usuario VARCHAR(100) NOT NULL,
        email TEXT,
        telefone varchar(15),
        senha varchar(100)
        )