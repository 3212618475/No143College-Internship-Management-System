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
 * 班级
 *
 * @author 
 * @email
 */
@TableName("banji")
public class BanjiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BanjiEntity() {

	}

	public BanjiEntity(T t) {
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
     * 班级编号
     */
    @ColumnInfo(comment="班级编号",type="varchar(200)")
    @TableField(value = "banji_uuid_number")

    private String banjiUuidNumber;


    /**
     * 班级名称
     */
    @ColumnInfo(comment="班级名称",type="varchar(200)")
    @TableField(value = "banji_name")

    private String banjiName;


    /**
     * 班级位置
     */
    @ColumnInfo(comment="班级位置",type="varchar(200)")
    @TableField(value = "banji_address")

    private String banjiAddress;


    /**
     * 班级备注
     */
    @ColumnInfo(comment="班级备注",type="longtext")
    @TableField(value = "banji_content")

    private String banjiContent;


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
	 * 获取：班级编号
	 */
    public String getBanjiUuidNumber() {
        return banjiUuidNumber;
    }
    /**
	 * 设置：班级编号
	 */

    public void setBanjiUuidNumber(String banjiUuidNumber) {
        this.banjiUuidNumber = banjiUuidNumber;
    }
    /**
	 * 获取：班级名称
	 */
    public String getBanjiName() {
        return banjiName;
    }
    /**
	 * 设置：班级名称
	 */

    public void setBanjiName(String banjiName) {
        this.banjiName = banjiName;
    }
    /**
	 * 获取：班级位置
	 */
    public String getBanjiAddress() {
        return banjiAddress;
    }
    /**
	 * 设置：班级位置
	 */

    public void setBanjiAddress(String banjiAddress) {
        this.banjiAddress = banjiAddress;
    }
    /**
	 * 获取：班级备注
	 */
    public String getBanjiContent() {
        return banjiContent;
    }
    /**
	 * 设置：班级备注
	 */

    public void setBanjiContent(String banjiContent) {
        this.banjiContent = banjiContent;
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
        return "Banji{" +
            ", id=" + id +
            ", banjiUuidNumber=" + banjiUuidNumber +
            ", banjiName=" + banjiName +
            ", banjiAddress=" + banjiAddress +
            ", banjiContent=" + banjiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
