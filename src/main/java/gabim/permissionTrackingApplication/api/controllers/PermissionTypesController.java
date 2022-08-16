package gabim.permissionTrackingApplication.api.controllers;

import java.util.List;

import gabim.permissionTrackingApplication.core.utilities.results.SuccessDataResult;
import gabim.permissionTrackingApplication.dto.PermissionType.PermissionTypeCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import gabim.permissionTrackingApplication.service.PermissionTypeService;
import gabim.permissionTrackingApplication.core.utilities.results.Result;
import gabim.permissionTrackingApplication.dto.PermissionType.PermissionTypeDto;
import gabim.permissionTrackingApplication.entity.PermissionTypeEntity;

@RestController
@RequestMapping("/api/permissionTypes")
public class PermissionTypesController {
	
	private PermissionTypeService permissionTypeService;


	@Autowired
	public PermissionTypesController(PermissionTypeService permissionTypeService) {
		super();
		this.permissionTypeService = permissionTypeService;
	}
	
	
	@GetMapping("/getAll")
	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_Personel')")
	public SuccessDataResult<List<PermissionTypeDto>> getAll(){
		
		return this.permissionTypeService.getAll();
		
	}

	
	@PostMapping("/add")
	@PreAuthorize("hasAnyRole('ROLE_Admin', 'ROLE_IK')")
	public Result add(@RequestBody PermissionTypeCreateDto permissionTypeCreateDto) {
		
		return this.permissionTypeService.add(permissionTypeCreateDto);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam PermissionTypeEntity permissionTypeEntity) {
		
		return this.permissionTypeService.delete(permissionTypeEntity);
	}

}
