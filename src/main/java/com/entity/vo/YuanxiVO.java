package com.entity.vo;

import com.entity.YuanxiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 院系
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yuanxi")
public class YuanxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 院系编号
     */

    @TableField(value = "yuanxi_uuid_number")
    private String yuanxiUuidNumber;


    /**
     * 院系名称
     */

    @TableField(value = "yuanxi_name")
    private String yuanxiName;


    /**
     * 院系位置
     */

    @TableField(value = "yuanxi_address")
    private String yuanxiAddress;


    /**
     * 院系备注
     */

    @TableField(value = "yuanxi_content")
    private String yuanxiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：院系编号
	 */
    public String getYuanxiUuidNumber() {
        return yuanxiUuidNumber;
    }


    /**
	 * 获取：院系编号
	 */

    public void setYuanxiUuidNumber(String yuanxiUuidNumber) {
        this.yuanxiUuidNumber = yuanxiUuidNumber;
    }
    /**
	 * 设置：院系名称
	 */
    public String getYuanxiName() {
        return yuanxiName;
    }


    /**
	 * 获取：院系名称
	 */

    public void setYuanxiName(String yuanxiName) {
        this.yuanxiName = yuanxiName;
    }
    /**
	 * 设置：院系位置
	 */
    public String getYuanxiAddress() {
        return yuanxiAddress;
    }


    /**
	 * 获取：院系位置
	 */

    public void setYuanxiAddress(String yuanxiAddress) {
        this.yuanxiAddress = yuanxiAddress;
    }
    /**
	 * 设置：院系备注
	 */
    public String getYuanxiContent() {
        return yuanxiContent;
    }


    /**
	 * 获取：院系备注
	 */

    public void setYuanxiContent(String yuanxiContent) {
        this.yuanxiContent = yuanxiContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
