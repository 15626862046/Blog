import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter);

  const routes = [
    {
      path: '/',
      redirect: '/ArticleList'
    },
    {
      path: '/ArticleList',
      name: 'ArticleList',
      component: () => import( '../views/ArticleList.vue')
    },
    {
      path: '/ArticleTypeList/:id',
      name: 'ArticleTypeList',
      component: () => import( '../views/ArticleTypeList.vue')
    },
    {
      path: '/articleDetail/:articleId',
      name: 'ArticleDetail',
      component: () => import( '../views/ArticleDetail.vue')
    },
    {
      path: '/articleSearch/:keyword',
      name: 'ArticleSearch',
      component: () => import('../views/ArticleSearch.vue')
    },
];

const router = new VueRouter({
  //base: 'front', //mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router
