Feature: Cadastro de Consultas 

Esse caso de uso é responsável por fazer o gerenciamento das consultas de um paciente.
 
Scenario:  Cadastro de Consulta com Sucesso.
Given  Eu sou um paciente cadastrado.
When  Eu seleciono uma consulta.
Then  Eu recebo uma mensagem de sucesso informando o agendamento da consulta.

Scenario:  Cadastro de Consulta com Conflito.
Given  Eu sou um paciente cadastrado.
When  Eu seleciono uma consulta.
Then  Eu recebo uma mensagem de alerta me informando que ja tenho uma consulta para esse mesmo dia e hora.

Scenario:  Cancelamento de Consulta.
Given  Eu sou um paciente cadastrado e tenho uma consulta marcada.
When  Eu excluo uma consulta.
Then  Eu recebo uma mensagem de sucesso informando que a consulta foi desmarcada.

Scenario: Consulta de Informacoes das consultas
Given  Eu sou um paciente cadastrado e tenho uma consulta marcada.
When  Eu entro na tela de informacoes.
Then  Eu eh exibido uma tela com minhas informacoes referente as consultas marcadas.
