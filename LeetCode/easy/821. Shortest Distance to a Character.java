import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestDistancetoaCharacter {
    public static int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];

        List<Integer>list = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==c){
                list.add(i);
            }
        }

        int index = 0;
        for(int i=0; i<s.length(); i++){
            if(index+1 < list.size()){
                int nextIndex = list.get(index+1);
                if(Math.abs(list.get(index)-i) < Math.abs(nextIndex-i)){
                    result[i] = Math.abs(list.get(index)-i);
                }else{
                    result[i] = Math.abs(nextIndex-i);
                    index++;
                }
            }else
                result[i] = Math.abs(list.get(index)-i);

        }
        return result;
    }


    public static void main(String args[]){
        System.out.println(Arrays.toString(shortestToChar("lobeleetcode", 'e')));
    }
}
