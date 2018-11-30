package cn.bmc.dao;

import cn.bmc.pojo.UploadData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImportMapper {
    void addUser(UploadData sysUser);

    int updateUserById(UploadData sysUser);

    int selectByID(Integer id);
}
