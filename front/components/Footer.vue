<template>
  <div class="container">
    <footer class="py-3 my-4">
      <ul class="nav justify-content-center border-bottom pb-3 mb-3">
        <li class="nav-item">
          <nuxt-link active-class="active" class="nav-link" to="/laboratory">
            Laboratory
          </nuxt-link>
        </li>
        <li class="nav-item">
          <nuxt-link active-class="active" class="nav-link" to="/project">
            Project
          </nuxt-link>
        </li>
        <li class="nav-item">
          <nuxt-link active-class="active" class="nav-link" to="/news">
            News
          </nuxt-link>
        </li>
        <li class="nav-item">
          <nuxt-link active-class="active" class="nav-link" to="/about">
            Company
          </nuxt-link>
        <li class="nav-item">
          <nuxt-link active-class="active" class="nav-link" to="/contacts">
            Contacts
          </nuxt-link>
        </li>
      </ul>
      <p class="text-center text-muted">&copy; 2021 Company, Inc</p>
    </footer>
  </div>
</template>

<script>
export default {
  name: "Footer"
}
</script>

<style scoped>

</style>
