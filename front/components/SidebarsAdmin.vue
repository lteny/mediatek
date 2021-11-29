<template>
<section>
  <div id="sidebarPanel" class="flex-shrink-0 p-3 border">
    <nuxt-link to="/admin" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-light text-decoration-none">
      <b-icon icon="gear" class="mr-2"></b-icon>
      <span class="fs-4">Панель администратора</span>
    </nuxt-link>
    <hr>
    <ul class="list-unstyled ps-0 mb-auto">
      <li class="nav-item">
        <nuxt-link id="link" active-class="active" class="nav-link text-light" to="/">
          <b-icon icon="house-door" class="mr-2"></b-icon>
          Home
        </nuxt-link>
      </li>
      <li class="nav-item">
        <nuxt-link active-class="active" class="nav-link text-light" to="/staffs">
          <b-icon icon="person-circle" class="mr-2"></b-icon>
          Staff
        </nuxt-link>
      </li>
      <li>
        <a href="#" class="nav-link text-light">
          <b-icon icon="people" class="mr-2"></b-icon>
          Users
        </a>
      </li>
      <li>
        <a href="#" class="nav-link text-light">
          <b-icon icon="card-text" class="mr-2"></b-icon>
          News
        </a>
      </li>
      <li>
        <a href="#" class="nav-link text-light">
          <b-icon icon="grid" class="mr-2"></b-icon>
          Products
        </a>
      </li>
      <li>
        <a href="#" class="nav-link text-light">
          <b-icon icon="columns-gap" class="mr-2"></b-icon>
          Content
        </a>
      </li>
    </ul>
    <hr>
  </div>
</section>
</template>

<script>
export default {
  name: "SidebarsAdmin"
}
</script>

<style scoped>
#sidebarPanel{
  background-color: #008080;
  width: 280px;
}
hr {
  background-color: aliceblue;
}
</style>
