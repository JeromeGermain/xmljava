package javaxml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class AfficherCompte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			final String fileName = "animal.xml";
			try {
				SAXBuilder builder = new SAXBuilder();
					File xmlFile = new File(fileName);
					Document jdomDoc = (Document) builder.build(xmlFile);
					
					Element root = jdomDoc.getRootElement();
					List <Element> listOfAnimals = root.getChildren("Animal");
					
					List<Animal> animals = new ArrayList<Animal>();
					for(Element element : listOfAnimals)
					{
						Animal a = new Animal( element.getChildText("nom"),
								               element.getChildText("espece"),
								               Integer.parseInt(element.getChildText("age")),
								               Double.parseDouble(element.getChildText("age"))
											 );
						animals.add(a);						
					}
					for(Animal ani : animals) {
						System.out.println(ani.toString());
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}

	}

}
