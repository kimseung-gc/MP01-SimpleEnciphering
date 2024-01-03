# Simple Enciphering

## Groups
```
Seunghyeon Kim
```

## Description
```
I created a program that can encrypt alphabets into Caesar Cipher method and Vigenère Cipher method.
CaesarCipher takes in encoded/decoded message, and decodes/encodes it by trying 26 
combinations of keys that are possible; similar with CaesarCipher, VigenéreCipher
takes in an ecoded/decoded message, and encodes/decodes with the given key to the
message. (e.x. VigenereCipher("hello", "cap") = {'h'+'c', 'e'+'a', 'l'+'p', 
'l'+'c', 'o' + 'a'}.toString() = "jeano").
```

## Files Included
```
CaesarCipher.java
VigenereCipher.java
CHANGES.md
README.md
```

## How to Compile
```
javac -d bin/ *.java
```

## How to Run

### Caesar Cipher
```
java -cp bin CaesarCipher <option> <word/phrase>

<option> ∈ {"encode", "decode"}
"encode" : encodes the <word/phrase> into all 26 possible outcomes of encrypting 
with Caesar Cipher method
"decode" : decodes the <word/phrase> into all 26 possible outcomes of decrypting
with Caesar Cipher method

<word/phrase> can be any valid string input desired to be encoded or decoded (they shall 
not contain any special characters other than the alphabets).
```

### Vigenère Cipher
```
java -cp bin VigenereCipher <option> <word/phrase> <key>

<option> ∈ {"encode", "decode"}
"encode" : encodes the <word/phrase> into an encrypted message using Vigenère Cipher method
using the given <key>
"decode" : decodes the <word/phrase> into a decrypted message using Vigenère Cipher method 
using the given <key>

<word/phrase> can be any valid string input desired to be encoded or decoded (they shall 
not contain any special characters other than the alphabets).

<key> can be any valid string input desired to be encode or decode the given <word/phrase> 
(they shall not contain any special characters other than the alphabets).
```

## Acknowledgements
```
Professor Sam. Rebelsky
https://rebelsky.cs.grinnell.edu/Courses/CSC207/2023Fa/mps/mp01.html
```