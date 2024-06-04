package edu.utec.sistemacad.repository;

import edu.utec.sistemacad.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    public List<Payment> findByDebt(boolean debt);

    public List<Payment> findByStudentId(Long student_id);

}
