<template>
    <div>
        <!--
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"/> 文章管理
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        -->
        <div class="container">
            <div class="handle-box">
                <el-button icon="el-icon-edit-outline" type="primary" class="handle-del mr10"><router-link :to="{name: 'ArticleEdit'}">新增文章</router-link></el-button>
                <!--
                <el-select v-model="type" placeholder="类型" class="handle-select mr10">
                    <el-option key="1" label="原创" value="原创"/>
                    <el-option key="2" label="转载" value="转载"/>
                    <el-option key="2" label="翻译" value="翻译"/>
                </el-select>
                <el-input v-model="name" placeholder="关键字" class="handle-input mr10"/>
                <el-button type="primary" icon="el-icon-search" >搜索</el-button>
                -->
            </div>
            <el-table
                :data="articles"
                border
                class="table"
                ref="multipleTable"
                header-cell-class-name="table-header">
                <el-table-column prop="id" label="ID" width="55" align="center"/>
                <el-table-column prop="title" label="文章标题"/>
                <el-table-column prop="description" :show-overflow-tooltip="true" label="文章简述"/>
                <el-table-column prop="author" label="作者"/>
                <el-table-column prop="content" :show-overflow-tooltip="true" label="文章原文"/>
                <el-table-column prop="readNum" label="阅读量"/>
                <el-table-column prop="commentNum" label="评论量"/>
                <el-table-column prop="likeNum" label="点赞量"/>
                <el-table-column prop="recommend" label="推荐" align="center">
                    <template scope="scope">
                        <el-tag  type="success" v-if="scope.row.recommend===1 || scope.row.recommend=== true ">是</el-tag>
                        <el-tag type="info" v-if="scope.row.recommend===0 ||scope.row.recommend=== false ">否</el-tag>
                    </template>
                </el-table-column>
                <el-table-column prop="type"   label="文章类型" show-overflow-tooltip align="center">
                    <template scope="scope">
                        <el-tag type="success" v-if="scope.row.type==='1'">原创</el-tag>
                        <el-tag v-if="scope.row.type==='2'">转载</el-tag>
                        <el-tag type="warning" v-if="scope.row.type==='3'">翻译</el-tag>
                    </template>
                </el-table-column>
                <el-table-column prop="publish" label="发布" align="center">
                    <template slot-scope="scope">
                        <el-tag type="success" v-if="scope.row.publish===0">发布</el-tag>
                        <el-tag type="danger" v-if="scope.row.publish===1">删除</el-tag>
                    </template>
                </el-table-column>
                <el-table-column prop="createTime" label="创建时间"/>
                <el-table-column prop="updateTime" label="更新时间"/>
                <el-table-column label="操作" width="180" align="center">
                    <template slot-scope="scope">
                        <el-button
                                type="text"
                                icon="el-icon-view">
                            <router-link :to="{name: 'ArticleDetail', params: {articleId: scope.row.id}}">查看</router-link></el-button>
                        <el-button
                            type="text"
                            icon="el-icon-edit">
                            <router-link :to="{name: 'ArticleEdit', params: {articleId: scope.row.id}}">编辑</router-link></el-button>
                        <!--
                        <el-button
                            type="text"
                            icon="el-icon-delete"
                            class="red"
                            @click="handleDelete(scope.row.id)"
                        >删除</el-button>
                        -->
                    </template>
                </el-table-column>
            </el-table>

            <div class="pagination">
                <el-pagination
                        background
                        layout="total, prev, pager, next"
                        :current-page="currentPage"
                        :page-size="pageSize"
                        :total="total"
                        @current-change="page"
                />
            </div>
        </div>
    </div>
</template>

<script>
import { ArticleList } from '../api/index';
export default {
    name: 'article',
    data() {
        return {
            articles:{},
            type:'',
            name: '',
            currentPage: 1,
            total: 0,
            pageSize: 5,
        };
    },
    methods: {
        page(currentPage) {
            const _this = this;
            ArticleList({currentPage:currentPage,pageSize:_this.pageSize}).then(res=>{
                _this.articles = res.data.data.records;
                _this.currentPage = res.data.data.current;
                _this.total = res.data.data.total;
                _this.pageSize = res.data.data.size;
            });
        },
        /**
        // 删除操作
        handleDelete(rowId) {
            const _this = this;
            // 二次确认删除
            this.$confirm('确定要删除吗？', '提示', {
                type: 'warning'
            }).then(() => {
                this.$axios.post('/article/del',rowId, {
                    headers: {
                        "Authorization": localStorage.getItem("token")
                    }
                }).then((res) => {
                    _this.$alert('操作成功', '提示', {
                        confirmButtonText: '确定',
                        callback: action => {
                            _this.$router.push("/article")
                        }
                    });
                });
            }).catch(() => {});
        },
         */
    },
    mounted () {
        this.page(1);
    },
        /**
        // 触发搜索按钮
        handleSearch() {
            this.$set(this.query, 'pageIndex', 1);
            this.getData();
        },*/
};
</script>

<style scoped>
.handle-box {
    margin-bottom: 20px;
}

.handle-select {
    width: 120px;
}

.handle-input {
    width: 300px;
    display: inline-block;
}
.table {
    width: 100%;
    font-size: 14px;
}
.red {
    color: #ff0000;
}
.mr10 {
    margin-right: 10px;
}
.table-td-thumb {
    display: block;
    margin: auto;
    width: 40px;
    height: 40px;
}
</style>
