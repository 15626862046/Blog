<template>
    <el-container>
        <Siderbar style="width: 20%"/>
            <el-main style="width: 80%">
                <router-view v-if="isRouterAlive"/>
            </el-main>
    </el-container>
</template>

<script>
    import Siderbar from "./Siderbar";
    export default {
        name: "Layout",
        components: { Siderbar},
        data:{
            components: {Siderbar}
        },
        provide () {    //父组件中通过provide来提供变量，在子组件中通过inject来注入变量。
            return {
                reload: this.reload
            }
        },
        data() {
            return{
                isRouterAlive: true                    //控制视图是否显示的变量
            }
        },
        methods: {
            reload () {
                this.isRouterAlive = false;            //先关闭，
                this.$nextTick(function () {
                    this.isRouterAlive = true;         //再打开
                })
            }
        }
    }
</script>

<style scoped>

</style>
