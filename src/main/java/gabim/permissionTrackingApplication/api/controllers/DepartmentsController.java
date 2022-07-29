package gabim.permissionTrackingApplication.api.controllers;

import java.util.List;

import gabim.permissionTrackingApplication.entity.DepartmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import gabim.permissionTrackingApplication.service.DepartmentService;
import gabim.permissionTrackingApplication.core.utilities.results.DataResult;
import gabim.permissionTrackingApplication.core.utilities.results.Result;
import gabim.permissionTrackingApplication.dto.Department.DepartmentCreateDto;
import gabim.permissionTrackingApplication.dto.Department.DepartmentOzetDto;

@RestController
@RequestMapping("/api/departments")
public class DepartmentsController {

	private DepartmentService departmentService;

	@Autowired
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody DepartmentCreateDto departmentCreateDto) {

		return departmentService.add(departmentCreateDto);
	}

	@GetMapping("/getAll")
	public DataResult<List<DepartmentOzetDto>> getAll() {

		return departmentService.getAll();

	}

	@PostMapping("/delete")
	public Result delete(@RequestParam DepartmentEntity departmentEntity){
		return this.departmentService.delete(departmentEntity);
	}




}
