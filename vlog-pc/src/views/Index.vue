<template>
  <v-main style="width: 100vw">
    <!-- 轮播图 -->
    <v-carousel cycle height="600" hide-delimiter-background>
      <v-carousel-item v-for="(slide, i) in slides" :key="i">
        <v-sheet height="100%">
          <v-row class="fill-height">
            <img :src="slide" class="slider-img" width="100%" height="100%" style="opacity: 0.8" />
          </v-row>
        </v-sheet>
      </v-carousel-item>
    </v-carousel>

    <!-- 精选文章 -->
    <v-row style="width: 80%; margin: 0 auto; margin-top: -80px">
      <v-col cols="12" md="6" v-for="(article, index) in indexList" :key="index">
        <v-hover v-slot="{ hover }">
          <v-card class="rounded-lg" height="450" link :elevation="hover ? 12 : 2" :class="{ 'on-hover': hover }">
            <v-img class="white--text text-center" :src="article.cover" height="100%">
              <v-row align="start" justify="center" class="py-12 px-6">
                <div class="mt-6 pa-6 title">
                  <h3>{{ article.title }}</h3>
                </div>
                <p
                  class="text-md-body-1 pa-2 display-3 text-left"
                  style="background-color: #000; opacity: 0.4; height: 150px"
                >
                  {{ article.summary }}
                </p>
                <v-row class="px-6 mt-6" align="center" @click="gotoProfile(article.userId)" justify="start">
                  <v-avatar>
                    <img :src="article.avatar" />
                  </v-avatar>
                  <h3 class="font-weight-black ml-3">{{ article.nickname }}</h3>
                </v-row>
              </v-row>
              <v-btn rounded dark elevation="12" class="px-12 py-6 purple-btn" @click="gotoDetail(article.id)">
                <h3>阅读更多</h3>
              </v-btn>
            </v-img>
          </v-card>
        </v-hover>
      </v-col>
    </v-row>
    <!-- 所有文章 -->
    <v-row style="width: 80%; margin: 10px auto">
      <v-col cols="12" md="4" v-for="(article, index) in articles" :key="index">
        <v-hover v-slot="{ hover }">
          <v-card class="rounded-lg" height="350" link :elevation="hover ? 12 : 2" :class="{ 'on-hover': hover }">
            <v-img class="white--text align-end" :src="article.cover" height="50%" @click="gotoDetail(article.id)">
              <h4 class="title">{{ article.title }}</h4>
            </v-img>
            <v-card-text class="text--primary">
              {{ article.summary.substring(0, 40) }}
            </v-card-text>

            <v-row justify="space-between" class="px-8 mb-4">
              <span>{{ article.createTime }}</span>
              <div>
                <v-icon color="#38485C"> mdi-bookmark </v-icon>
                <span>{{ article.category }}</span>
              </div>
            </v-row>

            <v-divider></v-divider>
            <v-row class="ml-4 mt-2" align="center" @click="gotoProfile(article.userId)" justify="start">
              <span class="mr-3">{{ article.nickname }}</span>
              <v-avatar>
                <img :src="article.avatar" />
              </v-avatar>
            </v-row>
          </v-card>
        </v-hover>
      </v-col>
    </v-row>

    <!-- 分页按钮 -->
    <v-row justify="space-around" class="my-6">
      <v-btn class="mx-2 grey" fab dark large elevation="12" :class="{ bgColor: pageNum > 1 }" @click="previous">
        <v-icon> mdi-less-than </v-icon>
      </v-btn>
      <h3>{{ pageNum }}/{{ pages }}</h3>
      <v-btn class="mx-2 bgColor" fab dark large elevation="12" :class="{ greyColor: pageNum === pages }" @click="next">
        <v-icon> mdi-greater-than </v-icon>
      </v-btn>
    </v-row>
  </v-main>
</template>

<script>
import { mapState } from 'vuex'
export default {
  name: 'Index',
  data() {
    return {
      pageNum: 1,
      pages: 0,
      articles: [], //所有文章数组
      indexList: [], //推荐文章数组
      slides: [], //轮播图图片数组
    }
  },
  computed: {
    ...mapState({
      loginStatus: (state) => state.loginStatus,
      loginUser: (state) => state.loginUser,
    }),
  },
  created() {
    this.getIndexList()
    this.getArticles()
  },
  methods: {
    // 请求热门文章接口
    getIndexList() {
      this.axios({
        method: 'get',
        url: '/article/recommend',
      }).then((res) => {
        // console.log(res.data.data)
        this.indexList = res.data.data
        this.indexList.forEach((item) => {
          this.slides.push(item.cover)
        })
        // console.log(this.slides)
      })
    },
    //请求所有文章接口
    getArticles() {
      this.axios({
        method: 'post',
        url: `/article/page?pageNum=${this.pageNum}`,
      }).then((res) => {
        // console.log(res.data.data)
        this.articles = res.data.data.list
        this.pages = res.data.data.pages
        console.log(this.articles[0].title)
      })
    },
    //  上一页
    previous() {
      if (this.pageNum > 1) {
        this.pageNum--
        this.getArticles()
      } else {
        // eslint-disable-next-line no-undef
        swal('已经是第一页了')
      }
    },

    //  下一页
    next() {
      if (this.pageNum < this.pages) {
        this.pageNum++
        this.getArticles()
      } else {
        //已经是最后一页了
        // eslint-disable-next-line no-undef
        swal('已经是最后一页了')
      }
    },
    // 详情页
    gotoDetail(id) {
      this.$router.push({
        path: '/article/' + id,
      })
    },
    //跳转到个人空间
    gotoProfile(id) {
      this.$router.push({
        path: '/my/' + id,
      })
    },
  },
}
</script>

<style lang="scss" scoped>
.purple-btn {
  width: 140px;
  height: 80px;
  background: linear-gradient(to right, rgb(51, 141, 133) 0%, rgb(157, 120, 65) 100%);
}
// 导航条透明样式
.nav-transparent {
  background-color: transparent !important;
  background-image: none;
  box-shadow: none;
}

.mask {
  background-color: rgba(0, 0, 0, 0.3);
  color: #fff;
  text-align: left;
  // line-height: 1.5rem;
}
.display-1 {
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 1;
  -webkit-box-orient: vertical;
}

// 文章摘要内容限制3行
.display-3 {
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical;
}

//卡片悬停
.v-card {
  transition: All 0.4s ease-in-out;
  -webkit-transition: All 0.4s ease-in-out;
  -moz-transition: All 0.4s ease-in-out;
  -o-transition: All 0.4s ease-in-out;
}
.v-card:hover {
  transform: scale(1.05);
  -webkit-transform: scale(1.05);
  -moz-transform: scale(1.05);
  -o-transform: scale(1.05);
  -ms-transform: scale(1.05);
  opacity: 0.7;
}

.title {
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  background-color: #000;
  opacity: 0.4;
  width: 100%;
  height: 60px;
}

.bgColor {
  background-image: linear-gradient(to right, rgb(51, 141, 133) 0%, rgb(157, 120, 65) 100%);
  opacity: 0.7;
  box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 7px 10px 0 rgba(0, 0, 0, 0.12);
}
.greyColor {
  background-image: linear-gradient(to right, #333 0%, #aaa 100%);
  opacity: 0.7;
  box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 7px 10px 0 rgba(0, 0, 0, 0.12);
}
</style>