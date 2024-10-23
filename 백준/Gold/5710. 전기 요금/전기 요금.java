import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
        	String instr=in.readLine();
        	if(instr.equals("0 0")) {
        		break;
        	}
        	String[] split=instr.split(" ");
        	int A=Integer.parseInt(split[0]);
        	int B=Integer.parseInt(split[1]);
        	

        	int last=cal_watt(A);
        	
        	int a=0;
        	int b=last/2;
        	while(a<=b) {
        		int middle=(a+b)/2;
        		
        		int fir=cal(middle);
        		int sec=cal(last-middle);
        		
        		int diff=Math.abs(fir-sec);
        		
//        		if(Math.abs(cal(myuse)-cal(otheruse))==B) {
//        			b=Math.min(myuse, otheruse);
//        			break;
//        		}
        		if(diff<B) {	
        			b=middle-1;
        		}else if(diff>B){
        			a=middle+1;
        		}else {
        			b=Math.min(fir,sec);
        			break;
        		}
        		

        	}

        	System.out.println(b);
        }
    }
    
    public static int cal_watt(int p) {
        if(p <= 200) {
            return p / 2;
        } else if(p <= 29900) {
            return (p - 200) / 3 + 100;
        } else if(p <= 4979900) {
            return (p - 29900) / 5 + 10000;
        } else {
            return (p - 4979900) / 7 + 1000000;
        }
    }

	private static int cal(int me) {

		int myFee=0;
		
		if(me<=100) {
			myFee=me*2;
		}else if(me<=10000) {
			myFee=(2*100)+(3*(me-100));
		}else if(me<=1000000) {
			myFee=(2*100)+(3*9900)+(5*(me-10000));
		}else {
			myFee=(2*100)+(3*9900)+(5*990000)+(7*(me-1000000));
		}
		
		
		return myFee;
	}
}