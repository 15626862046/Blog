<template>
    <div>
        <div class="about">
            <img class="background" src="../assets/background.jpg" alt="">
            <img class="avatar" src="../assets/avatar.gif" @click="ArticleList" alt="">
            <p class="name">九曜</p>
            <p class="desc">天地者万物之逆旅，光阴者百代之过客</p>
            <ul class="social">
                <el-link href="https://github.com/15626862046">
                <svg  class="icon" aria-hidden="true">
                    <use xlink:href="#icon-github"></use>
                </svg>
                </el-link>
                <el-link  href="https://blog.csdn.net/qq_44961149">
                <svg class="icon" aria-hidden="true">
                <use xlink:href="#icon-csdn"></use>
                </svg>
                </el-link>
                <el-link  href="https://juejin.im/user/5edf78ddf265da76ed486231">
                    <svg class="icon" aria-hidden="true">
                        <use xlink:href="#icon-juejin"></use>
                    </svg>
                </el-link>
            </ul>
            <div class="line"></div>
            <h4>技能值</h4>
            <div class="progresses">Java
                <el-progress :percentage="58" color="#42b983"></el-progress>SpringBoot
                <el-progress :percentage="57" color="#f1e05a"></el-progress>Vue
                <el-progress :percentage="36"></el-progress>Mysql
                <el-progress :percentage="42" color="#f56c6c"></el-progress>
            </div>
        </div>
        <div>
            <br>
            <el-card shadow="hover" class="box-card">
                <div slot="header" class="link">
                    <el-link class="book" type="primary" :underline="false" icon="el-icon-reading" @click="ArticleList()">博文列表</el-link>
                    <el-link class="back" style=" padding: 0;float: right;" type="primary" :underline="false" icon="el-icon-setting" @click="goBack()">后台管理</el-link>
                </div>
                <div v-for="type in types" :key="type.id" class="text item">
                   <el-link style="font-size: Medium" :underline="false" @click="ArticleTypeList(type.id)" >{{type.name}}</el-link>
                </div>
            </el-card>
        </div>
    </div>
</template>

<style lang="scss" scoped>
    .icon {
        width: 2em;
        height: 2em;
        vertical-align: -0.15em;
        fill: currentColor;
        overflow: hidden;
        margin: 0px 10px 0px;
    }
    .about {
        position: relative;
        text-align: center;
        border: 1px solid #eee;
        padding-bottom: 20px;
        img.background {
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            width: 100%;
            height: 125px;
            z-index: 1;
        }
        img.avatar {
            position: relative;
            margin: 75px auto 15px;
            width: 100px;
            height: 100px;
            border: 5px solid #E8E8E8;
            border-radius: 50%;
            z-index: 9;
        }.name {
             font-size: 22px;
             color: #333;
             line-height: 30px;
             font-weight: 700;
         }.desc {
              font-size: 15px;
              color: #878d99;
              line-height: 30px;
              font-weight: 100;
          }.social {
               text-align: center;
               padding: 0 20px;
               margin-top: 15px;> li {
            padding: 8px;
            a {
                display: block;
                width: 44px;
                height: 44px;
                margin: auto;
                img {
                    width: 100%;
                }
            }
        }
           }.line {
                height: 1px;
                background-color: #E8E8E8;
                margin: 10px 20px;
            }
        h4 {
            font-size: 19px;
            margin: 30px 0 20px;
            font-weight: 600;
        }.progresses {
             padding: 0 20px;
             p.title {
                 height: 38px;
                 line-height: 38px;
                 text-align: right;
             }.bar {
                  margin: 10px 0;
              }
         }
    }
</style>


<script>
    import {goBack} from "../api/index";
    import {typeList} from "../api/index";

    export default {
        name: "Siderbar",
        data() {
            return {
                types: {},
                id:null,
            }
        },
        methods: {
            ArticleList(){
                this.$router.push('/')
            },
            goBack(){
                goBack();
            },
            ArticleTypeList(id){
                this.$router.push({
                    path: `/ArticleTypeList/${id}`,
                })
            }
        },
        mounted() {
                const _this = this;
                typeList().then(res=>{
                    _this.types=res.data.data.records;
                });
        },
    }
</script>

