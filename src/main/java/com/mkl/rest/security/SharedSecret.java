package com.mkl.rest.security;

import java.security.SecureRandom;

public class SharedSecret {
	private static byte[] secret;
	public static byte[] getSharedKey() {
		//REMOVE BEFORE PRODUCTION
		if(true){
			return "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA".getBytes();
		}
		if (secret == null) {
			secret = new byte[32];
			new SecureRandom().nextBytes(secret);
		}
		return secret;
	}
}
