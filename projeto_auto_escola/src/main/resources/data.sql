INSERT INTO usuario (nome, email, senha) values ('Administrador','admin@uea.edu.br','{bcrypt}$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
INSERT INTO usuario (nome, email, senha) values ('Maria Silva','maria@uea.edu.br','{bcrypt}$2a$10$Zc3w6HyuPOPXamaMhh.PQOXvDnEsadztbfi6/RyZWJDzimE8WQjaq');

INSERT INTO permissao (descricao) values ('ROLE_CADASTRAR_INSTRUTOR');
INSERT INTO permissao (descricao) values ('ROLE_PESQUISAR_INSTRUTOR');
INSERT INTO permissao (descricao) values ('ROLE_ATUALIZAR_INSTRUTOR');
INSERT INTO permissao (descricao) values ('ROLE_REMOVER_INSTRUTOR');

INSERT INTO permissao (descricao) values ('ROLE_CADASTRAR_ALUNO');
INSERT INTO permissao (descricao) values ('ROLE_PESQUISAR_ALUNO');
INSERT INTO permissao (descricao) values ('ROLE_ATUALIZAR_ALUNO');
INSERT INTO permissao (descricao) values ('ROLE_REMOVER_ALUNO');

INSERT INTO permissao (descricao) values ('ROLE_CADASTRAR_AULA');
INSERT INTO permissao (descricao) values ('ROLE_PESQUISAR_AULA');
INSERT INTO permissao (descricao) values ('ROLE_ATUALIZAR_AULA');
INSERT INTO permissao (descricao) values ('ROLE_REMOVER_AULA');

INSERT INTO permissao (descricao) values ('ROLE_CADASTRAR_USUARIO');
INSERT INTO permissao (descricao) values ('ROLE_PESQUISAR_USUARIO');
INSERT INTO permissao (descricao) values ('ROLE_ATUALIZAR_USUARIO');
INSERT INTO permissao (descricao) values ('ROLE_REMOVER_USUARIO');

INSERT INTO permissao (descricao) values ('ROLE_CADASTRAR_PERMISSAO');
INSERT INTO permissao (descricao) values ('ROLE_PESQUISAR_PERMISSAO');
INSERT INTO permissao (descricao) values ('ROLE_ATUALIZAR_PERMISSAO');
INSERT INTO permissao (descricao) values ('ROLE_REMOVER_PERMISSAO');
