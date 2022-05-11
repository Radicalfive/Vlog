<template>
  <div>
    <!-- 自定义导航 -->
    <nav-bar></nav-bar>

    <!-- 主题内容，二级路由出口 -->
    <div class="main-content">
      <router-view />
    </div>
    <!-- 自定义Footer -->
    <my-footer></my-footer>
  </div>
</template>

<script>
import MyFooter from '../components/MyFooter.vue'
import NavBar from '../components/NavBar.vue'
export default {
  name: 'Layout',
  components: {
    NavBar,
    MyFooter,
  },
}
</script>

<style lang="scss" scoped>
.main-content {
  margin: 60px auto;
  min-height: 500px;
  margin: 75px auto;
}
</style>
