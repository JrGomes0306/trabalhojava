CREATE TABLE alunos (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    email VARCHAR(100),
    matricula VARCHAR(20) UNIQUE,
    data_nascimento DATE
);
