package cn.bmc.service;

import cn.bmc.dao.ImportMapper;
import org.springframework.web.multipart.MultipartFile;

public interface ImportService {
    Boolean batchImport(String fileName, String file) throws Exception;
}
