Feature: Cadastro de Perfil do AgenteSaude

Esse caso de uso é responsável por fazer o gerenciamento do perfil de um agente de saude.
 
Scenario:  Cadastro de Agente com Sucesso.
Given  Eu sou um agentesaude nao cadastrado.
When  Eu entro com dados de agente de saude validos.
Then  Eu agente recebo uma mensagem de sucesso.

Scenario:  Cadastro de Agente com Erro.
Given  Eu sou um agentesaude nao cadastrado.
When  Eu entro com dados de agente de saude incorretos.
Then  Eu agente recebo uma mensagem de alerta.

Scenario:  Cadastro de Agente Repetido.
Given  Eu sou um agentesaude cadastrado.
When  Eu entro com dados de agente de saude registrados.
Then  Eu agente recebo uma mensagem de alerta informando que ja tenho acesso.

Scenario:  Alteracao de dados do agente.
Given  Eu sou um agentesaude cadastrado.
When  Eu entro com dados de agente de saude  novos.
Then  Eu agente recebo uma mensagem de sucesso informando que os dados foram alterados.

Scenario: Consulta de Informacoes do Agente.
Given  Eu sou um agentesaude cadastrado.
When  Eu entro na tela de informacoes do agente.
Then  Eh exibido uma tela com minhas informacoes de agente de saude.
