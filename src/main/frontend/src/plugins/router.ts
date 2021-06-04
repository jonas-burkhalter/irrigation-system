import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

export const PLANT_LIST = "plant.list"
export const AUTHENTICATE_LOGIN = "authenticate.login"
export const AUTHENTICATE_LOGOUT = "authenticate.logout"

const routes = [
    { path: '/', name: 'home', redirect: { name: PLANT_LIST } },
    {
        path: '/plant/list',
        name: PLANT_LIST,
        component: () => import(/* webpackChunkName: "plants" */ '@/areas/plant/views/List.vue')
    },
    {
        path: '/login',
        name: AUTHENTICATE_LOGIN,
        component: () => import(/* webpackChunkName: "authenticate" */ '@/areas/authenticate/views/Login.vue')
    },
    {
        path: '/logout',
        name: AUTHENTICATE_LOGOUT,
        component: () => import(/* webpackChunkName: "authenticate" */ '@/areas/authenticate/views/Logout.vue')
    },
];

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
});

export default router;
