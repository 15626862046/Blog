<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-user"></i> 关于作者
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <el-row>
                    <el-card :body-style="{ padding: '0px' }">
                        <img src="../assets/img/head.jpg" class="image">
                        <div style="padding: 14px;">
                            <span>一个学生的个人博客后台管理系统</span>

                            <div class="bottom clearfix">
                                <span>2020/6/9</span>
                                <el-button type="text" class="button">
                                    <a href="https://github.com/HeBingJun" target="_blank">
                                        <el-dropdown-item>GitHub项目仓库</el-dropdown-item>
                                </a>
                                </el-button>
                            </div>

                        </div>
                    </el-card>
            </el-row>
        </div>
    </div>
</template>

<script>
export default {
};
</script>

<style scoped>
    img {
        display: block;
        width: 40px;
        height: 40px;
        border-radius: 50%;
    }
</style>
