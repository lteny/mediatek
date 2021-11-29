<template>
  <section>
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-2">
          <SidebarsAdmin/>
        </div>
        <div class="col-md-10">
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
import SidebarsAdmin from "@/components/SidebarsAdmin";
import Footer from "@/components/Footer";
export default {
  name: "layoutStaffs",
  components: {
    SidebarsAdmin,
    Footer,
  }
}
</script>

<style scoped>

</style>
