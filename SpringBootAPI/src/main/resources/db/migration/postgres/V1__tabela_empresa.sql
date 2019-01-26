CREATE TABLE public.empresa(
  id         	   INTEGER NOT NULL UNIQUE,
  cnpj             CHARACTER VARYING(255) NOT NULL,
  data_atualizacao TIMESTAMP NOT NULL,
  data_criacao 	   TIMESTAMP NOT NULL,
  razao_social     CHARACTER VARYING(255) NOT NULL,
  CONSTRAINT pk_empresa PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
