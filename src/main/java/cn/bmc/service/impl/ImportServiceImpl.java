package cn.bmc.service.impl;

import cn.bmc.common.MyException;
import cn.bmc.controller.UploadController;
import cn.bmc.dao.ImportMapper;
import cn.bmc.pojo.UploadData;
import cn.bmc.service.ImportService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ImportServiceImpl implements ImportService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImportServiceImpl.class);

    @Autowired
    private ImportMapper importMapper;


    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public Boolean batchImport(String fileName, String file) throws Exception {

        Boolean notNull = false;
        List<UploadData> userList = new ArrayList<UploadData>();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new MyException("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = new FileInputStream(file);
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if (sheet != null) {
            notNull = true;
        }
        UploadData user;
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }

            user = new UploadData();

            Integer gid = (int) row.getCell(0).getNumericCellValue();

            if (gid == null) {
                throw new MyException("导入失败(第" + (r + 1) + "行,姓名未填写)");
            }

            Double price = row.getCell(1).getNumericCellValue();
            if (price == null) {
                throw new MyException("导入失败(第" + (r + 1) + "行,电话未填写)");
            }


            Integer sid = (int) row.getCell(2).getNumericCellValue();
            if (sid == null) {
                throw new MyException("导入失败(第" + (r + 1) + "行,不存在此单位或单位未填写)");
            }

            Date date = new Date();


            user.setG_id(gid);
            user.setG_price(price);
            user.setS_id(sid);
            user.setUptime(date);
            //System.out.println("gid:" + gid + ",price:" + price + ",sid:" + sid + ",date:" + date);
            userList.add(user);
        }
        for (UploadData userResord : userList) {
            Integer id = userResord.getG_id();
            int cnt = importMapper.selectByID(id);
            if (cnt == 0) {
                importMapper.addUser(userResord);
                LOGGER.info(" 插入 " + userResord);
            } else {
                importMapper.updateUserById(userResord);
                LOGGER.info(" 更新 " + userResord);
            }
        }
        return notNull;
    }
}
