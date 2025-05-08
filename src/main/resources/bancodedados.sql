CREATE DATABASE brinquedoHistoria;
USE brinquedoHistoria;

CREATE TABLE tb_brinquedo (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome_brinquedo VARCHAR(100) NOT NULL,
    categoria_brinquedo VARCHAR(100) NOT NULL,
    marca_brinquedo VARCHAR(100) NOT NULL,
    url_imagem VARCHAR(255),
    valor_brinquedo DOUBLE NOT NULL,
    descricao_brinquedo TEXT,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
