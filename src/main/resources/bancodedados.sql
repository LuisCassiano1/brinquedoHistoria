CREATE DATABASE brinquedoHistoria;
USE brinquedoHistoria;

CREATE TABLE tb_brinquedo (
    id_brinquedo BIGINT NOT NULL AUTO_INCREMENT,
    codigo_brinquedo BIGINT NOT NULL,
    nome_brinquedo VARCHAR(100) NOT NULL,
    categoria_brinquedo VARCHAR(100) NOT NULL,
    marca_brinquedo VARCHAR(100) NOT NULL,
    imagem_brinquedo VARCHAR(255),
    valor_brinquedo DOUBLE NOT NULL,
    descricao_brinquedo TEXT,
    PRIMARY KEY (id_Brinquedo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
