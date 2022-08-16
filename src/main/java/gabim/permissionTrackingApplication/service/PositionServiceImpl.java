package gabim.permissionTrackingApplication.service;

import java.util.List;

import gabim.permissionTrackingApplication.core.utilities.results.*;
import gabim.permissionTrackingApplication.dto.Position.PositionCreateDto;
import gabim.permissionTrackingApplication.dto.Position.PositionListDto;
import gabim.permissionTrackingApplication.mapper.PositionMapper;
import gabim.permissionTrackingApplication.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gabim.permissionTrackingApplication.dto.Position.PositionDto;
import gabim.permissionTrackingApplication.entity.PositionEntity;

@Service
public class PositionServiceImpl implements PositionService {

	private PositionRepository positionRepository;
	private PositionMapper positionMapper;

	@Autowired
	public PositionServiceImpl(PositionRepository positionRepository, PositionMapper positionMapper) {
		this.positionRepository = positionRepository;
		this.positionMapper = positionMapper;
	}

	@Override
	public Result add(PositionCreateDto positionCreateDto) {
		try{
			PositionEntity positionEntity = positionMapper.createDtoToEntity(positionCreateDto);
			positionRepository.save(positionEntity);

			return new SuccessResult("Pozisyon Eklendi");
		} catch (Exception e){
			return new ErrorResult("Pozisyon eklenemedi"+ e.getMessage());
		}
	}


	@Override
	public DataResult<List<PositionListDto>> getAll() {

		List<PositionEntity> positionList = positionRepository.findAll();

		return new SuccessDataResult<List<PositionListDto>>(positionMapper.entityListToPositionListDtoList(positionList), "Data Listelendi");
	}


	@Override
	public Result delete(PositionEntity positionEntity) {
		try {
			positionRepository.delete(positionEntity);
			return new SuccessResult("Pozisyon Silme İşlemi Başarılı");
		}catch (Exception e){
			return new ErrorResult("Pozisyon Silme İşlemi Başarısız. Hata: " + e.getMessage());
		}
	}

	@Override
	public PositionEntity getPosition(String name) {
		return null;
	}

	/*
	 * private PositionDao positionDao;
	 * 
	 * @Autowired public PositionServiceImpl(PositionDao positionDao) { super();
	 * this.positionDao = positionDao; }
	 * 
	 * 
	 * @Override public DataResult<List<PositionEntity>> getAll() {
	 * 
	 * return new SuccessDataResult<List<PositionEntity>>
	 * (this.positionDao.findAll(),"Data Listelendi"); }
	 * 
	 * 
	 * @Override public Result add(PositionDto positionDto) {
	 * 
	 * PositionEntity position = new PositionEntity();
	 * 
	 * position.setName(positionDto.getName());
	 * 
	 * this.positionDao.save(position);
	 * 
	 * return new SuccessResult("Pozisyon Eklendi"); }
	 * 
	 * 
	 * @Override public Result delete(PositionEntity position) {
	 * 
	 * this.positionDao.delete(position);
	 * 
	 * return new SuccessResult("Personel Silindi"); }
	 * 
	 * 
	 * @Override public PositionEntity getPosition(String name) {
	 * 
	 * return positionDao.getByName(name);
	 * 
	 * 
	 * }
	 */
}
