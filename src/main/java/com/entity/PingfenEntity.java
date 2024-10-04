package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 实习评分
 *
 * @author 
 * @email
 */
@TableName("pingfen")
public class PingfenEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public PingfenEntity() {

	}

	public PingfenEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 公司
     */
    @ColumnInfo(comment="公司",type="int(11)")
    @TableField(value = "gongsi_id")

    private Integer gongsiId;


    /**
     * 学生
     */
    @ColumnInfo(comment="学生",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 评分
     */
    @ColumnInfo(comment="评分",type="decimal(10,2)")
    @TableField(value = "pingfen_pingfen")

    private Double pingfenPingfen;


    /**
     * 评价内容
     */
    @ColumnInfo(comment="评价内容",type="longtext")
    @TableField(value = "pingfen_text")

    private String pingfenText;


    /**
     * 评价时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="评价时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：公司
	 */
    public Integer getGongsiId() {
        return gongsiId;
    }
    /**
	 * 设置：公司
	 */

    public void setGongsiId(Integer gongsiId) {
        this.gongsiId = gongsiId;
    }
    /**
	 * 获取：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：评分
	 */
    public Double getPingfenPingfen() {
        return pingfenPingfen;
    }
    /**
	 * 设置：评分
	 */

    public void setPingfenPingfen(Double pingfenPingfen) {
        this.pingfenPingfen = pingfenPingfen;
    }
    /**
	 * 获取：评价内容
	 */
    public String getPingfenText() {
        return pingfenText;
    }
    /**
	 * 设置：评价内容
	 */

    public void setPingfenText(String pingfenText) {
        this.pingfenText = pingfenText;
    }
    /**
	 * 获取：评价时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：评价时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Pingfen{" +
            ", id=" + id +
            ", gongsiId=" + gongsiId +
            ", yonghuId=" + yonghuId +
            ", pingfenPingfen=" + pingfenPingfen +
            ", pingfenText=" + pingfenText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
