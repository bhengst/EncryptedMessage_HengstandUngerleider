/**
 * 
 */
package tdd.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.EncryptedMessage;

/**
 * @author TBD
 *
 */
class EncryptedMessageTest {

	@Test
	/**
	 * Invalid character test for message
	 * 
	 *   Expecting null value
	 */
	void specialCharMessageTest() {
		EncryptedMessage message = new EncryptedMessage("?", "a");
		
		assertNull(message.getMessage());
	}
	
	@Test
	/**
	 * Invalid character test for key
	 * 
	 *   Expecting null value
	 */
	void specialCharKeyTest() {
    EncryptedMessage key = new EncryptedMessage("abc", "?");
    
    assertNull(key.getMessage());
  }
	
	@Test
	/**
	 * Space as message
	 * 
	 *   Expecting assertEquals to pass
	 */
	void spaceMessageTest() {
    EncryptedMessage message = new EncryptedMessage(" ", "a");
    
    assertEquals(message.getMessage(), "[");
  }
	
	@Test
	/**
   * all lower case input
   * 
   *   Expecting assertEquals to pass
   */
  void decryptedCapsTest() {
    EncryptedMessage message = new EncryptedMessage("abcd", "a");
    
    assertEquals(message.decryptMessage("a"), "ABCD");
  }
  
	@Test
  /**
   * lowercase input with a space
   * 
   *   Expecting assertEquals to pass
   */
  void spaceCharsTest() {
    EncryptedMessage message = new EncryptedMessage("a bc", "a");
    
    assertEquals(message.getMessage(), "A[BC");
  }
  
	@Test
  /**
   * lowercase input, testing encryption
   * 
   *   Expecting assertEquals to pass
   */
  void modulusEncryptTest() {
    EncryptedMessage message = new EncryptedMessage("xyz", "c");
    
    assertEquals(message.getMessage(), "Z[A");
  }
  
	@Test
  /**
   * lowercase input, testing decryption
   * 
   *   Expecting assertEquals to pass
   */
  void modulusDecryptTest() {
    EncryptedMessage message = new EncryptedMessage("xyz", "c");
    
    assertEquals(message.getMessage(), "XYZ");
  }
	
	@Test
  /**
   * Encrypted message constructor with a space
   * 
   *   Expecting assertNull to pass
   */
  void encryptedMessageTest() {
    EncryptedMessage message = new EncryptedMessage("A BC");
    
    assertNull(message.getMessage());
  }
	
	@Test
  /**
   * lowercase input, testing decryption
   * 
   *   Expecting assertEquals to pass
   */
  void encryptedSpecialTest() {
    EncryptedMessage message = new EncryptedMessage("?");
    
    assertNull(message.getMessage());
  }

}
