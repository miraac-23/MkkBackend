package gabim.permissionTrackingApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gabim.permissionTrackingApplication.core.utilities.results.DataResult;
import gabim.permissionTrackingApplication.core.utilities.results.ErrorResult;
import gabim.permissionTrackingApplication.core.utilities.results.Result;
import gabim.permissionTrackingApplication.core.utilities.results.SuccessDataResult;
import gabim.permissionTrackingApplication.core.utilities.results.SuccessResult;
import gabim.permissionTrackingApplication.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import gabim.permissionTrackingApplication.dto.Department.DepartmentCreateDto;
import gabim.permissionTrackingApplication.dto.Department.DepartmentOzetDto;
import gabim.permissionTrackingApplication.entity.DepartmentEntity;
import gabim.permissionTrackingApplication.mapper.DepartmentMapper;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentRepository departmentRepository;
	private DepartmentMapper departmentMapper;

	@Autowired
	public void setDepartmentRepository(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@Autowired
	public void setDepartmentMapper(DepartmentMapper departmentMapper) {		
		this.departmentMapper = departmentMapper;
	}

	@Override
	public Result add(DepartmentCreateDto departmentCreateDto) {

		try {
			DepartmentEntity departmentEntity = departmentMapper.createDtoToEntity(departmentCreateDto);

			departmentRepository.save(departmentEntity);

			return new SuccessResult("Departman eklendi");
		} catch (Exception e) {
			return new ErrorResult("Departman eklenemedi. Hata: " + e.getMessage());
		}
	}

	@Override
	public DataResult<List<DepartmentOzetDto>> getAll() {

		List<DepartmentEntity> departmentList = departmentRepository.findAll();

		return new SuccessDataResult<List<DepartmentOzetDto>>(departmentMapper.entityListToOzetDtoList(departmentList), "Data Listelendi");
	}

	@Override
	public Result delete(DepartmentEntity departmentEntity) {
		try {
			departmentRepository.delete(departmentEntity);
			return new SuccessResult("Departman Silindi");
		}catch (Exception e){
			return new ErrorResult("Departman Silme İşlemi Başarısız. Hata: " + e.getMessage());
		}
	}
}
