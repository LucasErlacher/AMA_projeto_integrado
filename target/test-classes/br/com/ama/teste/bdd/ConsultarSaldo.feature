Feature: Consultar Saldo

Este caso de uso é responsável por apresentar os cenários 
que envolve a apresentação do saldo do cliente em uma conta bancaria

  Scenario: Informaçoes validas
    Given cliente informa conta, senha e agencia valida
    When cliente solicitar o saldo
    Then o sistema informa o saldo

  Scenario: Informaçoes invalidas
    Given cliente informa conta, senha ou agencia invalida
    When cliente solicitar o saldo
    Then o sistema informa um erro