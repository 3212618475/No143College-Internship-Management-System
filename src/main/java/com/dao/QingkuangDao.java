package com.dao;

import com.entity.QingkuangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.QingkuangView;

/**
 * 实习情况 Dao 接口
 *
 * @author 
 */
public interface QingkuangDao extends BaseMapper<QingkuangEntity> {

   List<QingkuangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
