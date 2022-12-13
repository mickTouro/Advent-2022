import java.util.List;
import java.util.ArrayList;
public class Advent_10{

    public static void main(String [] args){
        System.out.println(getSumOfStagerredOutput2(getInput()));
        printOutput(getInput());
    }



    public static void printOutput(List<String> l){
        int xRegister = 1;
        int cycle = 0;
        for(String s: l){
            if(s.startsWith("noop")) { 
                if(cycle +1 >= xRegister && cycle -1 <= xRegister) System.out.print("#");
                else System.out.print(".");
            }
            else if(s.startsWith("addx")) { 

                if(cycle +1 >= xRegister && cycle -1 <= xRegister ) System.out.print("#");
                else System.out.print(".");
                cycle++;
                if(cycle % 40 == 0) System.out.println("");
                cycle = cycle % 40;

                if(cycle +1 >= xRegister && cycle -1 <= xRegister) System.out.print("#");
                else System.out.print(".");
                xRegister += Integer.parseInt(s.split(" " )[1]);
            }
            cycle++; 
            if(cycle % 40 == 0) System.out.println("");
            cycle = cycle % 40;
        }
    }

    public static int getSumOfStagerredOutput2(List<String> l){
        List<Integer> xRegister = new ArrayList<Integer>();
        for(String s: l){
            int last = xRegister.isEmpty() ? 1 : xRegister.get(xRegister.size()-1);
            if(s.startsWith("noop")) { 
                xRegister.add(last); 
            }
            else if(s.startsWith("addx")) { 
                xRegister.add(last); 
                xRegister.add(last + Integer.parseInt(s.split(" ")[1]));
            }
        }

        int count = 1;
        int sum = 0;
        while(count < 250){
            if( count % 40 == 20 ){ sum += (count * xRegister.get(count-2));}
            count++;
        }
        return sum;
    }

    public static List<String> getTestInput(){
List<String> l = new ArrayList<String>();
l.add("addx 15");
l.add("addx -11");
l.add("addx 6");
l.add("addx -3");
l.add("addx 5");
l.add("addx -1");
l.add("addx -8");
l.add("addx 13");
l.add("addx 4");
l.add("noop");
l.add("addx -1");
l.add("addx 5");
l.add("addx -1");
l.add("addx 5");
l.add("addx -1");
l.add("addx 5");
l.add("addx -1");
l.add("addx 5");
l.add("addx -1");
l.add("addx -35");
l.add("addx 1");
l.add("addx 24");
l.add("addx -19");
l.add("addx 1");
l.add("addx 16");
l.add("addx -11");
l.add("noop");
l.add("noop");
l.add("addx 21");
l.add("addx -15");
l.add("noop");
l.add("noop");
l.add("addx -3");
l.add("addx 9");
l.add("addx 1");
l.add("addx -3");
l.add("addx 8");
l.add("addx 1");
l.add("addx 5");
l.add("noop");
l.add("noop");
l.add("noop");
l.add("noop");
l.add("noop");
l.add("addx -36");
l.add("noop");
l.add("addx 1");
l.add("addx 7");
l.add("noop");
l.add("noop");
l.add("noop");
l.add("addx 2");
l.add("addx 6");
l.add("noop");
l.add("noop");
l.add("noop");
l.add("noop");
l.add("noop");
l.add("addx 1");
l.add("noop");
l.add("noop");
l.add("addx 7");
l.add("addx 1");
l.add("noop");
l.add("addx -13");
l.add("addx 13");
l.add("addx 7");
l.add("noop");
l.add("addx 1");
l.add("addx -33");
l.add("noop");
l.add("noop");
l.add("noop");
l.add("addx 2");
l.add("noop");
l.add("noop");
l.add("noop");
l.add("addx 8");
l.add("noop");
l.add("addx -1");
l.add("addx 2");
l.add("addx 1");
l.add("noop");
l.add("addx 17");
l.add("addx -9");
l.add("addx 1");
l.add("addx 1");
l.add("addx -3");
l.add("addx 11");
l.add("noop");
l.add("noop");
l.add("addx 1");
l.add("noop");
l.add("addx 1");
l.add("noop");
l.add("noop");
l.add("addx -13");
l.add("addx -19");
l.add("addx 1");
l.add("addx 3");
l.add("addx 26");
l.add("addx -30");
l.add("addx 12");
l.add("addx -1");
l.add("addx 3");
l.add("addx 1");
l.add("noop");
l.add("noop");
l.add("noop");
l.add("addx -9");
l.add("addx 18");
l.add("addx 1");
l.add("addx 2");
l.add("noop");
l.add("noop");
l.add("addx 9");
l.add("noop");
l.add("noop");
l.add("noop");
l.add("addx -1");
l.add("addx 2");
l.add("addx -37");
l.add("addx 1");
l.add("addx 3");
l.add("noop");
l.add("addx 15");
l.add("addx -21");
l.add("addx 22");
l.add("addx -6");
l.add("addx 1");
l.add("noop");
l.add("addx 2");
l.add("addx 1");
l.add("noop");
l.add("addx -10");
l.add("noop");
l.add("noop");
l.add("addx 20");
l.add("addx 1");
l.add("addx 2");
l.add("addx 2");
l.add("addx -6");
l.add("addx -11");
l.add("noop");
l.add("noop");
l.add("noop");
return l;
}

public static List<String> getInput(){
    List<String> l = new ArrayList<String>();
l.add("noop");
l.add("noop");
l.add("addx 15");
l.add("addx -10");
l.add("noop");
l.add("noop");
l.add("addx 3");
l.add("noop");
l.add("noop");
l.add("addx 7");
l.add("addx 1");
l.add("addx 4");
l.add("addx -1");
l.add("addx 1");
l.add("addx 5");
l.add("addx 1");
l.add("noop");
l.add("noop");
l.add("addx 5");
l.add("addx -1");
l.add("noop");
l.add("addx 3");
l.add("noop");
l.add("addx 3");
l.add("addx -38");
l.add("noop");
l.add("addx 3");
l.add("addx 2");
l.add("addx 5");
l.add("addx 2");
l.add("addx 26");
l.add("addx -21");
l.add("addx -2");
l.add("addx 5");
l.add("addx 2");
l.add("addx -14");
l.add("addx 15");
l.add("noop");
l.add("addx 7");
l.add("noop");
l.add("addx 2");
l.add("addx -22");
l.add("addx 23");
l.add("addx 2");
l.add("addx 5");
l.add("addx -40");
l.add("noop");
l.add("noop");
l.add("addx 3");
l.add("addx 2");
l.add("noop");
l.add("addx 24");
l.add("addx -19");
l.add("noop");
l.add("noop");
l.add("noop");
l.add("addx 5");
l.add("addx 5");
l.add("addx 2");
l.add("noop");
l.add("noop");
l.add("noop");
l.add("noop");
l.add("addx 7");
l.add("noop");
l.add("addx 3");
l.add("noop");
l.add("addx 3");
l.add("addx -2");
l.add("addx 2");
l.add("addx 5");
l.add("addx -38");
l.add("noop");
l.add("noop");
l.add("noop");
l.add("addx 5");
l.add("addx 2");
l.add("addx -1");
l.add("addx 2");
l.add("addx 30");
l.add("addx -23");
l.add("noop");
l.add("noop");
l.add("noop");
l.add("noop");
l.add("addx 3");
l.add("addx 5");
l.add("addx -11");
l.add("addx 12");
l.add("noop");
l.add("addx 6");
l.add("addx 1");
l.add("noop");
l.add("addx 4");
l.add("addx 3");
l.add("noop");
l.add("addx -40");
l.add("addx 4");
l.add("addx 28");
l.add("addx -27");
l.add("addx 5");
l.add("addx 2");
l.add("addx 5");
l.add("noop");
l.add("noop");
l.add("addx -2");
l.add("addx 2");
l.add("addx 5");
l.add("addx 3");
l.add("noop");
l.add("addx 2");
l.add("addx -25");
l.add("addx 30");
l.add("noop");
l.add("addx 3");
l.add("addx -2");
l.add("addx 2");
l.add("addx 5");
l.add("addx -39");
l.add("addx 29");
l.add("addx -27");
l.add("addx 5");
l.add("noop");
l.add("noop");
l.add("noop");
l.add("addx 4");
l.add("noop");
l.add("addx 1");
l.add("addx 2");
l.add("addx 5");
l.add("addx 2");
l.add("noop");
l.add("noop");
l.add("noop");
l.add("noop");
l.add("addx 5");
l.add("addx 1");
l.add("noop");
l.add("addx 2");
l.add("addx 5");
l.add("addx -32");
l.add("addx 34");
l.add("noop");
l.add("noop");
l.add("noop");
l.add("noop");
return l;
}
}
