<template>
  <section>
    <Navbar/>
    <MainMenu/>
    <div class="container">
      <nuxt/>
    </div>
    <Footer/>
  </section>
</template>

<script>
import Navbar from "@/components/Navbar";
import MainMenu from "@/components/MainMenu";
import Footer from "@/components/Footer";
export default {
  name: "layoutContacts",
  components: {
    Navbar,
    MainMenu,
    Footer
  }
}
</script>

<style scoped>

</style>
