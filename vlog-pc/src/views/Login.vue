<template>
  <div class="bg row">
    <v-form v-model="valid" lazy-validation ref="form" class="col">
      <h2>欢迎登录个人VLOG</h2>
      <v-text-field v-model="phone" required label="Phone" :rules="phoneRules"></v-text-field>
      <v-text-field v-model="password" required label="Password" :rules="passwordRules"></v-text-field>

      <!-- 验证码 -->
      <v-row>
        <v-col cols="12" md="8">
          <v-text-field v-model="verifyCode" label="verifyCode" required></v-text-field>
        </v-col>
        <v-col cols="12" md="4">
          <img class="verify" @click.prevent="getVerifyCode" ref="codeImg" :src="url" />
        </v-col>
      </v-row>

      <!-- 复选框 -->
      <v-checkbox v-model="checkbox" label="同意协议？" required :rules="[(v) => !!v || '同意才能继续']"> </v-checkbox>
      <div class="btns">
        <!-- <v-btn color="success" class="mr-10" @click="validate">验证</v-btn> -->
        <v-btn color="primary" class="mr-10" @click="submit" :disabled="!valid">登录</v-btn>
        <v-btn color="warning" class="mr-10" @click="reset" :loading="loading">重置</v-btn>
      </div>
    </v-form>
    <v-overlay absolute z-index="5" class="mask"></v-overlay>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data() {
    return {
      valid: true,
      phone: '19908324671',
      password: '123123',
      verifyCode: '',
      checkbox: true,
      loading: false,
      url: '',
      phoneRules: [(v) => !!v || '手机号不能为空', (v) => (v && v.length === 11) || '手机号必须为11位'],
      passwordRules: [
        (v) => !!v || '密码不能为空',
        (v) => (v && v.length >= 6 && v.length <= 20) || '密码长度要在6-20位之间',
      ],
    }
  },
  created() {
    if (this.phoneRules) {
      this.getVerifyCode()
    }
  },
  methods: {
    validate() {
      this.$$refs.form.validate()
    },
    async reset() {
      this.loading = true
      await new Promise((resolve) => setTimeout(resolve, 500))
      this.$refs.form.reset()
      this.loading = false
    },

    getVerifyCode() {
      this.axios.get('/captcha?phone=' + this.phone, { responseType: 'blob' }).then((res) => {
        this.url = window.URL.createObjectURL(res.data)
      })
    },

    async submit() {
      // this.validate()
      this.axios({
        method: 'post',
        url: '/user/login',
        data: {
          phone: this.phone,
          password: this.password,
        },
      }).then((res) => {
        // console.log(res)
        if (res.data.code === 1) {
          // eslint-disable-next-line no-undef
          swal('Welcome Vlog!', '登录成功!', 'success')
          this.$store.commit('login', res.data.data)
          localStorage.setItem('login', res.data.data)
          this.$router.push('/index')
        } else {
          // eslint-disable-next-line no-undef
          swal('登录失败!', 'error')
        }
      })
    },
  },
}
</script>

<style lang="scss">
.bg {
  width: 100vw;
  height: 100vh;
  background: url('https://ossstored.oss-cn-shanghai.aliyuncs.com/bg/f71698b2b33e4539ac294e70ba8cd327.jpg');
  background-size: 100% 100%;
}

.row {
  display: flex;
  align-items: center;
  justify-content: center;
  .col {
    flex: 0 0 35%;
    background-color: rgb(207, 207, 207, 0.35);
    border-radius: 10px;
    z-index: 10;
    height: 450px;
    line-height: 80px;
    align-content: center;

    h2 {
      display: flex;
      justify-content: center;
      align-content: center;
    }
  }
}
.btns {
  display: flex;
  justify-content: center;
  align-content: center;
}
</style>