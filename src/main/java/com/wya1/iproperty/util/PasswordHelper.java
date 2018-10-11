package com.wya1.iproperty.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.wya1.iproperty.entity.User;

/**
 * 密码加密解密辅助类
 * 
 * @author 任远曼
 *
 */
public class PasswordHelper {

	private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private static String algorithmName = "md5";
	private static int hashIterations = 2;

//	public static void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
//		this.randomNumberGenerator = randomNumberGenerator;
//	}
//
//	public void setAlgorithmName(String algorithmName) {
//		this.algorithmName = algorithmName;
//	}
//
//	public void setHashIterations(int hashIterations) {
//		this.hashIterations = hashIterations;
//	}

	public static void encryptPassword(User user) {

		user.setSalt(randomNumberGenerator.nextBytes().toHex());

		String newPassword = new SimpleHash(algorithmName, user.getPassword(),
				ByteSource.Util.bytes(user.getCredentialsSalt()), hashIterations).toHex();

		user.setPassword(newPassword);
	}
}
