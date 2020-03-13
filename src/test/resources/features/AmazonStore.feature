@AmazonStore
Feature: AmazonStore
  Como un cliente
  Yo quiero buscar un producto especifico en Amazon
  Para finalmente comprarlo


  Scenario: Búsqueda en Amazon de un producto específico
    Given Yo visito el sitio web de "https://www.amazon.com/"
    When ingreso el valor de "ipad" en la caja de busqueda
    And doy click en el boton buscar
    Then Yo deberia visualizar "ipad" en los resultados de mi busqueda


  Scenario Outline: Cambiar el idioma  a una pagina en Amazon
    Given Yo visito el sitio web de "https://www.amazon.com/"
    When Yo selecciono la lista de idiomas
    And doy click en el idioma "<idioma>"
    Then Yo deberia visualizar "<mensaje>" en la pantalla
    Examples:
      | idioma    | mensaje        |
      | ingles    | Today's Deals  |
      | portugues | Ofertas do Dia |