package io.cucumber.jessica;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;


public class PetzComMassa extends Teste{
	

	Teste ler = new Teste();
	
	
	public  PetzComMassa(){
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
	

	  
	  @Entao("devo ver os dados")
		public void devo_ver_os_dados() throws InterruptedException, IOException {
	
	  List<WebElement> lista= new ArrayList();
	  List<String> produtosSite = new ArrayList();
	  lista = driver.findElements(By.cssSelector(".nome_produto"));
	  for(WebElement e:lista) {
		
	  	  System.out.println(e.getText());
	  	produtosSite.add(e.getText());
	  	

	  }
	List<CsvProdutos> CSV = new ArrayList();
	List<String> produtosCSV = new ArrayList();
	CSV = ler.metodo();
	Object x;
	for(CsvProdutos x1:CSV) {
		produtosCSV.add(x1.toString());
	}
	
	
	  assertEquals(false,produtosCSV.contains(produtosSite));
	  	
	  }
}
	  
		
	
		
		 
		 
		
	





	


