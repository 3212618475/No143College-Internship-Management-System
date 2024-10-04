package com.entity.model;

import com.entity.YuanxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 院系
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YuanxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 院系编号
     */
    private String yuanxiUuidNumber;


    /**
     * 院系名称
     */
    private String yuanxiName;


    /**
     * 院系位置
     */
    private String yuanxiAddress;


    /**
     * 院系备注
     */
    private String yuanxiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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

    }
