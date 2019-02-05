CREATE TABLE public.usuario(
  id         	   INTEGER NOT NULL UNIQUE,
  email            CHARACTER VARYING(255) NOT NULL,
  senha            CHARACTER VARYING(255) NOT NULL,
  perfil            CHARACTER VARYING(255) NOT NULL,
  data_atualizacao TIMESTAMP NOT NULL,
  data_criacao 	   TIMESTAMP NOT NULL,
  CONSTRAINT pk_usuario PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);