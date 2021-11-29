<template>
  <section>
  <div id="mainMenu">
    <b-nav id="menuContent" justified>
      <b-nav-item>
        <nuxt-link active-class="active" class="nav-link" to="/laboratory">
          Laboratory
        </nuxt-link>
      </b-nav-item>
      <b-nav-item>
        <nuxt-link active-class="active" class="nav-link" to="/project">
          Project
        </nuxt-link>
      </b-nav-item>
      <b-nav-item>
        <nuxt-link active-class="active" class="nav-link" to="/news">
          News
        </nuxt-link>
      </b-nav-item>
      <b-nav-item>
        <nuxt-link active-class="active" class="nav-link" to="/about">
          Company
        </nuxt-link>
      </b-nav-item>
      <b-nav-item>
        <nuxt-link active-class="active" class="nav-link" to="/contacts">
          Contacts
        </nuxt-link>
      </b-nav-item>
    </b-nav>
  </div>
  </section>
</template>

<script>
export default {
  name: "MainMenu"
}
</script>

<style scoped>
#mainMenu{
  background-color: darkgrey;
  height: 80px;
}

#menuContent{
  height: 5em;
  display: flex;
  align-items: center;
  justify-content: center
}

</style>
