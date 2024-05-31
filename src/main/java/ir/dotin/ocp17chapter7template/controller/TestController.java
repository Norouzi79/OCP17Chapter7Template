package ir.dotin.ocp17chapter7template.controller;

import io.swagger.v3.oas.annotations.Operation;
import ir.dotin.ocp17chapter7template.dto.TestDto;
import ir.dotin.ocp17chapter7template.dto.TestUpdateDto;
import ir.dotin.ocp17chapter7template.service.intefaces.TestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class TestController {
    private final TestService testService;

    @PostMapping("/save")
    @Operation(summary = "save test", description = "just fill the name to save your test")
    public void save(TestDto dto) {
        testService.saveTestModel(dto);
    }

    @PutMapping("/update")
    @Operation(summary = "update test", description = "both id and name must be present to update the test")
    public void update(TestUpdateDto dto) {
        testService.saveTestModel(dto);
    }

    @GetMapping("/getAll")
    @Operation(summary = "list all tests", description = "lists all tests")
    public List<TestDto> getAll() {
        return testService.getTests();
    }

    @GetMapping("/getById/{id}")
    @Operation(summary = "get by id", description = "gets your test by id if exists")
    public Optional<TestDto> getById(@PathVariable int id) {
        return testService.findTestById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete by id", description = "deletes your test by id if exists")
    public void deleteById(@PathVariable int id) {
        testService.deleteTestModel(id);
    }
}
