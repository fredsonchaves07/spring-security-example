CREATE TABLE IF NOT EXISTS users
(
    id          varchar primary key,
    name        varchar(255) NOT NULL,
    username    varchar(255) NOT NULL,
    password    varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS products
(
    id           varchar primary key,
    name         varchar(255) NOT NULL,
    description  varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS roles
(
    id          varchar primary key,
    name        varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS users_roles
(
    user_id     varchar REFERENCES users (id) ON UPDATE CASCADE ON DELETE CASCADE,
    role_id     varchar REFERENCES roles (id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT  users_roles_pkey PRIMARY KEY (user_id, role_id)
);

INSERT INTO roles (id, name)
VALUES ('81e47e1c-a566-11ec-b909-0242ac120002', 'USER');

INSERT INTO roles (id, name)
VALUES ('b60974bc-7fe1-44c9-a874-cd989b961ec9', 'ADMIN');

INSERT INTO PRODUCTS(id, name, description) VALUES ('d2cae6f5-736f-4ae1-addc-99e26a5426e3','Camiseta', 'Camiseta branca masculina');
INSERT INTO PRODUCTS(id, name, description) VALUES ('3d5b5c38-9995-4d55-8167-92b0d6a37eca','Calça', 'Calça skinny feminina');
INSERT INTO PRODUCTS(id, name, description) VALUES ('34d71e45-54fc-45ce-a783-be39f8bf7982', 'Vestido', 'Vestido longo rosa');