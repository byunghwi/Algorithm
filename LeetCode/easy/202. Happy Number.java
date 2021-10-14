class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        
        
        while(!set.contains(n)){
            int sum = 0;
            set.add(n);
            
            while(n > 0){
                sum += (n%10)*(n%10);
                n /= 10;
            }

            n = sum;

        }
        return n==1;
    }
}
