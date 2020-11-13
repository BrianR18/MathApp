package model;
import java.util.ArrayList;

public class IntegerSet{
	private String name;
	private int cardinality;
	private ArrayList<Integer> elements;
	
	public IntegerSet(){
		name = new String();
		cardinality = 0;
		elements = new ArrayList<Integer>();
	}//End constructor1.
	
	public IntegerSet(String name){
		this.name = name;
		cardinality = 0;
		elements = new ArrayList<Integer>();
	}//End constructor1.
	
	public void setName(String name){
		this.name = name;
	}//End setName
	
	public String getName(){
		return name;
	}//getName
	
	public int getCardinality(){
		return elements.size();
	}//End getCardinality
	
	public void setElements(ArrayList<Integer> elements){
		this.elements = elements;
	}//End setElements
	
	public ArrayList<Integer> getElements(){
		return elements;
	}//End getElements
	
	public void addElement(int element){
		elements.add(element);
	}//End addElement
	
	public void removeElement(int element){
		boolean remove = false;
		for(int i = 0; i < elements.size(); i++){
			if(elements.get(i) == element){
				elements.remove(i);
				remove = true;
			}//End if
		}//End for
	}//End removeElement
	
	public IntegerSet union(IntegerSet set,String newName){
		IntegerSet newSet = new IntegerSet(newName);
		ArrayList<Integer> setElement = set.getElements();
		ArrayList<Integer> newSetelement = (ArrayList<Integer>) elements.clone();
		for(int i = 0; i < setElement.size(); i++){
			if( !newSetelement.contains(setElement.get(i)) )
				newSetelement.add(setElement.get(i));
		}//End for
		newSet.setElements(newSetelement);
		return newSet;
	}//End union
	
	public IntegerSet difference(IntegerSet set,String newName){
		IntegerSet newSet = new IntegerSet(newName);
		ArrayList<Integer> s = set.getElements();
		for(int i = 0; i < elements.size(); i++){
			if(!s.contains(elements.get(i)))
				newSet.addElement(elements.get(i));
		}//End for
		return newSet;
	}//End difference
	
	public IntegerSet intersection(IntegerSet set,String newName){
		IntegerSet newSet = new IntegerSet(newName);
		ArrayList<Integer> setElement = set.getElements();
		ArrayList<Integer> newSetelement = new ArrayList<Integer>();
		int minor = (elements.size() < setElement.size())?elements.size():setElement.size();
		for(int i = 0; i < minor; i++){
			if( elements.size() == minor && (setElement.contains(elements.get(i)) && !newSetelement.contains( elements.get(i)) ) )
				newSetelement.add(elements.get(i));
			else if(setElement.size() == minor && ( elements.contains( setElement.get(i) ) && !newSetelement.contains(setElement.get(i)) ) )
				newSetelement.add(setElement.get(i));
		}//End for
		newSet.setElements(newSetelement);
		return newSet;
	}//End intersection
	
	public IntegerSet symmetricDifference(IntegerSet set,String newName){
		IntegerSet newSet = new IntegerSet(newName);
		ArrayList<Integer> setItem = set.getElements();
		ArrayList<Integer> newSetElements = new ArrayList<Integer>();
		for(int i = 0; i < setItem.size(); i++){
			if(!elements.contains(setItem.get(i)))
				newSetElements.add(setItem.get(i));
		}//End for
		for(int i = 0; i < elements.size();i++){
			if(!setItem.contains(elements.get(i)))
				newSetElements.add(elements.get(i));
		}//End for
		newSet.setElements(newSetElements);
		return newSet;
	}//End symmetricDifference
	
	public String showContents(){
		String content = "\n*********************************\n" +
						 "*Conjunto " + getName() + "\n*";
		for(int i = 0; i < elements.size();i++){
			content += elements.get(i) + " ";
			if( (i>0) && (i%5 == 0) )
				content += "\n*";
		}//End for
		content += "\n*Cardinalidad: " + getCardinality() + "\n";
		content += "*********************************" ;
		return content;
	}//End showContents
}//End IntegerSet