import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon_1018 {

	static boolean origin[][];
	static int min = 64; // 총 말판 갯수 8x8
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		origin = new boolean[N][M];
		
		//전체 NxM 배열에 현재 문자들 넣
		for(int i=0; i<N; i++){
			
			String line = br.readLine();
			
			for(int j=0; j<M; j++){				
				origin[i][j] = (line.charAt(j)=='W')?true:false;
			}
		}
		
		//(N-7)*(M-7)*2; //경우의수 -> 8x8이므로 가능한 가짓수는 M이 8 N이 8일 때 1가지이므로 (8-7)*(8-7) 과 첫번째 말이 흑,백 2가지 이므로 2를 곱한다. 
		int row = N-7;
		int col = M-7;
 		 
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				find(i, j); // 현재 시작하는 좌표값 전달.
			}
		}

		System.out.println(min);
		
	}
	
	public static void find(int x, int y){
		int end_x = x+8;
		int end_y = y+8;
		int count = 0; // 총 고쳐야할 말
		
		boolean TF = origin[x][y];
		
		for(int i=x; i<end_x; i++){
			for(int j=y; j<end_y; j++){
				if(origin[i][j] != TF){
					count++;
				}
				
				TF = (!TF);
			}
			TF = (!TF);
		}

		count = Math.min(count, 64 - count); // 총 체스판의 수는 64, 바꿔야할 부분이 64의 과반수 보다 높다면 아닌 부분을 바꾸는 것이 더 효율적이므로.
		
		min = Math.min(min, count); // 최솟값과 현재의 바꿔야할 값을 비교해서 더 작은 값을 최솟값으로 업데이트
	}

}
