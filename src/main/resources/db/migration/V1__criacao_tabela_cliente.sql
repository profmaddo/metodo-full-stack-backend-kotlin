CREATE TABLE cliente (
  clienteid BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   nome VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL,
   CONSTRAINT pk_cliente PRIMARY KEY (clienteid)
);