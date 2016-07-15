import java.util.*;
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
        print();    
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
                "Cannot find file '" + 
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
        int itercount = 0;
        Boolean firedInThisPass = false;
        ArrayList<String> transitionnames = new ArrayList<String>();
        Iterator i = transitions.keySet().iterator();
        while(i.hasNext()){
            transitionnames.add((String)i.next());
        }
        while(true){
            for(String k : transitionnames){
                if(transitions.get(k).canFire()){
                    transitions.get(k).fire();
                    firedInThisPass = true;
                    itercount++;
                }
                if(itercount>=cycles){
                    return;
                }
                if(!firedInThisPass){
                    break;
                }
            }
            firedInThisPass=false;
        }
    }
    public static void print(){
        System.out.println("Simulation results");
        System.out.println("After "+ cycles+" cycles: ");
        Iterator i = places.entrySet().iterator();
        while(i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            System.out.println("  -> Place "+me.getKey()+" has "+me.getValue()+" tokens");
        }
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
    public void fire(){
        for(Place p : this.incoming){
            if(p.tokencount>0){
                p.tokencount--;
            }
        }
        for(Place p : this.outgoing){
            p.tokencount++;
        }
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
    @Override
    public String toString() {
        return Integer.toString(tokencount);
    }
}