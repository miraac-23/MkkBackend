package gabim.permissionTrackingApplication.api.controllers;

import java.util.List;

import gabim.permissionTrackingApplication.dto.Permission.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gabim.permissionTrackingApplication.service.PermissionService;
import gabim.permissionTrackingApplication.core.utilities.results.DataResult;
import gabim.permissionTrackingApplication.core.utilities.results.Result;
import gabim.permissionTrackingApplication.entity.PermissionEntity;

@RestController
@RequestMapping("/api/permissions")
public class PermissionsController {

	private PermissionService permissionService;

	@Autowired
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	@PostMapping("/add")
	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Personel','ROLE_IK')")
	public Result add(@RequestBody PermissionCreateDto permissionCreateDto) {

		return this.permissionService.add(permissionCreateDto);
	}

	@GetMapping("/getAll")
	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Personel','ROLE_IK')")
	public DataResult<List<PermissionListDto>> getAll(){
		
		return this.permissionService.getAll();
		
	}

	@GetMapping("/getPermissionWithEmployeeAndPermissionType")
	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Personel','ROLE_IK')")
	public DataResult<List<PermissionWithEmployeeAndPermissionTypeDto>> getPermissionWithEmployeeAndPermissionType(){

		return this.permissionService.getPermissionWithEmployeeAndPermissionType();
	}

	@DeleteMapping("/delete")
	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Personel','ROLE_IK')")
	public Result delete(@RequestParam PermissionEntity permission) {
		return this.permissionService.delete(permission);
	}


	@GetMapping("/getById")
	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Personel','ROLE_IK')")
	public DataResult<PermissionDto> findById(@RequestParam Integer id){

		return this.permissionService.getById(id);
	}


	@GetMapping("/getPermissionDaySum")
	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Personel','ROLE_IK')")
	public DataResult<List<PermissionDaySum>> getPermissionDaySum(){
		return this.permissionService.getPermissionDaySum();
	}

	
}
