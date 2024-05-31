package ir.dotin.ocp17chapter7template.service.impl;

import ir.dotin.ocp17chapter7template.dto.TestDto;
import ir.dotin.ocp17chapter7template.dto.TestUpdateDto;
import ir.dotin.ocp17chapter7template.model.TestModel;
import ir.dotin.ocp17chapter7template.repository.TestRepository;
import ir.dotin.ocp17chapter7template.service.intefaces.TestService;
import ir.dotin.ocp17chapter7template.util.ObjectUtility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;

    private static TestDto convertToDto(TestModel model) {
        return ObjectUtility.getObjectMapperInstance().convertValue(model, TestDto.class);
    }

    @Override
    public void saveTestModel(TestDto dto) {
        TestModel model = ObjectUtility
                .getObjectMapperInstance()
                .convertValue(dto, TestModel.class);
        if (Objects.nonNull(model)
                && Objects.nonNull(model.getName())
                && !model.getName().isEmpty()) {
            this.testRepository.saveAndFlush(model);
        }
    }

    @Override
    public void saveTestModel(TestUpdateDto dto) {
        TestModel model = ObjectUtility
                .getObjectMapperInstance()
                .convertValue(dto, TestModel.class);
        if (Objects.nonNull(model)
                && Objects.nonNull(model.getId())
                && Objects.nonNull(model.getName())
                && !model.getName().isEmpty()) {
            testRepository.findById(model.getId())
                    .ifPresent(x -> this.testRepository.saveAndFlush(model));
        }
    }

    @Override
    public List<TestDto> getTests() {
        return this.testRepository.findAll()
                .stream()
                .map(TestServiceImpl::convertToDto)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Optional<TestDto> findTestById(Integer id) {
        return this.testRepository.findById(id)
                .map(TestServiceImpl::convertToDto);
    }

    @Override
    public Optional<TestDto> findTestModelByName(String name) {
        if (Objects.nonNull(name) && !name.isEmpty())
            return this.testRepository.findByName(name)
                    .map(TestServiceImpl::convertToDto);
        return Optional.empty();
    }

    @Override
    public void deleteTestModel(Integer id) {
        testRepository.deleteById(id);
    }
}
