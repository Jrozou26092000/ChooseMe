<template>
  <div id="app">
      <top-header></top-header>
    <router-view />
  </div>
</template>

<script>
import TopHeader from "@/components/TopHeader.vue";
  export default {
    components: {
      "top-header": TopHeader
    }
  }
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
