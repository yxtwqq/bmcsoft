package cn.bmc.service.impl;

import cn.bmc.dao.UploadMapper;
import cn.bmc.pojo.Uploads;
import cn.bmc.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private UploadMapper uploadMapper;

    @Override
    @Transactional
    public boolean addUpload(Uploads uploads) throws Exception {
        boolean flag = false;
        if (uploadMapper.addUpload(uploads) > 0)
            flag = true;
        return flag;
    }
}
