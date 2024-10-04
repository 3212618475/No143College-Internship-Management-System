package com.entity.vo;

import com.entity.BanjiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 班级
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("banji")
public class BanjiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 班级编号
     */

    @TableField(value = "banji_uuid_number")
    private String banjiUuidNumber;


    /**
     * 班级名称
     */

    @TableField(value = "banji_name")
    private String banjiName;


    /**
     * 班级位置
     */

    @TableField(value = "banji_address")
    private String banjiAddress;


    /**
     * 班级备注
     */

    @TableField(value = "banji_content")
    private String banjiContent;


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
	 * 设置：班级编号
	 */
    public String getBanjiUuidNumber() {
        return banjiUuidNumber;
    }


    /**
	 * 获取：班级编号
	 */

    public void setBanjiUuidNumber(String banjiUuidNumber) {
        this.banjiUuidNumber = banjiUuidNumber;
    }
    /**
	 * 设置：班级名称
	 */
    public String getBanjiName() {
        return banjiName;
    }


    /**
	 * 获取：班级名称
	 */

    public void setBanjiName(String banjiName) {
        this.banjiName = banjiName;
    }
    /**
	 * 设置：班级位置
	 */
    public String getBanjiAddress() {
        return banjiAddress;
    }


    /**
	 * 获取：班级位置
	 */

    public void setBanjiAddress(String banjiAddress) {
        this.banjiAddress = banjiAddress;
    }
    /**
	 * 设置：班级备注
	 */
    public String getBanjiContent() {
        return banjiContent;
    }


    /**
	 * 获取：班级备注
	 */

    public void setBanjiContent(String banjiContent) {
        this.banjiContent = banjiContent;
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
