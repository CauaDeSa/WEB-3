package br.edu.ifsp.arqweb1.ifitness.model.util.users;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncoder {
	public static String encode(String password) {
		String encrypted = null;
		
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] bytes = md5.digest(password.getBytes());
			
			StringBuilder builder = new StringBuilder();
			
			for( byte b : bytes) {
				builder.append(String.format("%02x", b));
			}
			
			encrypted = builder.toString();
			
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Erro ao buscar algoritmo", e);
		}
		
		return encrypted;
	}
}