INSERT INTO TBL_CATEGORY (NAME) VALUES ('SP');
INSERT INTO TBL_CATEGORY (NAME) VALUES ('RJ');
INSERT INTO TBL_CATEGORY (NAME) VALUES ('MG');
INSERT INTO TBL_CATEGORY (NAME) VALUES ('RS');
INSERT INTO TBL_CATEGORY (NAME) VALUES ('BA');


INSERT INTO TBL_PESSOA (
    name,
    email,
    telefone,
    datanascimento,
    cpf,
    endereco,
    cidade,
    estado_id,
    cep,
    favorito
) VALUES (
    'Jorge',
    'jorge@email.com',
    '11999999999',
    '1990-01-01',
    '123.456.789-00',
    'Rua A, 123',
    'São Paulo',
    1,
    '01000-000',
    false
);

INSERT INTO TBL_PESSOA (
    name,
    email,
    telefone,
    datanascimento,
    cpf,
    endereco,
    cidade,
    estado_id,
    cep,
    favorito
) VALUES (
    'Ana Maria',
    'ana.maria@email.com',
    '21988887777',
    '1987-09-15',
    '123.456.789-10',
    'Avenida B, 456',
    'Rio de Janeiro',
    2,
    '20000-000',
    false
);