package gabim.permissionTrackingApplication.api.controllers;

import java.util.List;

import gabim.permissionTrackingApplication.dto.Position.PositionCreateDto;
import gabim.permissionTrackingApplication.dto.Position.PositionListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import gabim.permissionTrackingApplication.service.PositionService;
import gabim.permissionTrackingApplication.core.utilities.results.DataResult;
import gabim.permissionTrackingApplication.core.utilities.results.Result;
import gabim.permissionTrackingApplication.dto.Position.PositionDto;
import gabim.permissionTrackingApplication.entity.PositionEntity;

@RestController
@RequestMapping("/api/positions")
public class PositionsController {
	
	private PositionService positionService;

	@Autowired
	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody PositionCreateDto positionCreateDto) {

		return this.positionService.add(positionCreateDto);
	}

	@GetMapping("/getAll")
	public DataResult<List<PositionListDto>> getAll(){
		
		return this.positionService.getAll();
		
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam PositionEntity positionEntity) {
		
		return this.positionService.delete(positionEntity);
	}

}
