package models;
import java.util.Random;
public class Simpson {
	static int count = 0;
	int id;
	int number;
	String name;

public Simpson() {
	this.id= count++;
	this.name = name;
	this.number = number;
	
	}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getNumber() {
	return number;
}

public void setNumber(int number) {
	this.number = number;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
public String getUnderscore() {
	String underscore = name.replaceAll(" ","_").toLowerCase(); 
	return underscore;
}

public String getRandom() {
	Random r = new Random();
	boolean hasMore = false;
	int randomPic = r.nextInt(this.number);
	if (this.number>0)
		hasMore = true;
	
	String picNum= Integer.toString(randomPic);
	if(picNum.length() != 4) {
		if(picNum.length()==1 && hasMore==true) 
			picNum = "000"+picNum;
		else if(picNum.length()==2 && hasMore==true)
			picNum = "00"+picNum;
		else if(picNum.length()==3 && hasMore==true)
			picNum = "0"+picNum;
		
	}
	return picNum;
	
}

}
