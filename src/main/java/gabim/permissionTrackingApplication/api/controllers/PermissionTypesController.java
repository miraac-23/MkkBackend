package gabim.permissionTrackingApplication.api.controllers;

import java.util.List;

import gabim.permissionTrackingApplication.dto.PermissionType.PermissionTypeCreateDto;
import gabim.permissionTrackingApplication.dto.PermissionType.PermissionTypeListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gabim.permissionTrackingApplication.service.PermissionTypeService;
import gabim.permissionTrackingApplication.core.utilities.results.DataResult;
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
	public DataResult<List<PermissionTypeListDto>> getAll(){
		
		return this.permissionTypeService.getAll();
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody PermissionTypeCreateDto permissionTypeCreateDto) {
		
		return this.permissionTypeService.add(permissionTypeCreateDto);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam PermissionTypeEntity permissionTypeEntity) {
		
		return this.permissionTypeService.delete(permissionTypeEntity);
	}

}
