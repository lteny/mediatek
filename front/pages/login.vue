<template>
<section>
  <div>
    <b-form>
      <b-form-group
        id="input-group-1"
        label="Email"
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          v-model="form.email"
          type="email"
          placeholder="Enter email"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Password" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.password"
          placeholder="Password"
          required
        ></b-form-input>
      </b-form-group>
      <nuxt-link to="/">Home</nuxt-link>
      <b-button type="submit" variant="primary">Войти</b-button>
    </b-form>
  </div>
</section>
</template>

<script>

export default {
  layout: 'emptyLogin',

  data() {
    return {
      form: {
        email: '',
        password: '',
      },
    }
  }
}
</script>

<style scoped>
  form{
    width: 500px;
    margin: 0 auto;
  }
</style>
