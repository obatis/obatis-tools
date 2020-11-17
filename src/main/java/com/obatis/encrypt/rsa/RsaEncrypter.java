package com.obatis.encrypt.rsa;

import com.obatis.encrypt.base64.Base64Decrypter;
import com.obatis.encrypt.base64.Base64Encrypter;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

/**
 * RSA加/解密
 * 非对称算法；签名算法默认为SHA1WithRSA
 * @author HuangLongPu
 */
public class RsaEncrypter {

	private static final String KEY_ALGORITHM = "RSA";
	private static final int KEY_LENGTH = 1024;
	/**
	 * 加密分块最大值
	 */
	private static final int MAX_ENCRYPT_BLOCK = 117;
	/**
	 * 解密分块最大值
	 */
	private static final int MAX_DECRYPT_BLOCK = 128;

	private Cipher privateEncryptCipher;
	private Cipher privateDecryptCipher;
	private Cipher publicEncryptCipher;
	private Cipher publicDecryptCipher;

	/**
	 * 生成RSA密钥对
	 * @return
	 */
	public static KeyPair generate() {
		KeyPairGenerator keyGen;
		try {
			keyGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		keyGen.initialize(KEY_LENGTH);
		return keyGen.generateKeyPair();
	}

	/**
	 * 生成 Rsa 加解密对象
	 * @param privateKey
	 * @param publicKey
	 * @throws Exception
	 */
	public RsaEncrypter(String publicKey, String privateKey) throws Exception {
		publicEncryptCipher = generatePublicEncryptCipher(publicKey);
		publicDecryptCipher = generatePublicDecryptCipher(publicKey);
		privateEncryptCipher = generatePrivateEncryptCipher(privateKey);
		privateDecryptCipher = generatePrivateDecryptCipher(privateKey);
	}

	/**
	 * 生成公钥加密句柄
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	private static Cipher generatePublicEncryptCipher(String publicKey) throws Exception {
		byte[] decoded = Base64Decrypter.decode(publicKey);
		RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance(KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(decoded));
		//RSA加密
		Cipher publicCipher = Cipher.getInstance(KEY_ALGORITHM);
		publicCipher.init(Cipher.ENCRYPT_MODE, pubKey);
		return publicCipher;
	}

	/**
	 * 生成公钥解密句柄
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	private static Cipher generatePublicDecryptCipher(String publicKey) throws Exception {
		byte[] decoded = Base64Decrypter.decode(publicKey);
		RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance(KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(decoded));
		//RSA加密
		Cipher publicCipher = Cipher.getInstance(KEY_ALGORITHM);
		publicCipher.init(Cipher.DECRYPT_MODE, pubKey);
		return publicCipher;
	}

	/**
	 * 生成私钥句柄
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	private static Cipher generatePrivateEncryptCipher(String privateKey) throws Exception {
		byte[] decoded = Base64Decrypter.decode(privateKey);
		RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) KeyFactory.getInstance(KEY_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(decoded));
		Cipher privateCipher = Cipher.getInstance(KEY_ALGORITHM);
		privateCipher.init(Cipher.ENCRYPT_MODE, rsaPrivateKey);
		return privateCipher;
	}

	/**
	 * 生成私钥句柄
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	private static Cipher generatePrivateDecryptCipher(String privateKey) throws Exception {
		byte[] decoded = Base64Decrypter.decode(privateKey);
		RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) KeyFactory.getInstance(KEY_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(decoded));
		Cipher privateCipher = Cipher.getInstance(KEY_ALGORITHM);
		privateCipher.init(Cipher.DECRYPT_MODE, rsaPrivateKey);
		return privateCipher;
	}

	/**
	 * 公钥加密
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public String encryptByPublicKey(String data) throws Exception{
		return encrypt(publicEncryptCipher, data);
	}

	/**
	 * 公钥加密
	 * @param data
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	public static String encryptByPublicKey(String data, String publicKey) throws Exception{
		Cipher cipher = generatePublicEncryptCipher(publicKey);
		return encrypt(cipher, data);
	}

	/**
	 * 私钥加密
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public String encryptByPrivateKey(String data) throws Exception {
		return encrypt(privateEncryptCipher, data);
	}

	/**
	 * 私钥加密
	 * @param data
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	public static String encryptByPrivateKey(String data, String privateKey) throws Exception {
		Cipher cipher = generatePrivateEncryptCipher(privateKey);
		return encrypt(cipher, data);
	}

	/**
	 * 分段加密
	 * @param cipher
	 * @param data
	 * @return
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 */
	private static String encrypt(Cipher cipher, String data) throws BadPaddingException, IllegalBlockSizeException {
		byte[] dataArray = data.getBytes();
		int dataLength = dataArray.length;
		// 标识
		int offSet = 0;
		byte[] resultBytes = {};
		byte[] cache = {};
		while (dataLength - offSet > 0) {
			if (dataLength - offSet > MAX_ENCRYPT_BLOCK) {
				cache = cipher.doFinal(dataArray, offSet, MAX_ENCRYPT_BLOCK);
				offSet += MAX_ENCRYPT_BLOCK;
			} else {
				cache = cipher.doFinal(dataArray, offSet, dataLength - offSet);
				offSet = dataLength;
			}
			resultBytes = Arrays.copyOf(resultBytes, resultBytes.length + cache.length);
			System.arraycopy(cache, 0, resultBytes, resultBytes.length - cache.length, cache.length);
		}

		return new String(Base64Encrypter.encode(resultBytes));
	}

	/**
	 * 私钥解密
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public String decryptByPrivateKey(String data) throws Exception {
		return decrypt(privateDecryptCipher, data);
	}

	/**
	 * 私钥解密
	 * @param data
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	public static String decryptByPrivateKey(String data, String privateKey) throws Exception {
		return decrypt(generatePrivateDecryptCipher(privateKey), data);
	}

	/**
	 * 公钥解密
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public String decryptByPublicKey(String data) throws Exception {
		return decrypt(publicDecryptCipher, data);
	}

	/**
	 * 公钥解密
	 * @param data
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	public static String decryptByPublicKey(String data, String publicKey) throws Exception {
		return decrypt(generatePublicDecryptCipher(publicKey), data);
	}

	/**
	 * 分段解密
	 * @param cipher
	 * @param data
	 * @return
	 */
	private static String decrypt(Cipher cipher, String data) throws BadPaddingException, IllegalBlockSizeException {

		byte[] dataArray = Base64Decrypter.decode(data);
		int dataLength = dataArray.length;
		// 标识
		int offSet = 0;
		byte[] resultBytes = {};
		byte[] cache = {};
		while (dataLength - offSet > 0) {
			if (dataLength - offSet > MAX_DECRYPT_BLOCK) {
				cache = cipher.doFinal(dataArray, offSet, MAX_DECRYPT_BLOCK);
				offSet += MAX_DECRYPT_BLOCK;
			} else {
				cache = cipher.doFinal(dataArray, offSet, dataLength - offSet);
				offSet = dataLength;
			}
			resultBytes = Arrays.copyOf(resultBytes, resultBytes.length + cache.length);
			System.arraycopy(cache, 0, resultBytes, resultBytes.length - cache.length, cache.length);
		}
		return new String(resultBytes);
	}

}
