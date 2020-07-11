<template>
    <div>
        <el-input style="width: 300px;
                display: inline-block;
                margin-left: 20%;
                margin-right: 10px;"
                        size="small"
                        placeholder="请输入内容"
                        v-model="keyword">
        </el-input>
        <el-button size="small" type="primary" icon="el-icon-search" @click="searchKey(keyword)">搜索</el-button>
        <div class="block" >
            <el-timeline>
                <el-timeline-item  icon="el-icon-star-off"  color="#E6A23C" v-for="article in articles"  v-bind:timestamp="article.updateTime" placement="top">
                    <el-card  :key="article.id">
                        <h4>
                            <router-link v-html="article.title" tag="li" :to="{name: 'ArticleDetail', params: {articleId: article.id}}">{{article.title}}
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
    </div>
</template>

<script>
    import {search} from "../api";
    export default {
        name: "ArticleSearch",
        data(){
            return{
                articles: {},
                keyword:this.$route.params.keyword,
            }
        },
        created() {
            const _this = this;
            search(_this.keyword).then(res=>{
                _this.articles = res.data;
            });
        },
        methods:{
            searchKey(keyword){
                var keyword=this.keyword;
                this.$router.push({
                    path: `/ArticleSearch/${keyword}`,
                })
            },
        },
    }
</script>

<style scoped>

</style>
