package com.datou.yhgl.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.datou.yhgl.entity.DownloadData;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lz
 * @since 2021-05-10
 */
@RestController
@RequestMapping("/yhgl/test")
public class TestController {

    /**
     * 文件下载（失败了会返回一个有部分数据的Excel）
     * <p>1. 创建excel对应的实体对象 参照{@link DownloadData}
     * <p>2. 设置返回的 参数
     * <p>3. 直接写，这里注意，finish的时候会自动关闭OutputStream,当然你外面再关闭流问题不大
     */
    @GetMapping("download")
    public void download(HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        ExcelWriterBuilder excelBuilder = EasyExcel.write(response.getOutputStream(), DownloadData.class);
        Set<String> includeColumnFiledNames=new HashSet<>();
        includeColumnFiledNames.add("字符串标题");
        includeColumnFiledNames.add("数字标题");
        excelBuilder = includeColumnFiledName(includeColumnFiledNames, excelBuilder);
        excelBuilder.sheet("sheet").doWrite(data());
    }

//    /**
//     * 文件上传
//     * <p>1. 创建excel对应的实体对象 参照{@link UploadData}
//     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link UploadDataListener}
//     * <p>3. 直接读即可
//     */
//    @PostMapping("upload")
//    @ResponseBody
//    public String upload(MultipartFile file) throws IOException {
//        EasyExcel.read(file.getInputStream(), UploadData.class, new UploadDataListener(uploadDAO)).sheet().doRead();
//        return "success";
//    }


    private ExcelWriterBuilder includeColumnFiledName(Set<String> includeColumnFiledNames, ExcelWriterBuilder excelBuilder) {
        excelBuilder = excelBuilder.registerWriteHandler(new LongestMatchColumnWidthStyleStrategy());
        if (includeColumnFiledNames.size() > 0) {
            excelBuilder = excelBuilder.includeColumnFiledNames(includeColumnFiledNames);
        }
        excelBuilder = excelBuilder.registerWriteHandler(new LongestMatchColumnWidthStyleStrategy());
        return excelBuilder;
    }
    private List<DownloadData> data() {
        List<DownloadData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            DownloadData data = new DownloadData();
            data.setString("字符串" + 0);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

}

