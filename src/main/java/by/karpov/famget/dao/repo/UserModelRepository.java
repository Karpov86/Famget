package by.karpov.famget.dao.repo;

import by.karpov.famget.dao.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserModelRepository extends JpaRepository<UserModel, Long>, JpaSpecificationExecutor<UserModel>
{
}