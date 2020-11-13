package model;
import java.util.ArrayList;
	
public class MathApp{
	private int amount;
	private ArrayList<IntegerSet> sets;
	
	public MathApp(){
		amount = 0;
		sets = new ArrayList<IntegerSet>();
	}//End constructor
	
	public int getAmount(){
		return amount;
	}//End getAmount
	
	public String addSet(String name){
		String msg =  "Ya existe un conjunto con ese nombre!";
		if(!checkName(name)){
			IntegerSet set = new IntegerSet(name); 
			sets.add(set);
			 msg = "Conjunto creado correctamente.";
			 updateAmount();
		}//End if 
		return msg;
	}//End addSet
	
	public boolean checkName(String name){
		boolean check = false;
		for(int i = 0; i < sets.size() && !check; i++){
			if(name.equals(sets.get(i).getName()))
				check = true;
		}//End for
		return check;
	}//End checkName
	
	public String removeSet(String name){
		boolean removed = false;
		String msg = "No se encontro un conjunto de nombre \"" + name + "\".";
		for(int i = 0; i < sets.size() && !removed; i++){
			if(name.equals(sets.get(i).getName())){
				sets.remove(i);
				msg = "Se ha eliminado el conjunto.";
				updateAmount();
			}//End if
		}//End for
		return msg;
	}//End removeSet
	
	public String addElementToSet(String setName, int element){
		boolean add = false;
		String msg = "No se encontro un conjunto de nombre \"" + setName + "\".";
		for(int i = 0; i < sets.size() && !add; i++){
			if(setName.equals(sets.get(i).getName())){
				msg = sets.get(i).addElement(element);
				updateAmount();
			}//End if
		}//End for
		return msg;
	}//End addElementToSet
	
	public String removeElementFrom(String setName,int element){
		boolean add = false;
		String msg = "No se encontro un conjunto de nombre \"" + setName + "\".";
		for(int i = 0; i < sets.size() && !add; i++){
			if(setName.equals(sets.get(i).getName())){
				msg = sets.get(i).removeElement(element);
				updateAmount();
			}//End if
		}//End for
		return msg;
	}//End removeElementFrom
	
	public String union(String setName1,String setName2,String newSetName ){
		String msg = "No se ha podido realizar la union entre los conjuntos ";
		boolean foundSet1 = false;
		boolean foundSet2 = false;		
		int indexSet1 = 0;
		int indexSet2 = 0;
		for(int i = 0; i < sets.size() && !(foundSet1 && foundSet2); i++){
			if(setName1.equals(sets.get(i).getName())){
				indexSet1 = i;
				foundSet1 = true;
			}//End if
			else if(setName2.equals(sets.get(i).getName())){
				indexSet2 = i;
				foundSet2 = true;
			}//End else
		}//End for
	
		if( (foundSet1 &&  foundSet2) && !checkName(newSetName) ){
			sets.add( (sets.get(indexSet1)).union(sets.get(indexSet2),newSetName) );
			updateAmount();
			msg = "Se ha realizado la union entre conjuntos correctamente.";
		}//End if
		return msg;
	}//End union
	
	public String difference(String setName1,String setName2,String newSetName){
		String msg = "No se ha podido realizar la diferencia entre los conjuntos ";
		boolean foundSet1 = false;
		boolean foundSet2 = false;		
		int indexSet1 = 0;
		int indexSet2 = 0;
		for(int i = 0; i < sets.size() && !(foundSet1 && foundSet2); i++){
			if(setName1.equals(sets.get(i).getName())){
				indexSet1 = i;
				foundSet1 = true;
			}//End if
			else if(setName2.equals(sets.get(i).getName())){
				indexSet2 = i;
				foundSet2 = true;
			}//End else
		}//End for
		if( (foundSet1 &&  foundSet2) && !checkName(newSetName) ){
			sets.add(sets.get(indexSet1).difference(sets.get(indexSet2),newSetName));
			updateAmount();
			msg = "Se ha realizado la diferencia entre conjuntos correctamente.";
		}//End if
		return msg;
	}//End difference
	public String intersection(String setName1,String setName2,String newSetName){
		String msg = "No se ha podido realizar la interseccion entre los conjuntos ";
		boolean foundSet1 = false;
		boolean foundSet2 = false;		
		int indexSet1 = 0;
		int indexSet2 = 0;
		for(int i = 0; i < sets.size() && !(foundSet1 && foundSet2); i++){
			if(setName1.equals(sets.get(i).getName())){
				indexSet1 = i;
				foundSet1 = true;
			}//End if
			else if(setName2.equals(sets.get(i).getName())){
				indexSet2 = i;
				foundSet2 = true;
			}//End else
		}//End for
		if( (foundSet1 &&  foundSet2) && !checkName(newSetName) ){
			sets.add(sets.get(indexSet1).intersection(sets.get(indexSet2),newSetName));
			updateAmount();
			msg = "Se ha realizado la interseccion entre conjuntos correctamente.";
		}//End if
		return msg;
	}//End intersection
	
	public String symmetricDifference(String setName1,String setName2,String newSetName){
		String msg = "No se ha podido realizar la diferencia simetrica entre los conjuntos ";
		boolean foundSet1 = false;
		boolean foundSet2 = false;		
		int indexSet1 = 0;
		int indexSet2 = 0;
		for(int i = 0; i < sets.size() && !(foundSet1 && foundSet2); i++){
			if(setName1.equals(sets.get(i).getName())){
				indexSet1 = i;
				foundSet1 = true;
			}//End if
			else if(setName2.equals(sets.get(i).getName())){
				indexSet2 = i;
				foundSet2 = true;
			}//End else
		}//End for
		if( (foundSet1 &&  foundSet2) && !checkName(newSetName) ){
			sets.add(sets.get(indexSet1).symmetricDifference(sets.get(indexSet2),newSetName));
			updateAmount();
			msg = "Se ha realizado la interseccion entre conjuntos correctamente.";
		}//End if
		return msg;
	}//End symmetricDifference
	
	public String showInfoSet(String name){
		boolean found = false;
		String set = "No se encontro un conjunto de nombre " + name;
		if(checkName(name)){
			set = "Conjunto " + name + "\n";
			for(int i = 0; i < sets.size() && !found; i++){
				if(name.equals(sets.get(i).getName())){
					found = true;
					set += sets.get(i).showContents();
				}//End if
			}//End for	
		}//End if
		return set;
	}//End showInfo
	
	public String showInfoSets(){
		String info = new String();
		for(int i = 0; i < sets.size(); i++){
			info += sets.get(i).showContents();
		}//End for
		return info;
	}//End showInfo
	
	public void updateAmount(){
		amount = sets.size();
	}//End updateAmount.
}//End MathApp