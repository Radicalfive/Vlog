<template>
  <v-main>
    <v-card>
      <v-img max-height="240px" max-width="100%" :src="banner"></v-img>
      <v-row align="start" class="mt-1">
        <v-col cols="12" md="3" class="ml-10">
          <side-bar></side-bar>
        </v-col>
        <v-col cols="12" md="8" class="ml-2">
          <router-view />
        </v-col>
      </v-row>
    </v-card>
    <!-- 对其他路由的渲染 -->
    <!-- <router-view /> -->
  </v-main>
</template>

<script>
import { mapState } from 'vuex'
import SideBar from '../components/SideBar'
export default {
  name: 'My',
  components: {
    SideBar,
  },
  data() {
    return {
      id: 0,
    }
  },
  computed: {
    ...mapState({
      loginStatus: (state) => state.loginStatus,
      loginUser: (state) => state.loginUser,
      user: (state) => state.user,
    }),
    banner() {
      return this.$store.state.user.banner
    },
  },
  created() {
    this.id = this.$route.params.id
    // alert('你要访问的用户id为：' + this.id)
    this.axios({
      method: 'GET',
      url: '/user/' + this.id,
    }).then((res) => {
      console.log(res.data.data.id)
      this.$store.commit('visit', res.data.data)
    })
  },
}
</script>
<style lang="scss" scoped>
.v-card {
  width: 85%;
  margin: 0 auto;
  min-height: 600px;
}
</style>
