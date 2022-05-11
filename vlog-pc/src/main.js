import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import swal from 'sweetalert'

import axios from 'axios'
import VueAxios from 'vue-axios'

//引入富文本编译器
import VueQuillEditor from 'vue-quill-editor'
import 'quill/dist/quill.core.css'
import 'quill/dist/quill.snow.css'
import 'quill/dist/quill.bubble.css'
Vue.use(VueQuillEditor)

Vue.use(VueAxios, axios)

import vuetify from './plugins/vuetify'

axios.defaults.baseURL = 'http://localhost:8080/api'

Vue.config.productionTip = false

new Vue({
  swal,
  router,
  store,
  vuetify,
  render: (h) => h(App)
}).$mount('#app')
