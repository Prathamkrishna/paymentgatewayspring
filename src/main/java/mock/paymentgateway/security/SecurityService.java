package mock.paymentgateway.security;

import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    private static final String[] userNames = new String[]{
            "pratham",
            "gatewayuser"
    };
    private static final String[] userPasswords = new String[]{
            "pratham",
            "gatewayuser"
    };
    protected static String getUsernames(int num){
        return userNames[num];
    }
    protected static String getPassword(int num){
        return userPasswords[num];
    }

}
