package cn.lanqiao.booksystem.mapper;

import cn.lanqiao.booksystem.modle.pojo.AdminInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AdministratorMapper {
    AdminInfo getAdminByUserName(@Param("operatorName") String operatorName,@Param("operatorPass") String opertorPass);
    int registerAdmin(AdminInfo adminInfo);


}