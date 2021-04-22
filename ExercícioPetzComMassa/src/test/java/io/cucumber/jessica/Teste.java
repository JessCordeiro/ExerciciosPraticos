package io.cucumber.jessica;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class Teste {

	public List<CsvProdutos> metodo() throws IOException {
		Reader reader = Files.newBufferedReader(Paths.get("massadedados.csv"));

        CsvToBean<CsvProdutos> csvToBean = new CsvToBeanBuilder(reader)
                .withType(CsvProdutos.class)
                .build();

        List<CsvProdutos> produtos = csvToBean.parse();

        for (CsvProdutos produto : produtos)
            System.out.println(produto);
		return produtos;


	}
}
