import java.io.IOException;
import java.util.Scanner;

public class Birles {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Please enter vertex size");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int i=0;
		System.out.println("Min edge should be "+ (N-1));
		System.out.println("Max edge should be "+ N*(N-1)/2   );
		boolean condition=true;
		//int e=N-1;
		//int e =((N*(N-1)/2)-31);
		int e=N;
		while(i<20) {
		String[] argg = new String[2];
		
		e=e+(((N*(N-1)/2)-(N-1))/20);
		i++;
		argg[0]=Integer.toString(N);
		argg[1]=Integer.toString(e);
		denemee.main(argg);
		PrimMST.main(argg);
		KruskalMST.main(argg);
		//argg=null;
		}
		//small 50 medium 100 big 250 verybig 500
	}

}
