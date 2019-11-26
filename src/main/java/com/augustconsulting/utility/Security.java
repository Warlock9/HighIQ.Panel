package com.augustconsulting.utility;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Base64;
import java.util.List;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

@Component
public class Security {

	private final static String characterEncoding = "UTF-8";
	private final static String cipherTransformation = "AES/CBC/PKCS5Padding";
	private final static String aesEncryptionAlgorithm = "AES";

	static String security_result;
	static String date_result;
	public static List<String> li1;
	public static String expiryDate;

	
	public static void main(String[] args) throws KeyException, GeneralSecurityException, IOException {
		String key = "$0123$#ABCD#*4567*%EFGH%@IJKL@&89&-MNOPQRS-!TUVWXYZ!";
		String encrypted = "5Ht38Bn6YClEzPlLoVs5xg==";
		System.out.println(decryptData(encrypted));
		String dycrypted = "0001056131801200150005190909";
		System.out.println(encryptData(dycrypted));

		try {
			String output = decrypt(encrypted, key);
			System.out.println(output);
		} catch (KeyException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	 
	
	/*
	 * public static void main(String args[]) throws ParseException { try { Date
	 * currDate = new Date();
	 * 
	 * String dateStart = "09/10/2019"; SimpleDateFormat format = new
	 * SimpleDateFormat("dd/MM/yyyy"); Date d1 = format.parse(dateStart); //Date d2
	 * = format.parse(currDate);
	 * 
	 * 
	 * //in milliseconds long diff = d1.getTime()-currDate.getTime() ;
	 * 
	 * long diffSeconds = diff / 1000 % 60; long diffMinutes = diff / (60 * 1000) %
	 * 60; long diffHours = diff / (60 * 60 * 1000) % 24; long diffDays = diff / (24
	 * * 60 * 60 * 1000);
	 * 
	 * System.out.print(diffDays + " days, "); System.out.print(diffHours +
	 * " hours, "); System.out.print(diffMinutes + " minutes, ");
	 * System.out.print(diffSeconds + " seconds.");
	 * 
	 * if(diffDays>=0) { System.out.println("Active"); }else if(diffDays<= -30) {
	 * System.out.println("Deactivated");
	 * 
	 * }else if(diffDays<0) { System.out.println("Expired");
	 * 
	 * } } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * }
	 */
	    
	/*
	 * public static Boolean secMethod() {
	 * 
	 * try { String key = "$0123$#ABCD#*4567*%EFGH%@IJKL@&89&-MNOPQRS-!TUVWXYZ!";
	 * String ecryptedTextFile = fetchLicFromFile(); String ecryptedTextDb =
	 * fetchLicFromDataBase(li1); String file_text_decrypt =
	 * decrypt(ecryptedTextFile, key); System.out.println("bbbbbbbbbbb" +
	 * file_text_decrypt); String database_text_decrypt = decrypt(ecryptedTextDb,
	 * key); System.out.println("aaaaaaaaaaa" + database_text_decrypt);
	 * 
	 * if (file_text_decrypt.equals(database_text_decrypt)) { return true; } else {
	 * return false; } } catch (Exception e) { return false; }
	 * 
	 * }
	 */

	/*
	 * public static void main(String[] args) { LocalDate currDate =
	 * LocalDate.now(); LocalDate expiryDate = LocalDate.parse("2019-06-19");
	 * System.out.println(currDate.isAfter(expiryDate)); }
	 */

	/*
	 * public static String fetchLicFromFile() { try { String key =
	 * "$0123$#ABCD#*4567*%EFGH%@IJKL@&89&-MNOPQRS-!TUVWXYZ!"; String ecryptedText =
	 * fetchLicFromDataBase(li1); String database_text_decrypt =
	 * decrypt(ecryptedText, key); String macAddress =
	 * database_text_decrypt.split("#\\|\\|#\\|\\|#")[0]; String fileName =
	 * encrypt(macAddress,key); System.out.println(fileName); fileName =
	 * fileName.replace("/", "").replace("]",
	 * "").replace("\\", "").replace("//", ""); System.out.println(fileName);
	 * 
	 * List<String> s1 = Files.readAllLines(Paths.get(System.getenv("ProgramFiles")
	 * + "\\HighIQ\\"+fileName+".txt")); String filekey = s1.get(0);
	 * System.out.println(filekey); return filekey; } catch(Exception e) {
	 * 
	 * e.printStackTrace(); return ""; } }
	 */

	/*
	 * public static String fetchLicFromDataBase(List<String> li) { String s1 =
	 * li.get(0); System.out.println(s1); return s1; }
	 */

	/*
	 * public static Boolean licCheck(String latestMailDate) { try { String key =
	 * "$0123$#ABCD#*4567*%EFGH%@IJKL@&89&-MNOPQRS-!TUVWXYZ!"; String ecryptedText1
	 * = fetchLicFromFile(); String ecryptedText = fetchLicFromDataBase(li1); String
	 * file_text_decrypt = decrypt(ecryptedText1, key);
	 * System.out.println("its from file liccheck" + file_text_decrypt); String
	 * database_text_decrypt = decrypt(ecryptedText, key);
	 * System.out.println("its from db licckeck" + database_text_decrypt);
	 * 
	 * LocalDate latest_mail_date = LocalDate.parse(latestMailDate.split(" ")[0]);
	 * LocalDate currDate = LocalDate.now();
	 * 
	 * // LocalDate expiryDate = LocalDate.parse("2018-06-01"); LocalDate expiryDate
	 * = LocalDate.parse(database_text_decrypt.split("#\\|\\|#\\|\\|#")[3]); //
	 * LocalDate expiryDate = LocalDate.parse(ee);
	 * 
	 * if ((currDate.isAfter(expiryDate)) || (latest_mail_date.isAfter(expiryDate)))
	 * { return false; } else return true; } catch (Exception e) {
	 * e.printStackTrace(); return false; }
	 * 
	 * }
	 */

	public static String encryptData(String s)
			throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		String key1 = "$0123$#ABCD#*4567*%EFGH%@IJKL@&89&-MNOPQRS-!TUVWXYZ!";
		String encryptedData = encrypt(s, key1);
		return encryptedData;

	}

	public static String decryptData(String s) throws KeyException, GeneralSecurityException, IOException {
		String key1 = "$0123$#ABCD#*4567*%EFGH%@IJKL@&89&-MNOPQRS-!TUVWXYZ!";
		String decryptedData = decrypt(s, key1);
		return decryptedData;

	}

	public static byte[] decrypt(byte[] cipherText, byte[] key, byte[] initialVector)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance(cipherTransformation);
		SecretKeySpec secretKeySpecy = new SecretKeySpec(key, aesEncryptionAlgorithm);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpecy, ivParameterSpec);
		cipherText = cipher.doFinal(cipherText);
		return cipherText;
	}

	public static byte[] encrypt(byte[] plainText, byte[] key, byte[] initialVector)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance(cipherTransformation);
		SecretKeySpec secretKeySpec = new SecretKeySpec(key, aesEncryptionAlgorithm);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
		plainText = cipher.doFinal(plainText);
		return plainText;
	}

	private static byte[] getKeyBytes(String key) throws UnsupportedEncodingException {
		byte[] keyBytes = new byte[16];
		byte[] parameterKeyBytes = key.getBytes(characterEncoding);
		System.arraycopy(parameterKeyBytes, 0, keyBytes, 0, Math.min(parameterKeyBytes.length, keyBytes.length));
		return keyBytes;
	}

	/// <summary>
	/// Encrypts plaintext using AES 128bit key and a Chain Block Cipher and returns
	/// a base64 encoded string
	/// </summary>
	/// <param name="plainText">Plain text to encrypt</param>
	/// <param name="key">Secret key</param>
	/// <returns>Base64 encoded string</returns>

	public static String encrypt(String plainText, String key)
			throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		byte[] plainTextbytes = plainText.getBytes(characterEncoding);
		byte[] keyBytes = getKeyBytes(key);
		// return Base64.encodeToString(encrypt(plainTextbytes,keyBytes, keyBytes),
		// Base64.DEFAULT);
		return Base64.getEncoder().encodeToString(encrypt(plainTextbytes, keyBytes, keyBytes));
	}

	/// <summary>
	/// Decrypts a base64 encoded string using the given key (AES 128bit key and a
	/// Chain Block Cipher)
	/// </summary>
	/// <param name="encryptedText">Base64 Encoded String</param>
	/// <param name="key">Secret Key</param>
	/// <returns>Decrypted String</returns>
	public static String decrypt(String encryptedText, String key)
			throws KeyException, GeneralSecurityException, GeneralSecurityException, InvalidAlgorithmParameterException,
			IllegalBlockSizeException, BadPaddingException, IOException {
		byte[] cipheredBytes = Base64.getDecoder().decode(encryptedText.getBytes("UTF-8"));
		byte[] keyBytes = getKeyBytes(key);
		return new String(decrypt(cipheredBytes, keyBytes, keyBytes), characterEncoding);
	}
}
