Feature: Cadastro de Perfil do Paciente

Esse caso de uso é responsável por fazer o gerenciamento do perfil de um paciente.
 
Scenario:  Cadastro com Sucesso.
Given  Eu sou um paciente nao cadastrado.
When  Eu entro com dados validos.
Then  Eu recebo uma mensagem de sucesso.

Scenario:  Cadastro com Erro.
Given  Eu sou um paciente nao cadastrado.
When  Eu entro com dados incorretos.
Then  Eu recebo uma mensagem de alerta.

Scenario:  Cadastro Repetido.
Given  Eu sou um paciente cadastrado.
When  Eu entro com dados registrados.
Then  Eu recebo uma mensagem de alerta informando que ja tenho acesso.

Scenario:  Alteracao de dados.
Given  Eu sou um paciente cadastrado.
When  Eu entro com dados novos.
Then  Eu recebo uma mensagem de sucesso informando que os dados foram alterados.

Scenario: Consulta de Informacoes do Cadastro
Given  Eu sou um paciente cadastrado.
When  Eu entro na tela de informacoes.
Then  Eu eh exibido uma tela com minhas informacoes
