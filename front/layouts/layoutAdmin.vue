<template>
  <section>
    <div class="container-fluid">
      <div class="row">
        <div class="col-2">
          <SidebarsAdmin/>
        </div>
        <div class="col-10">
          <div class="container-fluid">
            <nuxt/>
          </div>
        </div>
      </div>
    </div>
    <Footer/>
  </section>
</template>

<script>
import Footer from "@/components/Footer";
import SidebarsAdmin from "@/components/SidebarsAdmin";
export default {
  name: "layoutAdmin",
  components: {
    SidebarsAdmin,
    Footer,
  }
}
</script>

<style scoped>

</style>
