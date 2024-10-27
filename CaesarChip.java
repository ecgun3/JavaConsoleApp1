import java.util.Scanner;

public class CaesarChip {

     public static String encryption(int key,String text)
     {
          //StringBuffer sınıfı --> düzenlemeyi sağlar stringde
          StringBuffer result = new StringBuffer();

          for(int i = 0; i < text.length(); i++)
          {
               //tek tek karakterlere erişim
               char c = text.charAt(i);

               if (Character.isLetter(c))  // harf mi kontrol et
               {

                    char base = Character.isLowerCase(c) ? 'a' : 'A'; // Küçükse taban a büyükse A
                    char newChar = (char) ((c - base + key) % 26 + base); // Encyrp işlemi
                    result.append(newChar); // Yeni karakteri nesneye ekle
                    
               } else 
                    result.append(c); // harf değilse doğrudan ekledik
          }

          // toString ile String'e çevirdik --> çünkü fonksioynun donüş tipi String
          return result.toString();
     }

     public static void main(String[] args)
     {
          Scanner input = new Scanner(System.in);

          //variables
          int choice;
          int shiftValue;

          //Submenu için 1-3 arasında bir seçenek iste kullanıcıdan, bunların haricinmde girerse tekrar iste
          do {
               //2-Submenu: 
               System.out.println("\nSubmenu\n\n1-Encryption\n2-Decryption\n3-Return to the Main Menu\n");
               
               System.out.print("Make a choice: ");
               choice = input.nextInt();

               if (choice < 1 || choice > 3) 
               {
                    System.out.println("Please make a choice in the given scale!"); // Error geçersiz input için
                    continue; // kODUN geri kalanını atladık (en başa döner)
               }

               switch (choice) {
                    case 1:
                         System.out.println("Encryption selected!");
     
                         while (true) {
                              
                              //1- int 'shif' değeri al [-26,26]
                              System.out.print("Enter a 'shift' value between -26 and 26 (include): ");
                              shiftValue = input.nextInt();
                              
                              //2- Aralıkta olup olmadığını kontrol et
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
     
                         // Buffer temizleme 
                         input.nextLine();
     
                         System.out.print("Enter the message to be encrypted: ");
                         String message2Encrypt = input.nextLine();
     
                         //Mesajı şifrele
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
     
                         //Decyrpt:
                         String DecryptedMessage = encryption((26-shiftValue),message2Decrypt);
                         
                         System.out.printf("key: %d%nMessage: %s%nDecrypted: %s%n",shiftValue,message2Decrypt,DecryptedMessage);
                         break;
                    case 3:
                         System.out.println("Returning to main menu!");
                         break;
               }
          } while (choice != 3); //3'ü seçerse looptan çık ve ana menüye dön
     }

}
