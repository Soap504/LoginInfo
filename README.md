# Secure Password Manager:

This Java program serves as a secure password manager that allows users to store and manage login credentials in an encrypted file. It utilizes encryption and decryption techniques to ensure the security of sensitive data.

## Features:

* **Encryption and Decryption:** The program encrypts the login information before storing it in a file and decrypts it when loading from the file. This ensures that the data remains secure even if the file is accessed by unauthorized users.
* **User Interface:** The program provides a simple graphical user interface (GUI) for users to interact with. Users can log in, register new accounts, and manage their login credentials conveniently.

## Components:
### **IDandPasswords Class**
This class handles the encryption, decryption, and file I/O operations related to login information. It utilizes Java's cryptographic libraries (javax.crypto) to encrypt and decrypt the data.

### **LoginPage Class**
The LoginPage class implements the GUI for user login. It allows users to enter their credentials, verifies them against the stored data, and provides feedback on the login status.

### **NewUser Class**
The NewUser class implements the GUI for registering new user accounts. It allows users to create a new username-password pair, stores it securely, and updates the encrypted file accordingly.

### **WelcomePage Class**
The WelcomePage class displays a welcome message to the user upon successful login. It provides a friendly interface to indicate that the user has successfully accessed their account.

**Usage**

To use the program:

1. Compile all Java files.
2. Run the **Main** class.
3. Use the login interface to log in with existing credentials or register a new account if necessary.
4. Upon successful login, the welcome page will be displayed, providing access to the user's account.

# Security Considerations
* **Secret Key Management:** The program manages the secret key used for encryption and decryption securely. The key is stored locally and is not exposed to external access.
* **Secure File Storage:** User login information is stored in an encrypted file **(importantData.txt)** to prevent unauthorized access to sensitive data.
