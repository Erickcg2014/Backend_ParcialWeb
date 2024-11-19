CREATE TABLE Contrato (
    id BIGSERIAL PRIMARY KEY,
    identificador VARCHAR(255) NOT NULL UNIQUE,
    valor DOUBLE PRECISION,
    nombre_contratante VARCHAR(255) NOT NULL,
    documento_contratante VARCHAR(255),
    nombre_contratantista VARCHAR(255),
    documento_contratantista VARCHAR(255),
    fecha_inicial DATE,
    fecha_final DATE
);
