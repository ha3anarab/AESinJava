# AESinJava
Advance AES Example

you should to 3 step to see the outcome

1- create key and IV
  Use [Starter.java](https://github.com/ha3anarab/AESinJava/blob/Server/Clinet/src/Starter.java) class and run it from "main" method.
  Save "SecretKey" and "IV". We need it for initFromString method.
  
2-run Server side app
  need some change in [Server.java](https://github.com/ha3anarab/AESinJava/blob/Server/Clinet/src/Server.java) -> in "main" method change "SecretKey" and "IV" in "initFromStrings" method to given text from Starter.
  run "main" in Server.java and it show "Encrypted Text".
  
3-run Client side app
  need some change in [Client.java](https://github.com/ha3anarab/AESinJava/blob/Server/Clinet/src/Client.java) -> in "main" method change "SecretKey" and "IV" in "initFromStrings" method to given text from Starter.
  change "decryptedMessage" to given "Encrypted Text" from Server.java
  run "main" in Client.java and it show "Decrypted Message"
