
package poe;

import javax.swing.JOptionPane;


public class POE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Example usage
        String username = JOptionPane.showInputDialog("Enter UserName");
        String password = JOptionPane.showInputDialog("Enter Password");
        String storedUsername = JOptionPane.showInputDialog("Enter First Name");
        String storedPassword = JOptionPane.showInputDialog("Enter Last Name");
        
        
        // Register user
        String registrationMessage = Login.registerUser(username, password);
        System.out.println(registrationMessage);

        // Login user
        boolean loginStatus = Login.loginUser(username, password, storedUsername, storedPassword);
        String loginStatusMessage = Login.returnLoginStatus(loginStatus);
        System.out.println(loginStatusMessage);
        
        
    }
}

class Login {
    static boolean checkUserName(String username) {
        // Check if username contains an underscore and is no more than 5 characters long
        return username.matches("^[a-zA-Z0-9_]{1,5}$");
    }

    static boolean checkPasswordComplexity(String password) {
        // Check if password meets complexity rules
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*\\d.*") &&
               password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }

    static String registerUser(String username, String password) {
        // Check if username is correctly formatted
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }

        // Check if password meets complexity rules
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }

        // Registration successful
        return "Registration successful. Welcome!";
        
    }
        
    static boolean loginUser(String username, String password, String storedUsername, String storedPassword) {
        // Verify login details
        return username.equals(storedUsername) && password.equals(storedPassword);
    }

    static String returnLoginStatus(boolean loginStatus) {
        // Return login status message
        return loginStatus ? "Login successful." : "Login successful. Welcome.";
    }
}

              
    

    


