package com.datou.yhgl.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    //insertFill方法在mp执行添加操作的时候运行
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
        //添加乐观锁默认值是1
        this.setFieldValByName("version",1,metaObject);
        //逻辑删除默认值
        this.setFieldValByName("deleted",0,metaObject);
    }

    //updateFill方法在mp执行修改操作的时候运行
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
