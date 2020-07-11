import axios from 'axios'; //引入axios
axios.defaults.baseURL='http://localhost:8081';

//转后台管理
export const goBack = params => {
    return window.location.href = 'http://localhost:8081/admin/index.html#login';
};
//分类集合
export const typeList = params =>{
    return axios.get("/type/list")
};
//文章集合
export const articleList = params =>{
    return axios.get("/article/list",{params:params})
};
//文章分类集合
export const articleTypeList = params =>{
    return axios.get("/article/typeList",{params:params})
};
//文章详细内容
export function articleById (id){
    return axios.get(`/article/${id}`)
}

//搜索
export function search (keyword){
    return axios.get(`/search/${keyword}`)
}
