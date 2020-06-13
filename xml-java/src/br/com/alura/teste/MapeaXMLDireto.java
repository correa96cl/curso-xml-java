package br.com.alura.teste;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.alura.model.Produto;
import br.com.alura.model.Venda;

public class MapeaXMLDireto {
	
	
	public static void main(String[] args) throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(Venda.class);
	
		
		xmlParaObjeto(jaxbContext);
		
		//objetoParaXml(jaxbContext);
	}

	private static void objetoParaXml(JAXBContext jaxbContext) throws Exception {
		Marshaller createMarshaller = jaxbContext.createMarshaller();
		Venda venda = new Venda();
		venda.setFormaDePagamento("Crediario");
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(new Produto("Livro de Vue", 59.90));
		produtos.add(new Produto("Livro de React", 49.90));
		produtos.add(new Produto("Livro de Node", 39.90));
		venda.setProdutos(produtos);
		StringWriter writer = new StringWriter();
		createMarshaller.marshal(venda, writer);
		System.out.println(writer.toString());
		
	}

	private static void xmlParaObjeto(JAXBContext jaxbContext) throws Exception {
	Unmarshaller createUnmarshaller = jaxbContext.createUnmarshaller();
		
		Venda venda = (Venda) createUnmarshaller.unmarshal(new File("src/venda.xml"));
		
		System.out.println(venda);
		
	}

}
