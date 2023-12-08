package javaxml;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class AfficherCompte {

	public static void main(String[] args) {
		final String fileName = "compteBancaire.xml";
		try {
			SAXBuilder builder = new SAXBuilder();
			File xmlFile = new File(fileName);
			Document jdomDoc = (Document) builder.build(xmlFile);

			Element root = jdomDoc.getRootElement();
			List <Element> listeComptes = root.getChildren("compteBancaire");

			List<CompteBancaire> comptes = new ArrayList<CompteBancaire>();
			for(Element element : listeComptes)
			{
				CompteBancaire a = new CompteBancaire( Integer.parseInt(element.getChildText("numCompte")),
											   element.getChildText("nomProprietaire"),
	                       					   Double.parseDouble(element.getChildText("solde")),
	                       					   LocalDate.parse(element.getChildText("date")),
	                       					   element.getChildText("typeCompte")
						);
				comptes.add(a);						
			}
			for(CompteBancaire cpt : comptes) {
				System.out.println(cpt.toString());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	} 
}
