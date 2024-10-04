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
 * 院系
 *
 * @author 
 * @email
 */
@TableName("yuanxi")
public class YuanxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YuanxiEntity() {

	}

	public YuanxiEntity(T t) {
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
     * 院系编号
     */
    @ColumnInfo(comment="院系编号",type="varchar(200)")
    @TableField(value = "yuanxi_uuid_number")

    private String yuanxiUuidNumber;


    /**
     * 院系名称
     */
    @ColumnInfo(comment="院系名称",type="varchar(200)")
    @TableField(value = "yuanxi_name")

    private String yuanxiName;


    /**
     * 院系位置
     */
    @ColumnInfo(comment="院系位置",type="varchar(200)")
    @TableField(value = "yuanxi_address")

    private String yuanxiAddress;


    /**
     * 院系备注
     */
    @ColumnInfo(comment="院系备注",type="longtext")
    @TableField(value = "yuanxi_content")

    private String yuanxiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
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
	 * 获取：院系编号
	 */
    public String getYuanxiUuidNumber() {
        return yuanxiUuidNumber;
    }
    /**
	 * 设置：院系编号
	 */

    public void setYuanxiUuidNumber(String yuanxiUuidNumber) {
        this.yuanxiUuidNumber = yuanxiUuidNumber;
    }
    /**
	 * 获取：院系名称
	 */
    public String getYuanxiName() {
        return yuanxiName;
    }
    /**
	 * 设置：院系名称
	 */

    public void setYuanxiName(String yuanxiName) {
        this.yuanxiName = yuanxiName;
    }
    /**
	 * 获取：院系位置
	 */
    public String getYuanxiAddress() {
        return yuanxiAddress;
    }
    /**
	 * 设置：院系位置
	 */

    public void setYuanxiAddress(String yuanxiAddress) {
        this.yuanxiAddress = yuanxiAddress;
    }
    /**
	 * 获取：院系备注
	 */
    public String getYuanxiContent() {
        return yuanxiContent;
    }
    /**
	 * 设置：院系备注
	 */

    public void setYuanxiContent(String yuanxiContent) {
        this.yuanxiContent = yuanxiContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
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
        return "Yuanxi{" +
            ", id=" + id +
            ", yuanxiUuidNumber=" + yuanxiUuidNumber +
            ", yuanxiName=" + yuanxiName +
            ", yuanxiAddress=" + yuanxiAddress +
            ", yuanxiContent=" + yuanxiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
