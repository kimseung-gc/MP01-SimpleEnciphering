/**
 * An enciphering/deciphering program by the caesar cipher method
 * 
 * @author Seunghyeon (Hyeon) Kim
 * @version 1 of Sep. 2023
 */

import java.io.PrintWriter;

public class CaesarCipher {
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
  } // newMod(int, int)
  /**
   * @param m
   * @param key
   * @pre The input has to be characters where m is the character of the message,
   * and key is the key for encoding.
   * @post The output is a character m encoded by the key.
   * @comments This function is a helper function for encipher. They return '\0' when 
   * invalid input is given.
   */
  public static char encodeChar(char m, char key){
    if(('a'<= m && m <= 'z') && ('a'<= key && key <= 'z')){
      char temp = m;
      temp -= 'a'; // clearing temp char to make the modulo 26 work
      temp += key;
      temp = (char)newMod((int)temp, 26); // utilizing newMod to be used to add on to the key, and mod it down
      temp += 'a'; // adding back 'a' which was removed when clearing
      return temp; // returning output
    }else{
      return '\0'; // returns empty char when the input is invalid.
    } // if/else
  } // encodeChar(char, char)

  /**
   * @param m
   * @param key
   * @pre The input has to be characters where m is the character of the message,
   * and key is the key for decoding.
   * @post The output is a character m decoded by the key.
   * @comments This function is a helper function for decipher. They return '\0' when 
   * invalid input is given.
   */
  public static char decodeChar(char m, char key){
    if(('a'<= m && m <= 'z') && ('a'<= key && key <= 'z')){
      int temp = (int)m;
      temp -= (int)'a'; // clearing temp char to make the modulo 26 work
      temp -= (int)key;
      temp = newMod(temp, 26); // utilizing newMod to be used to add on to the key, and mod it down
      temp += 'a'; // adding back 'a' which was removed when clearing
      return (char)temp; // returning output
    }else{
      return '\0'; // returns empty char when the input is invalid.
    } // if/else
  } // decodeChar(char, char)

  /**
   * @param message
   * @param key
   * @pre The input "message" shall be string and key has to be an integer
   * larger than 0.
   * @post The output of the function is the enciphered message string.
   * @comments If the function has invalid inputs, it will return an empty string.
   * The special characters that cannot be deciphered will be printed as empty.
   */
  public static String encipher(String message, int key) throws IllegalArgumentException{
    if(key < 0 || message.equals("")){
      throw new IllegalArgumentException(); // throwing exception when the message is empty or invalid key was given
    } // if
    char[] returningMessage = message.toCharArray(); // converting temp to char arrays for encoding and decoding
    for(int i = 0; i < message.length(); i++){
      returningMessage[i] = encodeChar(returningMessage[i], (char)key); // encoding the message with given key
    } // for
    String retStr = new String(returningMessage); // recombining the encrypted char array to a string
    return retStr;
  } // encipher(String, int)

  /**
   * @param message
   * @param key
   * @pre the input must be a string with the message, and the other with a 
   * positive valued integer key.
   * @post the output is a string that decodes the message with a given key.
   * @comments The special characters that cannot be deciphered will be printed as empty.
   */
  public static String decipher(String message, int key) throws IllegalArgumentException{
    if(key < 0 || message.equals("")){
      throw new IllegalArgumentException(); // throwing exception when the message is empty or invalid key was given
    } // if
    char[] returningMessage = message.toCharArray(); // converting temp to char arrays for encoding and decoding
    for(int i = 0; i < message.length(); i++){
      returningMessage[i] = decodeChar(returningMessage[i], (char)key); // decoding the message with given key
    } // for
    String retStr = new String(returningMessage); // recombining the decrypted char array to a string
    return retStr;
  } // decipher(String, int)
  public static void main(String[] args) throws Exception{
    PrintWriter pen = new PrintWriter(System.out, true);
    if(args.length != 2){
      pen.println("Incorrect number of parameters"); // throws an error when there aren't enough or too many arguments were given
      return;
    } // if
    String message = args[1];
    //pen.println(newMod(1000, 670));
    if(args[0].equals("encode")){
      for(int i = 0; i < 26; i++){
        pen.print("n = "+ i +": ");
        pen.println(encipher(message, i));
      } // for
    }else if(args[0].equals("decode")){
      for(int i = 0; i < 26; i++){
        pen.print("n = "+ i +": ");
        pen.println(decipher(message, i));
      } // for
    }else{
      pen.println("The only possible options \"encode\" or \"decode\"!"); // throws an error when invalid argument was given
    } // if/else
  } // main(String[])
} // Class CaesarCipher
