package com.usstudy.spring2024se083_usstudy_capstoneproject.repository;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    Payment getPaymentByTransactionNo(Integer transactionNo);
    List<Payment> getPaymentByProgramApplicationProgramApplicationId(Integer id);
    @Query("select COUNT(p.paymentId) from Payment p " +
            "where p.paymentDate between :startDate and :endDate " +
            "and (:#{#status} is null OR p.status = :#{#status})")
    Integer getNumberOfPayment(Date startDate,Date endDate,Integer status);
    @Query("select SUM(p.amount) from Payment p " +
            "where p.paymentDate between :startDate and :endDate " +
            "and (:#{#status} is null OR p.status = :#{#status})")
    Long getTotalAmount(Date startDate,Date endDate,Integer status);
}
