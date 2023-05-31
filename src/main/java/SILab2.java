import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public static boolean function (User user, List<User> allUsers) {
        if (user==null || user.getPassword()==null || user.getEmail()==null){ //N1
            throw new RuntimeException("Mandatory information missing!"); //N2
        }

        if (user.getUsername()==null){ //N3
            user.setUsername(user.getEmail()); //N4
        }

        int same = 1;
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) { //N5
            same = 0;
            for (int i=0;i<allUsers.size();i++) { //N6, N7, N8
                User existingUser = allUsers.get(i);
                if (existingUser.getEmail() == user.getEmail()) { //N9
                    same += 1; //N10
                }
                if (existingUser.getUsername() == user.getUsername()) { //N11
                    same += 1; //N12
                }
            }
        }

        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}";
        String password = user.getPassword();
        String passwordLower = password.toLowerCase();

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length()<8) { //N13
            return false; //N14
        }
        else {
            if (!passwordLower.contains(" ")) { //N15
                for (int i = 0; i < specialCharacters.length(); i++) { //N16, N17, N18
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) { //N19
                        return same == 0; //N20
                    }
                }
            }
        }
        return false; //N21
    }

}
//N22