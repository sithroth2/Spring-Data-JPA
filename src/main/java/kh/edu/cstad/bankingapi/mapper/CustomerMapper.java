package kh.edu.cstad.bankingapi.mapper;

import kh.edu.cstad.bankingapi.domain.Customer;
import kh.edu.cstad.bankingapi.dto.CreateCustomerRequest;
import kh.edu.cstad.bankingapi.dto.CustomerResponse;
import kh.edu.cstad.bankingapi.dto.UpdateCustomerRequest;
import org.mapstruct.*;

import java.util.List;
@Mapper(componentModel = "spring")
//@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toCustomerPartial (UpdateCustomerRequest request, @MappingTarget Customer customer);



    // Domain -> DTO
    // 1. return type
    // 2. parameter

    CustomerResponse toCustomerResponse(Customer customer);

    //
    List<CustomerResponse> toCustomerResponses(List<Customer> customers);

    // DTO -> Domain
    //@Mapping(source = "customerSegment", target ="customerSegment.segment")
    Customer toCustomer(CreateCustomerRequest request);

}
