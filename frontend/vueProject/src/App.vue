<template>
  <div id="app">
    <nav v-if="!$route.meta.hideNavbar" class="navbar navbar-expand navbar-dark bg-dark">
      <router-link to="/" class="navbar-brand">NoteTaker</router-link>
      <div class="navbar-nav mr-auto">
        <li class="nav-item">
          <router-link to="/home" class="nav-link">Notes</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/add" class="nav-link">Add Note</router-link>
        </li>
      </div>
      <div>
        <li class="nav-item">
          <a class="nav-link" href @click.prevent="logOut">
            <font-awesome-icon icon="sign-out-alt" />LogOut
          </a>
        </li>
      </div>
    </nav>

    <div class="container mt-3">
      <router-view />
    </div>
  </div>
</template>

<script>
import AuthService from "./services/AuthService";

export default {
  computed:{
    currentUSer() {
      return this.$store.state.auth.user;
    }
  },
  name: "app",
  methods: {
    logOut(){
      this.$store.dispatch('auth/logout');
      AuthService.logout()
      this.$router.push("/login")
    }
  }
};
</script>
