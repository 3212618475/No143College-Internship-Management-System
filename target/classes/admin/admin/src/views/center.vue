<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="auto"
    >  
     <el-row>
                    <el-col :span="12">
           <el-form-item v-if="flag=='gongsi'"  label='公司名称' prop="gongsiName">
               <el-input v-model="ruleForm.gongsiName"  placeholder='公司名称' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='gongsi'"  label='公司类型' prop="gongsiTypes">
                 <el-select v-model="ruleForm.gongsiTypes"  placeholder='请选择公司类型'>
                     <el-option
                             v-for="(item,index) in gongsiTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='gongsi'"  label='联系方式' prop="gongsiPhone">
               <el-input v-model="ruleForm.gongsiPhone"  placeholder='联系方式' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='gongsi'"  label='邮箱' prop="gongsiEmail">
               <el-input v-model="ruleForm.gongsiEmail"  placeholder='邮箱' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='gongsi'" label='公司封面' prop="gongsiPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.gongsiPhoto?$base.url+ruleForm.gongsiPhoto:''"
                         @change="gongsiPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item v-if="flag=='gongsi'"  label="公司简介" prop="gongsiContent">
                 <editor
                         style="min-width: 200px; max-width: 600px;"
                         v-model="ruleForm.gongsiContent"
                         class="editor"
                         action="file/upload">
                 </editor>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='laoshi'"  label='老师姓名' prop="laoshiName">
               <el-input v-model="ruleForm.laoshiName"  placeholder='老师姓名' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='laoshi'"  label='老师手机号' prop="laoshiPhone">
               <el-input v-model="ruleForm.laoshiPhone"  placeholder='老师手机号' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='laoshi'"  label='老师身份证号' prop="laoshiIdNumber">
               <el-input v-model="ruleForm.laoshiIdNumber"  placeholder='老师身份证号' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='laoshi'" label='老师头像' prop="laoshiPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.laoshiPhoto?$base.url+ruleForm.laoshiPhoto:''"
                         @change="laoshiPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='laoshi'"  label='电子邮箱' prop="laoshiEmail">
               <el-input v-model="ruleForm.laoshiEmail"  placeholder='电子邮箱' clearable></el-input>
           </el-form-item>
         </el-col>
        <!--<el-col :span="12" v-if="flag=='yonghu'">
            <el-form-item class="select" label="院系" prop="yuanxiId">
                <el-select v-model="ruleForm.yuanxiId" filterable placeholder="请选择院系" @change="yuanxiChange">
                    <el-option
                            v-for="(item,index) in yuanxiOptions"
                            v-bind:key="item.id"
                                            :label="item.yuanxiName"
                            :value="item.id">
                    </el-option>
                </el-select>
            </el-form-item>
        </el-col>-->
         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'" label='院系编号' prop="yuanxiUuidNumber">
                 <el-input v-model="yuanxiForm.yuanxiUuidNumber" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'" label='院系名称' prop="yuanxiName">
                 <el-input v-model="yuanxiForm.yuanxiName" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'" label='院系位置' prop="yuanxiAddress">
                 <el-input v-model="yuanxiForm.yuanxiAddress" disabled></el-input>
             </el-form-item>
         </el-col>
        <!--<el-col :span="12" v-if="flag=='yonghu'">
            <el-form-item class="select" label="班级" prop="banjiId">
                <el-select v-model="ruleForm.banjiId" filterable placeholder="请选择班级" @change="banjiChange">
                    <el-option
                            v-for="(item,index) in banjiOptions"
                            v-bind:key="item.id"
                                            :label="item.banjiName"
                            :value="item.id">
                    </el-option>
                </el-select>
            </el-form-item>
        </el-col>-->
         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'" label='班级编号' prop="banjiUuidNumber">
                 <el-input v-model="banjiForm.banjiUuidNumber" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'" label='班级名称' prop="banjiName">
                 <el-input v-model="banjiForm.banjiName" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'" label='班级位置' prop="banjiAddress">
                 <el-input v-model="banjiForm.banjiAddress" disabled></el-input>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='学生姓名' prop="yonghuName">
               <el-input v-model="ruleForm.yonghuName"  placeholder='学生姓名' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='学生手机号' prop="yonghuPhone">
               <el-input v-model="ruleForm.yonghuPhone"  placeholder='学生手机号' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='学生身份证号' prop="yonghuIdNumber">
               <el-input v-model="ruleForm.yonghuIdNumber"  placeholder='学生身份证号' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'" label='学生头像' prop="yonghuPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.yonghuPhoto?$base.url+ruleForm.yonghuPhoto:''"
                         @change="yonghuPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='电子邮箱' prop="yonghuEmail">
               <el-input v-model="ruleForm.yonghuEmail"  placeholder='电子邮箱' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-form-item v-if="flag=='users'" label="学生名" prop="username">
             <el-input v-model="ruleForm.username"
                       placeholder="学生名"></el-input>
         </el-form-item>
         <el-col :span="12">
             <el-form-item v-if="flag!='users' &&( 1==2|| flag=='yonghu'
|| flag=='laoshi')"  label="性别" prop="sexTypes">
                 <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
                     <el-option
                             v-for="(item,index) in sexTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item>
                 <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
             </el-form-item>
         </el-col>
     </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
        ruleForm: {},
        flag: '',
        usersFlag: false,
        // sexTypesOptions : [],
// 注册表 学生
    // 注册的类型字段 学生
        // 性别
        sexTypesOptions : [],
    // 注册的级联表 学生
        // 院系列表
        yuanxiOptions : [],
        yuanxiForm:{},
        // 班级列表
        banjiOptions : [],
        banjiForm:{},
// 注册表 公司
    // 注册的类型字段 公司
        // 公司类型
        gongsiTypesOptions : [],
// 注册表 老师
    // 注册的类型字段 老师
        // 性别
        sexTypesOptions : [],
    };
  },
  mounted() {
    //获取当前登录学生的信息
    var table = this.$storage.get("sessionTable");
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    if (this.role != "管理员"){
    }

    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
// 注册表 学生
    // 注册的级联表 学生
        if(table == 'yonghu'){
            this.yuanxiChange(this.ruleForm.yuanxiId);
        }
        if(table == 'yonghu'){
            this.banjiChange(this.ruleForm.banjiId);
        }
// 注册表 公司
// 注册表 老师
      } else {
        this.$message.error(data.msg);
      }
    });

// 注册表 学生 的级联表
    // 注册的级联表 学生
        // 院系列表
    this.$http({
        url: `yuanxi/page?page=1&limit=100`,
        method: "get"
    }).then(({ data }) => {
        if (data && data.code === 0) {
        this.yuanxiOptions = data.data.list;
        }else{
            this.$message.error(data.msg);
        }
    });
        // 班级列表
    this.$http({
        url: `banji/page?page=1&limit=100`,
        method: "get"
    }).then(({ data }) => {
        if (data && data.code === 0) {
        this.banjiOptions = data.data.list;
        }else{
            this.$message.error(data.msg);
        }
    });
// 注册表 公司 的级联表
// 注册表 老师 的级联表

      this.$http({
          url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
          method: "get"
      }).then(({ data }) => {
          if (data && data.code === 0) {
              this.sexTypesOptions = data.data.list;
          } else {
              this.$message.error(data.msg);
          }
      });
   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=gongsi_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.gongsiTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });
  },
  methods: {
    chongzhi() {
      this.$router.replace({ path: "/pay" });
    },
    tixian() {
      let _this=this;
      this.$confirm(`确定要提现么?`, "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
      }).then(() => {
          _this.ruleForm.newMoney=0;
          _this.$http({
              url: `${this.$storage.get("sessionTable")}/update`,
              method: "post",
              data: this.ruleForm
          }).then(({ data }) => {
              if (data && data.code === 0) {
                  _this.$message({message: "提现成功",type: "success",duration: 1500,onClose: () => {}});
              } else {this.$message.error(data.msg);}
          });
      });
    },
    gongsiPhotoUploadChange(fileUrls) {
        this.ruleForm.gongsiPhoto = fileUrls;
    },
    laoshiPhotoUploadChange(fileUrls) {
        this.ruleForm.laoshiPhoto = fileUrls;
    },
    yonghuPhotoUploadChange(fileUrls) {
        this.ruleForm.yonghuPhoto = fileUrls;
    },
// 注册表的级联表
    yuanxiChange(id){
        this.$http({
            url: `yuanxi/info/`+id,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code === 0) {
                this.yuanxiForm = data.data;
            }
        });
    },
    banjiChange(id){
        this.$http({
            url: `banji/info/`+id,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code === 0) {
                this.banjiForm = data.data;
            }
        });
    },


    onUpdateHandler() {
                         if((!this.ruleForm.gongsiName)&& 'gongsi'==this.flag){
                             this.$message.error('公司名称不能为空');
                             return
                         }

                         if((!this.ruleForm.gongsiTypes)&& 'gongsi'==this.flag){
                             this.$message.error('公司类型不能为空');
                             return
                         }

                         if((!this.ruleForm.gongsiPhone)&& 'gongsi'==this.flag){
                             this.$message.error('联系方式不能为空');
                             return
                         }

                             if( 'gongsi' ==this.flag && this.ruleForm.gongsiEmail&&(!isEmail(this.ruleForm.gongsiEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.gongsiPhoto)&& 'gongsi'==this.flag){
                             this.$message.error('公司封面不能为空');
                             return
                         }

                         if((!this.ruleForm.gongsiContent)&& 'gongsi'==this.flag){
                             this.$message.error('公司简介不能为空');
                             return
                         }

                         if((!this.ruleForm.laoshiName)&& 'laoshi'==this.flag){
                             this.$message.error('老师姓名不能为空');
                             return
                         }

                             if( 'laoshi' ==this.flag && this.ruleForm.laoshiPhone&&(!isMobile(this.ruleForm.laoshiPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.laoshiIdNumber)&& 'laoshi'==this.flag){
                             this.$message.error('老师身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.laoshiPhoto)&& 'laoshi'==this.flag){
                             this.$message.error('老师头像不能为空');
                             return
                         }

                             if( 'laoshi' ==this.flag && this.ruleForm.laoshiEmail&&(!isEmail(this.ruleForm.laoshiEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.yuanxiId)&& 'yonghu'==this.flag){
                             this.$message.error('院系不能为空');
                             return
                         }

                         if((!this.ruleForm.banjiId)&& 'yonghu'==this.flag){
                             this.$message.error('班级不能为空');
                             return
                         }

                         if((!this.ruleForm.yonghuName)&& 'yonghu'==this.flag){
                             this.$message.error('学生姓名不能为空');
                             return
                         }

                             if( 'yonghu' ==this.flag && this.ruleForm.yonghuPhone&&(!isMobile(this.ruleForm.yonghuPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.yonghuIdNumber)&& 'yonghu'==this.flag){
                             this.$message.error('学生身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.yonghuPhoto)&& 'yonghu'==this.flag){
                             this.$message.error('学生头像不能为空');
                             return
                         }

                             if( 'yonghu' ==this.flag && this.ruleForm.yonghuEmail&&(!isEmail(this.ruleForm.yonghuEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
        if((!this.ruleForm.sexTypes) && (1==2|| this.flag=='yonghu'
|| this.flag=='laoshi')){
            this.$message.error('性别不能为空');
            return
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
        this.$message.error(`学生名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
