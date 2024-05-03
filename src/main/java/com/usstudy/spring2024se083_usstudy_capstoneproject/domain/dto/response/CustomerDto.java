package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Customer;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.CustomerMapper;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto implements Serializable {
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "full_name")
    private String fullName;
    private String email;
    private String password;
    private String address;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    private String gender;
    private String phone;
    private String img;

//    public static CustomerDto convert(Customer customer) {
//        return CustomerMapper.INSTANT.toDto(customer);
//    }
//    public static Customer convert(CustomerDto customerDto) {
//        return CustomerMapper.INSTANT.toEntity(customerDto);
//    }
}
