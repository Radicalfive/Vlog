<template>
  <div class="mt-10">
    <v-text-field required label="请输入旧密码" :rules="phoneRules"></v-text-field>
    <v-text-field required label="请输入新密码" :rules="phoneRules"></v-text-field>
    <v-text-field required label="确认新密码" :rules="phoneRules"></v-text-field>
    <v-btn color="success" class="mr-11">修改密码</v-btn>
    <v-btn color="warning" class="">重置输入</v-btn>
  </div>
</template>

<script>
export default {
  name: 'Usersafe'
}
</script>

<style></style>