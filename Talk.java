/*
 * Pei-Cheng (Peggy) Chen
 * pc2857
 * Talk class 
 * 1)Get name, start time and end time of each talk
 * 2)Check potential exceptions and handle them
 * 3)compareTo for Comparable interface
 * 4)toString -> print description
*/

public class Talk implements Comparable<Talk>{
    
    private String name; //name of the speaker
    private int start; //start time
    private int end; //end time
    private String lineNew; //line after removing space
    private int pos; //for tracking position
    
    public Talk(String line){
        
        lineNew = line.replaceAll("\\s+","");
        
        pos =0;
        if(!(Character.isLetter(lineNew.charAt(pos)))){
            System.out.println("Talk info is arranged in the wrong order");
            System.out.println("Please change to -> name+start time+end time");
            System.exit(1);
            //Right format: name+start time+end time
        }else while(Character.isLetter(lineNew.charAt(pos))){
            pos++;//track the position of letter to substring name
        }
        
        if(pos+7 == lineNew.length()-1){
            name = lineNew.substring(0,pos);
        }else{
            System.out.println("Talk info is formatted in a wrong way");
            System.exit(1);
            //(wrong way)Ex. start time = 09001
        }
                
        for(int a=pos; a<lineNew.length()-1; a++){
            if(lineNew.substring(a, a+1).equals("-")){
                System.out.println("Negative value is found. Please fix it.");
                System.exit(1); 
            }//checking if any negative value is present
        }
        
        try{
            start = Integer.parseInt(lineNew.substring(pos,pos+4));
            end = Integer.parseInt(lineNew.substring(pos+4));
        }
        catch(NumberFormatException ex){
            System.out.println(ex.getMessage());
            System.out.println("Please check you file input.");
            System.exit(1);
            //checking if start time&end time can be parsed into int
        }

        if(start>2400 || end>2400){
            System.out.println("schedule time entered is not within 24 hours");
            System.exit(1);
            //checking the validity of the time frame
        }else if(start > end){
            System.out.println("improper input: start time>end time");
            System.exit(1);
            //checking the order of start/end time
        }
    }
    
    public int compareTo(Talk t){
        int ans = 0;
        if(this.end>t.end){
            ans = 1;
        }else if(this.end<t.end){
            ans = -1;            
        }else if(this.end == t.end){
            if(this.start>t.start){
                ans = 1;
            }else if(this.start<t.start){
                ans = -1;
            }
        }
        return ans;
    }
    
    public String toString(){
        String description = "";
        description = "\nSpeaker: " + name + "\n"
                    +"start at: "+lineNew.substring(pos,pos+4) + "\n"
                    +"end at: "+lineNew.substring(pos+4);
        return description; 
    }
    
    public int getStart(){
        return start;
    }
    
    public int getEnd(){
        return end; 
    }
}