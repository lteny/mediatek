<template>
<section>
  <h1>{{pageTitle}}</h1>
  <div class="container-fluid">
  <table class="table table-bordered table-sm">
    <thead class="table-info">
    <th scope="col">#</th>
    <th scope="col">FirstName</th>
    <th scope="col">LastName</th>
    <th scope="col">Email</th>
    <th scope="col">Role</th>
    <th scope="col">Status</th>
    </thead>
    <tbody>
    <tr>
      <th scope="row">{{staff.id}}</th>
      <th scope="row">{{staff.firstName}}</th>
      <th scope="row">{{staff.lastName}}</th>
      <th scope="row">{{staff.email}}</th>
      <th scope="row">{{staff.role}}</th>
      <th scope="row">{{staff.status}}</th>
    </tr>
    </tbody>
  </table>
  </div>
</section>
</template>

<script>
export default {
  layout: 'layout_staffs/layoutStaffsDetails',
  data: () => ({
    pageTitle: 'Staff page details'
  }),
  validate({params}){
    return /^\d+$/.test(params.id)
  },
  async asyncData({$axios, params}){
    const staff = await $axios.$get('http://localhost:9000/staff/' + params.id)
    return{staff}
  }
}
</script>

<style scoped>

</style>
