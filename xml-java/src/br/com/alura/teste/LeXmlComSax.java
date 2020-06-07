package br.com.alura.teste;

import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.com.alura.handler.ProdutosHandler;

public class LeXmlComSax {
	
	public static void main(String[] args) throws Exception {
		XMLReader leitor = XMLReaderFactory.createXMLReader();
		ProdutosHandler logica = new ProdutosHandler();
		leitor.setContentHandler(logica);
		InputStream ips = new FileInputStream("src/venda.xml");
		InputSource input = new InputSource(ips);
		leitor.parse(input);
		System.out.println(logica.getProdutos());
	}

}
