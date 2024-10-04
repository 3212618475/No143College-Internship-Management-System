package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZuoyeTijiaoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 作业提交
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zuoye_tijiao")
public class ZuoyeTijiaoView extends ZuoyeTijiaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 提交状态的值
	*/
	@ColumnInfo(comment="提交状态的字典表值",type="varchar(200)")
	private String zuoyeTijiaoYesnoValue;

	//级联表 公司
		/**
		* 公司名称
		*/

		@ColumnInfo(comment="公司名称",type="varchar(200)")
		private String gongsiName;
		/**
		* 公司类型
		*/
		@ColumnInfo(comment="公司类型",type="int(11)")
		private Integer gongsiTypes;
			/**
			* 公司类型的值
			*/
			@ColumnInfo(comment="公司类型的字典表值",type="varchar(200)")
			private String gongsiValue;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String gongsiPhone;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String gongsiEmail;
		/**
		* 公司封面
		*/

		@ColumnInfo(comment="公司封面",type="varchar(200)")
		private String gongsiPhoto;
		/**
		* 公司简介
		*/

		@ColumnInfo(comment="公司简介",type="text")
		private String gongsiContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer gongsiDelete;
	//级联表 学生
												/**
		* 学生姓名
		*/

		@ColumnInfo(comment="学生姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 学生手机号
		*/

		@ColumnInfo(comment="学生手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 学生身份证号
		*/

		@ColumnInfo(comment="学生身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 学生头像
		*/

		@ColumnInfo(comment="学生头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;
	//级联表 实习作业
					 
		/**
		* 实习作业 的 老师
		*/
		@ColumnInfo(comment="老师",type="int(11)")
		private Integer zuoyeGongsiId;
		/**
		* 作业名称
		*/

		@ColumnInfo(comment="作业名称",type="varchar(200)")
		private String zuoyeName;
		/**
		* 作业编号
		*/

		@ColumnInfo(comment="作业编号",type="varchar(200)")
		private String zuoyeUuidNumber;
		/**
		* 作业封面
		*/

		@ColumnInfo(comment="作业封面",type="varchar(200)")
		private String zuoyePhoto;
		/**
		* 作业类型
		*/
		@ColumnInfo(comment="作业类型",type="int(11)")
		private Integer zuoyeTypes;
			/**
			* 作业类型的值
			*/
			@ColumnInfo(comment="作业类型的字典表值",type="varchar(200)")
			private String zuoyeValue;
		/**
		* 作业下载
		*/

		@ColumnInfo(comment="作业下载",type="varchar(200)")
		private String zuoyeFile;
		/**
		* 作业介绍
		*/

		@ColumnInfo(comment="作业介绍",type="text")
		private String zuoyeContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer zuoyeDelete;



	public ZuoyeTijiaoView() {

	}

	public ZuoyeTijiaoView(ZuoyeTijiaoEntity zuoyeTijiaoEntity) {
		try {
			BeanUtils.copyProperties(this, zuoyeTijiaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 提交状态的值
	*/
	public String getZuoyeTijiaoYesnoValue() {
		return zuoyeTijiaoYesnoValue;
	}
	/**
	* 设置： 提交状态的值
	*/
	public void setZuoyeTijiaoYesnoValue(String zuoyeTijiaoYesnoValue) {
		this.zuoyeTijiaoYesnoValue = zuoyeTijiaoYesnoValue;
	}


	//级联表的get和set 公司

		/**
		* 获取： 公司名称
		*/
		public String getGongsiName() {
			return gongsiName;
		}
		/**
		* 设置： 公司名称
		*/
		public void setGongsiName(String gongsiName) {
			this.gongsiName = gongsiName;
		}
		/**
		* 获取： 公司类型
		*/
		public Integer getGongsiTypes() {
			return gongsiTypes;
		}
		/**
		* 设置： 公司类型
		*/
		public void setGongsiTypes(Integer gongsiTypes) {
			this.gongsiTypes = gongsiTypes;
		}


			/**
			* 获取： 公司类型的值
			*/
			public String getGongsiValue() {
				return gongsiValue;
			}
			/**
			* 设置： 公司类型的值
			*/
			public void setGongsiValue(String gongsiValue) {
				this.gongsiValue = gongsiValue;
			}

		/**
		* 获取： 联系方式
		*/
		public String getGongsiPhone() {
			return gongsiPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setGongsiPhone(String gongsiPhone) {
			this.gongsiPhone = gongsiPhone;
		}

		/**
		* 获取： 邮箱
		*/
		public String getGongsiEmail() {
			return gongsiEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setGongsiEmail(String gongsiEmail) {
			this.gongsiEmail = gongsiEmail;
		}

		/**
		* 获取： 公司封面
		*/
		public String getGongsiPhoto() {
			return gongsiPhoto;
		}
		/**
		* 设置： 公司封面
		*/
		public void setGongsiPhoto(String gongsiPhoto) {
			this.gongsiPhoto = gongsiPhoto;
		}

		/**
		* 获取： 公司简介
		*/
		public String getGongsiContent() {
			return gongsiContent;
		}
		/**
		* 设置： 公司简介
		*/
		public void setGongsiContent(String gongsiContent) {
			this.gongsiContent = gongsiContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getGongsiDelete() {
			return gongsiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setGongsiDelete(Integer gongsiDelete) {
			this.gongsiDelete = gongsiDelete;
		}
	//级联表的get和set 学生

		/**
		* 获取： 学生姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 学生姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 学生手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 学生手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 学生身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 学生身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 学生头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 学生头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}
	//级联表的get和set 实习作业
		/**
		* 获取：实习作业 的 老师
		*/
		public Integer getZuoyeGongsiId() {
			return zuoyeGongsiId;
		}
		/**
		* 设置：实习作业 的 老师
		*/
		public void setZuoyeGongsiId(Integer zuoyeGongsiId) {
			this.zuoyeGongsiId = zuoyeGongsiId;
		}

		/**
		* 获取： 作业名称
		*/
		public String getZuoyeName() {
			return zuoyeName;
		}
		/**
		* 设置： 作业名称
		*/
		public void setZuoyeName(String zuoyeName) {
			this.zuoyeName = zuoyeName;
		}

		/**
		* 获取： 作业编号
		*/
		public String getZuoyeUuidNumber() {
			return zuoyeUuidNumber;
		}
		/**
		* 设置： 作业编号
		*/
		public void setZuoyeUuidNumber(String zuoyeUuidNumber) {
			this.zuoyeUuidNumber = zuoyeUuidNumber;
		}

		/**
		* 获取： 作业封面
		*/
		public String getZuoyePhoto() {
			return zuoyePhoto;
		}
		/**
		* 设置： 作业封面
		*/
		public void setZuoyePhoto(String zuoyePhoto) {
			this.zuoyePhoto = zuoyePhoto;
		}
		/**
		* 获取： 作业类型
		*/
		public Integer getZuoyeTypes() {
			return zuoyeTypes;
		}
		/**
		* 设置： 作业类型
		*/
		public void setZuoyeTypes(Integer zuoyeTypes) {
			this.zuoyeTypes = zuoyeTypes;
		}


			/**
			* 获取： 作业类型的值
			*/
			public String getZuoyeValue() {
				return zuoyeValue;
			}
			/**
			* 设置： 作业类型的值
			*/
			public void setZuoyeValue(String zuoyeValue) {
				this.zuoyeValue = zuoyeValue;
			}

		/**
		* 获取： 作业下载
		*/
		public String getZuoyeFile() {
			return zuoyeFile;
		}
		/**
		* 设置： 作业下载
		*/
		public void setZuoyeFile(String zuoyeFile) {
			this.zuoyeFile = zuoyeFile;
		}

		/**
		* 获取： 作业介绍
		*/
		public String getZuoyeContent() {
			return zuoyeContent;
		}
		/**
		* 设置： 作业介绍
		*/
		public void setZuoyeContent(String zuoyeContent) {
			this.zuoyeContent = zuoyeContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getZuoyeDelete() {
			return zuoyeDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setZuoyeDelete(Integer zuoyeDelete) {
			this.zuoyeDelete = zuoyeDelete;
		}


	@Override
	public String toString() {
		return "ZuoyeTijiaoView{" +
			", zuoyeTijiaoYesnoValue=" + zuoyeTijiaoYesnoValue +
			", zuoyeName=" + zuoyeName +
			", zuoyeUuidNumber=" + zuoyeUuidNumber +
			", zuoyePhoto=" + zuoyePhoto +
			", zuoyeFile=" + zuoyeFile +
			", zuoyeContent=" + zuoyeContent +
			", zuoyeDelete=" + zuoyeDelete +
			", gongsiName=" + gongsiName +
			", gongsiPhone=" + gongsiPhone +
			", gongsiEmail=" + gongsiEmail +
			", gongsiPhoto=" + gongsiPhoto +
			", gongsiContent=" + gongsiContent +
			", gongsiDelete=" + gongsiDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
