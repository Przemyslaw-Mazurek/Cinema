package com.example.Cinema.controllers;

import com.example.Cinema.enums.PaymentStatus;
import com.example.Cinema.model.Movie;
import com.example.Cinema.model.Payment;
import com.example.Cinema.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPayment(Long id){
        return ResponseEntity.ok(paymentService.getPayment(id));
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments(){
        return ResponseEntity.ok(paymentService.getAllPayments());
    }


    @GetMapping("/findByStatus")
    public ResponseEntity<List<Payment>> getAllPaymentsByStatus(@RequestParam PaymentStatus paymentStatus) {

        List<Payment> payments = paymentService.findByPaymentStatus(paymentStatus);
        return ResponseEntity.ok(payments);
    }


    @PostMapping
    public ResponseEntity<Payment> addPayment(@RequestBody @Valid Payment payment) {
        return ResponseEntity.ok(paymentService.addPayment(payment));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void removeMovie(Long id) {
        paymentService.removePayment(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @Valid @RequestBody Payment payment) {
        return ResponseEntity.ok(paymentService.updatePayment(id, payment));
    }




}
