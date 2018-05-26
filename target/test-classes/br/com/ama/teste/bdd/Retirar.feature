Feature: Retirar dinheiro

Este caso de uso é responsável por apresentar os cenários 
que envolve a retirada de dinheiro de uma conta

  Scenario: Saldo positivo
    Given cliente tem 100 reais na conta
    When cliente solicitar a retirada de 100 reais
    Then o sistema aprova a retirada
    And o saldo atual é de 0 reais

  Scenario: Negação para retirar
    Given cliente tem 100 reais na conta
    When cliente solicitar a retirada de 200 reais
    Then o sistema não aprova a retirada
    And o saldo atual é de 100 reais
