package gabim.permissionTrackingApplication.repository;

import gabim.permissionTrackingApplication.dto.Permission.PermissionDaySum;
import gabim.permissionTrackingApplication.dto.Permission.PermissionWithEmployeeAndPermissionTypeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gabim.permissionTrackingApplication.entity.PermissionEntity;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, Integer> {

	//PermissionEntity getById(Integer id);

	@Query("Select new gabim.permissionTrackingApplication.dto.Permission.PermissionWithEmployeeAndPermissionTypeDto(k.id,k.startingDate,k.endDate,k.statement,k.permissionDay,t.name,p.name,p.surname,p.id,c.name,m.name) From DepartmentEntity c Inner Join c.employees p Inner Join p.position m Inner Join p.permissions k Inner Join k.permissionType t")
	List<PermissionWithEmployeeAndPermissionTypeDto> getPermissionWithEmployeeDetails();


	@Query(value = " SELECT new  gabim.permissionTrackingApplication.dto.Permission.PermissionDaySum(c.employee.id ,SUM(c.permissionDay))   FROM PermissionEntity AS c GROUP BY c.employee.id")
	List<PermissionDaySum> getPermissionDaySum();



}




/*

     @Query(value ="SELECT new moon.odyssey.entity.YearReportSum(rp.year, SUM(rp.loanSmall), SUM (rp.loanMajor), SUM (rp.loanTotal)) FROM Report rp GROUP BY rp.year"


@Query("Select c.employee.id , SUM(c.permissionDay) From PermissionEntity AS c GROUP BY c.employee.id ")

	@Query("Select c.employee.id , SUM(c.permissionDay) From PermissionEntity AS c GROUP BY c.employee.id ")

*
*	@Query("Select new gabim.permissionTrackingApplication.dto.Permission.PermissionDaySum(c.employee.id) , SUM(c.permissionDay) FROM PermissionEntity AS c GROUP BY c.employee.id ORDER BY c.employee.id DESC ")

@Query(value = "select employee_id , sum(permission_day) AS toplam from permission group by employee_id " , nativeQuery = true)

*   @Query(value = "select top 5 p.*, sum(po.quantity) as total_quantity from product p " +"inner join productorder po " +"on p.id = po.product_id " +"group by p.id, p.name " +"order by total_quantity desc", nativeQuery = true)
    List<Product> findTopFiveBestSeller();




     @Query(value ="SELECT new moon.odyssey.entity.YearReportSum(rp.year, SUM(rp.loanSmall), SUM (rp.loanMajor), SUM (rp.loanTotal)) FROM Report rp GROUP BY rp.year"
    )
*
*
* */

