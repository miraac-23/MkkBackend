package gabim.permissionTrackingApplication.api.controllers;

import java.util.List;

import gabim.permissionTrackingApplication.dto.Employee.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import gabim.permissionTrackingApplication.service.EmployeeService;
import gabim.permissionTrackingApplication.core.utilities.results.DataResult;
import gabim.permissionTrackingApplication.core.utilities.results.Result;
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
    @PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Personel')")
    public Result add(@RequestBody EmployeeCreateDto employeeCreateDto) {
        return this.employeeService.add(employeeCreateDto);
    }


    @GetMapping("/getAll")
    @PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Personel','ROLE_IK')")
    public DataResult<List<EmployeeWithDepartmentAndPositionDto>> getAll() {
        return this.employeeService.getAll();

    }


    @GetMapping("/getEmployeeWithPosition")
    @PreAuthorize("hasAnyRole('ROLE_Admin','ROLE_IK')")
    public DataResult<List<EmployeeWithDepartmentAndPositionDto>> getEmployeeWithPosition() {
        return this.employeeService.getEmployeeWithPosition();
    }


    @GetMapping("/getById")
    @PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Personel','ROLE_IK')")
    public DataResult<EmployeeDto> findById(@RequestParam Integer id) {
        return this.employeeService.getById(id);

    }

    @GetMapping("/getByTcNo")
    @PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Personel','ROLE_IK')")
    public DataResult<EmployeeDto> getByTcNo(@RequestParam Integer tcNo){

        return this.employeeService.getByTcNo(tcNo);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Personel')")
    public Result delete(@RequestParam EmployeeEntity employeeEntity) {

        return this.employeeService.delete(employeeEntity);
    }

    @PostMapping ("/update")
    @PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_IK')")
    public Result update(@RequestBody EmployeeUpdateDto employeeUpdateDto) {

        return this.employeeService.update(employeeUpdateDto);
    }



}
