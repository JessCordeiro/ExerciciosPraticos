package io.cucumber.jessica;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class Petz {

	public  Petz(){
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		 driver= new ChromeDriver();
		 driver.manage().window().maximize();
	}
	
	public WebDriver driver;	
	

	@Quando("eu acesso ao site petz")
	public void eu_acesso_ao_site_petz() {
	    driver.get("https://www.petz.com.br");
	}
	
	@Quando("consulto por {string}")
	public void consulto_por(String string) {
		WebElement input = driver.findElement(By.cssSelector(".inputPesquisa"));
		 input.click();
		 input.sendKeys(string);
		 WebElement input2 = driver.findElement(By.cssSelector(".button-search"));
		 input2.click();
		
	}

	@Quando("clico no terceiro item")
	public void clico_no_terceiro_item() {
		 List<WebElement> lista= new ArrayList();
		 lista = driver.findElements(By.cssSelector(".nome_produto"));
		 WebElement terceiro = lista.get(2);
		 terceiro.click();
		 
		
	}

	@Entao("eu devo ver produto {string}")
	public void eu_devo_ver_produto(String string) throws InterruptedException {
		Thread.sleep(3000);
		WebElement input = driver.findElement(By.cssSelector(".col-md-7.prod-info"));
		assert(input.getText().contains(string));
		
	}

	@Entao("eu devo ver fornecedor {string}")
	public void eu_devo_ver_fornecedor(String string) {
		WebElement input = driver.findElement(By.cssSelector(".blue"));
		assert(input.getText().contains(string));
		
		
	}

	@Entao("eu devo ver preco {string}")
	public void eu_devo_ver_preco(String string) {
		WebElement input = driver.findElement(By.cssSelector(".price-current"));
		assert(input.getText().contains(string));
		
	}

	@Entao("eu devo ver preco assinante {string}")
	public void eu_devo_ver_preco_assinante(String string) {
		WebElement input = driver.findElement(By.cssSelector(".price-subscriber"));
		assert(input.getText().contains(string));
		
	}
	
	@Quando("adiciono ao carrinho de compra")
	public void adiciono_ao_carrinho_de_compra() {
		WebElement input = driver.findElement(By.cssSelector("#adicionarAoCarrinho"));
		 input.click();
		
	}
	

	
	@Entao("eu devo ver preco apos clicar {string}")
	public void eu_devo_ver_preco_apos_clicar(String string) throws InterruptedException {
		Thread.sleep(5000);
		WebElement input = driver.findElement(By.cssSelector(".col-md-9.produtosCarrinho"));
		assert(input.getText().contains(string));
		
	}
	
	@Entao("eu devo ver nome {string}")
	public void eu_devo_ver_nome(String string) throws InterruptedException {
		Thread.sleep(5000);
		WebElement input = driver.findElement(By.cssSelector(".col-md-9.produtosCarrinho"));
		assert(input.getText().contains(string));
		
	}
	
	@After 
	public void aScreenshots(){
		String EvidênciaDeTeste = "./target/surefire-reports/screenshot.png" + Generator.dataHoraParaArquivo() +".png";
		Screenshot.tirar(driver, EvidênciaDeTeste );
	}
	
	

	
	
}
