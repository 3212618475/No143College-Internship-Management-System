<template>
  <div class="addEdit-block">
    <el-form
        class="detail-form-content"
        ref="ruleForm"
        :model="ruleForm"
        :rules="rules"
        label-width="auto"
    >
      <el-row>
        <el-col :span="12" v-if="sessionTable !='gongsi'">
          <el-form-item class="select" v-if="type!='info'" label="公司" prop="gongsiId">
            <el-select v-model="ruleForm.gongsiId" :disabled="ro.gongsiId" filterable placeholder="请选择公司"
                       @change="gongsiChange">
              <el-option
                  v-for="(item,index) in gongsiOptions"
                  v-bind:key="item.id"
                  :label="item.gongsiName"
                  :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>

        <el-col :span="12" v-if="sessionTable !='gongsi' ">
          <el-form-item class="input" v-if="type!='info'" label="公司名称" prop="gongsiName">
            <el-input v-model="gongsiForm.gongsiName"
                      placeholder="公司名称" clearable readonly></el-input>
          </el-form-item>
          <div v-else-if="type=='info'">
            <el-form-item class="input" label="公司名称" prop="gongsiName">
              <el-input v-model="ruleForm.gongsiName"
                        placeholder="公司名称" readonly></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12" v-if="sessionTable !='gongsi' ">
          <el-form-item class="input" v-if="type!='info'" label="公司类型" prop="gongsiValue">
            <el-input v-model="gongsiForm.gongsiValue"
                      placeholder="公司类型" clearable readonly></el-input>
          </el-form-item>
          <div v-else-if="type=='info'">
            <el-form-item class="input" label="公司类型" prop="gongsiValue">
              <el-input v-model="ruleForm.gongsiValue"
                        placeholder="公司类型" readonly></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12" v-if="sessionTable !='gongsi' ">
          <el-form-item class="input" v-if="type!='info'" label="联系方式" prop="gongsiPhone">
            <el-input v-model="gongsiForm.gongsiPhone"
                      placeholder="联系方式" clearable readonly></el-input>
          </el-form-item>
          <div v-else-if="type=='info'">
            <el-form-item class="input" label="联系方式" prop="gongsiPhone">
              <el-input v-model="ruleForm.gongsiPhone"
                        placeholder="联系方式" readonly></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12" v-if="sessionTable !='gongsi' ">
          <el-form-item class="input" v-if="type!='info'" label="邮箱" prop="gongsiEmail">
            <el-input v-model="gongsiForm.gongsiEmail"
                      placeholder="邮箱" clearable readonly></el-input>
          </el-form-item>
          <div v-else-if="type=='info'">
            <el-form-item class="input" label="邮箱" prop="gongsiEmail">
              <el-input v-model="ruleForm.gongsiEmail"
                        placeholder="邮箱" readonly></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12" v-if="sessionTable !='gongsi' ">
          <el-form-item class="upload" v-if="type!='info' && !ro.gongsiPhoto" label="公司封面" prop="gongsiPhoto">
            <img style="margin-right:20px;" v-bind:key="index"
                 v-for="(item,index) in (gongsiForm.gongsiPhoto || '').split(',')" :src="$base.url+item" width="100"
                 height="100">
          </el-form-item>
          <div v-else-if="type=='info'">
            <el-form-item v-if="ruleForm.gongsiPhoto" label="公司封面" prop="gongsiPhoto">
              <img style="margin-right:20px;" v-bind:key="index"
                   v-for="(item,index) in (ruleForm.gongsiPhoto || '').split(',')" :src="$base.url+item" width="100"
                   height="100">
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12" v-if="sessionTable !='yonghu'">
          <el-form-item class="select" v-if="type!='info'" label="学生" prop="yonghuId">
            <el-select v-model="ruleForm.yonghuId" :disabled="ro.yonghuId" filterable placeholder="请选择学生"
                       @change="yonghuChange">
              <el-option
                  v-for="(item,index) in yonghuOptions"
                  v-bind:key="item.id"
                  :label="item.yonghuName"
                  :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>

        <el-col :span="12" v-if="sessionTable !='yonghu' ">
          <el-form-item class="input" v-if="type!='info'" label="学生姓名" prop="yonghuName">
            <el-input v-model="yonghuForm.yonghuName"
                      placeholder="学生姓名" clearable readonly></el-input>
          </el-form-item>
          <div v-else-if="type=='info'">
            <el-form-item class="input" label="学生姓名" prop="yonghuName">
              <el-input v-model="ruleForm.yonghuName"
                        placeholder="学生姓名" readonly></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12" v-if="sessionTable !='yonghu' ">
          <el-form-item class="input" v-if="type!='info'" label="学生手机号" prop="yonghuPhone">
            <el-input v-model="yonghuForm.yonghuPhone"
                      placeholder="学生手机号" clearable readonly></el-input>
          </el-form-item>
          <div v-else-if="type=='info'">
            <el-form-item class="input" label="学生手机号" prop="yonghuPhone">
              <el-input v-model="ruleForm.yonghuPhone"
                        placeholder="学生手机号" readonly></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12" v-if="sessionTable !='yonghu' ">
          <el-form-item class="input" v-if="type!='info'" label="学生身份证号" prop="yonghuIdNumber">
            <el-input v-model="yonghuForm.yonghuIdNumber"
                      placeholder="学生身份证号" clearable readonly></el-input>
          </el-form-item>
          <div v-else-if="type=='info'">
            <el-form-item class="input" label="学生身份证号" prop="yonghuIdNumber">
              <el-input v-model="ruleForm.yonghuIdNumber"
                        placeholder="学生身份证号" readonly></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12" v-if="sessionTable !='yonghu' ">
          <el-form-item class="upload" v-if="type!='info' && !ro.yonghuPhoto" label="学生头像" prop="yonghuPhoto">
            <img style="margin-right:20px;" v-bind:key="index"
                 v-for="(item,index) in (yonghuForm.yonghuPhoto || '').split(',')" :src="$base.url+item" width="100"
                 height="100">
          </el-form-item>
          <div v-else-if="type=='info'">
            <el-form-item v-if="ruleForm.yonghuPhoto" label="学生头像" prop="yonghuPhoto">
              <img style="margin-right:20px;" v-bind:key="index"
                   v-for="(item,index) in (ruleForm.yonghuPhoto || '').split(',')" :src="$base.url+item" width="100"
                   height="100">
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12" v-if="sessionTable !='yonghu' ">
          <el-form-item class="input" v-if="type!='info'" label="电子邮箱" prop="yonghuEmail">
            <el-input v-model="yonghuForm.yonghuEmail"
                      placeholder="电子邮箱" clearable readonly></el-input>
          </el-form-item>
          <div v-else-if="type=='info'">
            <el-form-item class="input" label="电子邮箱" prop="yonghuEmail">
              <el-input v-model="ruleForm.yonghuEmail"
                        placeholder="电子邮箱" readonly></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12" v-if="sessionTable !='zuoye'">
          <el-form-item class="select" v-if="type!='info'" label="实习作业" prop="zuoyeId">
            <el-select v-model="ruleForm.zuoyeId" :disabled="ro.zuoyeId" filterable placeholder="请选择实习作业"
                       @change="zuoyeChange">
              <el-option
                  v-for="(item,index) in zuoyeOptions"
                  v-bind:key="item.id"
                  :label="item.zuoyeName"
                  :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>

        <el-col :span="12" v-if="sessionTable !='zuoye' ">
          <el-form-item class="input" v-if="type!='info'" label="作业名称" prop="zuoyeName">
            <el-input v-model="zuoyeForm.zuoyeName"
                      placeholder="作业名称" clearable readonly></el-input>
          </el-form-item>
          <div v-else-if="type=='info'">
            <el-form-item class="input" label="作业名称" prop="zuoyeName">
              <el-input v-model="ruleForm.zuoyeName"
                        placeholder="作业名称" readonly></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12" v-if="sessionTable !='zuoye' ">
          <el-form-item class="input" v-if="type!='info'" label="作业编号" prop="zuoyeUuidNumber">
            <el-input v-model="zuoyeForm.zuoyeUuidNumber"
                      placeholder="作业编号" clearable readonly></el-input>
          </el-form-item>
          <div v-else-if="type=='info'">
            <el-form-item class="input" label="作业编号" prop="zuoyeUuidNumber">
              <el-input v-model="ruleForm.zuoyeUuidNumber"
                        placeholder="作业编号" readonly></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12" v-if="sessionTable !='zuoye' ">
          <el-form-item class="upload" v-if="type!='info' && !ro.zuoyePhoto" label="作业封面" prop="zuoyePhoto">
            <img style="margin-right:20px;" v-bind:key="index"
                 v-for="(item,index) in (zuoyeForm.zuoyePhoto || '').split(',')" :src="$base.url+item" width="100"
                 height="100">
          </el-form-item>
          <div v-else-if="type=='info'">
            <el-form-item v-if="ruleForm.zuoyePhoto" label="作业封面" prop="zuoyePhoto">
              <img style="margin-right:20px;" v-bind:key="index"
                   v-for="(item,index) in (ruleForm.zuoyePhoto || '').split(',')" :src="$base.url+item" width="100"
                   height="100">
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12" v-if="sessionTable !='zuoye' ">
          <el-form-item class="input" v-if="type!='info'" label="作业类型" prop="zuoyeValue">
            <el-input v-model="zuoyeForm.zuoyeValue"
                      placeholder="作业类型" clearable readonly></el-input>
          </el-form-item>
          <div v-else-if="type=='info'">
            <el-form-item class="input" label="作业类型" prop="zuoyeValue">
              <el-input v-model="ruleForm.zuoyeValue"
                        placeholder="作业类型" readonly></el-input>
            </el-form-item>
          </div>
        </el-col>
        <input id="updateId" name="id" type="hidden">
        <el-col :span="12">
          <el-form-item class="input" v-if="type!='info'" label="报名唯一编号" prop="zuoyeTijiaoUuidNumber">
            <el-input v-model="ruleForm.zuoyeTijiaoUuidNumber"
                      placeholder="报名唯一编号" clearable :readonly="ro.zuoyeTijiaoUuidNumber"></el-input>
          </el-form-item>
          <div v-else-if="type=='info'">
            <el-form-item class="input" label="报名唯一编号" prop="zuoyeTijiaoUuidNumber">
              <el-input v-model="ruleForm.zuoyeTijiaoUuidNumber"
                        placeholder="报名唯一编号" readonly></el-input>
            </el-form-item>
          </div>
        </el-col>
        <input id="zuoyeId" name="zuoyeId" type="hidden">
        <input id="gongsiId" name="gongsiId" type="hidden">
        <input id="yonghuId" name="yonghuId" type="hidden">
        <el-col :span="24">
          <el-form-item v-if="type!='info'" label="内容" prop="zuoyeTijiaoText">
            <el-input type="textarea" :readonly="ro.zuoyeTijiaoText" v-model="ruleForm.zuoyeTijiaoText"
                      placeholder="内容"></el-input>
          </el-form-item>
          <div v-else-if="type=='info'">
            <el-form-item v-if="ruleForm.zuoyeTijiaoText" label="内容" prop="zuoyeTijiaoText">
              <span v-html="ruleForm.zuoyeTijiaoText"></span>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12">
          <el-form-item class="upload" v-if="type!='info' && !ro.zuoyeShangchuanFile" label="作业上传"
                        prop="zuoyeShangchuanFile">
            <file-upload
                tip="点击上传作业上传"
                action="file/upload"
                :limit="3"
                :multiple="true"
                :fileUrls="ruleForm.zuoyeShangchuanFile?$base.url+ruleForm.zuoyeShangchuanFile:''"
                @change="zuoyeShangchuanFileUploadChange"
            ></file-upload>
          </el-form-item>
          <div v-else>
            <el-form-item v-if="ruleForm.zuoyeShangchuanFile" label="作业上传" prop="zuoyeShangchuanFile">
              <a type="text" style="text-decoration:none" class="el-button"
                 :href="$base.url+ruleForm.zuoyeShangchuanFile">作业上传下载</a>
            </el-form-item>
          </div>
        </el-col>
<!--        <el-col :span="12" v-if="type=='info'">-->
<!--          <div>-->
<!--            <el-form-item v-if="ruleForm.zuoyeTijiaoYesnoTypes" label="提交状态" prop="zuoyeTijiaoYesnoTypes">-->
<!--              <el-input v-model="ruleForm.zuoyeTijiaoYesnoValue" placeholder="提交状态" readonly></el-input>-->
<!--            </el-form-item>-->
<!--          </div>-->
<!--        </el-col>-->
<!--        <el-col :span="12">-->
<!--          <el-form-item class="input" v-if="type!='info'" label="批改分数" prop="zuoyeTijiaoPigai">-->
<!--            <el-input v-model="ruleForm.zuoyeTijiaoPigai"-->
<!--                      placeholder="批改分数" clearable :readonly="ro.zuoyeTijiaoPigai"></el-input>-->
<!--          </el-form-item>-->
<!--          <div v-else-if="type=='info'">-->
<!--            <el-form-item class="input" label="批改分数" prop="zuoyeTijiaoPigai">-->
<!--              <el-input v-model="ruleForm.zuoyeTijiaoPigai"-->
<!--                        placeholder="批改分数" readonly></el-input>-->
<!--            </el-form-item>-->
<!--          </div>-->
<!--        </el-col>-->
      </el-row>
      <el-form-item class="btn">
        <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import styleJs from "../../../utils/style.js";
// 数字，邮件，手机，url，身份证校验
import {isNumber, isIntNumer, isEmail, isPhone, isMobile, isURL, checkIdCard} from "@/utils/validate";
import utilsJs, {getYearFormat, getMonthFormat, getDateFormat, getDatetimeFormat} from "../../../utils/utils.js";

export default {
  data() {
    return {
      addEditForm: null,
      id: '',
      type: '',
      sessionTable: "",//登录账户所在表名
      role: "",//权限
      userId: "",//当前登录人的id
      gongsiForm: {},
      yonghuForm: {},
      zuoyeForm: {},
      ro: {
        zuoyeTijiaoUuidNumber: true,
        zuoyeId: false,
        gongsiId: false,
        yonghuId: false,
        zuoyeTijiaoText: false,
        zuoyeShangchuanFile: false,
        zuoyeTijiaoYesnoTypes: false,
        zuoyeTijiaoPigai: false,
        insertTime: false,
      },
      ruleForm: {
        zuoyeTijiaoUuidNumber: new Date().getTime(),
        zuoyeId: '',
        gongsiId: '',
        yonghuId: '',
        zuoyeTijiaoText: '',
        zuoyeShangchuanFile: '',
        zuoyeTijiaoYesnoTypes: '',
        zuoyeTijiaoPigai: '',
        insertTime: '',
      },
      zuoyeTijiaoYesnoTypesOptions: [],
      gongsiOptions: [],
      yonghuOptions: [],
      zuoyeOptions: [],
      rules: {
        zuoyeTijiaoUuidNumber: [
          {required: true, message: '报名唯一编号不能为空', trigger: 'blur'},
        ],
        zuoyeId: [
          {required: true, message: '作业不能为空', trigger: 'blur'},
          {
            pattern: /^[0-9]*$/,
            message: '只允许输入整数',
            trigger: 'blur'
          }
        ],
        gongsiId: [
          {required: true, message: '老师不能为空', trigger: 'blur'},
          {
            pattern: /^[0-9]*$/,
            message: '只允许输入整数',
            trigger: 'blur'
          }
        ],
        yonghuId: [
          {required: true, message: '学生不能为空', trigger: 'blur'},
          {
            pattern: /^[0-9]*$/,
            message: '只允许输入整数',
            trigger: 'blur'
          }
        ],
        zuoyeTijiaoText: [
          {required: true, message: '内容不能为空', trigger: 'blur'},
        ],
        zuoyeShangchuanFile: [
          {required: true, message: '作业上传不能为空', trigger: 'blur'},
        ],
        // zuoyeTijiaoYesnoTypes: [
        //   {required: true, message: '提交状态不能为空', trigger: 'blur'},
        //   {
        //     pattern: /^[0-9]*$/,
        //     message: '只允许输入整数',
        //     trigger: 'blur'
        //   }
        // ],
        // zuoyeTijiaoPigai: [
        //   {required: true, message: '批改分数不能为空', trigger: 'blur'},
        //   {
        //     pattern: /^[0-9]*$/,
        //     message: '只允许输入整数',
        //     trigger: 'blur'
        //   }
        // ],
        // insertTime: [
        //   {required: true, message: '作业提交时间不能为空', trigger: 'blur'},
        // ],
      }
    };
  },
  props: ["parent"],
  computed: {},
  created() {
    //获取当前登录学生的信息
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    this.userId = this.$storage.get("userId");


    if (this.role != "管理员") {
    } else {
    }
    this.addEditForm = styleJs.addStyle();
    this.addEditStyleChange()
    this.addEditUploadStyleChange()
    //获取下拉框信息
    this.$http({
      url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=zuoye_tijiao_yesno_types`,
      method: "get"
    }).then(({data}) => {
      if (data && data.code === 0) {
        this.zuoyeTijiaoYesnoTypesOptions = data.data.list;
      }
    });

    this.$http({
      url: `gongsi/page?page=1&limit=100`,
      method: "get"
    }).then(({data}) => {
      if (data && data.code === 0) {
        this.gongsiOptions = data.data.list;
      }
    });
    this.$http({
      url: `yonghu/page?page=1&limit=100`,
      method: "get"
    }).then(({data}) => {
      if (data && data.code === 0) {
        this.yonghuOptions = data.data.list;
      }
    });
    this.$http({
      url: `zuoye/page?page=1&limit=100`,
      method: "get"
    }).then(({data}) => {
      if (data && data.code === 0) {
        this.zuoyeOptions = data.data.list;
      }
    });

  },
  mounted() {
  },
  methods: {
    // 下载
    download(file) {
      window.open(`${file}`)
    },
    // 初始化
    init(id, type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if (this.type == 'info' || this.type == 'else') {
        this.info(id);
      }
      // 获取学生信息
      this.$http({
        url: `${this.$storage.get("sessionTable")}/session`,
        method: "get"
      }).then(({data}) => {
        if (data && data.code === 0) {
          var json = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });
    },
    gongsiChange(id) {
      this.$http({
        url: `gongsi/info/` + id,
        method: "get"
      }).then(({data}) => {
        if (data && data.code === 0) {
          this.gongsiForm = data.data;
        }
      });
    },
    yonghuChange(id) {
      this.$http({
        url: `yonghu/info/` + id,
        method: "get"
      }).then(({data}) => {
        if (data && data.code === 0) {
          this.yonghuForm = data.data;
        }
      });
    },
    zuoyeChange(id) {
      this.$http({
        url: `zuoye/info/` + id,
        method: "get"
      }).then(({data}) => {
        if (data && data.code === 0) {
          this.zuoyeForm = data.data;
        }
      });
    },
    // 多级联动参数
    info(id) {
      let _this = this;
      _this.$http({
        url: `zuoyeTijiao/info/${id}`,
        method: 'get'
      }).then(({data}) => {
        if (data && data.code === 0) {
          _this.ruleForm = data.data;
          _this.gongsiChange(data.data.gongsiId)
          _this.yonghuChange(data.data.yonghuId)
          _this.zuoyeChange(data.data.zuoyeId)
        } else {
          _this.$message.error(data.msg);
        }
      });
    },
    // 提交
    onSubmit() {
      this.ruleForm.zuoyeTijiaoYesnoTypes=1
      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `zuoyeTijiao/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.zuoyeTijiaoCrossAddOrUpdateFlag = false;
                  this.parent.search();
                  this.parent.contentStyleChange();
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },
    // 获取uuid
    getUUID() {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.zuoyeTijiaoCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    //图片
    zuoyeShangchuanFileUploadChange(fileUrls) {
      this.ruleForm.zuoyeShangchuanFile = fileUrls;
      this.addEditUploadStyleChange()
    },

    addEditStyleChange() {
      this.$nextTick(() => {
        // input
        document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el => {
          el.style.height = this.addEditForm.inputHeight
          el.style.color = this.addEditForm.inputFontColor
          el.style.fontSize = this.addEditForm.inputFontSize
          el.style.borderWidth = this.addEditForm.inputBorderWidth
          el.style.borderStyle = this.addEditForm.inputBorderStyle
          el.style.borderColor = this.addEditForm.inputBorderColor
          el.style.borderRadius = this.addEditForm.inputBorderRadius
          el.style.backgroundColor = this.addEditForm.inputBgColor
        })
        document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el => {
          el.style.lineHeight = this.addEditForm.inputHeight
          el.style.color = this.addEditForm.inputLableColor
          el.style.fontSize = this.addEditForm.inputLableFontSize
        })
        // select
        document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el => {
          el.style.height = this.addEditForm.selectHeight
          el.style.color = this.addEditForm.selectFontColor
          el.style.fontSize = this.addEditForm.selectFontSize
          el.style.borderWidth = this.addEditForm.selectBorderWidth
          el.style.borderStyle = this.addEditForm.selectBorderStyle
          el.style.borderColor = this.addEditForm.selectBorderColor
          el.style.borderRadius = this.addEditForm.selectBorderRadius
          el.style.backgroundColor = this.addEditForm.selectBgColor
        })
        document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el => {
          el.style.lineHeight = this.addEditForm.selectHeight
          el.style.color = this.addEditForm.selectLableColor
          el.style.fontSize = this.addEditForm.selectLableFontSize
        })
        document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el => {
          el.style.color = this.addEditForm.selectIconFontColor
          el.style.fontSize = this.addEditForm.selectIconFontSize
        })
        // date
        document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el => {
          el.style.height = this.addEditForm.dateHeight
          el.style.color = this.addEditForm.dateFontColor
          el.style.fontSize = this.addEditForm.dateFontSize
          el.style.borderWidth = this.addEditForm.dateBorderWidth
          el.style.borderStyle = this.addEditForm.dateBorderStyle
          el.style.borderColor = this.addEditForm.dateBorderColor
          el.style.borderRadius = this.addEditForm.dateBorderRadius
          el.style.backgroundColor = this.addEditForm.dateBgColor
        })
        document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el => {
          el.style.lineHeight = this.addEditForm.dateHeight
          el.style.color = this.addEditForm.dateLableColor
          el.style.fontSize = this.addEditForm.dateLableFontSize
        })
        document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el => {
          el.style.color = this.addEditForm.dateIconFontColor
          el.style.fontSize = this.addEditForm.dateIconFontSize
          el.style.lineHeight = this.addEditForm.dateHeight
        })
        // upload
        let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
        document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el => {
          el.style.width = this.addEditForm.uploadHeight
          el.style.height = this.addEditForm.uploadHeight
          el.style.borderWidth = this.addEditForm.uploadBorderWidth
          el.style.borderStyle = this.addEditForm.uploadBorderStyle
          el.style.borderColor = this.addEditForm.uploadBorderColor
          el.style.borderRadius = this.addEditForm.uploadBorderRadius
          el.style.backgroundColor = this.addEditForm.uploadBgColor
        })
        document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el => {
          el.style.lineHeight = this.addEditForm.uploadHeight
          el.style.color = this.addEditForm.uploadLableColor
          el.style.fontSize = this.addEditForm.uploadLableFontSize
        })
        document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el => {
          el.style.color = this.addEditForm.uploadIconFontColor
          el.style.fontSize = this.addEditForm.uploadIconFontSize
          el.style.lineHeight = iconLineHeight
          el.style.display = 'block'
        })
        // 多文本输入框
        document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el => {
          el.style.height = this.addEditForm.textareaHeight
          el.style.color = this.addEditForm.textareaFontColor
          el.style.fontSize = this.addEditForm.textareaFontSize
          el.style.borderWidth = this.addEditForm.textareaBorderWidth
          el.style.borderStyle = this.addEditForm.textareaBorderStyle
          el.style.borderColor = this.addEditForm.textareaBorderColor
          el.style.borderRadius = this.addEditForm.textareaBorderRadius
          el.style.backgroundColor = this.addEditForm.textareaBgColor
        })
        document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el => {
          // el.style.lineHeight = this.addEditForm.textareaHeight
          el.style.color = this.addEditForm.textareaLableColor
          el.style.fontSize = this.addEditForm.textareaLableFontSize
        })
        // 保存
        document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el => {
          el.style.width = this.addEditForm.btnSaveWidth
          el.style.height = this.addEditForm.btnSaveHeight
          el.style.color = this.addEditForm.btnSaveFontColor
          el.style.fontSize = this.addEditForm.btnSaveFontSize
          el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
          el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
          el.style.borderColor = this.addEditForm.btnSaveBorderColor
          el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
          el.style.backgroundColor = this.addEditForm.btnSaveBgColor
        })
        // 返回
        document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el => {
          el.style.width = this.addEditForm.btnCancelWidth
          el.style.height = this.addEditForm.btnCancelHeight
          el.style.color = this.addEditForm.btnCancelFontColor
          el.style.fontSize = this.addEditForm.btnCancelFontSize
          el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
          el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
          el.style.borderColor = this.addEditForm.btnCancelBorderColor
          el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
          el.style.backgroundColor = this.addEditForm.btnCancelBgColor
        })
      })
    },
    addEditUploadStyleChange() {
      this.$nextTick(() => {
        document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el => {
          el.style.width = this.addEditForm.uploadHeight
          el.style.height = this.addEditForm.uploadHeight
          el.style.borderWidth = this.addEditForm.uploadBorderWidth
          el.style.borderStyle = this.addEditForm.uploadBorderStyle
          el.style.borderColor = this.addEditForm.uploadBorderColor
          el.style.borderRadius = this.addEditForm.uploadBorderRadius
          el.style.backgroundColor = this.addEditForm.uploadBgColor
        })
      })
    },
  }
};
</script>
<style lang="scss">
.editor {
  height: 500px;

  & /deep/ .ql-container {
    height: 310px;
  }
}

.amap-wrapper {
  width: 100%;
  height: 500px;
}

.search-box {
  position: absolute;
}

.addEdit-block {
  margin: -10px;
}

.detail-form-content {
  padding: 12px;
  background-color: transparent;
}

.btn .el-button {
  padding: 0;
}</style>

