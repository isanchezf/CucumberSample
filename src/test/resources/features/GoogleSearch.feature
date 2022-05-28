Feature: prueba de busqueda en google
  
  Yo como usuario de google deseo poder buscar temas de interes

  Scenario: Validar que google esta trabajando
    Given abro el browser
    And estoy en la pagina de google
    When ingreso un texto en la caja de busqueda
    And presiono el boton de buscar
    Then google navega a los resultados
    And cierro el browser
  