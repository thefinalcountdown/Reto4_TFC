package Modelo;

import static org.junit.Assert.*;

import javax.crypto.spec.SecretKeySpec;

import org.junit.Test;

public class AESTest {
    
    private AES AESTest = new AES();
    
    
//	@Test
//	public void testSetKey() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testEncrypt_Decrypt() {
		String texto = "12345678xD";
		String texto_encriptado = AESTest.encrypt(texto, "llave");
		assertEquals(AESTest.decrypt(texto_encriptado, "llave"), texto);
	}
}
