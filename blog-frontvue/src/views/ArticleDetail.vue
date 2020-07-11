<template>
    <div class="m-container">
            <h2>{{ article.title }}</h2>
            <el-divider></el-divider>
            <div class="content markdown-body" v-html="article.content"></div>
    </div>
</template>

<script>
    import 'github-markdown-css' // 然后添加样式markdown-body
    import {articleById} from "../api";

    export default {
        name: "ArticleDetail",
        data() {
            return {
                article: {
                    title: "",
                    description: "",
                    content: ""
                },
            }
        },
        created() {
            const articleId = this.$route.params.articleId
            const _this = this
            articleById( articleId).then(res => {
                const article = res.data.data
                _this.article.id = article.id
                _this.article.title = article.title
                var MardownIt = require("markdown-it")
                var md = new MardownIt()
                var result = md.render(article.content)
                _this.article.content = result
            })
        }
    }
</script>

<style scoped>

</style>
