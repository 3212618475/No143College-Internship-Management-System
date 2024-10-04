import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import banji from '@/views/modules/banji/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gonggao from '@/views/modules/gonggao/list'
    import gongsi from '@/views/modules/gongsi/list'
    import jianli from '@/views/modules/jianli/list'
    import laoshi from '@/views/modules/laoshi/list'
    import pingfen from '@/views/modules/pingfen/list'
    import qingkuang from '@/views/modules/qingkuang/list'
    import toudi from '@/views/modules/toudi/list'
    import yonghu from '@/views/modules/yonghu/list'
    import yuanxi from '@/views/modules/yuanxi/list'
    import zhaopin from '@/views/modules/zhaopin/list'
    import zuoye from '@/views/modules/zuoye/list'
    import zuoyeTijiao from '@/views/modules/zuoyeTijiao/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryGongsi from '@/views/modules/dictionaryGongsi/list'
    import dictionaryJianli from '@/views/modules/dictionaryJianli/list'
    import dictionaryLeixing from '@/views/modules/dictionaryLeixing/list'
    import dictionaryMianshiYesno from '@/views/modules/dictionaryMianshiYesno/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryZhaopin from '@/views/modules/dictionaryZhaopin/list'
    import dictionaryZuoye from '@/views/modules/dictionaryZuoye/list'
    import dictionaryZuoyeTijiaoYesno from '@/views/modules/dictionaryZuoyeTijiaoYesno/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryGongsi',
        name: '公司类型',
        component: dictionaryGongsi
    }
    ,{
        path: '/dictionaryJianli',
        name: '求职意向',
        component: dictionaryJianli
    }
    ,{
        path: '/dictionaryLeixing',
        name: '招聘类型',
        component: dictionaryLeixing
    }
    ,{
        path: '/dictionaryMianshiYesno',
        name: '投递状态',
        component: dictionaryMianshiYesno
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryZhaopin',
        name: '招聘岗位',
        component: dictionaryZhaopin
    }
    ,{
        path: '/dictionaryZuoye',
        name: '作业类型',
        component: dictionaryZuoye
    }
    ,{
        path: '/dictionaryZuoyeTijiaoYesno',
        name: '提交状态',
        component: dictionaryZuoyeTijiaoYesno
    }


    ,{
        path: '/banji',
        name: '班级',
        component: banji
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/gongsi',
        name: '公司',
        component: gongsi
      }
    ,{
        path: '/jianli',
        name: '简历',
        component: jianli
      }
    ,{
        path: '/laoshi',
        name: '老师',
        component: laoshi
      }
    ,{
        path: '/pingfen',
        name: '实习评分',
        component: pingfen
      }
    ,{
        path: '/qingkuang',
        name: '实习情况',
        component: qingkuang
      }
    ,{
        path: '/toudi',
        name: '简历投递',
        component: toudi
      }
    ,{
        path: '/yonghu',
        name: '学生',
        component: yonghu
      }
    ,{
        path: '/yuanxi',
        name: '院系',
        component: yuanxi
      }
    ,{
        path: '/zhaopin',
        name: '职位招聘',
        component: zhaopin
      }
    ,{
        path: '/zuoye',
        name: '实习作业',
        component: zuoye
      }
    ,{
        path: '/zuoyeTijiao',
        name: '作业提交',
        component: zuoyeTijiao
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
