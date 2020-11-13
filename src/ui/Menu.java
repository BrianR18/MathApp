package ui;
import model.MathApp;
import java.util.Scanner;

public class Menu{
	private final int ADDSET = 1;
	private final int REMOVESET = 2;
	private final int ADDELEMENTTOSET = 3;
	private final int REMOVEELEMENTFROMSET = 4;
	private final int UNION = 5;
	private final int DIFFERENCE = 6;
	private final int INTERSECTION = 7;
	private final int SYMMETRICDIFERENCE = 8;
	private final int SHOWINFOSET = 9;
	private final int SHOWINFOSETS = 10;
	private final int EXIT = 11;
	
	private MathApp app;
	private Scanner sc;
	
	public Menu(){
		app = new MathApp();
		sc = new Scanner(System.in);
	}//End constructor
	
	public void showMenu(){
		System.out.println("\nMostrando menu...\n");
		System.out.println("[1]Agregar conjunto.");
		System.out.println("[2]Eliminar conjunto.");
		System.out.println("[3]Agregar elemento al conjunto.");
		System.out.println("[4]Remover elemento del conjunto.");
		System.out.println("[5]Union de conjuntos.");
		System.out.println("[6]Diferencia entre conjuntos.");
		System.out.println("[7]Interseccion entre conjuntos.");
		System.out.println("[8]Diferencia simetrica entre conjuntos.");
		System.out.println("[9]Mostrar informacion del conjunto.");
		System.out.println("[10]Mostrar informacion de todos conjuntos.");
		System.out.println("[11]Salir.");
	}//End showMenu
	
	public int readOption(){
		int opt = 0;
		System.out.print("Ingrese la opcion: ");
		opt = sc.nextInt();
		sc.nextLine();
		return opt;
	}//End readOption
	
	public void addSet(){
		String name = new String();
		System.out.print("\nIngrese el nombre del conjunto: ");
		name = sc.nextLine();
		System.out.println(app.addSet(name));
	}//End addSet
	
	public void removeSet(){
		String name = new String();
		System.out.print("\nIngrese el nombre del conjunto a eliminar: ");
		name = sc.nextLine();
		System.out.println(app.removeSet(name));
	}//End removeSet
	
	public void addElementToSet(){
		String name = new String();
		int element = 0;
		System.out.print("\nIngrese el nombre del conjunto: ");
		name = sc.nextLine();
		System.out.print("\nIngrese el elemento: ");
		element = sc.nextInt();
		sc.nextLine();
		System.out.println(app.addElementToSet(name,element));
	}//End addElementToSet
	
	public void removeElementFromSet(){
		String name = new String();
		int element = 0;
		System.out.print("\nIngrese el nombre del conjunto: ");
		name = sc.nextLine();
		System.out.print("\nIngrese el elemento a eliminar: ");
		element = sc.nextInt();
		sc.nextLine();
		System.out.println(app.removeElementFrom(name,element));
	}//End removeElementFromSet
	
	public void unionSet(){
		String name1 = new String();
		String name2 = new String();
		String name3 = new String();
		System.out.println("Ingrese el nombre del primer conjunto: ");
		name1 = sc.nextLine();
		System.out.println("Ingrese el nombre del segundo conjunto: ");
		name2 = sc.nextLine();
		System.out.println("Ingrese el nombre del nuevo conjunto: ");
		name3 = sc.nextLine();
		System.out.println(app.union(name1,name2,name3));
	}//End unionSet
	
	public void differenceSet(){
		String name1 = new String();
		String name2 = new String();
		String name3 = new String();
		System.out.println("Ingrese el nombre del primer conjunto: ");
		name1 = sc.nextLine();
		System.out.println("Ingrese el nombre del segundo conjunto: ");
		name2 = sc.nextLine();
		System.out.println("Ingrese el nombre del nuevo conjunto: ");
		name3 = sc.nextLine();
		System.out.println(app.difference(name1,name2,name3));
	}//End differenceSet
	
	public void intersectionSet(){
		String name1 = new String();
		String name2 = new String();
		String name3 = new String();
		System.out.println("Ingrese el nombre del primer conjunto: ");
		name1 = sc.nextLine();
		System.out.println("Ingrese el nombre del segundo conjunto: ");
		name2 = sc.nextLine();
		System.out.println("Ingrese el nombre del nuevo conjunto: ");
		name3 = sc.nextLine();
		System.out.println(app.intersection(name1,name2,name3));
	}//End intersectionSet
	
	public void symmetricDifferenceSet(){
		String name1 = new String();
		String name2 = new String();
		String name3 = new String();
		System.out.println("Ingrese el nombre del primer conjunto: ");
		name1 = sc.nextLine();
		System.out.println("Ingrese el nombre del segundo conjunto: ");
		name2 = sc.nextLine();
		System.out.println("Ingrese el nombre del nuevo conjunto: ");
		name3 = sc.nextLine();
		System.out.println(app.symmetricDifference(name1,name2,name3));
	}//End differenceSet
	
	public void showInfoSet(){
		String name = new String();
		System.out.print("\nIngrese el nombre del conjunto: ");
		name = sc.nextLine();
		System.out.println(app.showInfoSet(name));
	}//End showInfoSet

	public void doOperation(int option){
		switch(option){
			case ADDSET:
				addSet();
				break;
			case REMOVESET:
				if(app.getAmount() != 0)
					removeSet();
				else
					System.out.println("\nNo hay conjuntos creados aun.");
				break;
			case ADDELEMENTTOSET:
				if(app.getAmount() != 0)
					addElementToSet();
				else
					System.out.println("\nNo hay conjuntos creados aun.");
				break;
			case REMOVEELEMENTFROMSET:
				if(app.getAmount() != 0)
					removeElementFromSet();
				else
					System.out.println("\nNo hay conjuntos creados aun.");
				break;
			case UNION:
				if(app.getAmount() != 0)
					unionSet();
				else
					System.out.println("\nNo hay conjuntos creados aun.");
				break;
			case DIFFERENCE:
				if(app.getAmount() != 0)
					differenceSet();
				else
					System.out.println("\nNo hay conjuntos creados aun.");
				break;
			case INTERSECTION:
				if(app.getAmount() != 0)
					intersectionSet();
				else
					System.out.println("\nNo hay conjuntos creados aun.");
				break;
			case SYMMETRICDIFERENCE:
				if(app.getAmount() != 0)
					symmetricDifferenceSet();
				else
					System.out.println("\nNo hay conjuntos creados aun.");
				break;
			case SHOWINFOSET:
				if(app.getAmount() != 0)
					showInfoSet();
				else
					System.out.println("\nNo hay conjuntos creados aun.");
				break;
			case SHOWINFOSETS:
				if(app.getAmount() != 0)
					System.out.println("\n" + app.showInfoSets());
				else
					System.out.println("\nNo hay conjuntos creados aun.");
				break;
			case EXIT:
				break;
			default:
				System.out.println("\nEsa opcion no existe.");
		}//End switch
	}//End doOperation
	
	public void startProgram(){
		int opt = 0;
		do{
			showMenu();
			opt = readOption();
			doOperation(opt);
		}while(opt != 11);
	}//End startProgram
}//End Menu