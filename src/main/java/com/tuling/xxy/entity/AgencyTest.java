package com.tuling.xxy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.tuling.xxy.annotation.ReplaceField;
import com.tuling.xxy.constant.ReplaceFieldConstant;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

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
public class AgencyTest implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 代办名称
     */
    private String name;

    /**
     * 代办标题
     */
    private String title;

    /**
     * 代办类型
     */
    @ReplaceField(name = ReplaceFieldConstant.AGENCY_TYPE)
    private String type;

    /**
     * 创建时间
     */
    private LocalDateTime createTm;

    /**
     * 更新时间
     */
    private LocalDateTime updateTm;


}
