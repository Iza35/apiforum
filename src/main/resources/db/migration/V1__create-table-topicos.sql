create table topicos(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(50) NOT NULL,
    mensagem VARCHAR(150),
    datadecriacao DATETIME NOT NULL,
    estadodotopico VARCHAR(50),
    autor VARCHAR(50) NOT NULL,
    curso VARCHAR(50)
);