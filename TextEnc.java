package JavaConsoleApp1;

//if shift value =0 : no change
//if shift value >0 : şifreleme yaparken shift right, şifre çözülürken sola.
//if shift value <0 : şifreleme yaparken shift left, şifre çözülürken sola.
//bu değer -26 dan küçük ve 26 dan büyükse hata mesajı gönderilir.
//alfabetik olmayan karakterler sabit kalır.

//önce kaydırma değeri istenecek
//sonra şifrelenecek mesajın girilmesi istenecek

import java.util.Scanner;

public class TextEnc {

    public static String encrypt(final String msg, int key){

        String encrypted_msg = "";

        for(char c : msg.toCharArray()){

            if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')){
                
                char encryptedChar = (char) (c + key);
                encrypted_msg += encryptedChar;
                
            }

            else{
                encrypted_msg += c;
            }
            
        }

        return encrypted_msg;
    }

    
    public static String decrypt(final String msg, int key){

        String decrypted_msg = "";

        for (char c : msg.toCharArray()) {

            if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')){
                
                char decryptedChar = (char) (c - key);
                decrypted_msg += decryptedChar;
                
            }

            else{
                decrypted_msg += c;
            }

        }
    
        return decrypted_msg;

    }


    public static void main(String[] args) {
        
        String message;
        int key;

        Scanner input = new Scanner(System.in);


        System.out.println("Enter message to encrypt or decrypt: ");
        message = input.nextLine();

        System.out.println("Enter the key: ");
        do{
            key = input.nextInt();

            if((key > 26) && (key < -26)){

                System.out.printf("Invalid key!");
            }

        } while((key > 26) && (key < -26));


        if(key == 0){
            System.out.println("No encryption.");
        }

        else if(key > 0){
            int choice;

            System.out.println("Press 1 to encrypt, press 2 to decrypt: ");
            
            do{
                choice = input.nextInt();

            if(choice == 1){
                System.out.println(encrypt(message, key));
            }
            else if(choice == 2){
                System.out.println(decrypt(message,key));
            }
            else{
                System.out.println("Invalid choice.");
            }

            }while((choice != 1) || (choice != 2));
        }
        
        else if(key < 0){

            int choice;

            System.out.println("Press 1 to encrypt, press 2 to decrypt: ");
            
            do{
                choice = input.nextInt();

            if(choice == 1){
                System.out.println(decrypt(message,key));
            }

            else if(choice == 2){
                System.out.println(encrypt(message, key));
            }

            else{
                System.out.println("Invalid choice.");
            }

            }while((choice != 1) || (choice != 2));
        }

    }
}
