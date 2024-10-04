package com.dao;

import com.entity.PingfenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.PingfenView;

/**
 * 实习评分 Dao 接口
 *
 * @author 
 */
public interface PingfenDao extends BaseMapper<PingfenEntity> {

   List<PingfenView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
