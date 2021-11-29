<template>
  <section>
    <b-navbar toggleable="lg" type="light">
      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav class="ml-left">
          <b-navbar-nav>
            <nuxt-link active-class="active" class="nav-link" to="/">
              Главная
            </nuxt-link>
          </b-navbar-nav>
          <b-navbar-nav>
            <nuxt-link active-class="active" class="nav-link" to="/admin">
              Admin
            </nuxt-link>
          </b-navbar-nav>
        </b-navbar-nav>
        <b-navbar-nav class="ml-auto">
          <b-navbar-nav>
            <nuxt-link active-class="active" class="nav-link" to="/login">
              Войти
            </nuxt-link>
          </b-navbar-nav>
          <b-navbar-nav>
            <nuxt-link active-class="active" class="nav-link" to="#">
              Регистрация
            </nuxt-link>
          </b-navbar-nav>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
    <b-navbar>
      <b-navbar-brand tag="h1">
        <img src="https://placekitten.com/g/30/30" class="d-inline-block align-top" alt="Kitten">
        Mediatek
      </b-navbar-brand>
      <b-navbar-nav class="ml-auto">
        <b-form-input size="sm" class="mr-sm-2" placeholder="Поиск..."></b-form-input>
        <b-button size="sm" class="my-2 my-sm-0" type="submit">Search</b-button>
      </b-navbar-nav>
    </b-navbar>
  </section>
</template>

<script>
export default {
  name: "Navbar"
}
</script>

<style scoped>

</style>
