Feature: Cadastro de Enderecos

Esse caso de uso é responsável por fazer o gerenciamento dos enderecos

Scenario: Cadastro com Sucesso
Given Um endereco nao cadastrado
When Entro com dados validos
Then Recebo uma mensagem de sucesso

Scenario: Cadastro com erro
Given Um endereco nao cadastrado
When Entro com dados invalidos
Then Recebo uma mensagem de erro nos dados

Scenario: Alteracao de dados
Given Um endereco cadastrado
When Entro com dados novos
Then Recebo uma mensagem informando que os dados foram alterados

Scenario: Consulta de Informacoes de endereco
Given Um endereco cadastrado
When  Entro na tela de informacoes
Then  E exibido as informacoes do endereco

Scenario: Excluir endereco
Given Um endereco cadastrado
When Seleciono a opcao para excluir
Then Recebo uma mensagem informando que o endereco foi excluido