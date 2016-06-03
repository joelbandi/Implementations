import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.io.*;


public class Petrinet{

	static HashMap<String,Transition> transitions = new HashMap<String,Transition>();
	static HashMap<String,Place> places = new HashMap<String,Place>();
	static String file;
	static int cycles;

	// ArrayList<Transition> transition = new ArrayList<Transition>();
	// ArrayList<Place> places = new ArrayList<Place>();


	public static void main(String[] args){

		file = args[0];
		cycles = Integer.parseInt(args[1]);

		parse();
		simulate();	
	}

	public static void parse(){
		String line = "";
		String[] params;
		try {
            FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
            	
            	params = line.split(" ");
            	if(params[0].equals("place")){
            		try{
            			int tokencount = Integer.parseInt(params[2]);
            			place(params[1],tokencount);
            		}catch(NumberFormatException e){
            			System.out.println("Illegal Petrinet Command.[Ignoring this line]");
            			continue;
            		}


            	}else if(params[0].equals("transition")){
            		
            		transition(params[1]);

            	}else if(params[0].equals("edge")){
            		
            		edge(params[1],params[2]);

            	}else{
            		System.out.println("Illegal Petrinet Command.[Ignoring this line]");
            		continue;
            	}
            }   
            bufferedReader.close();

        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                file + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + file + "'");                  
        }
    }

    public static void place(String place, int tokens){
    	places.put(place,new Place(place,tokens));
    }

    public static void transition(String transition){
    	transitions.put(transition,new Transition(transition));
    }
    //assuming a transition cannot directly to another transition
    public static void edge(String one, String two){
    	if(transitions.containsKey(one) && places.containsKey(two)){
    		transitions.get(one).outgoing.add(places.get(two));
    		places.get(two).incoming.add(transitions.get(one));
    	}else if(places.containsKey(one) && transitions.containsKey(two)){
    		places.get(one).outgoing.add(transitions.get(two));
    		transitions.get(two).incoming.add(places.get(one));
    	}else{
    		System.out.println("This Edge ("+one+"->"+two+") isnt valid [Skipping this line]");
    	}
    }

    public static void simulate(){

    	for(int i = 1; i<= cycles; i++)
    	Set set = transitions.entrySet();
    	Iterator i = set.iterator();



    }
}







class Transition{

	public ArrayList<Place> incoming = new ArrayList<Place>();
	public ArrayList<Place> outgoing = new ArrayList<Place>();
	public String name;

	Transition(String name){
		this.name=name;
	}

	public boolean canFire(){
		for(Place p : this.incoming){
			int edgecount = 0;
			for(Transition t : p.outgoing){
				if(t.equals(this)){
					edgecount++;
				} 
			}
			if(p.tokencount<edgecount){
				return false;
			}
		}
		return true;
	}

}


class Place{

	public int tokencount;
	public String name;
	public ArrayList<Transition> incoming = new ArrayList<Transition>();
	public ArrayList<Transition> outgoing = new ArrayList<Transition>();

	Place(String name,int tokencount){
		this.name=name;
		this.tokencount=tokencount;
	}

}