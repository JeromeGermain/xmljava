package javaxml;

public class Animal {
	private String nom;
	private String espece;
	private int age;
	private double poids;
	
	
	
	public Animal(String nom, String espece, int age, double poids) {
		super();
		this.nom = nom;
		this.espece = espece;
		this.age = age;
		this.poids = poids;
	}
	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getEspece() {
		return espece;
	}



	public void setEspece(String espece) {
		this.espece = espece;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public double getPoids() {
		return poids;
	}



	public void setPoids(double poids) {
		this.poids = poids;
	}



	@Override
	public String toString() {
		return "Animal [nom=" + nom + ", espece=" + espece + ", age=" + age + ", poids=" + poids + "]";
	}
	
	
}
