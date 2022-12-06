import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;
import java.util.HashSet;
public class Advent_06{
    public static void main(String[] args){
        System.out.println(getCharNum(getInputString()));
        System.out.println(getCharNum14(getInputString()));
    }

    public static int getCharNum14(String s){
        Queue<Character> fifo = new LinkedList<Character>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < 14; i++) { fifo.add(chars[i]); }
        for(int i = 14; i < chars.length; i++){
            if(!checkQueueForDups(fifo)) return i; 
            else{fifo.remove(); fifo.add(chars[i]);}
        }
        return 0;
    }

    public static int getCharNum(String s){
        Queue<Character> fifo = new LinkedList<Character>();
        char[] chars = s.toCharArray();
        fifo.add(chars[0]);fifo.add(chars[1]);fifo.add(chars[2]);fifo.add(chars[3]);
        for(int i = 4; i < chars.length; i++){
            if(!checkQueueForDups(fifo)) return i; 
            else{fifo.remove(); fifo.add(chars[i]);}
        }
        return 0;
    }

    public static boolean checkQueueForDups(Queue<Character> q){
        Set<Character> s = new HashSet<Character>();
        for(char c : q){
            if(s.contains(c)) return true;
            else s.add( c);
        }
        return false;
    }

    public static String getInputString(){
        return "pnnfhnhshrhmhwwmwzmznmnwmwfmfhfjfcjjtgtbggpdgdjjbjrjsjpjrrmddmgmpmddrhddnfnfzfpfvpfpprhhlffmtffqhhdtdcdsswsdwswmmfvvpdprrnnhhhtffnfbbznbznnvdnnbffjrfrbfrbrgbrrntnggrqqwtqwwgjgsswgwqwtwwsvwvbwvwrwlrlppzfzwfzzpmzzhqqzqlzlglzzmrmwrmwwvmwvvnppjfjttlffhjjjsccbggnffqgfgjjnccmdmzmllvnlnznttlvlttvnvgnvvqvmvqqzrqqcgglzzwtztwwmjmzjjnddsffqrqlrrvsvdvldvvlgvlvccdzczcqcpphggtnthhhtbhtttcjtjcjgcjcbbrhbbfrffgjgdgzddcttczzsccbpcpddcpcggmjgjddtcccthccfrccmdmhmddnwddfldffntnptnpttcptcptpfphhmfmwfwmmlblgbgvbvlltqltldttfcfcclgcllmplmlbbjnjzjnzzttnvvgddshddsqddggsqgqddsggdhghjgjhhgchhdmdjmjddgdhghrrphrrpnnqhhjwwqrrcmmslmmszzpgzpzzrmzmznzllnjnnlnbbdvdsdffbpffcmmnznqqcbbzvvjnjvvwqwgqqpnnzwnzwnzwwwlpwpzzfqzfqqwnqnbnfnqnbqqbggqnqdndrrzzlffbbgqgfgrfrqqsddnqnqjjgssqwqwcqcpcrrqppwpjjfnfpffhphwwmcwwznwznnplptlplnlsnlsldslslsffwtwftwtbtdbbjsjcczwwfllwtlwtlwlvwlwrwppsggvcvrrqcrqqvmqvmmbrrsbsfspspjpnnmpmqmcczgzffqmfmtmpppwzppzrpzrzsrrpqrpqpmpvmpvpttbqtqmtmjttqdqgggcppclcjcpcsppctpplpdpcppcmmdzmzddvhvhnhrrldllcwwbnwnssshlhrhthggtmggbjbjwwbvbttjllvrrfggngvngnmmvzzrrmddmcddztztctfccqpcpcqqvqppqcqdcdhhvhssgfgzgwwzmmnssvwwbqbhbnhnphpqqjcqcddfwfttqjtqtlttglljgjbgjgnnsqqvrvffqvqfqbffljjpffssqdsqstqqqldqqmhmsmsqqwtqwqdqgdgjjfbjffgbbrhhqghgppqgpgmpmmfzfhhfrhffgmfggpzgpzzhtzhhlbhhqbbzvvnvqnntptmmbhbdhdwwmjjcnnmsscqcbbtjtvjvwjvvmsmjmtmpmgghttcztzggpddbfbfgbbdsdrsrrqfqjjqfjjhzhtzzmdzzcgzgdzzmvmmfmjmgjmggmppbdppmzpppvfppzhhfsfwfhhpjpmmrjjpssdccjpjpwjppvdpphcpcjcfjfwjfwfjwfjjqcqcwqqqsmmmbbgdgwwpcwwdfdlflrltlgtthfhfjhhlthtddlgdggsjsrrdpdcppgttphpgpwppmpzmmrjmmvjvgvgfglfgllbqlqhllszzlwwhzzdfdcdtctptwtztfzzmjzjtjtrjrcrnrjjmwmnnbddgvgtgsstjsszmpqdmzgqflrbrspjmtzjcrmlzltmhgblghnwqvwwqwzbpnfrpdpblpjgshfccfbjfsnwvvhnjftsdnsgtzzjtzpmtfdvzrhtqpblhwgmqtgpbfvbdmsnrrrvvbstpsznvbbwgjfqjrhdvwvgptpglpfddhddmtglmjlpwlvfpbtbmgbplbzrlpdlvqzcwhbscpszgfstjpfdvfpmljlngrbgrdnnblzqrfpzsdvblpwbtnhdjclldvwvbwcwzfzbdspgwpfqjfbdbrqcshtlvcrdstnzggbwqnzbrfzbpnrtmvpbvdhcvdsdshgtvhfgdzljflppqbwclnvbhbczvrscjhlbgbfvwdjhnjsgmvwhpfgwbbmnndpnglfrmtfdzvqgfjdqfhgrhvpbqndmqnqccgwswwdsqjnbjtjbjdbqgjnmfbdvlnfwbnrdqgvgzzhmmbbdzfdvvpwhpbwbnzdcdpchrwlhfsjnhhjggvplmqggwjdsvjtpnpnqgldjjdcscrdltssjdrpcrfbgbcjfplhzgwbprfcslhpcngtszrghmwhzdqscbfrhzdwcffzvmjrmcjcstfvhplvrsglgsjnjtrpddsdfqjsndjnfmvdhfgdbzzflqhsrrwmrnlpqzmcddqbqvvzgtlztpgjnddtcnbmqsjlhmcszrmcjvwzpptlfqsmpvgnzvrjdwzpdwqgbmdgdtvjlmfczthjbcgfhbqpnmlbmrwwhfptzlbmfdhssznjcvjbmnjtnvzjhzczlrrdnttmmcbnzhqpplzqwgttwrnwfvmnptgqlfrnzvqpjfgrzwmlcwvtptvcvrlsrdwdgqfvffspmdbnnrqjttpqvhvdpbcrvzptwnhhfsqzchmncvttcdgdnlppcfzpmjpvbvqhlvplwvrmmbbggbwttwmvsqjlllsftprsmtmnzjcqfzblrllzgshfljchrjwjlpvhpbrtrsschzltrblgjnbgdnmwdggjhqggntblnhsvfgsbcblhmctbqzqwmhqnjhpzjfqpjdgwpzhczcftfcpdhvzhzccmwmrfrbqshzmtpqgpbbvfqqbjbmvnlnlwjtzrpmhdlffccrqcfgsjfszbrzrfztntchtmgmbhjgmlsqzcbtqqjzzlghtzzqmlnnvsgsvbbjfgqsqbqmqrdzwpwdgbggpdvhvnlzshhntprjdwhnwfvdjzpqgflwrvwgtmfdmfdztcbtfnjdrvgdwwczdgphnvdgrbdchprqldfjrvcsflcmlcmzqvqgsgnzcgmrhccgcmptcdzhbcdgdtppwztfstzqqzqrdzlnzthggjmpcflmbcmdrrjnnpbpqfmjbzqbtsjjgdlmgncbmgspqqvbrvzrdjscpzjsdtcdvsdwqlmwrngttswnrsbqctvhgfnnwblpcqzdmzpfchplslspmghvgcqntmlrfhgpcbpspvfhnvqvglsqzsnsdzddqpbsjhlclslngbwvvgjhwfcncqsmqwbptzvpzlzslsjjjldjpwpfrdlfbjphqcjtsgqdsdfdjhqgdhcppndwmhmmldvvmblcqcqfqhltbcbvrnghjfmtgqwtwljtczvqlnmgscjhqdhnzwhzvzzqnlsrhqvljqpgpwghfqlhjjrrhvnmnnrbnlhdcjctwtlhmhhmhjvcgzdrzmdjrvqzgnsttjdwglgwlcmbcdnjprgfsbbdzzngbqdrvwwwhbtlnnmzqdjttsrrpvlfdqnfhhtdtvmpcjgdwtbnqmwmtszdqfmbhjsjpqqddzfggwjhbtlnqfgcwbjzdtcpcpzgnrmnvwlpgmwfjlpgppdfrfvvjwsfcdqdnpcpjbqsvhttssgptqjghctrbgntlfjzdrfjccsprsjlrrwrzsmnjsqslmpdtrvhlqbnmgpjthpqdqmnvrtzlhhzzfzbrcclpmpcszhbttgrtcpgcpjwpdbfpfvgspsgtvglwthqcmcvmrfmclwlvjlsptfgmtlrnsvjrnfwzhdcsmgztpzfcvzwdztpppvqpvqfpdrsfnlhrbqwrsqjtwjmhnpwmqmpdgdhbtbpfwnmswffdqffdggrdrpmngvpzplmmwlddnhcvjjzqqfsbbtfmzdwnpvbjrshmllczhgvwwcbcbtfrfnplqjwmjlvpwwgfrtffwddwppsgtnlmpvfnhfzcsgjbqbjmbvpnqppsrvwnlzvcmjqgtbzrdsnrgwbfmrvnflgccrssfvcwgllqqbbcthzmbtnsmbzbcczhtzcvmthttpltrtdmgspctvtpvqbhmnnpnjwmhpqclmjsdrbjwvjbtzcjlqbjsvbgdwqzflnwzcfjwtrhjgfshfmwbjfwpnhjsmtpgbpwlfjjnmdlrhchmnfmgmgcrftmwbzshdwbhndgwtjbrrvbwprqppfmgfmfllpcjgrwdmtzddthsjlgjljv";
    }
}
