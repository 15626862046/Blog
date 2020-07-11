import Vue from 'vue';
import Router from 'vue-router';


Vue.use(Router);


const routes = [
        {
            path: '/',
            redirect: '/dashboard'
        },
        {
            path: '/home',
            component: () => import( '../components/Home.vue'),
            meta: { requireAuth: true},
            children: [
                {
                    path: '/dashboard',
                    component: () => import( '../view/Dashboard.vue'),
                    meta: { title: '系统首页' }
                },
                {
                    path: '/article',
                    component: () => import('../view/Article.vue'),
                    meta: { title: '文章管理' }
                },
                {
                    //ArticleDetail文章详情
                    path: '/article/:articleId',
                    name: 'ArticleDetail',
                    component: () => import('../view/ArticleDetail.vue'),
                    meta: { title: '文章详情' }
                },
                {
                    // ArticleEdit
                    path: '/article/:articleId/edit',
                    name: 'ArticleEdit',
                    component: () => import('../view/ArticleEdit.vue'),
                    meta: { title: '文章编辑'}
                },
                {
                    // comment评论管理
                    path: '/comment',
                    component: () => import( '../view/Comment.vue'),
                    meta: { title: '评论管理' }
                },
                {
                    // tag标签管理
                    path: '/tag',
                    component: () => import( '../view/Tag.vue'),
                    meta: { title: '标签管理' }
                },
                {
                    // type类型管理
                    path: '/type',
                    component: () => import( '../view/Type.vue'),
                    meta: { title: '类型管理' }
                },
                {
                    // friend友链管理
                    path: '/link',
                    component: () => import('../view/Link.vue'),
                    meta: { title: '友链管理' }
                },
                {
                    // log日志查看
                    path: '/log',
                    component: () => import( '../view/Log.vue'),
                    meta: { title: '日志查看' }
                },
                {
                    path: '/404',
                    component: () => import( '../view/404.vue'),
                    meta: { title: '404' }
                },
                {
                    path: '/403',
                    component: () => import( '../view/403.vue'),
                    meta: { title: '403' }
                },
                {
                    path: '/about',
                    component: () => import( '../view/About.vue'),
                    meta: { title: '关于作者' }
                }
            ]
        },
        {
            path: '/login',
            component: () => import( '../view/Login.vue'),
            meta: { title: '登录' }
        },
        {
            path: '*',
            redirect: '/404'
        }
    ];
const router = new Router({
    //mode: 'history',
    //base: process.env.BASE_URL,
    routes
});
export default router
