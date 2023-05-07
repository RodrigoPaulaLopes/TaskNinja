CREATE TABLE tarefas (
   id BIGINT NOT NULL AUTO_INCREMENT primary key,
   nome VARCHAR(100) NOT NULL,
   descricao VARCHAR(255) NOT NULL,
   prazo DATE NOT NULL,
   status VARCHAR(20) NOT NULL,
   prioridade VARCHAR(20) NOT NULL,
   usuario_id bigint not null,
   FOREIGN KEY (usuario_id) REFERENCES usuarios(id)

 );


