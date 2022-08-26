package com.datou.yhgl.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 知识分类
 * </p>
 *
 * @author rock
 * @since 2022-08-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class KnowledgeType extends Model<KnowledgeType> {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 父id
     */
    private Long parentId;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createAt;

    /**
     * 更新时间
     */
    private LocalDateTime updateAt;

    /**
     * 是否删除 N未删除 Y已删除
     */
    private String isDeleted;

    /**
     * 是否默认 N非默认分类 Y默认分类
     */
    private String isDefault;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
