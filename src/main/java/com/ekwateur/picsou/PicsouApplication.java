package com.ekwateur.picsou;

import com.ekwateur.picsou.model.customer.IndividualCustomer;
import com.ekwateur.picsou.model.customer.ProfessionalCustomer;
import com.ekwateur.picsou.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigInteger;

import static com.ekwateur.picsou.model.customer.Civility.Mr;

@SpringBootApplication
public class PicsouApplication {

    public static void main(String... args) {
        SpringApplication.run(PicsouApplication.class, args);
    }

    @Bean
    CommandLineRunner init(CustomerRepository customerRepo) {
        return args -> {
            var acme = new ProfessionalCustomer();
            acme.setCustomerRef("EKW100000000");
            acme.hasElectricityContract(true);
            acme.hasGasContract(true);
            acme.setSiretNumber("12345678901234");
            acme.setBusinessName("Acme");
            acme.setRevenues(BigInteger.valueOf(1000001));
            customerRepo.save(acme);
            var pouicPouic = new ProfessionalCustomer();
            pouicPouic.setCustomerRef("EKW100000001");
            pouicPouic.hasElectricityContract(true);
            pouicPouic.hasGasContract(true);
            pouicPouic.setSiretNumber("22345678901234");
            pouicPouic.setBusinessName("Pouic-Pouic Industries");
            pouicPouic.setRevenues(BigInteger.valueOf(1000));
            customerRepo.save(pouicPouic);
            var bp = new IndividualCustomer();
            bp.setCustomerRef("EKW100000002");
            bp.hasElectricityContract(true);
            bp.hasGasContract(true);
            bp.setFirstname("Baltazard");
            bp.setLastname("Picsou");
            bp.setCivility(Mr);
            customerRepo.save(bp);
        };
    }
}
