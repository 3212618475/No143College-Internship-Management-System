package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.YonghuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 学生
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("yonghu")
public class YonghuView extends YonghuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 性别的值
	*/
	@ColumnInfo(comment="性别的字典表值",type="varchar(200)")
	private String sexValue;

	//级联表 班级
		/**
		* 班级编号
		*/

		@ColumnInfo(comment="班级编号",type="varchar(200)")
		private String banjiUuidNumber;
		/**
		* 班级名称
		*/

		@ColumnInfo(comment="班级名称",type="varchar(200)")
		private String banjiName;
		/**
		* 班级位置
		*/

		@ColumnInfo(comment="班级位置",type="varchar(200)")
		private String banjiAddress;
		/**
		* 班级备注
		*/

		@ColumnInfo(comment="班级备注",type="longtext")
		private String banjiContent;
	//级联表 院系
		/**
		* 院系编号
		*/

		@ColumnInfo(comment="院系编号",type="varchar(200)")
		private String yuanxiUuidNumber;
		/**
		* 院系名称
		*/

		@ColumnInfo(comment="院系名称",type="varchar(200)")
		private String yuanxiName;
		/**
		* 院系位置
		*/

		@ColumnInfo(comment="院系位置",type="varchar(200)")
		private String yuanxiAddress;
		/**
		* 院系备注
		*/

		@ColumnInfo(comment="院系备注",type="longtext")
		private String yuanxiContent;



	public YonghuView() {

	}

	public YonghuView(YonghuEntity yonghuEntity) {
		try {
			BeanUtils.copyProperties(this, yonghuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 性别的值
	*/
	public String getSexValue() {
		return sexValue;
	}
	/**
	* 设置： 性别的值
	*/
	public void setSexValue(String sexValue) {
		this.sexValue = sexValue;
	}


	//级联表的get和set 班级

		/**
		* 获取： 班级编号
		*/
		public String getBanjiUuidNumber() {
			return banjiUuidNumber;
		}
		/**
		* 设置： 班级编号
		*/
		public void setBanjiUuidNumber(String banjiUuidNumber) {
			this.banjiUuidNumber = banjiUuidNumber;
		}

		/**
		* 获取： 班级名称
		*/
		public String getBanjiName() {
			return banjiName;
		}
		/**
		* 设置： 班级名称
		*/
		public void setBanjiName(String banjiName) {
			this.banjiName = banjiName;
		}

		/**
		* 获取： 班级位置
		*/
		public String getBanjiAddress() {
			return banjiAddress;
		}
		/**
		* 设置： 班级位置
		*/
		public void setBanjiAddress(String banjiAddress) {
			this.banjiAddress = banjiAddress;
		}

		/**
		* 获取： 班级备注
		*/
		public String getBanjiContent() {
			return banjiContent;
		}
		/**
		* 设置： 班级备注
		*/
		public void setBanjiContent(String banjiContent) {
			this.banjiContent = banjiContent;
		}
	//级联表的get和set 院系

		/**
		* 获取： 院系编号
		*/
		public String getYuanxiUuidNumber() {
			return yuanxiUuidNumber;
		}
		/**
		* 设置： 院系编号
		*/
		public void setYuanxiUuidNumber(String yuanxiUuidNumber) {
			this.yuanxiUuidNumber = yuanxiUuidNumber;
		}

		/**
		* 获取： 院系名称
		*/
		public String getYuanxiName() {
			return yuanxiName;
		}
		/**
		* 设置： 院系名称
		*/
		public void setYuanxiName(String yuanxiName) {
			this.yuanxiName = yuanxiName;
		}

		/**
		* 获取： 院系位置
		*/
		public String getYuanxiAddress() {
			return yuanxiAddress;
		}
		/**
		* 设置： 院系位置
		*/
		public void setYuanxiAddress(String yuanxiAddress) {
			this.yuanxiAddress = yuanxiAddress;
		}

		/**
		* 获取： 院系备注
		*/
		public String getYuanxiContent() {
			return yuanxiContent;
		}
		/**
		* 设置： 院系备注
		*/
		public void setYuanxiContent(String yuanxiContent) {
			this.yuanxiContent = yuanxiContent;
		}


	@Override
	public String toString() {
		return "YonghuView{" +
			", sexValue=" + sexValue +
			", yuanxiUuidNumber=" + yuanxiUuidNumber +
			", yuanxiName=" + yuanxiName +
			", yuanxiAddress=" + yuanxiAddress +
			", yuanxiContent=" + yuanxiContent +
			", banjiUuidNumber=" + banjiUuidNumber +
			", banjiName=" + banjiName +
			", banjiAddress=" + banjiAddress +
			", banjiContent=" + banjiContent +
			"} " + super.toString();
	}
}
