package org.example.stepdefs;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.fw.ParentScenario;
import org.junit.Assert;

public class AmazonStoreStepDefinitions extends ParentScenario {

    @Given("Yo visito el sitio web de {string}")
    public void yoVisitoElSitioWebDe(String url) {
        startChrome();
        landingPage.gotoUrl(url);
        System.out.println("La pagina ha cargado correctamente");
    }

    @When("ingreso el valor de {string} en la caja de busqueda")
    public void ingresoElValorDeEnLaCajaDeBusqueda(String product) {
        landingPage.writeProduct(product);
        System.out.println("El nombre del producto fue escrito correctamente "+product);
    }

    @And("doy click en el boton buscar")
    public void doyClickEnElBotonBuscar() {
        landingPage.clickBtnSearch();
        System.out.println("Se dió click correctamente en el botón de búsqueda");
    }

    @Then("Yo deberia visualizar {string} en los resultados de mi busqueda")
    public void yoDeberiaVisualizarEnLosResultadosDeMiBusqueda(String result) {
        String textResultActual = landingPage.getTextResult();
        String textResultExpected ="\""+result+"\"";
        Assert.assertEquals(textResultExpected,textResultActual);
        System.out.println("El resultado se visualizó correctamente: "+textResultActual);
        closeDriver();
    }

    @When("Yo selecciono la lista de idiomas")
    public void yoSeleccionoLaListaDeIdiomas() {
        landingPage.toSelectListLanguage();
        System.out.println("Se selecciono la lista de idiomas correctamente");
    }

    @And("doy click en el idioma {string}")
    public void doyClickEnElIdioma(String idioma) {
        landingPage.clickRbtnLangEng(idioma);
        System.out.println("Se selecciono el idioma "+idioma+ "correctamente");
    }

    @Then("Yo deberia visualizar {string} en la pantalla")
    public void yoDeberiaVisualizarEnLaPantalla(String textExpected) {
        Assert.assertEquals(textExpected,landingPage.getTextToday());
        System.out.println("El resultado se visualizó correctamente: "+textExpected);
        closeDriver();
    }
 }