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
```
java -cp bin BlockChainDriver <initial amount>
```

## Acknowledgements
```
Professor Sam. Rebelsky
https://rebelsky.cs.grinnell.edu/Courses/CSC207/2023Fa/mps/mp01.html
```