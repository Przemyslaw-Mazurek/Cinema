package com.example.Cinema.repositories;

import com.example.Cinema.enums.PaymentStatus;
import com.example.Cinema.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

        List<Payment> findByPaymentStatus(PaymentStatus paymentStatus);
}
