package StepsDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class GoogleSearchSteps {
	
	WebDriver driver;

	@Given("abro el browser")
	public void abro_el_browser() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@And("estoy en la pagina de google")
	public void estoy_en_la_pagina_de_google() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://www.google.com");
	}

	@When("ingreso un texto en la caja de busqueda")
	public void ingreso_un_texto_en_la_caja_de_busqueda() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("q")).sendKeys("Hola Mundo");
	}

	@And("presiono el boton de buscar")
	public void presiono_el_boton_de_buscar() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("q")).submit();
	}

	@Then("google navega a los resultados")
	public void google_navega_a_los_resultados() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals("Hola Mundo - Google Search", driver.getTitle());
	}

	@And("cierro el browser")
	public void cierro_el_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.quit();
	}
}
