package cn.bmc.controller;

import cn.bmc.pojo.Uploads;
import cn.bmc.service.ImportService;
import cn.bmc.service.UploadService;
import javafx.scene.input.DataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UploadController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    @Autowired
    private UploadService uploadService;
    @Autowired
    private ImportService importService;

    @RequestMapping("/upload")  //配置地址
    public String upload() {
        return "test";   //返回页面
    }

    @RequestMapping(value = "/uploadSave", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }

        String fileName = file.getOriginalFilename();
        String filePath = "D:/workspace/";    //文件保存位置
        String date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        date = simpleDateFormat.format(new Date());
        File dest = new File(filePath + date + fileName);
        try {
            //LOGGER.info(fileName);
            // 验证文件格式
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            //LOGGER.info(suffix);
            if (fileName != "") {
                if (suffix.equals("xls") || suffix.equals("xlsx")) {
                    file.transferTo(dest);
                    LOGGER.info("上传成功");
                    Uploads uploads = new Uploads();
                    uploads.setUp_time(new Date());
                    uploads.setUp_path(filePath + date + fileName);
                    boolean flag = uploadService.addUpload(uploads);  //调用接口
                    LOGGER.info("uploadService.addUpload(uploads)==============" + flag);
                    LOGGER.info("importService.batchImport(fileName,filePath+date+fileName)==============" + flag);
                    importService.batchImport(fileName,filePath+date+fileName);

                    return "success";
                } else {
                    return "Exception/401.html";
                }
            }
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "Exception/401.html";
    }
}