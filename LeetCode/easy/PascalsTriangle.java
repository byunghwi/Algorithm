import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle {
    public static void main (String[] args){
        List<List<Integer>> result = generate(5);

        for(int i=0; i<result.size(); i++){
            for(int j=0; j<result.get(i).size(); j++){
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }


    }

    public static List<List<Integer>> generate(int numRows) {
        // numRows 5
        //           1
        //        1     1
        //      1    2     1
        //   1    3    3     1
        // 1   4     6    4     1

        List<List<Integer>> mainList = new ArrayList<>();

        for(int i=0; i<numRows; i++){

            List<Integer> list = new ArrayList<>();

            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    list.add(1);
                }else{
                    int newInt = mainList.get(i-1).get(j-1) + mainList.get(i-1).get(j);
                    //System.out.println("현재 > " + mainList.get(i-1).get(j-1) + ", " + mainList.get(i-1).get(j));
                    list.add(newInt);
                }

            }

            mainList.add(list);
        }

        return mainList;
    }

}
