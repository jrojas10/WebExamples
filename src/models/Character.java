package models;

public class Character {
static int count = 0;
int id;
int number;
String name;

//public Character(String nameIn, int num) {
//	this.id= count++;
//	this.name = nameIn;
//	this.number = num;
//}
public Character() {
	this.id= count++;
	this.name = name;
	this.number = number;
}

public Integer getId() {
	return id;
}



public int getNumber() {
	return number;
}

public void setNumber(int numberOfPictures) {
	this.number = numberOfPictures;
}

public String getName() {
	return name;
}
public String getUnderscore() {
	String underscore = name.replaceAll(" ","_").toLowerCase(); 
	return underscore;
}

public void setName(String name) {
	this.name = name;
}
}
