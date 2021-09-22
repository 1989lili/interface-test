package com.tuling.xxy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiongxy
 * @since 2021-09-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DictionaryTest implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    /**
     * 字典分组
     */
    private String dicGroup;

    /**
     * 字典项编码
     */
    private String dicCode;

    /**
     * 字典项名称
     */
    private String dicName;

    /**
     * 字典项值
     */
    private String dicValue;

    /**
     * 字典项排序(组内)
     */
    private String dicSort;

    /**
     * 字典项备注
     */
    private String remark;

    /**
     * 分类标志（0=字典明细；1=字典分组）
     */
    private String groupFlag;

    /**
     * 更新时间
     */
    private LocalDateTime updateDate;


}
