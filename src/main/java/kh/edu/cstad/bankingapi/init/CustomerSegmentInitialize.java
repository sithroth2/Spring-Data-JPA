package kh.edu.cstad.bankingapi.init;

import jakarta.annotation.PostConstruct;
import kh.edu.cstad.bankingapi.domain.CustomerSegment;
import kh.edu.cstad.bankingapi.repository.CustomerRepository;
import kh.edu.cstad.bankingapi.repository.CustomerSegmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerSegmentInitialize {
    private final CustomerSegmentRepository customerSegmentRepository;
    private final CustomerRepository customerRepository;

    @PostConstruct
    public void init() {
       if(customerSegmentRepository.count() == 0) {
           CustomerSegment customerSegment = new CustomerSegment();
           customerSegment.setSegment("REGULER");
           customerSegment.setDescription("Normal Customer");
           customerSegment.setIsDeleted(false);

           CustomerSegment customerSegmentSilver = new CustomerSegment();
           customerSegment.setSegment("SILVER");
           customerSegment.setDescription("Silver Customer");
           customerSegment.setIsDeleted(false);

           customerSegmentRepository.save(customerSegment);
           customerSegmentRepository.save(customerSegmentSilver);
       }

    }
}
