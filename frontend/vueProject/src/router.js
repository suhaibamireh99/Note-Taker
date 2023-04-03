import Vue from 'vue'
import Router from 'vue-router'
import Meta from 'vue-meta'

import NoteFormEdit from './components/note'
import noteAdd from './components/AddNote'
import NoteView from './components/noteList'
import Register from './views/register.vue';
import Login from './views/login.vue';
import './style.css'

Vue.use(Router)
Vue.use(Meta)
export default new Router({
  mode: 'history',
  routes: [
    {
      path:'/',
      redirect:'/login'
    },
    {
      name: 'Login',
      path: '/login',
      component: Login,
      meta: {hideNavbar: true}
    },
    {
      name: 'Register',
      path: '/register',
      component: Register,
      meta: {hideNavbar: true}
    },
    {
      name: 'Home',
      path: '/home',
      component: NoteView,
    },
    {
      name: 'add-note',
      path: '/add',
      component: noteAdd,
    },
    {
      name: 'note-details',
      path: '/note/:id',
      component: NoteFormEdit,
    },
  ]
  
})