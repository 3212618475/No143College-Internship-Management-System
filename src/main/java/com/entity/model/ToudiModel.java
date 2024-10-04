package com.entity.model;

import com.entity.ToudiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 简历投递
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ToudiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 简历
     */
    private Integer jianliId;


    /**
     * 招聘
     */
    private Integer zhaopinId;


    /**
     * 投递状态
     */
    private Integer mianshiYesnoTypes;


    /**
     * 投递回复
     */
    private String mianshiYesnoText;


    /**
     * 投递时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
