package ir.dotin.ocp17chapter7template.service.intefaces;

import ir.dotin.ocp17chapter7template.dto.TestDto;
import ir.dotin.ocp17chapter7template.dto.TestUpdateDto;

import java.util.List;
import java.util.Optional;

public interface TestService {
    void saveTestModel(TestDto dto);

    void saveTestModel(TestUpdateDto dto);

    List<TestDto> getTests();

    Optional<TestDto> findTestById(Integer id);

    Optional<TestDto> findTestModelByName(String name);

    void deleteTestModel(Integer id);
}
