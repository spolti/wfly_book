package dswildfly;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class DsPassword {

	public static char[] decode(String secret) throws NoSuchPaddingException,
			NoSuchAlgorithmException, InvalidKeyException, BadPaddingException,
			IllegalBlockSizeException {
		byte[] kbytes = "jaas is the way".getBytes();
		SecretKeySpec key = new SecretKeySpec(kbytes, "Blowfish");

		BigInteger n = new BigInteger(secret, 16);
		byte[] encoding = n.toByteArray();

		Cipher cipher = Cipher.getInstance("Blowfish");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] decode = cipher.doFinal(encoding);
		return new String(decode).toCharArray();
	}

	public static String encode(String secret) throws NoSuchPaddingException,
			NoSuchAlgorithmException, InvalidKeyException, BadPaddingException,
			IllegalBlockSizeException {
		byte[] kbytes = "jaas is the way".getBytes();
		SecretKeySpec key = new SecretKeySpec(kbytes, "Blowfish");

		Cipher cipher = Cipher.getInstance("Blowfish");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encoding = cipher.doFinal(secret.getBytes());
		BigInteger n = new BigInteger(encoding);
		return n.toString(16);
	}

	public static void main(String args[]) throws InvalidKeyException,
			NoSuchPaddingException, NoSuchAlgorithmException,
			BadPaddingException, IllegalBlockSizeException {

		if (args[0].equals("encode")) {
			System.out.println("By Spolti");
			System.out.println(encode(args[1]));
		} else if (args[0].equals("decode")) {
			char[] decodedPassword = decode(args[1]);
			System.out.println("By Spolti");
			System.out.println(decodedPassword);
		} else {
			System.out.println("By Spolti");
			System.out
					.println("Usage: java -jar cript_spolti_utils.jar encode|decode pass|encripted pass");
		}

	}
}