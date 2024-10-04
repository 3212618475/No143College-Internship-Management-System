<template>
    <div>
        <div class="container">
            <div class="login-form">
                <h1 class="h1" style="color:#000;fontSize:28px;">高校实习管理系统注册</h1>
                <el-form class="rgs-form">
                    <el-form-item label="账号" class="input">
                        <el-input v-model="ruleForm.username" autocomplete="off" placeholder="账号"  />
                    </el-form-item>
                    <el-form-item label="密码" class="input">
                        <el-input type="password" v-model="ruleForm.password" autocomplete="off" show-password/>
                    </el-form-item>
                    <el-form-item label="重复密码" class="input">
                        <el-input type="passwo   rd" v-model="ruleForm.repetitionPassword" autocomplete="off" show-password/>
                    </el-form-item>
                        <el-form-item label="公司名称" class="input" v-if="tableName=='gongsi'">
                            <el-input v-model="ruleForm.gongsiName" autocomplete="off" placeholder="公司名称"  />
                        </el-form-item>
                        <!--
                            <el-form-item label="公司类型" class="input" v-if="tableName=='gongsi'">
                                <el-input v-model="ruleForm.gongsiTypes" autocomplete="off" placeholder="公司类型"  />
                           </el-form-item>
                        -->
                        <el-form-item label="联系方式" class="input" v-if="tableName=='gongsi'">
                            <el-input v-model="ruleForm.gongsiPhone" autocomplete="off" placeholder="联系方式"  />
                        </el-form-item>
                        <el-form-item label="邮箱" class="input" v-if="tableName=='gongsi'">
                            <el-input v-model="ruleForm.gongsiEmail" autocomplete="off" placeholder="邮箱"  />
                        </el-form-item>
                        <!--
                            <el-form-item v-if="gongsiPhotoFlag">
                            </el-form-item>
                            <el-form-item label="公司封面" class="input" v-if="tableName=='gongsi'">
                                    <file-upload
                                        tip="点击上传公司封面"
                                        action="file/upload"
                                        :limit="1"
                                        :multiple="true"
                                        :fileUrls="ruleForm.gongsiPhoto?$base.url+ruleForm.gongsiPhoto:''"
                                        @change="gongsiPhotoUploadChange"
                                    ></file-upload>
                           </el-form-item>
                        -->
                        <!--
                            <el-form-item label="公司简介" class="input" v-if="tableName=='gongsi'">
                                <el-input type="textarea" v-model="ruleForm.gongsiContent" placeholder="公司简介"></el-input>
                           </el-form-item>
                        -->
                        <!--
                            <el-form-item label="逻辑删除" class="input" v-if="tableName=='gongsi'">
                                <el-input v-model="ruleForm.gongsiDelete" autocomplete="off" placeholder="逻辑删除"  />
                           </el-form-item>
                        -->
                        <!--
                            <el-form-item label="创建时间 show1 show2 photoShow" class="input" v-if="tableName=='gongsi'">
                                <el-input v-model="ruleForm.createTime" autocomplete="off" placeholder="创建时间 show1 show2 photoShow"  />
                           </el-form-item>
                        -->
                        <el-form-item label="老师姓名" class="input" v-if="tableName=='laoshi'">
                            <el-input v-model="ruleForm.laoshiName" autocomplete="off" placeholder="老师姓名"  />
                        </el-form-item>
                        <el-form-item label="老师手机号" class="input" v-if="tableName=='laoshi'">
                            <el-input v-model="ruleForm.laoshiPhone" autocomplete="off" placeholder="老师手机号"  />
                        </el-form-item>
                        <el-form-item label="老师身份证号" class="input" v-if="tableName=='laoshi'">
                            <el-input v-model="ruleForm.laoshiIdNumber" autocomplete="off" placeholder="老师身份证号"  />
                        </el-form-item>
                        <!--
                            <el-form-item v-if="laoshiPhotoFlag">
                            </el-form-item>
                            <el-form-item label="老师头像" class="input" v-if="tableName=='laoshi'">
                                    <file-upload
                                        tip="点击上传老师头像"
                                        action="file/upload"
                                        :limit="1"
                                        :multiple="true"
                                        :fileUrls="ruleForm.laoshiPhoto?$base.url+ruleForm.laoshiPhoto:''"
                                        @change="laoshiPhotoUploadChange"
                                    ></file-upload>
                           </el-form-item>
                        -->
                        <el-form-item label="电子邮箱" class="input" v-if="tableName=='laoshi'">
                            <el-input v-model="ruleForm.laoshiEmail" autocomplete="off" placeholder="电子邮箱"  />
                        </el-form-item>
                        <!--
                            <el-form-item label="创建时间" class="input" v-if="tableName=='laoshi'">
                                <el-input v-model="ruleForm.createTime" autocomplete="off" placeholder="创建时间"  />
                           </el-form-item>
                        -->
                       <!--<el-form-item class="select" label="院系">
                            <el-select style="width: 399px;height: 40px;" v-model="ruleForm.yuanxiId" placeholder="请选择院系">
                                <el-option
                                        v-for="(item,index) in yuanxiOptions"
                                        v-bind:key="item.id"
                                        :label="item.yuanxiName"
                                        :value="item.id">
                                </el-option>
                            </el-select>
                        </el-form-item>-->
                       <!--<el-form-item class="select" label="班级">
                            <el-select style="width: 399px;height: 40px;" v-model="ruleForm.banjiId" placeholder="请选择班级">
                                <el-option
                                        v-for="(item,index) in banjiOptions"
                                        v-bind:key="item.id"
                                        :label="item.banjiName"
                                        :value="item.id">
                                </el-option>
                            </el-select>
                        </el-form-item>-->
                        <el-form-item label="学生姓名" class="input" v-if="tableName=='yonghu'">
                            <el-input v-model="ruleForm.yonghuName" autocomplete="off" placeholder="学生姓名"  />
                        </el-form-item>
                        <el-form-item label="学生手机号" class="input" v-if="tableName=='yonghu'">
                            <el-input v-model="ruleForm.yonghuPhone" autocomplete="off" placeholder="学生手机号"  />
                        </el-form-item>
                        <el-form-item label="学生身份证号" class="input" v-if="tableName=='yonghu'">
                            <el-input v-model="ruleForm.yonghuIdNumber" autocomplete="off" placeholder="学生身份证号"  />
                        </el-form-item>
                        <!--
                            <el-form-item v-if="yonghuPhotoFlag">
                            </el-form-item>
                            <el-form-item label="学生头像" class="input" v-if="tableName=='yonghu'">
                                    <file-upload
                                        tip="点击上传学生头像"
                                        action="file/upload"
                                        :limit="1"
                                        :multiple="true"
                                        :fileUrls="ruleForm.yonghuPhoto?$base.url+ruleForm.yonghuPhoto:''"
                                        @change="yonghuPhotoUploadChange"
                                    ></file-upload>
                           </el-form-item>
                        -->
                        <el-form-item label="电子邮箱" class="input" v-if="tableName=='yonghu'">
                            <el-input v-model="ruleForm.yonghuEmail" autocomplete="off" placeholder="电子邮箱"  />
                        </el-form-item>
                        <!--
                            <el-form-item label="创建时间" class="input" v-if="tableName=='yonghu'">
                                <el-input v-model="ruleForm.createTime" autocomplete="off" placeholder="创建时间"  />
                           </el-form-item>
                        -->
                    <div style="display: flex;flex-wrap: wrap;width: 100%;justify-content: center;">
                        <el-button class="btn" type="primary" @click="login()">注册</el-button>
                        <el-button class="btn close" type="primary" @click="close()">取消</el-button>
                    </div>
                </el-form>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                ruleForm: {
                },
                tableName:"",
                rules: {},
                sexTypesOptions : [],
                yuanxiOptions : [],
                banjiOptions : [],
                gongsiPhotoFlag:false,//用于刷新文件上传
                laoshiPhotoFlag:false,//用于刷新文件上传
                yonghuPhotoFlag:false,//用于刷新文件上传
            };
        },
        mounted(){
            let table = this.$storage.get("loginTable");
            this.tableName = table;

            //级联表的下拉框查询

            this.$http({
                url: `yuanxi/page?page=1&limit=100`,
                method: "get"
            }).then(({ data }) => {
                if (data && data.code === 0) {
                    this.yuanxiOptions = data.data.list;
                }else {
                    alert(data.msg);
                }
            });

            this.$http({
                url: `banji/page?page=1&limit=100`,
                method: "get"
            }).then(({ data }) => {
                if (data && data.code === 0) {
                    this.banjiOptions = data.data.list;
                }else {
                    alert(data.msg);
                }
            });

        },
        methods: {
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            gongsiPhotoUploadChange(fileUrls) {
               this.ruleForm.gongsiPhoto = fileUrls;
                if(this.gongsiPhotoFlag){
                    this.gongsiPhotoFlag=false;
                }else{
                    this.gongsiPhotoFlag=true;
                }
            },
            laoshiPhotoUploadChange(fileUrls) {
               this.ruleForm.laoshiPhoto = fileUrls;
                if(this.laoshiPhotoFlag){
                    this.laoshiPhotoFlag=false;
                }else{
                    this.laoshiPhotoFlag=true;
                }
            },
            yonghuPhotoUploadChange(fileUrls) {
               this.ruleForm.yonghuPhoto = fileUrls;
                if(this.yonghuPhotoFlag){
                    this.yonghuPhotoFlag=false;
                }else{
                    this.yonghuPhotoFlag=true;
                }
            },
            close(){
                this.$router.push({ path: "/login" });
            },
            // 注册
            login() {

                            if((!this.ruleForm.username)){
                                this.$message.error('账号不能为空');
                                return
                            }
                            if((!this.ruleForm.password)){
                                this.$message.error('密码不能为空');
                                return
                            }
                            if((!this.ruleForm.repetitionPassword)){
                                this.$message.error('重复密码不能为空');
                                return
                            }
                            if(this.ruleForm.repetitionPassword != this.ruleForm.password){
                                this.$message.error('密码和重复密码不一致');
                                return
                            }
                            if((!this.ruleForm.gongsiName)&& 'gongsi'==this.tableName){
                                this.$message.error('公司名称不能为空');
                                return
                            }
                            // gongsi 中的 公司类型 判空处理
                            // if('gongsi' == this.tableName && (this.ruleForm.gongsiTypes== null ||this.ruleForm.gongsiTypes== "")){
                            //     this.$message.error("公司类型不能为空");
                            //     return
                            // }
                             if('gongsi' == this.tableName && this.ruleForm.gongsiPhone&&(!this.$validate.isMobile(this.ruleForm.gongsiPhone))){
                                 this.$message.error('手机应输入手机格式');
                                 return
                             }
                            if('gongsi' == this.tableName && this.ruleForm.gongsiEmail&&(!this.$validate.isEmail(this.ruleForm.gongsiEmail))){
                                this.$message.error("邮箱应输入邮件格式");
                                return
                            }
                            // gongsi 中的 公司封面 判空处理
                            // if('gongsi' == this.tableName && (this.ruleForm.gongsiPhoto== null ||this.ruleForm.gongsiPhoto== "")){
                            //     this.$message.error("公司封面不能为空");
                            //     return
                            // }
                            // gongsi 中的 公司简介 判空处理
                            // if('gongsi' == this.tableName && (this.ruleForm.gongsiContent== null ||this.ruleForm.gongsiContent== "")){
                            //     this.$message.error("公司简介不能为空");
                            //     return
                            // }
                            // gongsi 中的 逻辑删除 判空处理
                            // if('gongsi' == this.tableName && (this.ruleForm.gongsiDelete== null ||this.ruleForm.gongsiDelete== "")){
                            //     this.$message.error("逻辑删除不能为空");
                            //     return
                            // }
                            // gongsi 中的 创建时间 show1 show2 photoShow 判空处理
                            // if('gongsi' == this.tableName && (this.ruleForm.createTime== null ||this.ruleForm.createTime== "")){
                            //     this.$message.error("创建时间 show1 show2 photoShow不能为空");
                            //     return
                            // }
                            if((!this.ruleForm.laoshiName)&& 'laoshi'==this.tableName){
                                this.$message.error('老师姓名不能为空');
                                return
                            }
                             if('laoshi' == this.tableName && this.ruleForm.laoshiPhone&&(!this.$validate.isMobile(this.ruleForm.laoshiPhone))){
                                 this.$message.error('手机应输入手机格式');
                                 return
                             }
                            if((!this.ruleForm.laoshiIdNumber)&& 'laoshi'==this.tableName){
                                this.$message.error('老师身份证号不能为空');
                                return
                            }
                            // laoshi 中的 老师头像 判空处理
                            // if('laoshi' == this.tableName && (this.ruleForm.laoshiPhoto== null ||this.ruleForm.laoshiPhoto== "")){
                            //     this.$message.error("老师头像不能为空");
                            //     return
                            // }
                            if('laoshi' == this.tableName && this.ruleForm.laoshiEmail&&(!this.$validate.isEmail(this.ruleForm.laoshiEmail))){
                                this.$message.error("邮箱应输入邮件格式");
                                return
                            }
                            // laoshi 中的 创建时间 判空处理
                            // if('laoshi' == this.tableName && (this.ruleForm.createTime== null ||this.ruleForm.createTime== "")){
                            //     this.$message.error("创建时间不能为空");
                            //     return
                            // }
                            //// 学生 的 院系
                            // if((!this.ruleForm.yuanxiId)&& 'yonghu'==this.tableName){
                            //     this.$message.error('院系不能为空');
                            //     return
                            // }
                            //// 学生 的 班级
                            // if((!this.ruleForm.banjiId)&& 'yonghu'==this.tableName){
                            //     this.$message.error('班级不能为空');
                            //     return
                            // }
                            if((!this.ruleForm.yonghuName)&& 'yonghu'==this.tableName){
                                this.$message.error('学生姓名不能为空');
                                return
                            }
                             if('yonghu' == this.tableName && this.ruleForm.yonghuPhone&&(!this.$validate.isMobile(this.ruleForm.yonghuPhone))){
                                 this.$message.error('手机应输入手机格式');
                                 return
                             }
                            if((!this.ruleForm.yonghuIdNumber)&& 'yonghu'==this.tableName){
                                this.$message.error('学生身份证号不能为空');
                                return
                            }
                            // yonghu 中的 学生头像 判空处理
                            // if('yonghu' == this.tableName && (this.ruleForm.yonghuPhoto== null ||this.ruleForm.yonghuPhoto== "")){
                            //     this.$message.error("学生头像不能为空");
                            //     return
                            // }
                            if('yonghu' == this.tableName && this.ruleForm.yonghuEmail&&(!this.$validate.isEmail(this.ruleForm.yonghuEmail))){
                                this.$message.error("邮箱应输入邮件格式");
                                return
                            }
                            // yonghu 中的 创建时间 判空处理
                            // if('yonghu' == this.tableName && (this.ruleForm.createTime== null ||this.ruleForm.createTime== "")){
                            //     this.$message.error("创建时间不能为空");
                            //     return
                            // }
                this.$http({
                    url: `${this.tableName}/register`,
                    method: "post",
                    data:this.ruleForm
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                    this.$message({
                        message: "注册成功,请登录后在个人中心页面补充个人数据",
                        type: "success",
                        duration: 1500,
                        onClose: () => {
                        this.$router.replace({ path: "/login" });
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
	.el-radio__input.is-checked .el-radio__inner {
		border-color: #00c292;
		background: #00c292;
	}

	.el-radio__input.is-checked .el-radio__inner {
		border-color: #00c292;
		background: #00c292;
	}

	.el-radio__input.is-checked .el-radio__inner {
		border-color: #00c292;
		background: #00c292;
	}

	.el-radio__input.is-checked+.el-radio__label {
		color: #00c292;
	}

	.el-radio__input.is-checked+.el-radio__label {
		color: #00c292;
	}

	.el-radio__input.is-checked+.el-radio__label {
		color: #00c292;
	}

	.h1 {
		margin-top: 10px;
	}

	body {
		padding: 0;
		margin: 0;
	}


	.nk-navigation {
		margin-top: 15px;

		a {
			display: inline-block;
			color: #fff;
			background: rgba(255, 255, 255, .2);
			width: 100px;
			height: 50px;
			border-radius: 30px;
			text-align: center;
			display: flex;
			align-items: center;
			margin: 0 auto;
			justify-content: center;
			padding: 0 20px;
		}

		.icon {
			margin-left: 10px;
			width: 30px;
			height: 30px;
		}
	}

	.register-container {
		margin-top: 10px;

		a {
			display: inline-block;
			color: #fff;
			max-width: 500px;
			height: 50px;
			border-radius: 30px;
			text-align: center;
			display: flex;
			align-items: center;
			margin: 0 auto;
			justify-content: center;
			padding: 0 20px;

			div {
				margin-left: 10px;
			}
		}
	}

	.container {
		height: 100vh;
		background-position: center center;
		background-size: cover;
		background-repeat: no-repeat;
		background-image: url(/gaoxiaoxueshengshixiguanlixitong/img/back-img-bg.jpg);

		.login-form {
			right: 50%;
			top: 50%;
			transform: translate3d(50%, -50%, 0);
			border-radius: 10px;
			background-color: rgba(255,255,255,.5);
			font-size: 14px;
			font-weight: 500;
      box-sizing: border-box;

			width: 450px;
			height: auto;
			padding: 15px;
			margin: 0 auto;
			border-radius: 0;
			border-width: 5px;
			border-style: solid;
			border-color: var(--publicMainColor);
			background-color: rgba(255, 255, 255, 1);
			box-shadow: 0 0 6px rgba(255,0,0,.1);

			.h1 {
				width: auto;
				height: 54px;
				line-height:54px;
				color: var(--publicMainColor);
				font-size: 28px;
				padding: 0;
				margin: 0 auto 10px;
				border-radius: 0;
				border-width: 0;
				border-style: solid;
				border-color: rgba(255,0,0,0);
				background-color: rgba(255,0,0,0);
				box-shadow: 0 0 6px rgba(255,0,0,0);
				text-align: center;
			}

			.rgs-form {
				display: flex;
				flex-direction: column;
				justify-content: center;
				align-items: center;

        .el-form-item {
          width: 100%;
          display: flex;

          & /deep/ .el-form-item__content {
            flex: 1;
            display: flex;
          }
        }

				.input {
          width: 100%;
          height:auto;
          padding: 0;
          margin: 0 0 12px 0;
          border-radius: 0;
          border-width: 0;
          border-style: solid;
          border-color: rgba(255,0,0,0);
          background-color: rgba(255,0,0,0);
          box-shadow: 0 0 6px rgba(255,0,0,0);

					& /deep/ .el-form-item__label {
            width: 70px;
            line-height:44px;
            color: var(--publicMainColor);
            font-size: 14px;
            padding: 0 10px 0 0;
            margin: 0;
            border-radius: 0;
            border-width: 0;
            border-style: solid;
            border-color: rgba(255,0,0,0);
            background-color: rgba(255,0,0,0);
            box-shadow: 0 0 6px rgba(255,0,0,0);
					}

					& /deep/ .el-input__inner {
            width: 90%;
            height: 44px;
            line-height:44px;
            color: #606266;
            font-size: 14px;
            padding: 0 12px;
            margin: 0;
            border-radius: 4px;
            border-width: 0;
            border-style: solid;
            border-color: #606266;
            background-color: #fff;
            box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.16);
            text-align: left;
					}
				}

        .send-code {
          & /deep/ .el-input__inner {
            width: 180px;
            height: 44px;
            line-height:44px;
            color: #606266;
            font-size: 14px;
            padding: 0 12px;
            margin: 0;
            border-radius: 0;
            border-width: 1;
            border-style: solid;
            border-color: #606266;
            background-color: #fff;
            box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.16);
            text-align: left;
          }

          .register-code {
            margin: 0;
            padding: 0;
            width: 86px;
            height: 44px;
            line-height:44px;
            color: #fff;
            font-size: 14px;
            border-width: 0;
            border-style: solid;
            border-color: rgba(255,0,0,0);
            border-radius:  0 5px 5px 0;
            background-color: var(--publicMainColor);
            box-shadow: 0 0 6px rgba(255,0,0,0);
          }
        }

				.btn {
					margin: 0 10px;
          padding: 0;
					width: 88px;
					height: 44px;
          line-height:44px;
					color: #fff;
					font-size: 14px;
					border-width: 1px;
					border-style: solid;
					border-color: var(--publicMainColor);
					border-radius: 4px;
					background-color: var(--publicMainColor);
          box-shadow: 0 0 6px rgba(255,0,0,0);
				}

				.close {
          margin: 0 10px;
          padding: 0;
          width: 88px;
          height: 44px;
          line-height:44px;
          color: var(--publicMainColor);
          font-size: 14px;
          border-width: 1px;
          border-style: solid;
          border-color: var(--publicMainColor);
          border-radius: 4px;
          background-color: #FFF;
          box-shadow: 0 0 6px rgba(255,0,0,0);
				}

			}
		}
	}
</style>


