package com.datou.yhgl.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author datou
 * @since 2020-03-07
 */
@Data
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    private Long userId;

    private String name;

    public User() {
    }

    private Integer age;

    public User(Long id, Long userId, String name, Integer age, String email, String phone) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    private String email;


    private String phone;

//    private String password;
//    @TableField(fill = FieldFill.INSERT)
//    private Date createTime;
//    @TableField(fill = FieldFill.INSERT_UPDATE)
//    private Date updateTime;
//    //乐观锁版本号
//    @TableField(fill = FieldFill.INSERT)
//    @Version
//    private Integer version;
//    //逻辑删除标记
//    @TableField(fill = FieldFill.INSERT)
//    @TableLogic
//    private Integer deleted;


}
