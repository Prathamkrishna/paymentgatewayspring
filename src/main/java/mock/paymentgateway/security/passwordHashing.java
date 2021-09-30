package mock.paymentgateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// storing passwords securely for user auth flow.
public class passwordHashing {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    private final String[] userPasswords = new String[]{
            bCryptPasswordEncoder.encode("password1"),
            bCryptPasswordEncoder.encode("password2")
    };

    public void getPassword(String userEnteredPassword){
        boolean abc = bCryptPasswordEncoder.matches(userEnteredPassword, userPasswords[0]);
        System.out.println(abc + "dne");
    }
}
