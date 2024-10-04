
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
 * 实习评分
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/pingfen")
public class PingfenController {
    private static final Logger logger = LoggerFactory.getLogger(PingfenController.class);

    private static final String TABLE_NAME = "pingfen";

    @Autowired
    private PingfenService pingfenService;


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
    private ToudiService toudiService;//简历投递
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
        PageUtils page = pingfenService.queryPage(params);

        //字典表数据转换
        List<PingfenView> list =(List<PingfenView>)page.getList();
        for(PingfenView c:list){
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
        PingfenEntity pingfen = pingfenService.selectById(id);
        if(pingfen !=null){
            //entity转view
            PingfenView view = new PingfenView();
            BeanUtils.copyProperties( pingfen , view );//把实体数据重构到view中
            //级联表 公司
            //级联表
            GongsiEntity gongsi = gongsiService.selectById(pingfen.getGongsiId());
            if(gongsi != null){
            BeanUtils.copyProperties( gongsi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "gongsiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setGongsiId(gongsi.getId());
            }
            //级联表 学生
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(pingfen.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"
, "gongsiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody PingfenEntity pingfen, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,pingfen:{}",this.getClass().getName(),pingfen.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            pingfen.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("公司".equals(role))
            pingfen.setGongsiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<PingfenEntity> queryWrapper = new EntityWrapper<PingfenEntity>()
            .eq("gongsi_id", pingfen.getGongsiId())
            .eq("yonghu_id", pingfen.getYonghuId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PingfenEntity pingfenEntity = pingfenService.selectOne(queryWrapper);
//        if(pingfenEntity==null){
            pingfen.setInsertTime(new Date());
            pingfen.setCreateTime(new Date());
            pingfenService.insert(pingfen);
            return R.ok();
//        }else {
//            return R.error(511,"表中有相同数据");
//        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody PingfenEntity pingfen, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,pingfen:{}",this.getClass().getName(),pingfen.toString());
        PingfenEntity oldPingfenEntity = pingfenService.selectById(pingfen.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            pingfen.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("公司".equals(role))
//            pingfen.setGongsiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(pingfen.getPingfenText()) || "null".equals(pingfen.getPingfenText())){
                pingfen.setPingfenText(null);
        }

            pingfenService.updateById(pingfen);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<PingfenEntity> oldPingfenList =pingfenService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        pingfenService.deleteBatchIds(Arrays.asList(ids));

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
            List<PingfenEntity> pingfenList = new ArrayList<>();//上传的东西
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
                            PingfenEntity pingfenEntity = new PingfenEntity();
//                            pingfenEntity.setGongsiId(Integer.valueOf(data.get(0)));   //公司 要改的
//                            pingfenEntity.setYonghuId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            pingfenEntity.setPingfenPingfen(data.get(0));                    //评分 要改的
//                            pingfenEntity.setPingfenText(data.get(0));                    //评价内容 要改的
//                            pingfenEntity.setInsertTime(date);//时间
//                            pingfenEntity.setCreateTime(date);//时间
                            pingfenList.add(pingfenEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        pingfenService.insertBatch(pingfenList);
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

