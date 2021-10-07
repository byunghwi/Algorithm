public class UniqueBinarySearchTrees {
    // DP(동적계획법) 사용하여 풀기.
    // ※참고 : https://kj97.tistory.com/56

    public static void main(String[] args){
        System.out.println(numTrees(3));

    }

    public static int numTrees(int n) {
        if(n < 2)
            return 1;

        int[] count = new int[n+1];

        count[0] = 1;
        count[1] = 1;

        for(int i=2; i<n+1; i++){
            for(int j=0; j<i; j++){
                count[i] += count[j] * count[i-j-1];
            }
        }
        return count[n];
    }
}
