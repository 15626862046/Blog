import Vue from 'vue';
import App from './App.vue';
import store from './store'
import router from './router';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'; // 默认主题
import mavonEditor  from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import './assets/css/icon.css';
import 'babel-polyfill';
import axios from 'axios';
import "./utils/permission";
import './utils/request';

Vue.prototype.$axios = axios;
Vue.use(mavonEditor);
Vue.config.productionTip = false;

Vue.use(ElementUI, {
    size: 'small'
});


new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app');
