package ar.edu.ubp.das.ws;

public class FactorialWS {
	
	public long[] getFactorial(int nro) {
		long[] factorial = new long[nro + 1];
		for(int i = 0, l = nro; i <= l; i++) {
			factorial[i] = this.fact(i); 
		}
		return factorial;
	}	
	
	private long fact(long nro) {
		if(nro == 0) {
			return 1;
		}
		else {
			return nro * fact(nro - 1);
		}
	} 
	
}
