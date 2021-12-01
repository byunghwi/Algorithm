import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BlackJack {

	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String arr[] = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]); // 총 카드의 수
		int M = Integer.parseInt(arr[1]); // 딜러가 제시한 숫자
		
		final int blackjack = M;
		
		int nums[] = new int[N];	//입력 받은 숫자 배열.
		String strNums[] = br.readLine().split(" ");
		
		int result = 0;
		
		for(int i=0; i<N; i++){
			nums[i] = Integer.parseInt(strNums[i]);
		}
		

		for(int i=0; i<N-2; i++){
			if(nums[i] >= blackjack)
				continue;
		  for(int j=i+1; j<N-1; j++){
			  if(nums[i] + nums[j] >= blackjack)
				  continue;
			  
			  for(int k=j+1; k<N; k++){
				  int sum = nums[i] +nums[j] +nums[k];
				  
				  System.out.println("현재 값들 > " + nums[i] + " " + nums[j] + " " + nums[k] + "-> " + sum);
				  if(sum == blackjack){
					  System.out.println("블랙잭 완성 > "+ sum);
					  return;
				  }
				  else if(sum > result && sum < blackjack){
					  result = sum;
					  System.out.println();
					  System.out.println("현재 값들 > " + nums[i] + " " + nums[j] + " " + nums[k] +" / 더한 값 > " + result);
				  }
				  
			  }
		  }
		  
			
		}
		
		System.out.println("최종값 > "+ result);

	}

}
