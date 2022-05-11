<template>
  <v-app id="app">
    <v-main>
      <router-view />
    </v-main>
    <v-btn
      class="mx-2"
      fab
      dark
      large
      elevation="12"
      color="teal accent-4"
      fixed
      bottom
      right
      v-if="show"
      @click="backToTop"
    >
      <v-icon dark> mdi-arrow-up </v-icon>
    </v-btn>
  </v-app>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      show: false,
    }
  },
  created() {},
  mounted() {
    this.$nextTick(() => {
      window.addEventListener('scroll', this.scrollToTop)
    })
  },
  methods: {
    // 计算距离顶部的高度，当高度大于400时，按钮显示
    scrollToTop() {
      let scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop
      this.scrollTop = scrollTop
      // console.log(this.scrollTop)
      this.show = scrollTop > 400
    },

    //回到顶部  定时器，平滑回到顶部
    backToTop() {
      console.log('回到顶部')
      let timer = setInterval(() => {
        let speed = Math.floor(-this.scrollTop / 5)
        document.documentElement.scrollTop = this.scrollTop + speed
        if (this.scrollTop === 0) {
          clearInterval(timer)
        }
      }, 20)
    },
  },
}
</script>
<style lang="scss">
.move {
  animation-direction: 0.6s;
  animation-delay: 0.2s;
}

.bg-color {
  background-image: linear-gradient(to right, rgb(51, 141, 133) 0%, rgb(157, 120, 65) 100%);
  opacity: 0.7;
}
a {
  text-decoration: none;
}
</style>
 