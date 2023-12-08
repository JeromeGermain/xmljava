package javaxml;


import java.io.FileWriter;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Document doc = new Document();
			doc.setRootElement(new Element("Animals"));
			
			Animal a1 = new Animal("canard","canard de barbarie",2,2);
			Animal a2 = new Animal("Serge","Alpaga",2,2);
			
			doc.getRootElement().addContent(createAnimalXMLElement(a1));
			doc.getRootElement().addContent(createAnimalXMLElement(a2));
			
			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter("animal.xml"));
			System.out.println("File save");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			
		}
		
	}
	
	private static Element createAnimalXMLElement(Animal animal)
	{
		Element animalElement = new Element("Animal");
		animalElement.addContent(new Element("nom").setText(animal.getNom()));
		animalElement.addContent(new Element("espece").setText(animal.getEspece()));
		animalElement.addContent(new Element("age").setText(""+animal.getAge()));
		animalElement.addContent(new Element("poids").setText(""+animal.getPoids()));
		return animalElement;
	}

}
