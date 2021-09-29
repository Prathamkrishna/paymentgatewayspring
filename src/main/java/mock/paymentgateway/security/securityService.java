package mock.paymentgateway.security;

public class securityService {
    private static final String[] userNames = new String[]{
            "pratham",
            "gatewayuser",
    };
    protected static String getUsernames(int num){
        return userNames[num];
    }
}
