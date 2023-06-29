package com.xavier.xavierapiclientsdk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoveSentence {
    /**
     * id
     */
    private Long id;
    /**
     * type：1-含蓄委婉型, 2-文艺清新型, 3-直接霸道型, 4-沙雕搞笑型, 5-单身沙雕风, 6-情书
     */
    private int type;
    /**
     * 情话
     */
    private String sentence;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 是否删除 0-未删除 1-删除
     */
    private Integer isDelete;

    private static final long serialVersionUID = 1L;
}
