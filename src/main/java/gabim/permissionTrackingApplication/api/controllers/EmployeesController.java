package gabim.permissionTrackingApplication.api.controllers;

import java.util.List;

import gabim.permissionTrackingApplication.dto.Employee.EmployeeListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import gabim.permissionTrackingApplication.service.EmployeeService;
import gabim.permissionTrackingApplication.core.utilities.results.DataResult;
import gabim.permissionTrackingApplication.core.utilities.results.Result;
import gabim.permissionTrackingApplication.dto.Employee.EmployeeCreateDto;
import gabim.permissionTrackingApplication.dto.Employee.EmployeeUpdateDto;
import gabim.permissionTrackingApplication.dto.Employee.EmployeeWithPositionDto;
import gabim.permissionTrackingApplication.entity.EmployeeEntity;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody EmployeeCreateDto employeeCreateDto) {
        return this.employeeService.add(employeeCreateDto);
    }


    @GetMapping("/getAll")
    @PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Personel')")
    public DataResult<List<EmployeeListDto>> getAll() {
        return this.employeeService.getAll();

    }

    @GetMapping("/getEmployeeWithPositionDetails")
    public DataResult<List<EmployeeWithPositionDto>> getEmployeeWithPositionDetails() {

        return this.employeeService.getEmployeeWithPositionDetails();

    }


    @PostMapping("/delete")
    public Result delete(@RequestParam EmployeeEntity employeeEntity) {

        return this.employeeService.delete(employeeEntity);
    }

    @PatchMapping("/update")
    public Result update(@RequestBody EmployeeUpdateDto employeeUpdateDto, Integer id) {

        return this.employeeService.update(employeeUpdateDto, id);
    }


    @GetMapping("/getByName")
    public DataResult<EmployeeListDto> getByName(@RequestParam String name) {

        return this.employeeService.getByName(name);
    }


    @GetMapping("/getByNameAndId")
    public DataResult<EmployeeListDto> getByNameAndId(@RequestParam String name, @RequestParam int id) {

        return this.employeeService.getByNameAndId(name, id);
    }


    @GetMapping("/getByNameStartsWith")
    DataResult<List<EmployeeListDto>> getByNameStartsWith(@RequestParam String name) {

        return this.employeeService.getByNameStartsWith(name);
    }

    @GetMapping
    public DataResult<EmployeeUpdateDto> getById(@RequestParam Integer id) {

        return this.employeeService.getById(id);
    }

}
