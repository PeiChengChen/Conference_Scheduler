/*
 * Pei-Cheng (Peggy) Chen
 * pc2857
 * Scheduler class 
 * 1)makeTalks ->pass line in the file to Talk to create Talk
 * 2)scheduleTalks ->use compareTo to sort/ and add Talk to final list
*/

import java.util.*; 
import java.io.*;

public class Scheduler{    
    
    public static ArrayList<Talk> makeTalks(String f) throws IOException{
        ArrayList<Talk> schedule = new ArrayList<Talk>();
        try{
            Scanner in = new Scanner(new File(f));
            while(in.hasNextLine()){
                String content = in.nextLine();
                schedule.add(new Talk(content));
                //pass the content of the file 
                //line by line into Talk to instantiate a new object 
            }
            in.close();
        }
        catch(FileNotFoundException a){
            System.out.println(a.getMessage());
            System.exit(1);
        }
        return schedule; 
    }
    
    public static ArrayList<Talk> scheduleTalks(ArrayList<Talk> t){
        ArrayList<Talk> s = new ArrayList<Talk>();
        Collections.sort(t);
        s.add(t.get(0));//first talk added to the final list
        for(int a=1; a<t.size(); a++){
            if(!(s.get(s.size()-1).getEnd()>t.get(a).getStart())){
                s.add(t.get(a));
            }//checking if the start/end time overlap
        }
        return s; 
    }
}