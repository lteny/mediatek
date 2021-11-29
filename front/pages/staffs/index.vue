<template>
<section>
  <h1>{{pageTitle}}</h1>
  <div class="container-fluid">
    <table class="table table-bordered table-sm">
      <thead class="table-info">
      <th scope="col">#</th>
      <th scope="col">FirstName</th>
      <th scope="col">Role</th>
      <th scope="col">Status</th>
      </thead>
      <tbody>
      <tr v-for="staff of staffs" :key="staff.id">
        <th scope="row">{{staff.id}}</th>
        <th scope="row"><a href="#" @click.prevent="openStaff(staff)">{{staff.firstName}}</a></th>
        <th scope="row">{{staff.role}}</th>
        <th scope="row">{{staff.status}}</th>
      </tr>
      </tbody>
    </table>
  </div>

<!--  <ul>-->
<!--    <li v-for="staff of staffs" :key="staff.id">-->
<!--     <a href="#" @click.prevent="openStaff(staff)">{{staff.firstName}}</a>-->
<!--    </li>-->
<!--  </ul>-->
</section>
</template>

<script>
export default {
  layout: 'layout_staffs/layoutStaffs',

 async fetch({store}){
   if (store.getters['staffs/staffs'].length === 0){
     await store.dispatch('staffs/fetch')
   }
 },
  data: () => ({
    pageTitle: 'Staff page'
  }),
  computed: {
   staffs(){
     return this.$store.getters['staffs/staffs']
   }
  },
  methods: {
   openStaff(staff){
     this.$router.push('/staffs/' + staff.id)
   }
 }
}
</script>

<style scoped>

</style>
