<template>
  <div>
    <b-modal id="modal-1" title="Вход в личный кабинет">
      <div>
        <b-form-input v-model="text" placeholder="Enter your name"></b-form-input>

      </div>
    </b-modal>
  </div>
</template>

<script>
export default {
  name: "LoginModal"
}
</script>

<style scoped>

</style>
