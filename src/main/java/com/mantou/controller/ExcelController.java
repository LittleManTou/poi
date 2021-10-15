package com.mantou.controller;

import java.util.List;
import com.mantou.entity.UserExport;
import com.mantou.service.UserService;
import com.mantou.utils.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/excel")
@Slf4j
public class ExcelController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
    public void exportExcel(HttpServletResponse response)  {
        List<UserExport> resultList = userService.exportAllUserInfo("", "", "2");
        ExcelUtils.writeExcel(response, resultList, UserExport.class);
    }

    @RequestMapping(value = "/readExcel", method = RequestMethod.POST)
    public void readExcel(@RequestParam(value="uploadFile", required = false) MultipartFile file){
        List<UserExport> list = ExcelUtils.readExcel("", UserExport.class, file);
        int i = userService.importUser(list);
        list.forEach(
                b -> System.out.println(JSON.toJSONString(b))
        );
    }
}

