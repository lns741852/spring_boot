package com.example.springboot.mapper;


import com.example.springboot.bean.Department;
import org.apache.ibatis.annotations.*;


import java.util.List;


@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    //已id自增，SQL語句中id的值就不用加上null
    @Options(useGeneratedKeys = true,keyProperty = "id")
    //(departmentName)固定格式為資料欄位名稱，mybatis中不需要加null
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDept(Department department);

    //set更新的值， where尋找的方式
    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    public int updateDept(Department department);

    @Select("select * from department")
    public List<Department> list();


}
