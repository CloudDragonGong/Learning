<template>
  <div>
    <!-- <img alt="Vue logo" src="./assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/> -->
    <element-view></element-view>
  </div>
</template>

<script>
import ElementView from "./components/elements/ElementView.vue";
// import HelloWorld from './components/HelloWorld.vue'

export default {
  components: { ElementView },
  data() {
    return {
      message: "Hello Vue",
    };
  },
  methods: {},
  // name: 'App',
  // components: {
  //   HelloWorld
  // }
};
</script>

<style>
/* #app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
} */
</style>
