package br.com.qadecolar.desafio.tests;

import br.com.qadecolar.desafio.core.BaseTest;
import br.com.qadecolar.desafio.pages.GooglePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static br.com.qadecolar.desafio.core.DriverFactory.getDriver;

public class BuscadorGoogleTest extends BaseTest {

    private GooglePage page;

    @Before
    public void inicializar(){
        getDriver().get("https://www.google.com.br/");
        page = new GooglePage();
    }

    @Test
    public void deveRealizarPesquisaBasica() {
        String text = "Teste de software";

        page.buscarTexto(text);

        String result = page.obterPrimeiroResultado();
        Assert.assertTrue(result.contains("Teste"));
        Assert.assertEquals(text,page.obterTextoBuscador());
    }
}
