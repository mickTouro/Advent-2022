import java.util.List;
import java.util.*;
public class Advent_05{

    public static void main(String[] args){
        System.out.println(getTop(getStacks(), getMoves()));
        System.out.println(getTopRetainOrder(getStacks(), getMoves()));
    }

    public static String getTopRetainOrder(List<Stack<Character>> stackList, List<String> moveList){
        for(String move : moveList){
            String[] currMove = move.split(" ");

            Stack<Character> fromStack = stackList.get(Integer.parseInt(currMove[3])-1);
            Stack<Character> toStack = stackList.get(Integer.parseInt(currMove[5])-1);
            Stack<Character> tempStack = new Stack<Character>();

            for(int i = 0; i < Integer.parseInt(currMove[1]); i++){
                Character temp = fromStack.pop();
                tempStack.add(temp);
            }
            while(!tempStack.isEmpty()) toStack.add(tempStack.pop());
        }

        String tops = "";
        for(Stack<Character> stack : stackList){
            tops += stack.peek();
        }
        return tops;
    }

    public static String getTop(List<Stack<Character>> stackList, List<String> moveList){
        for(String move : moveList){
            String[] currMove = move.split(" ");

            Stack<Character> fromStack = stackList.get(Integer.parseInt(currMove[3])-1);
            Stack<Character> toStack = stackList.get(Integer.parseInt(currMove[5])-1);

            for(int i = 0; i < Integer.parseInt(currMove[1]); i++){
                Character temp = fromStack.pop();
                toStack.add(temp);
            }
        }

        String tops = "";
        for(Stack<Character> stack : stackList){
            tops += stack.peek();
        }
        return tops;
    }

    public static List<Stack<Character>> getStacks(){
        Stack<Character> stack1 = new Stack<Character>();
        Stack<Character> stack2 = new Stack<Character>();
        Stack<Character> stack3 = new Stack<Character>();
        Stack<Character> stack4 = new Stack<Character>();
        Stack<Character> stack5 = new Stack<Character>();
        Stack<Character> stack6 = new Stack<Character>();
        Stack<Character> stack7 = new Stack<Character>();
        Stack<Character> stack8 = new Stack<Character>();
        Stack<Character> stack9 = new Stack<Character>();
        stack1.add('H');stack1.add('B');stack1.add('V');stack1.add('W');
        stack1.add('N');stack1.add('M');stack1.add('L');stack1.add('P');
        stack2.add('M');stack2.add('Q');stack2.add('H');
        stack3.add('N');stack3.add('D');stack3.add('B');stack3.add('G');
        stack3.add('F');stack3.add('Q');stack3.add('M');stack3.add('L');
        stack4.add('Z');stack4.add('T');stack4.add('F');stack4.add('Q');
        stack4.add('M');stack4.add('W');stack4.add('G');
        stack5.add('M');stack5.add('T');stack5.add('H');stack5.add('P');
        stack6.add('C');stack6.add('B');stack6.add('M');stack6.add('J');
        stack6.add('D');stack6.add('H');stack6.add('G');stack6.add('T');
        stack7.add('M');stack7.add('N');stack7.add('B');stack7.add('F');
        stack7.add('V');stack7.add('R');
        stack8.add('P');stack8.add('L');stack8.add('H');stack8.add('M');
        stack8.add('R');stack8.add('G');stack8.add('S');
        stack9.add('P');stack9.add('D');stack9.add('B');stack9.add('C');
        stack9.add('N');
        List<Stack<Character>> stacks = new ArrayList<Stack<Character>>();
        stacks.add(stack1);stacks.add(stack2);stacks.add(stack3);stacks.add(stack4);
        stacks.add(stack5);stacks.add(stack6);stacks.add(stack7);stacks.add(stack8);
        stacks.add(stack9);
        return stacks;
    }

    public static List<String> getMoves(){
        List<String> list = new ArrayList<String>();
        list.add("move 8 from 3 to 2");
list.add("move 1 from 9 to 5");
list.add("move 5 from 4 to 7");
list.add("move 6 from 1 to 4");
list.add("move 8 from 6 to 8");
list.add("move 8 from 4 to 5");
list.add("move 4 from 9 to 5");
list.add("move 4 from 7 to 9");
list.add("move 7 from 7 to 2");
list.add("move 4 from 5 to 2");
list.add("move 11 from 8 to 3");
list.add("move 3 from 9 to 7");
list.add("move 11 from 2 to 8");
list.add("move 13 from 8 to 4");
list.add("move 11 from 5 to 6");
list.add("move 8 from 2 to 4");
list.add("move 1 from 5 to 4");
list.add("move 1 from 3 to 2");
list.add("move 2 from 2 to 1");
list.add("move 2 from 8 to 5");
list.add("move 3 from 7 to 5");
list.add("move 1 from 4 to 7");
list.add("move 9 from 6 to 7");
list.add("move 1 from 6 to 5");
list.add("move 1 from 1 to 4");
list.add("move 3 from 1 to 9");
list.add("move 15 from 4 to 3");
list.add("move 2 from 4 to 1");
list.add("move 1 from 1 to 9");
list.add("move 3 from 4 to 5");
list.add("move 1 from 4 to 1");
list.add("move 1 from 7 to 2");
list.add("move 1 from 6 to 3");
list.add("move 5 from 7 to 1");
list.add("move 19 from 3 to 9");
list.add("move 7 from 1 to 2");
list.add("move 24 from 9 to 7");
list.add("move 23 from 7 to 1");
list.add("move 1 from 4 to 6");
list.add("move 3 from 7 to 3");
list.add("move 1 from 6 to 1");
list.add("move 6 from 2 to 1");
list.add("move 21 from 1 to 9");
list.add("move 5 from 3 to 8");
list.add("move 2 from 2 to 5");
list.add("move 10 from 9 to 5");
list.add("move 1 from 2 to 1");
list.add("move 5 from 1 to 3");
list.add("move 6 from 3 to 4");
list.add("move 1 from 2 to 8");
list.add("move 3 from 5 to 2");
list.add("move 4 from 9 to 3");
list.add("move 13 from 5 to 9");
list.add("move 2 from 7 to 2");
list.add("move 3 from 4 to 7");
list.add("move 1 from 7 to 8");
list.add("move 5 from 1 to 3");
list.add("move 1 from 7 to 5");
list.add("move 1 from 8 to 1");
list.add("move 2 from 2 to 7");
list.add("move 19 from 9 to 2");
list.add("move 5 from 2 to 3");
list.add("move 7 from 5 to 9");
list.add("move 1 from 1 to 9");
list.add("move 5 from 9 to 2");
list.add("move 4 from 9 to 3");
list.add("move 20 from 3 to 9");
list.add("move 1 from 3 to 9");
list.add("move 3 from 7 to 3");
list.add("move 16 from 2 to 3");
list.add("move 12 from 3 to 4");
list.add("move 2 from 2 to 5");
list.add("move 1 from 2 to 4");
list.add("move 2 from 4 to 1");
list.add("move 4 from 8 to 1");
list.add("move 15 from 9 to 3");
list.add("move 2 from 5 to 3");
list.add("move 3 from 2 to 8");
list.add("move 5 from 8 to 5");
list.add("move 7 from 3 to 4");
list.add("move 2 from 9 to 6");
list.add("move 15 from 3 to 1");
list.add("move 3 from 1 to 8");
list.add("move 3 from 9 to 5");
list.add("move 9 from 4 to 1");
list.add("move 3 from 3 to 5");
list.add("move 2 from 6 to 5");
list.add("move 9 from 1 to 3");
list.add("move 1 from 9 to 4");
list.add("move 1 from 5 to 2");
list.add("move 3 from 8 to 5");
list.add("move 10 from 1 to 6");
list.add("move 12 from 4 to 8");
list.add("move 1 from 2 to 7");
list.add("move 2 from 5 to 6");
list.add("move 1 from 1 to 4");
list.add("move 7 from 3 to 6");
list.add("move 1 from 7 to 2");
list.add("move 2 from 4 to 9");
list.add("move 3 from 1 to 7");
list.add("move 1 from 9 to 8");
list.add("move 1 from 2 to 3");
list.add("move 3 from 1 to 7");
list.add("move 5 from 8 to 2");
list.add("move 5 from 7 to 1");
list.add("move 9 from 6 to 8");
list.add("move 6 from 6 to 9");
list.add("move 8 from 8 to 6");
list.add("move 1 from 7 to 4");
list.add("move 5 from 2 to 4");
list.add("move 7 from 5 to 1");
list.add("move 5 from 8 to 9");
list.add("move 11 from 6 to 7");
list.add("move 9 from 9 to 1");
list.add("move 2 from 7 to 5");
list.add("move 1 from 9 to 5");
list.add("move 1 from 3 to 6");
list.add("move 3 from 4 to 6");
list.add("move 1 from 8 to 2");
list.add("move 2 from 3 to 6");
list.add("move 6 from 5 to 2");
list.add("move 3 from 5 to 9");
list.add("move 3 from 2 to 1");
list.add("move 1 from 4 to 3");
list.add("move 3 from 2 to 7");
list.add("move 1 from 8 to 9");
list.add("move 1 from 2 to 8");
list.add("move 8 from 7 to 5");
list.add("move 1 from 7 to 8");
list.add("move 3 from 5 to 6");
list.add("move 5 from 5 to 2");
list.add("move 1 from 4 to 1");
list.add("move 1 from 3 to 2");
list.add("move 4 from 1 to 5");
list.add("move 4 from 2 to 6");
list.add("move 6 from 1 to 2");
list.add("move 5 from 9 to 3");
list.add("move 2 from 5 to 3");
list.add("move 3 from 3 to 6");
list.add("move 10 from 6 to 4");
list.add("move 4 from 8 to 5");
list.add("move 5 from 5 to 1");
list.add("move 21 from 1 to 7");
list.add("move 3 from 2 to 9");
list.add("move 1 from 5 to 2");
list.add("move 4 from 2 to 9");
list.add("move 8 from 4 to 8");
list.add("move 1 from 2 to 1");
list.add("move 7 from 8 to 2");
list.add("move 2 from 6 to 1");
list.add("move 2 from 1 to 5");
list.add("move 1 from 1 to 5");
list.add("move 4 from 3 to 7");
list.add("move 1 from 9 to 3");
list.add("move 4 from 6 to 3");
list.add("move 1 from 3 to 8");
list.add("move 1 from 3 to 4");
list.add("move 2 from 2 to 6");
list.add("move 2 from 9 to 7");
list.add("move 14 from 7 to 8");
list.add("move 10 from 8 to 7");
list.add("move 3 from 4 to 6");
list.add("move 5 from 2 to 3");
list.add("move 3 from 9 to 8");
list.add("move 3 from 3 to 4");
list.add("move 1 from 2 to 4");
list.add("move 1 from 9 to 4");
list.add("move 1 from 9 to 5");
list.add("move 1 from 5 to 2");
list.add("move 3 from 5 to 7");
list.add("move 1 from 4 to 6");
list.add("move 5 from 3 to 8");
list.add("move 1 from 6 to 8");
list.add("move 5 from 7 to 6");
list.add("move 14 from 8 to 5");
list.add("move 2 from 6 to 7");
list.add("move 18 from 7 to 2");
list.add("move 3 from 6 to 1");
list.add("move 5 from 5 to 4");
list.add("move 5 from 6 to 2");
list.add("move 7 from 2 to 1");
list.add("move 1 from 8 to 4");
list.add("move 1 from 5 to 1");
list.add("move 8 from 1 to 9");
list.add("move 10 from 4 to 3");
list.add("move 8 from 5 to 3");
list.add("move 1 from 4 to 3");
list.add("move 2 from 1 to 5");
list.add("move 1 from 5 to 3");
list.add("move 5 from 3 to 1");
list.add("move 1 from 1 to 3");
list.add("move 5 from 1 to 6");
list.add("move 13 from 3 to 1");
list.add("move 3 from 9 to 4");
list.add("move 2 from 9 to 6");
list.add("move 5 from 6 to 5");
list.add("move 6 from 5 to 1");
list.add("move 7 from 7 to 9");
list.add("move 7 from 9 to 6");
list.add("move 1 from 9 to 3");
list.add("move 1 from 7 to 9");
list.add("move 3 from 9 to 1");
list.add("move 12 from 2 to 7");
list.add("move 7 from 6 to 2");
list.add("move 22 from 1 to 7");
list.add("move 1 from 6 to 5");
list.add("move 4 from 7 to 6");
list.add("move 1 from 5 to 6");
list.add("move 2 from 4 to 1");
list.add("move 1 from 4 to 1");
list.add("move 23 from 7 to 9");
list.add("move 4 from 6 to 2");
list.add("move 4 from 7 to 3");
list.add("move 1 from 1 to 9");
list.add("move 6 from 2 to 1");
list.add("move 1 from 7 to 2");
list.add("move 7 from 2 to 8");
list.add("move 2 from 3 to 8");
list.add("move 3 from 1 to 9");
list.add("move 1 from 2 to 8");
list.add("move 5 from 8 to 3");
list.add("move 3 from 2 to 1");
list.add("move 2 from 7 to 8");
list.add("move 10 from 9 to 8");
list.add("move 4 from 1 to 3");
list.add("move 14 from 3 to 4");
list.add("move 7 from 4 to 5");
list.add("move 1 from 6 to 9");
list.add("move 5 from 5 to 8");
list.add("move 1 from 6 to 4");
list.add("move 6 from 9 to 4");
list.add("move 3 from 8 to 4");
list.add("move 1 from 5 to 1");
list.add("move 3 from 4 to 3");
list.add("move 9 from 4 to 3");
list.add("move 5 from 3 to 6");
list.add("move 5 from 1 to 5");
list.add("move 4 from 6 to 2");
list.add("move 8 from 9 to 2");
list.add("move 2 from 6 to 5");
list.add("move 3 from 4 to 7");
list.add("move 2 from 2 to 7");
list.add("move 2 from 5 to 4");
list.add("move 3 from 5 to 9");
list.add("move 3 from 4 to 2");
list.add("move 10 from 2 to 5");
list.add("move 1 from 9 to 8");
list.add("move 2 from 2 to 9");
list.add("move 3 from 7 to 2");
list.add("move 1 from 2 to 9");
list.add("move 13 from 5 to 1");
list.add("move 2 from 2 to 7");
list.add("move 8 from 9 to 2");
list.add("move 1 from 4 to 6");
list.add("move 1 from 9 to 5");
list.add("move 14 from 8 to 4");
list.add("move 7 from 4 to 5");
list.add("move 4 from 7 to 5");
list.add("move 2 from 3 to 8");
list.add("move 4 from 1 to 5");
list.add("move 2 from 5 to 4");
list.add("move 6 from 5 to 6");
list.add("move 7 from 2 to 5");
list.add("move 1 from 2 to 6");
list.add("move 1 from 5 to 2");
list.add("move 2 from 2 to 8");
list.add("move 2 from 1 to 3");
list.add("move 8 from 4 to 7");
list.add("move 1 from 4 to 3");
list.add("move 6 from 1 to 6");
list.add("move 7 from 3 to 9");
list.add("move 3 from 7 to 1");
list.add("move 2 from 8 to 7");
list.add("move 7 from 6 to 9");
list.add("move 2 from 3 to 6");
list.add("move 6 from 8 to 3");
list.add("move 9 from 5 to 3");
list.add("move 2 from 7 to 8");
list.add("move 2 from 6 to 4");
list.add("move 7 from 6 to 9");
list.add("move 5 from 3 to 8");
list.add("move 10 from 9 to 1");
list.add("move 11 from 1 to 8");
list.add("move 1 from 3 to 2");
list.add("move 4 from 5 to 6");
list.add("move 2 from 6 to 2");
list.add("move 2 from 7 to 9");
list.add("move 3 from 1 to 7");
list.add("move 6 from 3 to 9");
list.add("move 2 from 7 to 2");
list.add("move 2 from 6 to 9");
list.add("move 1 from 5 to 9");
list.add("move 11 from 9 to 8");
list.add("move 1 from 4 to 5");
list.add("move 6 from 9 to 8");
list.add("move 31 from 8 to 9");
list.add("move 1 from 3 to 6");
list.add("move 1 from 7 to 1");
list.add("move 1 from 4 to 3");
list.add("move 1 from 5 to 2");
list.add("move 1 from 1 to 8");
list.add("move 1 from 8 to 9");
list.add("move 1 from 7 to 3");
list.add("move 11 from 9 to 6");
list.add("move 2 from 3 to 1");
list.add("move 2 from 3 to 5");
list.add("move 1 from 5 to 4");
list.add("move 1 from 4 to 1");
list.add("move 6 from 8 to 3");
list.add("move 1 from 1 to 4");
list.add("move 1 from 4 to 6");
list.add("move 2 from 3 to 6");
list.add("move 17 from 9 to 2");
list.add("move 23 from 2 to 9");
list.add("move 14 from 9 to 4");
list.add("move 1 from 1 to 7");
list.add("move 1 from 5 to 6");
list.add("move 8 from 6 to 2");
list.add("move 1 from 3 to 2");
list.add("move 4 from 9 to 8");
list.add("move 5 from 4 to 7");
list.add("move 3 from 7 to 2");
list.add("move 1 from 1 to 2");
list.add("move 2 from 9 to 4");
list.add("move 3 from 6 to 9");
list.add("move 8 from 4 to 9");
list.add("move 2 from 4 to 2");
list.add("move 4 from 7 to 2");
list.add("move 1 from 7 to 9");
list.add("move 4 from 6 to 2");
list.add("move 16 from 2 to 1");
list.add("move 2 from 3 to 2");
list.add("move 18 from 9 to 8");
list.add("move 1 from 4 to 2");
list.add("move 1 from 6 to 8");
list.add("move 1 from 3 to 9");
list.add("move 3 from 9 to 5");
list.add("move 4 from 9 to 8");
list.add("move 6 from 2 to 8");
list.add("move 1 from 5 to 1");
list.add("move 4 from 2 to 8");
list.add("move 1 from 5 to 1");
list.add("move 17 from 1 to 4");
list.add("move 1 from 5 to 8");
list.add("move 10 from 4 to 3");
list.add("move 10 from 3 to 1");
list.add("move 4 from 4 to 9");
list.add("move 1 from 4 to 6");
list.add("move 1 from 4 to 8");
list.add("move 38 from 8 to 1");
list.add("move 27 from 1 to 5");
list.add("move 1 from 8 to 2");
list.add("move 1 from 6 to 3");
list.add("move 1 from 4 to 8");
list.add("move 1 from 8 to 4");
list.add("move 14 from 1 to 9");
list.add("move 1 from 3 to 1");
list.add("move 1 from 5 to 1");
list.add("move 1 from 2 to 5");
list.add("move 2 from 5 to 4");
list.add("move 17 from 5 to 8");
list.add("move 3 from 4 to 9");
list.add("move 2 from 9 to 1");
list.add("move 3 from 5 to 7");
list.add("move 3 from 7 to 4");
list.add("move 2 from 4 to 7");
list.add("move 12 from 1 to 4");
list.add("move 1 from 7 to 4");
list.add("move 1 from 7 to 6");
list.add("move 1 from 6 to 9");
list.add("move 11 from 4 to 3");
list.add("move 1 from 5 to 3");
list.add("move 11 from 3 to 9");
list.add("move 1 from 3 to 2");
list.add("move 3 from 5 to 4");
list.add("move 1 from 2 to 4");
list.add("move 1 from 5 to 8");
list.add("move 13 from 9 to 3");
list.add("move 16 from 9 to 1");
list.add("move 4 from 8 to 9");
list.add("move 2 from 1 to 4");
list.add("move 1 from 9 to 1");
list.add("move 1 from 9 to 7");
list.add("move 1 from 7 to 2");
list.add("move 6 from 8 to 3");
list.add("move 8 from 4 to 2");
list.add("move 4 from 9 to 6");
list.add("move 3 from 2 to 3");
list.add("move 3 from 6 to 1");
list.add("move 3 from 8 to 6");
list.add("move 1 from 6 to 8");
list.add("move 3 from 6 to 4");
list.add("move 11 from 3 to 5");
list.add("move 4 from 8 to 2");
list.add("move 6 from 3 to 5");
list.add("move 3 from 5 to 1");
list.add("move 2 from 8 to 3");
list.add("move 14 from 5 to 3");
list.add("move 4 from 3 to 4");
list.add("move 6 from 3 to 5");
list.add("move 3 from 2 to 9");
list.add("move 4 from 1 to 8");
list.add("move 3 from 9 to 6");
list.add("move 2 from 6 to 9");
list.add("move 6 from 4 to 3");
list.add("move 15 from 1 to 4");
list.add("move 1 from 6 to 7");
list.add("move 5 from 5 to 1");
list.add("move 11 from 3 to 1");
list.add("move 2 from 9 to 7");
list.add("move 1 from 5 to 6");
list.add("move 2 from 1 to 3");
list.add("move 7 from 2 to 6");
list.add("move 4 from 8 to 1");
list.add("move 8 from 4 to 2");
list.add("move 3 from 6 to 4");
list.add("move 5 from 1 to 4");
list.add("move 17 from 4 to 8");
list.add("move 3 from 3 to 7");
list.add("move 4 from 3 to 4");
list.add("move 4 from 4 to 2");
list.add("move 9 from 8 to 7");
list.add("move 1 from 3 to 8");
list.add("move 10 from 2 to 4");
list.add("move 1 from 6 to 2");
list.add("move 2 from 8 to 4");
list.add("move 2 from 6 to 9");
list.add("move 2 from 6 to 2");
list.add("move 1 from 2 to 3");
list.add("move 3 from 1 to 4");
list.add("move 1 from 3 to 2");
list.add("move 1 from 9 to 3");
list.add("move 1 from 9 to 7");
list.add("move 4 from 8 to 4");
list.add("move 10 from 4 to 8");
list.add("move 5 from 4 to 3");
list.add("move 1 from 2 to 8");
list.add("move 5 from 3 to 7");
list.add("move 3 from 7 to 8");
list.add("move 3 from 4 to 3");
list.add("move 8 from 7 to 2");
list.add("move 8 from 7 to 8");
list.add("move 1 from 3 to 2");
list.add("move 3 from 2 to 8");
list.add("move 9 from 2 to 5");
list.add("move 12 from 1 to 7");
list.add("move 21 from 8 to 3");
list.add("move 5 from 8 to 6");
list.add("move 8 from 7 to 5");
list.add("move 6 from 7 to 4");
list.add("move 12 from 5 to 7");
list.add("move 1 from 8 to 5");
list.add("move 2 from 4 to 2");
list.add("move 1 from 7 to 6");
list.add("move 14 from 3 to 8");
list.add("move 5 from 6 to 2");
list.add("move 7 from 2 to 6");
list.add("move 6 from 8 to 4");
list.add("move 11 from 7 to 4");
list.add("move 8 from 3 to 7");
list.add("move 4 from 5 to 7");
list.add("move 9 from 8 to 2");
list.add("move 6 from 4 to 1");
list.add("move 2 from 5 to 2");
list.add("move 1 from 7 to 2");
list.add("move 11 from 2 to 3");
list.add("move 1 from 2 to 1");
list.add("move 7 from 4 to 1");
list.add("move 5 from 6 to 8");
list.add("move 1 from 2 to 3");
list.add("move 2 from 8 to 7");
list.add("move 14 from 3 to 7");
list.add("move 15 from 7 to 6");
list.add("move 4 from 4 to 6");
list.add("move 2 from 8 to 3");
list.add("move 12 from 1 to 3");
list.add("move 1 from 8 to 2");
list.add("move 1 from 2 to 3");
list.add("move 1 from 3 to 9");
list.add("move 1 from 9 to 7");
list.add("move 1 from 1 to 4");
list.add("move 18 from 6 to 8");
list.add("move 3 from 3 to 2");
list.add("move 17 from 8 to 3");
list.add("move 3 from 7 to 6");
list.add("move 3 from 2 to 6");
list.add("move 25 from 3 to 7");
list.add("move 2 from 4 to 1");
list.add("move 9 from 6 to 5");
list.add("move 2 from 3 to 1");
list.add("move 1 from 3 to 9");
list.add("move 5 from 5 to 2");
list.add("move 1 from 8 to 3");
list.add("move 2 from 4 to 7");
list.add("move 1 from 9 to 4");
list.add("move 1 from 6 to 7");
list.add("move 2 from 5 to 2");
list.add("move 2 from 4 to 8");
list.add("move 2 from 5 to 8");
list.add("move 5 from 7 to 9");
list.add("move 27 from 7 to 5");
list.add("move 2 from 9 to 6");
return list;
    }
}
