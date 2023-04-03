
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store';
import VeeValidate from 'vee-validate';
import LottieVuePlayer from '@lottiefiles/vue-lottie-player'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import { BootstrapVue } from 'bootstrap-vue'

Vue.use(VeeValidate)
Vue.config.productionTip = false
Vue.use(BootstrapVue)

new Vue({
  store,
  router,
  render: h => h(App)
}).$mount('#app')