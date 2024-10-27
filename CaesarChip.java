import java.util.Scanner;

public class CaesarChip {

     public static String encryption(int key,String text)
     {
          StringBuffer result = new StringBuffer();

          for(int i = 0; i < text.length(); i++)
          {
               char c = text.charAt(i);

               if (Character.isLetter(c))
               {

                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    char newChar = (char) ((c - base + key) % 26 + base);
                    result.append(newChar);
                    
               } else 
                    result.append(c); 
          }

          return result.toString();
     }

     public static void main(String[] args)
     {
          Scanner input = new Scanner(System.in);

          int choice;
          int shiftValue;

          do {
               System.out.println("\nSubmenu\n\n1-Encryption\n2-Decryption\n3-Return to the Main Menu\n");
               
               System.out.print("Make a choice: ");
               choice = input.nextInt();

               if (choice < 1 || choice > 3) 
               {
                    System.out.println("Please make a choice in the given scale!");
                    continue; 
               }

               switch (choice) {
                    case 1:
                         System.out.println("Encryption selected!");
     
                         while (true) {
                              
                              System.out.print("Enter a 'shift' value between -26 and 26 (include): ");
                              shiftValue = input.nextInt();
                              
                              if(shiftValue == 0)
                              {
                                   System.out.println("Shift value is 0. No encryption will be performed.");
                                   break;
                              }
                              else if(shiftValue >= -26 && shiftValue <= 26)
                                   break;
                              else
                                   System.out.println("The 'shift' value should be in the [-26,26] range.\nPlease choose again in the scale!");
                         }
     
                         input.nextLine();
     
                         System.out.print("Enter the message to be encrypted: ");
                         String message2Encrypt = input.nextLine();
     
                         String encryptedMessage = encryption(shiftValue,message2Encrypt);
                         
                         System.out.printf("key: %d%nMessage: %s%nEncrypted: %s%n",shiftValue,message2Encrypt,encryptedMessage);
                         break;
                    case 2:
                         System.out.println("Decryption selected!");
     
                         while (true) {
                              
                              System.out.print("Enter a 'shift' value between -26 and 26 (include): ");
                              shiftValue = input.nextInt();

                              if(shiftValue == 0)
                              {
                                   System.out.println("Shift value is 0. No encryption will be performed.");
                                   break;
                              }
                              else if(shiftValue >= -26 && shiftValue <= 26)
                                   break;
                              else
                                   System.out.println("The 'shift' value should be in the [-26,26] range.\nPlease choose again in the scale!");
                         }
     
                         input.nextLine();
     
                         System.out.print("Enter the message to be decrypted: ");
                         String message2Decrypt = input.nextLine();
     
                         String DecryptedMessage = encryption((26-shiftValue),message2Decrypt);
                         
                         System.out.printf("key: %d%nMessage: %s%nDecrypted: %s%n",shiftValue,message2Decrypt,DecryptedMessage);
                         break;
                    case 3:
                         System.out.println("Returning to main menu!");
                         break;
               }
          } while (choice != 3);
     }

}
