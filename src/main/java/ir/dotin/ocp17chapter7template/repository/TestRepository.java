package ir.dotin.ocp17chapter7template.repository;

import ir.dotin.ocp17chapter7template.model.TestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<TestModel, Integer> {
    Optional<TestModel> findById(Integer id);
    Optional<TestModel> findByName(String name);
}
