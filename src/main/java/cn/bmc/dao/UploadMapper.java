package cn.bmc.dao;

import cn.bmc.pojo.Uploads;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UploadMapper {
    public int addUpload(Uploads uploads)throws Exception;
}
