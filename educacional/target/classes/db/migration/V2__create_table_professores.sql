CREATE TABLE professores (
    id Int not null AUTO_INCREMENT PRIMARY KEY,
    nome Varchar(100) not null,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefone VARCHAR(15),
    especialidade VARCHAR(100)
);