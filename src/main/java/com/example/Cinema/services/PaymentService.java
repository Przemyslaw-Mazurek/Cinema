package com.example.Cinema.services;

import com.example.Cinema.enums.PaymentStatus;
import com.example.Cinema.exceptions.NoSuchElementFoundException;
import com.example.Cinema.model.Movie;
import com.example.Cinema.model.Payment;
import com.example.Cinema.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    private final String paymentNotFound = "Payment with id = {0} not found.";
    //private final SystemProperties systemProperties;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment getPayment(Long id){
       Payment payment = paymentRepository.findById(id)
               .orElseThrow(() -> new NoSuchElementFoundException(MessageFormat.format(paymentNotFound, id)));
       return payment;
    }

    public List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }

    public void removePayment(Long id){
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(MessageFormat.format(paymentNotFound, id)));
        paymentRepository.deleteById(id);
    }

    public Payment updatePayment(Long id, Payment payment) {
        Payment paymentFromFromDB = paymentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(MessageFormat.format(paymentNotFound, id)));

        paymentFromFromDB.setDateOfPayment(payment.getDateOfPayment());
        paymentFromFromDB.setPaymentStatus(payment.getPaymentStatus());
        paymentFromFromDB.setUser(payment.getUser());
        paymentFromFromDB.setTotalPrice(payment.getTotalPrice());
        paymentFromFromDB.setTicket(payment.getTicket());

        return paymentRepository.save(paymentFromFromDB);
    }

    public Payment addPayment(Payment payment){
        return paymentRepository.save(payment);
    }

    public List<Payment> findByPaymentStatus(PaymentStatus paymentStatus){
        return paymentRepository.findByPaymentStatus(paymentStatus);
    }
}
