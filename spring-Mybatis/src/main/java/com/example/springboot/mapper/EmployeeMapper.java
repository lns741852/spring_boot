package com.example.springboot.mapper;

import com.example.springboot.bean.Department;
import com.example.springboot.bean.Employee;
import org.apache.ibatis.annotations.*;


import java.util.List;


@Mapper
public interface EmployeeMapper {

    @Select(" select * from employee")
    @Results({
            @Result(property = "department", column = "d_id", one=@One(select = "com.example.springboot.mapper.DepartmentMapper.getDeptById"))
    })
    public List<Employee> list();


    @Select("select * from employee where id=#{id}")
    @Results({
            @Result(property = "department", column = "d_id", one=@One(select = "com.example.springboot.mapper.DepartmentMapper.getDeptById"))
    })
    public Employee getEmpById(Integer id);


    @Delete("delete from employee where id=#{id}")
    public Integer deleteEmpById(Integer id);

    //已id自增，SQL語句中id的值就不用加上null
    @Options(useGeneratedKeys = true,keyProperty = "id")
    ////前資料庫欄位，後java屬性名稱，mybatis中不需要加null
    @Insert("insert into employee(lastName,email,gender,d_id,birth) values(#{lastName},#{email},#{gender},#{department.id},#{birth})")
    public void insertEmp(Employee employee);

    //set更新的值， where尋找的方式
    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{department.id},birth=#{birth} where id=#{id}")
    public void updateEmp(Employee employee);


}
