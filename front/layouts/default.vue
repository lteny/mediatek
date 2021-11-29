<template>
<div>
  <Navbar/>
  <MainMenu/>
  <main>
    <div class="container">
      <nuxt/>
    </div>
  </main>
  <Carousel/>
  <Features/>
  <CardContent/>
  <Content/>
  <Footer/>
</div>
</template>

<script>
import Carousel from "@/components/Carousel";
import CardContent from "@/components/CardContent";
import MainMenu from "@/components/MainMenu";
import Footer from "@/components/Footer";
import Content from "@/components/Content";
import Features from "@/components/Features";
import Navbar from "@/components/Navbar";
export default {
  components: {
    Navbar,
    Carousel,
    CardContent,
    MainMenu,
    Footer,
    Content,
    Features,
  }
}
</script>

<style scoped>

</style>
