package mock.paymentgateway.data;

public interface PaymentRepository {

    void updateDatabase(String username, int amt);
}
