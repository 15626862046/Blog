module.exports = {
    //publicPath:'/admin/', //history模式
    publicPath:'./',
    assetsDir: 'static',
    outputDir: 'admin',
    indexPath: "index.html",
    productionSourceMap: false,
    devServer: {
        hot:true,
        port:9090,
        //proxy: {
            //         '/api':{
            //             target:'http://jsonplaceholder.typicode.com',
            //             changeOrigin:true,
            //             pathRewrite:{
            //                 '/api':''
            //             }
            //         }
            //     }
            // }
        }
    }
