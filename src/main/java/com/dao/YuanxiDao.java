package com.dao;

import com.entity.YuanxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YuanxiView;

/**
 * 院系 Dao 接口
 *
 * @author 
 */
public interface YuanxiDao extends BaseMapper<YuanxiEntity> {

   List<YuanxiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
