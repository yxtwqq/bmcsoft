package cn.bmc.service;

import cn.bmc.pojo.Uploads;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    public boolean addUpload(Uploads uploads)throws Exception;
}
