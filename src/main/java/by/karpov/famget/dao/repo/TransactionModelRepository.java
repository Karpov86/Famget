package by.karpov.famget.dao.repo;

import by.karpov.famget.dao.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionModelRepository extends JpaRepository<TransactionModel, Long>
{
}