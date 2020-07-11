<template>
    <div class="m-container">
        <div class="block" >
            <el-timeline>
                <el-timeline-item  icon="el-icon-star-off"  color="#E6A23C" v-for="article in articles"  v-bind:timestamp="article.updateTime" placement="top">
                    <el-card  :key="article.id">
                        <h4>
                            <router-link tag="li" :to="{name: 'ArticleDetail', params: {articleId: article.id}}">{{article.title}}
                                <el-tag  effect="plain" size="small" type="warning" :key="type.id" v-for="type in types"  v-if="type.id==article.typeId?true:false">{{type.name}}</el-tag>
                            </router-link>
                        </h4>
                        <p>{{article.description}}
                            <router-link :to="{name: 'ArticleDetail', params: {articleId: article.id}}"><el-link class="el-icon-s-promotion" type="primary">查看更多</el-link></router-link>
                        </p>

                        <p style="font-size: 13px;color: #999;">
                            <span class="el-icon-user">作者：{{article.author}}</span>
                            <span class="el-icon-view">阅读：{{article.readNum}} </span>
                            <span class="el-icon-star-on">喜欢：{{article.likeNum}} </span>
                        </p>

                    </el-card>

                </el-timeline-item>
            </el-timeline>
        </div>
        <el-row>
            <el-col :span="10">
                <el-input
                        style="width: 300px;
                display: inline-block;margin-right: 10px;"
                        size="small"
                        placeholder="请输入内容"
                        v-model="keyword">
                </el-input>
                <el-button size="small" type="primary" icon="el-icon-search" @click="searchKey(keyword)">搜索</el-button>
            </el-col>
            <el-pagination  class="mpage"
                            background
                            layout="prev, pager, next"
                            :current-page=currentPage
                            :page-size=pageSize
                            @current-change=page
                            :total="total">
            </el-pagination>
        </el-row>
    </div>
</template>

<script>
    import {typeList} from "../api";
    import {articleTypeList} from "../api";
    export default {
        inject:['reload'],
        name: "ArticleTypeList",
        data() {
            return {
                articles: {},
                currentPage: 1,
                total: 0,
                pageSize: 3,
                id:this.$route.params.id,
                types:{},
                keyword:null,
            }
        },
        watch:{
            '$route.path':function(){
                this.reload();
            }
        },
        methods: {
            page(currentPage) {
                const _this = this;
                articleTypeList({currentPage:currentPage,id:this.$route.params.id,pageSize:_this.pageSize}).then(res=>{
                    _this.articles = res.data.data.records;
                    _this.currentPage = res.data.data.current;
                    _this.total = res.data.data.total;
                    _this.pageSize = res.data.data.size;
                });
                typeList().then(res=>{
                    _this.types=res.data.data.records;
                });
            },
            searchKey(keyword){
                var keyword=this.keyword;
                this.$router.push({
                    path: `/ArticleSearch/${keyword}`,
                })
            },
        },
        mounted () {
            this.page(1);
        }
    }
</script>

<style scoped>

</style>
