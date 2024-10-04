package com.dao;

import com.entity.ToudiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ToudiView;

/**
 * 简历投递 Dao 接口
 *
 * @author 
 */
public interface ToudiDao extends BaseMapper<ToudiEntity> {

   List<ToudiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
