CREATE TABLE USERS (
        ID INTEGER PRIMARY KEY AUTO_INCREMENT,  -- Coluna ID é a chave primária, do tipo INTEGER, e será auto-incrementada automaticamente pelo banco de dados.
        NAME VARCHAR(255),                     -- Coluna NAME armazena o nome do usuário, com um máximo de 255 caracteres.
        EMAIL VARCHAR(255),
        PASSWORD VARCHAR(255),
        CPF_CNPJ VARCHAR(255),
        IS_ACTIVE BOOLEAN DEFAULT TRUE
);

CREATE TABLE PRODUTOS (
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(255),
    QTDE INTEGER,
    PRECO DOUBLE
);

CREATE TABLE PEDIDOS(
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    USER_ID INTEGER REFERENCES USERS(ID),
    PRODUTO_ID INTEGER REFERENCES PRODUTOS(ID),
    QTDE INTEGER,
    PRECO DOUBLE
);
