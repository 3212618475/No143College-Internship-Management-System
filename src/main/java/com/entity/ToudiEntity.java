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
 * 简历投递
 *
 * @author 
 * @email
 */
@TableName("toudi")
public class ToudiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ToudiEntity() {

	}

	public ToudiEntity(T t) {
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
     * 简历
     */
    @ColumnInfo(comment="简历",type="int(11)")
    @TableField(value = "jianli_id")

    private Integer jianliId;


    /**
     * 招聘
     */
    @ColumnInfo(comment="招聘",type="int(11)")
    @TableField(value = "zhaopin_id")

    private Integer zhaopinId;


    /**
     * 投递状态
     */
    @ColumnInfo(comment="投递状态",type="int(11)")
    @TableField(value = "mianshi_yesno_types")

    private Integer mianshiYesnoTypes;


    /**
     * 投递回复
     */
    @ColumnInfo(comment="投递回复",type="text")
    @TableField(value = "mianshi_yesno_text")

    private String mianshiYesnoText;


    /**
     * 投递时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="投递时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
	 * 获取：简历
	 */
    public Integer getJianliId() {
        return jianliId;
    }
    /**
	 * 设置：简历
	 */

    public void setJianliId(Integer jianliId) {
        this.jianliId = jianliId;
    }
    /**
	 * 获取：招聘
	 */
    public Integer getZhaopinId() {
        return zhaopinId;
    }
    /**
	 * 设置：招聘
	 */

    public void setZhaopinId(Integer zhaopinId) {
        this.zhaopinId = zhaopinId;
    }
    /**
	 * 获取：投递状态
	 */
    public Integer getMianshiYesnoTypes() {
        return mianshiYesnoTypes;
    }
    /**
	 * 设置：投递状态
	 */

    public void setMianshiYesnoTypes(Integer mianshiYesnoTypes) {
        this.mianshiYesnoTypes = mianshiYesnoTypes;
    }
    /**
	 * 获取：投递回复
	 */
    public String getMianshiYesnoText() {
        return mianshiYesnoText;
    }
    /**
	 * 设置：投递回复
	 */

    public void setMianshiYesnoText(String mianshiYesnoText) {
        this.mianshiYesnoText = mianshiYesnoText;
    }
    /**
	 * 获取：投递时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：投递时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Toudi{" +
            ", id=" + id +
            ", jianliId=" + jianliId +
            ", zhaopinId=" + zhaopinId +
            ", mianshiYesnoTypes=" + mianshiYesnoTypes +
            ", mianshiYesnoText=" + mianshiYesnoText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
