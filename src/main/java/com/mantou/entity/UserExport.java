package com.mantou.entity;

import com.mantou.annotation.ExcelColumn;
import lombok.Data;

@Data
public class UserExport {
    @ExcelColumn(value = "ID", col = 1)
    private Integer id;
    @ExcelColumn(value = "用户名", col = 2)
    private String userName;
    @ExcelColumn(value = "工号", col = 3)
    private String jobNum;
    @ExcelColumn(value = "性别", col = 4)
    private String sex ;

    private Integer roleId ;
    @ExcelColumn(value = "角色", col = 5)
    private String roleName ;
}
