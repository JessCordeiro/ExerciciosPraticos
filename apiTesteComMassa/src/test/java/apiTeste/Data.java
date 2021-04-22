package apiTeste;


import org.testng.annotations.DataProvider;




public class Data {
	
	@DataProvider(name = "DataForPost")
	public Object[][] dataForPostUsuario() {
		
		return new Object[][] {
			 {"1","anaMaria", "ana", "Maria" },
			 {"2","joseSilva", "José", "Silva" },
			 {"3","robertaM", "Roberta", "Moraes" },
			 {"4","carlaOl", "Carla", "Oliveira" },
			 {"5","brunoSo", "Bruno", "Souza" },
            
	};
	}
	
	
	
	@DataProvider(name = "DataForPostDog")
	public Object[][] dataForPostDog() {
		
		return new Object[][] {
			 {"1", "dog", "Snoop" , "delivered"},
			 {"2", "dog", "Brutus","delivered" },
			 {"3", "dog", "Bethoven","delivered" },
			 {"4", "dog", "Bob","delivered" },
			 {"5", "dog", "Mel","delivered" },
            
	};
	}
	
	@DataProvider(name = "DataForPostCat")
	public Object[][] dataForPostCat() {
		
		return new Object[][] {
			 {"1", "cat", "Felix","approved" },
			 {"2", "cat", "Boris","approved" },
			 {"3", "cat", "Mario","approved" },
			 {"4", "cat", "Doris","approved" },
			 {"5", "cat", "Mel","approved" },
            
	};
	}
	

	
		
	}
	

