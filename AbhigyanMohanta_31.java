//Name: Abhigyan Mohanta
//Roll no: 31
//Sec: 29
//Reg No: 2241013204
//sem: 1

import java.util.Scanner;
public class AbhigyanMohanta_31
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text:");
        String text = sc.nextLine();
        System.out.println("Enter 1 to encrypt the text");
        System.out.println("Enter 2 to decrypt the text");
        int choice = sc.nextInt();
        System.out.println("Enter the value of key1(Multiplicative Key):");
        int key1 = sc.nextInt();
        System.out.println("Enter the value of key2(Additive Key):");
        int key2 = sc.nextInt();
        String result;
        if(choice == 1)
        {
            result = encrypt(text,key1,key2);
            System.out.println("The encrypted text is: "+result);
        }
        else if(choice == 2)
        {
            result = decrypt(text,key1,key2);
            System.out.println("The decrypted text is: "+result);
        }
        else
            System.out.println("Invalid Input");

    }
    public static String encrypt(String plaintext, int k1, int k2)
    {
        char ciphertext[] = new char[plaintext.length()];
        char checkCase; //temporary variable to check case
        int charint; //to hold the values of characters in integers
        int C; // to use as in formula C = (P × k1 + k2) mod 26
        for(int i=0;i<plaintext.length();i++)
        {
            checkCase = plaintext.charAt(i);
            if(Character.isUpperCase(checkCase))
            {
                charint = plaintext.charAt(i) - 'A';
                C = (charint*k1+k2)%26;
                ciphertext[i] = (char)(C+'A');
            }else
            {
                charint = plaintext.charAt(i) - 'a';
                C = (charint*k1+k2)%26;
                ciphertext[i] = (char)(C+'a');
            }
        }
        String res = "";
        for(int i=0;i<ciphertext.length;i++)
        {
            res = res+ciphertext[i];
        }
        return res;
    }
    public static String decrypt(String ciphertext, int k1, int k2)
    {
        // Compute block for k1_inverse
        int k1_inverse = 0;
        for (int i = 0; i < 26; i++) {
            if ((k1 * i) % 26 == 1) {
                k1_inverse = i;
                break;
            }
        }
        char plaintext[] = new char[ciphertext.length()];
        char checkCase; //temporary variable to check case
        int charint; //to hold the values of characters in integers
        int P; // to use as in formula P = ((C − k2) × k1^-1) mod 26
        int firstterm; //to store (C - k2) and prevent it from being negative
        for(int i=0; i<ciphertext.length(); i++)
        {
            checkCase = ciphertext.charAt(i);
            if(Character.isUpperCase(checkCase))
            {
                charint = ciphertext.charAt(i) - 'A';
                firstterm = charint - k2;
                while(firstterm <= 0) {
                    firstterm += 26;
                }
                P = (firstterm*k1_inverse)%26;
                plaintext[i] = (char)(P + 'A');
            }else
            {
                charint = ciphertext.charAt(i) - 'a';
                firstterm = charint - k2;
                while(firstterm <= 0){
                    firstterm += 26;
                }
                P = (firstterm*k1_inverse)%26;
                plaintext[i] = (char)(P + 'a');
            }
        }
        String res = "";
        for(int i=0;i<plaintext.length;i++)
        {
            res = res+plaintext[i];
        }
        return res;
    }
}

//******* OUTPUT 1 (ENCRYPTION) ***********************************

//        Enter the text:
//        hello
//        Enter 1 to encrypt the text
//        Enter 2 to decrypt the text
//        1
//        Enter the value of key1(Multiplicative Key):
//        7
//        Enter the value of key2(Additive Key):
//        2
//        The encrypted text is: zebbw


//******* OUTPUT 2 (DECRYPTION) **********************************

//        Enter the text:
//        zebbw
//        Enter 1 to encrypt the text
//        Enter 2 to decrypt the text
//        2
//        Enter the value of key1(Multiplicative Key):
//        7
//        Enter the value of key2(Additive Key):
//        2
//        The decrypted text is: hello


