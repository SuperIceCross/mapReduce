import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MapReduce {

	static String fichierCsv = "C:/Users/yacin/Desktop/Fayad/textExemple.csv";
	static String ligne = "";
	static String separateurCsv = ";";
	static String [] test;
	static HashMap<Integer, String> newmap = new HashMap<Integer, String>();
	static String[] testMap = new String[8];
	static String[] goodTab = new String[8];
	static int o=0;
	
	public static void main (String[] args) {
		int i = 0;
		try (BufferedReader br = new BufferedReader (new FileReader(fichierCsv))){
			ArrayList <String[]> tabMap = new ArrayList();
			while ((ligne = br.readLine()) != null) {
				HashMap<Integer, String>  toReduce = new HashMap<Integer, String>();
				goodTab = map(i,ligne.toString());
				i++;
			}
			for (String values: goodTab){
				//Retranscrire cette sortie dans le CSV
				System.out.println(values);
			}
			//System.out.print(goodTab[0]);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	static String[] map (int key, String values){
		String [] tableauMap = ligne.split(separateurCsv);
		//On a notre Map
		goodTab = reduce(o, tableauMap);
		
		return goodTab;
		
	}
	
	static String[] reduce (int o, String [] tableauMap) {
		for (String maps : tableauMap) {
			if (testMap[o] != null) {
				testMap[o] =  testMap[o] + ';' + maps;
			}else {
				testMap[o] =  maps;
			}
			o++;
		}o=0;
		return testMap;
	}
}
