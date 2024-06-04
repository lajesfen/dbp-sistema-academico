package edu.utec.sistemacad.service.Payment;

import edu.utec.sistemacad.model.Payment;
import edu.utec.sistemacad.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository pagoRepository;

    @Autowired
    public PaymentService(PaymentRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public  ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> courses = pagoRepository.findAll();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    public ResponseEntity<Payment> getPaymentsById(Long id) {
        Optional<Payment> pago = pagoRepository.findById(id);
        if(pago.isPresent()){
            return new ResponseEntity<>(pago.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> newPayment(Payment pago) {
        pagoRepository.save(pago);
        return ResponseEntity.status(201).body("Created");
    }

    public ResponseEntity<String> deletePaymentById(Long id) {
        Optional<Payment> OptionalPago = pagoRepository.findById(id);
        if (OptionalPago.isPresent()) {
            pagoRepository.deleteById(id);
            return ResponseEntity.status(200).body("Pago Deleted");
        }else {
            return ResponseEntity.status(404).body("Not Found");
        }
    }

}
