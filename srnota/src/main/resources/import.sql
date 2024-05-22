--Adicionando dados em tb_escola
INSERT INTO tb_escola(endereco, nome, telefone) VALUES ('rua sem fim', 'Escola Tia Maysa', '032155555555');

--Adicionando dados em tb_curso
INSERT INTO tb_curso(ano, escola_id, nome) VALUES (2024, 1, 'Ensino Fundamental');
INSERT INTO tb_curso(ano, escola_id, nome) VALUES (2024, 1, 'Ensino Médio');

INSERT INTO tb_turma(ano, curso_id, nome) VALUES (2024, 1, '101');
INSERT INTO tb_turma(ano, curso_id, nome) VALUES (2024, 2, '111');

INSERT INTO tb_professor(email, especializacao, nome, telefone) VALUES ('jojotodinho@gmail.com', 'Portugues', 'Jojo', '085698959686');
INSERT INTO tb_professor(email, especializacao, nome, telefone) VALUES ('nicaltodinho@gmail.com', 'Matematica', 'Nicolas', '08569585985');

INSERT INTO tb_disciplina(turma_id, nome) VALUES (1, 'Matematica');
INSERT INTO tb_disciplina(turma_id, nome) VALUES (1, 'Portugues');
INSERT INTO tb_disciplina(turma_id, nome) VALUES (2, 'Matematica');
INSERT INTO tb_disciplina(turma_id, nome) VALUES (2, 'Portugues');


-- Adicionando dados em tb_responsavel
INSERT INTO tb_responsavel(email, nome, telefone) VALUES ('edleuza@gmail.com', 'Edileza Silva', '086523698555');
INSERT INTO tb_responsavel(email, nome, telefone) VALUES ('maria@hotmail.com', 'Maria', '0985656566525');
INSERT INTO tb_responsavel(email, nome, telefone) VALUES ('noha@yahoo.com.br', 'Noel Souza', '08565859856985');


-- Adicionando dados em tb_aluno
INSERT INTO tb_aluno(nome, id_responsavel, data_Nascimento, cpf) VALUES ('Renato Douglas', 1, '1983-05-20', '99999999999');
INSERT INTO tb_aluno(nome, id_responsavel, data_Nascimento, cpf) VALUES ('Maysa Ferras', 2, '1994-06-22', '999992569999');
INSERT INTO tb_aluno(nome, id_responsavel, data_Nascimento, cpf) VALUES ('Nicodemos Souza', 3, '1993-02-20', '999125399');
INSERT INTO tb_aluno(nome, id_responsavel, data_Nascimento, cpf) VALUES ('Matuzalem de Souza', 3, '2003-01-20', '999125399');


-- Adicionando dados em tb_matricula
INSERT INTO tb_matricula(aluno_id, turma_id, matricula) VALUES (1, 1, '202415232');
INSERT INTO tb_matricula(aluno_id, turma_id, matricula) VALUES (2, 1, '202415231');
INSERT INTO tb_matricula(aluno_id, turma_id, matricula) VALUES (3, 1, '202415220');
INSERT INTO tb_matricula(aluno_id, turma_id, matricula) VALUES (4, 2, '202415245');

-- Adicionando dados em tb_nota
INSERT INTO tb_nota(matricula_id, nota) VALUES (1, 8.2);
INSERT INTO tb_nota(matricula_id, nota) VALUES (2, 9.2);
INSERT INTO tb_nota(matricula_id, nota) VALUES (3, 7.2);
INSERT INTO tb_nota(matricula_id, nota) VALUES (4, 6.2);
INSERT INTO tb_nota(matricula_id, nota) VALUES (1, 6.2);
INSERT INTO tb_nota(matricula_id, nota) VALUES (2, 5.2);
INSERT INTO tb_nota(matricula_id, nota) VALUES (3, 4.2);
INSERT INTO tb_nota(matricula_id, nota) VALUES (4, 10);


INSERT INTO tb_turma_professor(professor_id, turma_id) VALUES (1,1);

INSERT INTO tb_turma_professor(professor_id, turma_id) VALUES (1,2);

INSERT INTO tb_turma_professor(professor_id, turma_id) VALUES (2,1);

INSERT INTO tb_turma_professor(professor_id, turma_id) VALUES (2,2);



