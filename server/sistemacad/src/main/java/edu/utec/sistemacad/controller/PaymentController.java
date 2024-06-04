package edu.utec.sistemacad.controller;

import edu.utec.sistemacad.model.Payment;
import edu.utec.sistemacad.service.Payment.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments") //OJITO CON EL ()"")
public class PaymentController {
    @Autowired
    private PaymentService pagoService;

    // Obtener todos los pagos
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPagos() {
        return pagoService.getAllPayments();
    }

    // Obtener un pago por ID
    @GetMapping("/{pagoId}")
    public ResponseEntity<Payment> getPagoById(@PathVariable Long pagoId) {
        return pagoService.getPaymentsById(pagoId);
    }

    @PostMapping()
    public ResponseEntity<String> createPago(@RequestBody Payment pago) {
        return pagoService.newPayment(pago);
    }

    @DeleteMapping("/{pagoId}")
    public ResponseEntity<String> deletePago(@PathVariable Long pagoId) {
        return pagoService.deletePaymentById(pagoId);
    }
}
