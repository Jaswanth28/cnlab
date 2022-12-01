import java.math.*;
import java.util.*;

class rsat1 {
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		int p, q, n, z, d = 0, e, i;
		System.out.print("enter msg to be encrypted(int only): ");
		int msg = s.nextInt();
		double c;
		BigInteger msgback;
		p = 3;
		q = 11;
		n = p * q;
		z = (p - 1) * (q - 1);
		System.out.println("the value of z = " + z);

		for (e = 2; e < z; e++) {
			if (gcd(e, z) == 1) {
				break;
			}
		}
		System.out.println("the value of e = " + e);
		for (i = 0; i <= 9; i++) {
			int x = 1 + (i * z);
			if (x % e == 0) {
				d = x / e;
				break;
			}
		}
		System.out.println("the value of d = " + d);
		c = (Math.pow(msg, e)) % n;
		System.out.println("Encrypted message is : " + c);
		BigInteger N = BigInteger.valueOf(n);
		BigInteger C = BigDecimal.valueOf(c).toBigInteger();
		System.out.print("Decrypt msg? enter Y else N: ");
		String op=s.next();
		if (op.equalsIgnoreCase("y")) 
		{
			msgback = (C.pow(d)).mod(N);
			System.out.println("Decrypted message is : "+ msg);
		}
		else {
			System.out.println("Program terminated!!!");
		}
	}

	static int gcd(int e, int z)
	{
		if (e == 0)
			return z;
		else
			return gcd(z % e, e);
	}
}
