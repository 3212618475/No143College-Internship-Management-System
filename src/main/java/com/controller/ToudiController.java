
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 简历投递
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/toudi")
public class ToudiController {
    private static final Logger logger = LoggerFactory.getLogger(ToudiController.class);

    private static final String TABLE_NAME = "toudi";

    @Autowired
    private ToudiService toudiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BanjiService banjiService;//班级
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private GongsiService gongsiService;//公司
    @Autowired
    private JianliService jianliService;//简历
    @Autowired
    private LaoshiService laoshiService;//老师
    @Autowired
    private PingfenService pingfenService;//实习评分
    @Autowired
    private YonghuService yonghuService;//学生
    @Autowired
    private YuanxiService yuanxiService;//院系
    @Autowired
    private ZhaopinService zhaopinService;//职位招聘
    @Autowired
    private ZuoyeService zuoyeService;//实习作业
    @Autowired
    private ZuoyeTijiaoService zuoyeTijiaoService;//作业提交
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("公司".equals(role))
            params.put("gongsiId",request.getSession().getAttribute("userId"));
        else if("老师".equals(role))
            params.put("laoshiId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = toudiService.queryPage(params);

        //字典表数据转换
        List<ToudiView> list =(List<ToudiView>)page.getList();
        for(ToudiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ToudiEntity toudi = toudiService.selectById(id);
        if(toudi !=null){
            //entity转view
            ToudiView view = new ToudiView();
            BeanUtils.copyProperties( toudi , view );//把实体数据重构到view中
            //级联表 简历
            //级联表
            JianliEntity jianli = jianliService.selectById(toudi.getJianliId());
            if(jianli != null){
            BeanUtils.copyProperties( jianli , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJianliId(jianli.getId());
            }
            //级联表 职位招聘
            //级联表
            ZhaopinEntity zhaopin = zhaopinService.selectById(toudi.getZhaopinId());
            if(zhaopin != null){
            BeanUtils.copyProperties( zhaopin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setZhaopinId(zhaopin.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ToudiEntity toudi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,toudi:{}",this.getClass().getName(),toudi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ToudiEntity> queryWrapper = new EntityWrapper<ToudiEntity>()
            .eq("jianli_id", toudi.getJianliId())
            .eq("zhaopin_id", toudi.getZhaopinId())
            .in("mianshi_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ToudiEntity toudiEntity = toudiService.selectOne(queryWrapper);
        if(toudiEntity==null){
            toudi.setInsertTime(new Date());
            toudi.setCreateTime(new Date());
            toudiService.insert(toudi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ToudiEntity toudi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,toudi:{}",this.getClass().getName(),toudi.toString());
        ToudiEntity oldToudiEntity = toudiService.selectById(toudi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(toudi.getMianshiYesnoText()) || "null".equals(toudi.getMianshiYesnoText())){
                toudi.setMianshiYesnoText(null);
        }

            toudiService.updateById(toudi);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ToudiEntity> oldToudiList =toudiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        toudiService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<ToudiEntity> toudiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ToudiEntity toudiEntity = new ToudiEntity();
//                            toudiEntity.setJianliId(Integer.valueOf(data.get(0)));   //简历 要改的
//                            toudiEntity.setZhaopinId(Integer.valueOf(data.get(0)));   //招聘 要改的
//                            toudiEntity.setMianshiYesnoTypes(Integer.valueOf(data.get(0)));   //投递状态 要改的
//                            toudiEntity.setMianshiYesnoText(data.get(0));                    //投递回复 要改的
//                            toudiEntity.setInsertTime(date);//时间
//                            toudiEntity.setCreateTime(date);//时间
                            toudiList.add(toudiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        toudiService.insertBatch(toudiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




}

