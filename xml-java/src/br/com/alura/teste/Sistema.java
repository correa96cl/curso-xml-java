package br.com.alura.teste;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.alura.model.Produto;

public class Sistema {
	
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder newDocumentBuilder = fabrica.newDocumentBuilder();
		Document parse = newDocumentBuilder.parse("src/venda.xml");
		
		Element venda = parse.getDocumentElement();
		String moeda = venda.getAttribute("moeda");
		System.out.println(moeda);
		NodeList produtos = parse.getElementsByTagName("produto");
		
		for (int i = 0; i < produtos.getLength(); i++) {
			Element produto = (Element) produtos.item(i);
			
			String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
			double preco = Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent());
			Produto prod = new Produto(nome, preco);
			System.out.println(prod);
			
		}
		
	}

}
