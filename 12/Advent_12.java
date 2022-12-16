import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
public class Advent_12{

    public static void main(String[] args){
        char[][] board = parseInput(getInput());
        //Coordinates start = getCoordinates('S', board);
        //System.out.println(shortestPath(start, board, true));
        List<Coordinates> coordList = getAllCoordinates('a', board);
        int minDist = Integer.MAX_VALUE;
        for(Coordinates coords : coordList){
            int res = shortestPath(coords, copy(board));
            if(res == -1) continue;
            minDist = Math.min(minDist,res);
        }
        System.out.println(minDist);
    }
    
    public static int shortestPath(Coordinates start, char[][] board){
        
        Queue<SearchInfo> q = new LinkedList<SearchInfo>();
        q.add(new SearchInfo(start, 'a', 0));

        while(!q.isEmpty()){
            SearchInfo si = q.remove();
            Coordinates curr =  si.coordinates;
            char last =         si.last;
            int dist =          si.dist;

            char currChar = board[curr.x][curr.y];
            currChar = currChar == 'S' ? 'a' : currChar;
            
            // if got to the end location from next highest (z)
            if(currChar == 'E' && last == 'z') { return dist;}
            // if already visited, or more than 1 difference
            if(currChar == 'X' || currChar == 'E' || currChar - last > 1  ){
                continue;
            }

            board[curr.x][curr.y] = 'X';

            Coordinates up =    new Coordinates(curr.x-1, curr.y);
            Coordinates down =  new Coordinates(curr.x+1, curr.y);
            Coordinates right = new Coordinates(curr.x, curr.y+1);
            Coordinates left =  new Coordinates(curr.x, curr.y-1);

            if ( up.x < 0 )                   ; else q.add(new SearchInfo(up,    currChar, dist+1));
            if ( down.x >= board.length )     ; else q.add(new SearchInfo(down,  currChar, dist+1));
            if ( right.y >= board[0].length ) ; else q.add(new SearchInfo(right, currChar, dist+1));
            if ( left.y < 0 )                 ; else q.add(new SearchInfo(left,  currChar, dist+1));
        }
        return -1;
    }



   /* public static int shortestPath(Coordinates curr, Coordinates goTo, char[][] board, char last, int numMoves, Set<String> visited){
        
        char currChar = board[curr.x][curr.y];
        currChar = currChar == 'S' ? 'a' : currChar;
        
        // if got to the end location from next highest (z)
        if(currChar == 'E' && last == 'z') {System.out.println(numMoves); return numMoves;}
        // if already visited, or more than 1 difference
        if(visited.contains(curr.x + "_" + curr.y) || currChar == 'E' || currChar - last > 1 || currChar - last < 0 ){
            return Integer.MAX_VALUE;
        }
        
        HashSet<String> newVisited = ((HashSet)((HashSet)visited).clone());
        newVisited.add(curr.x + "_" + curr.y);

        Coordinates up =    new Coordinates(curr.x-1, curr.y);
        Coordinates down =  new Coordinates(curr.x+1, curr.y);
        Coordinates right = new Coordinates(curr.x, curr.y+1);
        Coordinates left =  new Coordinates(curr.x, curr.y-1);

        int path1 = ( up.x < 0 ) ?                      Integer.MAX_VALUE : shortestPath(up,    goTo, board, currChar, numMoves+1, newVisited);
        int path2 = ( down.x >= board.length ) ?        Integer.MAX_VALUE : shortestPath(down,  goTo, board, currChar, numMoves+1, newVisited);
        int path3 = ( right.y >= board[0].length ) ?    Integer.MAX_VALUE : shortestPath(right, goTo, board, currChar, numMoves+1, newVisited);
        int path4 = ( left.y < 0 ) ?                    Integer.MAX_VALUE : shortestPath(left,  goTo, board, currChar, numMoves+1, newVisited);
        return Math.min(path1,Math.min(path2, Math.min(path3, path4)));
    }*/
/*     public static int shortestPath(Coordinates curr, Coordinates goTo, char[][] board, char last, int numMoves){
        
        // bounds check
        if(curr.x < 0 || curr.x >= board.length || curr.y < 0 || curr.y >= board[0].length) return Integer.MAX_VALUE;

        char currChar = board[curr.x][curr.y];
        currChar = currChar == 'S' ? 'a' : currChar;
        
        // if got to the end location
        if(currChar == 'E' && last == 'z') return numMoves;
        // if already visited, or more than 1 difference
        if(currChar == 'X' || currChar == 'E' || currChar - last > 1){
            return Integer.MAX_VALUE;
        }
        
        char[][] myBoard = copy(board);
        myBoard[curr.x][curr.y] = 'X';

        Coordinates up =    new Coordinates(curr.x-1, curr.y);
        Coordinates down =  new Coordinates(curr.x+1, curr.y);
        Coordinates right = new Coordinates(curr.x, curr.y+1);
        Coordinates left =  new Coordinates(curr.x, curr.y-1);
        int path1 = shortestPath(up,    goTo, myBoard, currChar, numMoves+1);
        int path2 = shortestPath(down,  goTo, myBoard, currChar, numMoves+1);
        int path3 = shortestPath(right, goTo, myBoard, currChar, numMoves+1);
        int path4 = shortestPath(left,  goTo, myBoard, currChar, numMoves+1);
        return Math.min(path1,Math.min(path2, Math.min(path3, path4)));
    } */

    public static char[][] copy(char[][] src) {
        if (src == null) {
            return null;
        }
 
        char[][] copy = new char[src.length][];
        for (int i = 0; i < src.length; i++) {
            copy[i] = src[i].clone();
        }
 
        return copy;
    }

    public static List<Coordinates> getAllCoordinates(char c, char[][] board){
        List<Coordinates> result = new ArrayList<Coordinates>();
        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[x].length; y++){
                if(board[x][y] == c){
                    result.add(new Coordinates(x, y));
                }
            }
        }
        return result;
    }

    public static Coordinates getCoordinates(char c, char[][] board){
        Coordinates result = new Coordinates();
        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[x].length; y++){
                if(board[x][y] == c){
                    return new Coordinates(x, y);
                }
            }
        }
        return result;
    }

    public static String getMyTestInput(){
        String str =
        "Sab "+
        "xxc "+
        "Eed";
        return str;
    }

    public static String getTestInput(){
        String str =
        "Sabqponm "+
        "abcryxxl "+
        "accszExk "+
        "acctuvwj "+
        "abdefghi";
        return str;
    }

    public static String getInput(){
return "abaaaaaccccccccccccccccccaaaaaaaaaaaaaccccaaaaaaaccccccccccccccccccccccccccccaaaaaa "+
"abaaaaaaccaaaacccccccccccaaaaaaaaacaaaacaaaaaaaaaacccccccccccccccccccccccccccaaaaaa "+
"abaaaaaacaaaaaccccccccccaaaaaaaaaaaaaaacaaaaaaaaaacccccccccccccaacccccccccccccaaaaa "+
"abaaaaaacaaaaaacccccccccaaaaaaaaaaaaaaccaaacaaaccccccccccccccccaacccccccccccccccaaa "+
"abccaaaccaaaaaacccaaaaccaaaaaaaaaaaaaccccaacaaacccccccccaacaccccacccccccccccccccaaa "+
"abcccccccaaaaaccccaaaacccccaaaaacccaaaccaaaaaaccccccccccaaaaccccccccccccccccccccaac "+
"abcccccccccaaaccccaaaacccccaaaaacccccccccaaaaaccccccccccklllllccccccccccccccccccccc "+
"abcccccccccccccccccaaccccccccaaccccccccaaaaaaaccccccccckklllllllcccccddccccaacccccc "+
"abaccccccccccccccccccccccccccaaccccccccaaaaaaaaccccccckkkklslllllcccddddddaaacccccc "+
"abacccccccccccccccccccccccccccccccaaaccaaaaaaaaccccccckkkssssslllllcddddddddacccccc "+
"abaccccccccccccccccccccccccccccccccaaaaccaaacaccccccckkksssssssslllmmmmmdddddaacccc "+
"abcccccccccccccccaaacccccccccccccaaaaaaccaacccccccccckkkssssusssslmmmmmmmdddddacccc "+
"abcccccccaaccccaaaaacccccccccccccaaaaaccccccaaaaaccckkkrssuuuussssqmmmmmmmmdddccccc "+
"abcccccccaaccccaaaaaacccccccaaccccaaaaacccccaaaaacckkkkrruuuuuussqqqqqqmmmmdddccccc "+
"abccccaaaaaaaacaaaaaacccccccaaaaccaaccaccccaaaaaacjkkkrrruuuxuuusqqqqqqqmmmmeeccccc "+
"abcaaaaaaaaaaacaaaaaccccccaaaaaacccccaaccccaaaaajjjjrrrrruuuxxuvvvvvvvqqqmmmeeccccc "+
"abcaacccaaaaccccaaaaaaacccaaaaacccacaaaccccaaaajjjjrrrrruuuxxxxvvvvvvvqqqmmeeeccccc "+
"abaaaaccaaaaacccccccaaaccccaaaaacaaaaaaaacccaajjjjrrrrtuuuuxxxyvyyyvvvqqqnneeeccccc "+
"abaaaaaaaaaaacccaaaaaaaccccaacaacaaaaaaaacccccjjjrrrttttuxxxxxyyyyyvvvqqnnneeeccccc "+
"abaaaaaaaccaacccaaaaaaaaacccccccccaaaaaaccccccjjjrrrtttxxxxxxxyyyyyvvvqqnnneeeccccc "+
"SbaaaaaacccccccccaaaaaaaaaccccccccaaaaacccccccjjjrrrtttxxxEzzzzyyyvvrrrnnneeecccccc "+
"abaaaaacccccccccccaaaaaaacccccccccaaaaaaccccccjjjqqqtttxxxxxyyyyyvvvrrrnnneeecccccc "+
"abaaacccccccccccaaaaaaaccaaccccccccccaaccaaaaajjjqqqttttxxxxyyyyyyvvrrrnnneeecccccc "+
"abaaacccccccccccaaaaaaaccaaacaaacccccccccaaaaajjjjqqqtttttxxyywyyyywvrrnnnfeecccccc "+
"abcaaacccccccaaaaaaaaaaacaaaaaaaccccccccaaaaaaciiiiqqqqtttxwyywwyywwwrrrnnfffcccccc "+
"abcccccccccccaaaaaaaaaaccaaaaaacccccccccaaaaaacciiiiqqqqttwwywwwwwwwwrrrnnfffcccccc "+
"abccccccccccccaaaaaacccaaaaaaaacccccccccaaaaaaccciiiiqqqttwwwwwswwwwrrrrnnfffcccccc "+
"abccccccccccccaaaaaacccaaaaaaaaacccccccccaaacccccciiiqqqtswwwwssssrrrrrroofffcccccc "+
"abccccccaaaaacaaaaaacccaaaaaaaaaaccccccccccccccccciiiqqqssswsssssssrrrrooofffaccccc "+
"abccccccaaaaacaaccaaccccccaaacaaacccccccccccccccccciiiqqssssssspoorrrooooofffaacccc "+
"abcccccaaaaaacccccccccccccaaacccccccccccccccccccccciiiqppssssspppooooooooffffaacccc "+
"abcccccaaaaaacccccccccccccaacccccccccccccccccccccccciipppppppppppoooooooffffaaccccc "+
"abcccccaaaaaaccccccccccccccccccccccccccccccccccccccciihppppppppgggggggggfffaaaccccc "+
"abccccccaaacccccccccccccccccccccccaccccccccccccccccchhhhpppppphggggggggggfaaaaccccc "+
"abaaaccccccccccccccccccccccaccccaaacccccccccccccccccchhhhhhhhhhgggggggggcaacccccccc "+
"abaaccaaaccaccccccccccccccaaacccaaacaacccaaaaacccccccchhhhhhhhhgaaccccccccccccccccc "+
"abaaacaaacaacccccccccaaaccaaaacaaaaaaaaccaaaaaccccccccchhhhhhaaaaacccccccccccccccca "+
"abaaaccaaaaaccccccccccaaacaaaaaaaacaaaaccaaaaaaccccccccccaaacccaaaacccccccccccaccca "+
"abcccaaaaaaccccccccccaaaaaaaaaaaaacaaaaccaaaaaaccccccccccaaaccccaaaccccccccccaaaaaa "+
"abcccaaaaaaaacccccccaaaaaaaaaaaaaaaaaccccaaaaaacccccccccccccccccccccccccccccccaaaaa "+
"abcccaacaaaaaccccccaaaaaaaaaaaaaaaaaaacccccaacccccccccccccccccccccccccccccccccaaaaa";
    }

    public static char[][] parseInput(String str){

        String[] strings = str.split(" ");

        char[][] board = new char[strings.length][strings[0].length()];
        int i = 0;
        for(String s : strings){ 
            char[] a = s.toCharArray() ;
            for(int x = 0; x < a.length; x++){
                board[i][x] = a[x];
            }
            i++;
        }
        return board;
    }
}

class Coordinates{
    Coordinates(){};
    Coordinates(int x, int y){this.x = x; this.y = y;}
    int x;
    int y;
}

class SearchInfo{
    SearchInfo(Coordinates c, char last, int dist){this.coordinates = c; this.dist = dist; this.last = last;}
    Coordinates coordinates;
    int dist;
    char last;
}
