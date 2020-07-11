<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-lx-calendar"></i> 文章</el-breadcrumb-item>
                <el-breadcrumb-item>markdown编辑器</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="m-content">
            <el-form ref="editForm" status-icon :model="editForm" :rules="rules" label-width="80px">
                <el-form-item label="标题" prop="title">
                    <el-input v-model="editForm.title"/>
                </el-form-item>
                <el-form-item label="摘要" prop="description">
                    <el-input type="textarea" v-model="editForm.description"/>
                </el-form-item>
                <el-form-item label="作者" prop="author">
                    <el-input v-model="editForm.author"/>
                </el-form-item>
                <el-form-item label="内容" prop="content">
                    <mavon-editor v-model="editForm.content"/>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm()">立即创建</el-button>
                    <el-button>取消</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
    import {ArticleEditById} from "../api";

    export default {
        name: 'ArticleEdit',
        data() {
            return {
                editForm: {
                    id: null,
                    title: '',
                    description: '',
                    author:'',
                    content: ''
                },
                rules: {
                    title: [
                        {required: true, message: '请输入标题', trigger: 'blur'},
                    ],
                    description: [
                        {required: true, message: '请输入摘要', trigger: 'blur'}
                    ]
                }
            }
        },
        created() {
            const articleId = this.$route.params.articleId;
            const _this = this;
            console.log(articleId);
            if(articleId) {
                this.$axios.get('/article/' + articleId).then((res) => {
                    const article = res.data.data;
                    _this.editForm.id = article.id;
                    _this.editForm.title = article.title;
                    _this.editForm.description = article.description;
                    _this.editForm.author = article.author;
                    _this.editForm.content = article.content;
                });
            }
        },
        methods: {
            submitForm() {
                const _this = this;
                this.$refs.editForm.validate((valid) => {
                    if (valid) {
                        ArticleEditById(this.editForm,{
                            headers: {
                                "Authorization": localStorage.getItem("token")
                            } }).then((res) => {
                            _this.$alert('操作成功', '提示', {
                                confirmButtonText: '确定',
                                callback: action => {
                                    _this.$router.push("/article")
                                }
                            });
                        });
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                })
            }
        },
    }
</script>

<style scoped>
    .editor-btn{
        margin-top: 20px;
    }
</style>

