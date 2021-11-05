package mock.paymentgateway.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
class PaymentRepositoryImpl implements PaymentRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PaymentRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void updateDatabase(String username, int amt){
        try {
            jdbcTemplate.update("INSERT INTO UserPayments (name, amount) values (" + username + "," + amt + ");");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
