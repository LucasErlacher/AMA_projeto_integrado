Feature: Depositar Saldo

Este caso de uso é responsável por apresentar os cenários 
que envolve a apresentação do saldo do cliente em uma conta bancaria

  Scenario: depositar dinheiro
    Given cliente informa conta, senha e agencia valida
    And o cliente possui 100 reais em conta
    When cliente depositar 20 reais 
    Then o sistema informa que a operação foi um sucesso
    And a conta do cliente está com salda de 120 reais

  Scenario: depositar envelope vazio
    Given cliente informa conta, agencia valida
    And o cliente informa que há 100 reais no envelope
    But não há nenhum dinheiro no envelope
    When cliente solicita o deposito do envelope 
    Then o sistema informa que não há dinheiro no envelope.
    And o Saldo não é modificado