import Vue from 'vue';
import App from '@/App.vue';
import router from '@/plugins/router';
import store from '@/plugins/store';
import i18n from '@/plugins/i18n';
import vuetify from '@/plugins/vuetify';

Vue.config.productionTip = false;

import VueApexCharts from 'vue-apexcharts'
Vue.use(VueApexCharts)
Vue.component('apexchart', VueApexCharts)

new Vue({
    i18n,
    router,
    store,
    vuetify,
    render: (h: any) => h(App)
}).$mount('#app');
