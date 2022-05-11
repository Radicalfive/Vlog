<template>
  <v-card class="mt-10 mx-auto" max-width="100%">
    <v-sheet class="v-sheet--offset mx-auto" color="cyan" elevation="12" max-width="calc(100% - 32px)">
      <v-sparkline :labels="labels" :value="value" color="white" line-width="2" padding="16"></v-sparkline>
    </v-sheet>

    <v-card-text class="pt-0">
      <div class="text-h6 font-weight-light mb-2">User Registrations</div>
      <div class="subheading font-weight-light grey--text">Last Campaign Performance</div>
      <v-divider class="my-2"></v-divider>
      <v-icon class="mr-2" small> mdi-clock </v-icon>
      <span class="text-caption grey--text font-weight-light"
        >最近在忙面试，本来今天都不想更了，但是看基础知识看的太累了，于是写道题排解一下压力。 题目链接LeetCode 面试题13.
        机器人的运动范围 题目描述地上有一个 m 行 n 列的方格，从坐标 [0, 0] 到坐标 [m-1, n-1]</span
      >
    </v-card-text>
  </v-card>
</template>

<script>
export default {
  name: 'Feedback',
  data: () => ({
    labels: ['12am', '3am', '6am', '9am', '12pm', '3pm', '6pm', '9pm'],
    value: [200, 675, 410, 390, 310, 460, 250, 240],
  }),
}
</script>

<style scoped>
.v-sheet--offset {
  top: -24px;
  position: relative;
}
</style>
