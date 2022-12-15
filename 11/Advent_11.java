import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigInteger;
public class Advent_11{
    public static void main(String[] args){
       // System.out.println(getMonkeyBusiness(20, parse(getTestInput()), true));
        System.out.println(getMonkeyBusiness(10000, parse(getInput()), false));
    }

    static long modulo = 1;

    public static long getMonkeyBusiness(int rounds, List<Monkey> monkeys, boolean divBy3){
        long[] itemCount = new long[monkeys.size()];
        long resultWorry;
        long operand2;
        Item newItem;
        Monkey passTo;
        for ( int i = 0; i < rounds ; i++ ){ 
            for(Monkey m : monkeys){
                itemCount[m.num]+= m.itemList.size();
                for(Item item : m.itemList){
                    resultWorry = 0;
                    operand2 = m.operand2 == 0 ? item.worry : m.operand2;
                    switch (m.operator){
                        case '*':
                            resultWorry = item.worry * (operand2);
                        break;
                        case '+':
                            resultWorry = item.worry + (operand2);
                        break;
                    }

                    resultWorry = divBy3 ? Long.divideUnsigned(resultWorry, (3)) : resultWorry % modulo;
                    
                    newItem = new Item();
                    newItem.worry = resultWorry;
                    passTo = (Long.remainderUnsigned(resultWorry,m.divisibleByTest) == 0) ? monkeys.get(m.passMonkey) : monkeys.get(m.falseMonkey);
                    passTo.itemList.add(newItem);
                }
                m.itemList.clear();
            }
        }

        Arrays.sort(itemCount);
        return itemCount[itemCount.length-1]*itemCount[itemCount.length-2];
    }

    public static List<Monkey> parse(String s){
        List<Monkey> monkeyList = new ArrayList<Monkey>();
        String monkeys[] = s.split("Monkey ");
        for( String monkey : monkeys){
            if(monkey.length() <= 1 ) continue;
            Monkey currMonkey = new Monkey();
            currMonkey.itemList = new ArrayList<Item>(100);
            
            currMonkey.num = Integer.parseInt(monkey.substring(0,1));
            String[] attribs = monkey.split( "  ");
            for(String attrib : attribs){
                if(attrib.startsWith("Starting items:")){
                    String[] list = attrib.substring(15).trim().split(", ");
                    for(String item : list){
                        Item i = new Item();
                        i.worry = Long.parseLong(item.trim());
                        currMonkey.itemList.add(i);
                    }
                }
                else if(attrib.startsWith("Operation:")){
                    String[] ops = attrib.substring(20).trim().split(" ");
                    currMonkey.operator = ops[0].charAt(0);
                    currMonkey.operand2 = ops[1].equals("old") ? 0 : Long.parseLong(ops[1]);
                }
                else if(attrib.startsWith("Test:")){
                    currMonkey.divisibleByTest = Long.parseLong(attrib.substring(19).trim());
                }
                else if(attrib.startsWith("If true:")){
                    currMonkey.passMonkey = Integer.parseInt(attrib.substring(attrib.length()-1));
                }
                else if(attrib.startsWith("If false:")){
                    currMonkey.falseMonkey = Integer.parseInt(attrib.substring(attrib.length()-1));
                }
            }
            monkeyList.add(currMonkey);
        }
        for(Monkey m: monkeyList){ modulo *= m.divisibleByTest;}
        return monkeyList;
    }

    public static String getTestInput(){
return
"Monkey 0:"+
"  Starting items: 79, 98"+
"  Operation: new = old * 19"+
"  Test: divisible by 23"+
"    If true: throw to monkey 2"+
"    If false: throw to monkey 3"+
""+
"Monkey 1:"+
"  Starting items: 54, 65, 75, 74"+
"  Operation: new = old + 6"+
"  Test: divisible by 19"+
"    If true: throw to monkey 2"+
"    If false: throw to monkey 0"+
""+
"Monkey 2:"+
"  Starting items: 79, 60, 97"+
"  Operation: new = old * old"+
"  Test: divisible by 13"+
"    If true: throw to monkey 1"+
"    If false: throw to monkey 3"+
""+
"Monkey 3:"+
"  Starting items: 74"+
"  Operation: new = old + 3"+
"  Test: divisible by 17"+
"    If true: throw to monkey 0"+
"    If false: throw to monkey 1";
    }

    public static String getInput(){
return "Monkey 0:"+
"  Starting items: 71, 86"+
"  Operation: new = old * 13"+
"  Test: divisible by 19"+
"    If true: throw to monkey 6"+
"    If false: throw to monkey 7"+
""+
"Monkey 1:"+
"  Starting items: 66, 50, 90, 53, 88, 85"+
"  Operation: new = old + 3"+
"  Test: divisible by 2"+
"    If true: throw to monkey 5"+
"    If false: throw to monkey 4"+
""+
"Monkey 2:"+
"  Starting items: 97, 54, 89, 62, 84, 80, 63"+
"  Operation: new = old + 6"+
"  Test: divisible by 13"+
"    If true: throw to monkey 4"+
"    If false: throw to monkey 1"+
""+
"Monkey 3:"+
"  Starting items: 82, 97, 56, 92"+
"  Operation: new = old + 2"+
"  Test: divisible by 5"+
"    If true: throw to monkey 6"+
"    If false: throw to monkey 0"+
""+
"Monkey 4:"+
"  Starting items: 50, 99, 67, 61, 86"+
"  Operation: new = old * old"+
"  Test: divisible by 7"+
"    If true: throw to monkey 5"+
"    If false: throw to monkey 3"+
""+
"Monkey 5:"+
"  Starting items: 61, 66, 72, 55, 64, 53, 72, 63"+
"  Operation: new = old + 4"+
"  Test: divisible by 11"+
"    If true: throw to monkey 3"+
"    If false: throw to monkey 0"+
""+
"Monkey 6:"+
"  Starting items: 59, 79, 63"+
"  Operation: new = old * 7"+
"  Test: divisible by 17"+
"    If true: throw to monkey 2"+
"    If false: throw to monkey 7"+
""+
"Monkey 7:"+
"  Starting items: 55"+
"  Operation: new = old + 7"+
"  Test: divisible by 3"+
"    If true: throw to monkey 2"+
"    If false: throw to monkey 1";
    }
}

class Item{
    long worry;
}
class Monkey{
    int num;
    char operator;
    long operand2;
    List<Item> itemList;
    long divisibleByTest;
    int passMonkey;
    int falseMonkey;
}
