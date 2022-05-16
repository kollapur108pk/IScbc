package infosecutity;


import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
//import org.apache.commons.codec.binary.Base64;

public class cbc {

	private  final static String Algo="AES/CBC/PKCS5padding";
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
		KeyGenerator key=KeyGenerator.getInstance("AES");
		key.init(128);
		SecretKey seceretkey=key.generateKey();
		//SecretKeySpec sks=new SecretKeySpec("1234".getBytes(),"AES");
		
		byte[] bs= new byte[16];
		SecureRandom random=new SecureRandom();
		random.nextBytes(bs);
		
		IvParameterSpec ivparamerterspec=new IvParameterSpec(bs);
		Cipher cipher=Cipher.getInstance(Algo);
        cipher.init(cipher.ENCRYPT_MODE,seceretkey , ivparamerterspec);
       byte[] outputEncryption=Base64.getEncoder().encode(cipher.doFinal("prajwal".getBytes()));
       // byte[] encodedBytes = Base64.getEncoder().encode("Test".getBytes());
       String output=new String(outputEncryption,"UTF-8");
       System.out.println("cipher text :");
       System.out.println(output);
      // System.out.println("message encrypted");
       
       //decryption
       cipher.init(cipher.DECRYPT_MODE,seceretkey , ivparamerterspec);
     //  cipher.doFinal(Base64.DecodeBase64())
      // byte[] outputdecrypted = Base64.getDecoder().decode(cipher.doFinal(output.getBytes()));
       byte[] outputdecrypted = cipher.doFinal(Base64.getDecoder().decode(output.getBytes()));
       
       System.out.println("after decryption plain text");
       System.out.println(new String(outputdecrypted,"UTF-8"));
       
        
	}
	

}

