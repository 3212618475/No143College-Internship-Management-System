package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.YuanxiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 院系
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("yuanxi")
public class YuanxiView extends YuanxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表




	public YuanxiView() {

	}

	public YuanxiView(YuanxiEntity yuanxiEntity) {
		try {
			BeanUtils.copyProperties(this, yuanxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}







	@Override
	public String toString() {
		return "YuanxiView{" +
			"} " + super.toString();
	}
}
