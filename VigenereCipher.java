/**
 * An enciphering/deciphering program by the Vigenére cipher method
 * 
 * @author Seunghyeon (Hyeon) Kim
 * @version 1 of Sep. 2023
 */

import java.io.PrintWriter;

public class VigenereCipher {
  /**
   * @param num
   * @param div
   * @pre The input "num" can be any integer (positive, negative, 0) while divisor, 
   * "div," has to be positive.
   * @post The output will be an integer that is num-mod-div.
   * @comments While normal modulo operators do not operate with negative numbers, 
   * this is a modified version of modulo to work with negative nums.
  */
  public static int newMod(int num, int div){
    int newNum = num%div;
    if(newNum < 0){
      return div-((-1)*newNum%div); // negative indexing solved div-|newNum%div|
    } // if
    return newNum; // positive indexing
  } // newMod (int, int)

  /**
   * @param m
   * @param key
   * @pre The input has to be characters where m is the character of the message,
   * and key is the key for encoding.
   * @post The output is a character m encoded by the key.
   * @comments This function is a helper function for encipher, and it was modified from the
   * Caesar cipher. They return '\0' when invalid input is given.
   */
  public static char encodeChar(char m, char key){
    if(('a'<= m && m <= 'z') && ('a'<= key && key <= 'z')){
      char temp = m;
      temp -= 'a'; // clearing temp char to make the modulo 26 work
      temp += (key-'a');
      temp = (char)newMod((int)temp, 26); // utilizing newMod to be used to add on to the key, and mod it down
      temp += 'a'; // adding back 'a' which was removed when clearing
      return temp; // returning output
    }else{
      return '\0'; // returns empty char when the input is invalid.
    } // if/else
  } // encodeChar (char, char)
  /**
   * @param m
   * @param key
   * @post The input has to be characters where m is the character of the message,
   * and key is the key for decoding.
   * @pre The output is a character m decoded by the key.
   * @comments This function is a helper function for decipher, and it was modified from the
   * Caesar cipher. They return '\0' when invalid input is given.
   */
  public static char decodeChar(char m, char key){
    if(('a'<= m && m <= 'z') && ('a'<= key && key <= 'z')){
      int temp = (int)m;
      temp -= (int)'a'; // clearing temp char to make the modulo 26 work
      temp -= ((int)key-(int)'a'); // clearing key char to make the modulo 26 work
      temp = newMod(temp, 26); // utilizing newMod to be used to add on to the key, and mod it down
      temp += 'a'; // adding back 'a' which was removed when clearing
      return (char)temp; // returning output
    }else{
      return '\0'; // returns empty char when the input is invalid.
    } // if/else
  } // decodeChar(char, char)

  /**
   * 
   * @param message
   * @param key
   * @pre The input must be 2 strings: "message" is the message that the user
   * wants to encipher, and "key" must a non-empty string that is used to encode the 
   * message.
   * @post The function, under correct inputs, will output the enciphered message
   * with Vigenère method.
   * @comments The special characters that cannot be enciphered will be printed as empty.
   */
  public static String encipher(String message, String key) throws IllegalArgumentException{
    if(message.equals("")||key.equals("")){
      throw new IllegalArgumentException(); // when any of the inputs are empty, it will return message itself
    } // if
    char[] temp = message.toCharArray(); // converting temp and key to char arrays for encoding and decoding
    char[] keyArr = key.toCharArray();
    for(int i = 0; i < message.length(); i++){
      temp[i] = encodeChar(temp[i], keyArr[i%key.length()]); // recurring index on key to repeat vigenere ciphering
    } // for
    String ret = new String(temp); // making the final char arr into string
    return ret;
  } // encipher (String, String)

  /**
   * @param message
   * @param key
   * @pre The input must be 2 strings: "message" is the message that the user
   * wants to decipher, and "key" must a non-empty string that is used to decode the 
   * message.
   * @post The function, under correct inputs, will output the deciphered message
   * with Vigenère method.
   * @comments The special characters that cannot be deciphered will be printed as empty.
   */
  public static String decipher(String message, String key) throws IllegalArgumentException{
    if(message.equals("")||key.equals("")){
      throw new IllegalArgumentException();
    } // if
    char[] temp = message.toCharArray(); // converting temp and key to char arrays for encoding and decoding
    char[] keyArr = key.toCharArray();
    for(int i = 0; i < message.length(); i++){
      temp[i] = decodeChar(temp[i], keyArr[i%key.length()]); // recurring index on key to repeat vigenere ciphering
    } // for
    String ret = new String(temp); // making the final char arr into string
    return ret;
  } // decipher (String, String)

  public static void main(String[] args) throws Exception{
    PrintWriter pen = new PrintWriter(System.out, true);
    if(args.length != 3){
      pen.println("Too few Arguments!"); // throws an error when there aren't enough or too many arguments were given
      return;
    } // if
    if(args[0].equals("encode")){
      pen.println(encipher(args[1], args[2]));
    }else if(args[0].equals("decode")){
      pen.println(decipher(args[1], args[2]));
    }else{
      pen.println("The only valid options are \"encipher\" and \"decipher\""); // throws an error when invalid argument was given
    } // if/else
  } // main (String[])
} // Class VigenereCipher
