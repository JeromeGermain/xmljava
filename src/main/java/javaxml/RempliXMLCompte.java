package javaxml;

import java.io.FileWriter;
import java.time.LocalDate;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class RempliXMLCompte {

	public static void main(String[] args) {
		final String fileName = "compteBancaire.xml";
		try {
			Document doc = new Document();
			doc.setRootElement(new Element(fileName));

			CompteBancaire c1 = new CompteBancaire(001,"Jean Massiet",2000., LocalDate.of(2023, 10, 10),"Epargne" );
			CompteBancaire c2 = new CompteBancaire(002,"Jean-Baptise Shaw",21000., LocalDate.of(2021, 11, 1),"Courant" );

			doc.getRootElement().addContent(createAnimalXMLElement(c1));
			doc.getRootElement().addContent(createAnimalXMLElement(c2));

			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter(fileName));
			System.out.println("File save");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally{

		}

	}

	private static Element createAnimalXMLElement(CompteBancaire cpt)
	{
		Element animalElement = new Element("compteBancaire");
		animalElement.addContent(new Element("numCompte").setText(""+cpt.getNumCompte()));
		animalElement.addContent(new Element("nomProprietaire").setText(cpt.getNomProprietaire()));
		animalElement.addContent(new Element("solde").setText(""+cpt.getSolde()));
		animalElement.addContent(new Element("date").setText(""+cpt.getDate()));
		animalElement.addContent(new Element("typeCompte").setText(cpt.getTypeCompte()));
		return animalElement;
	}

}


