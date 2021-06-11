import Vue from 'vue';
import VueRouter, { Route } from 'vue-router';

Vue.use(VueRouter);

export const PLANT_LIST = "plant.list"
export const POT_LIST = "pot.list"
export const UNIT_CREATE = "unit.create"
export const UNIT_EDIT = "unit.entity"
export const UNIT_LIST = "unit.list"

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
        path: '/pot/list',
        name: POT_LIST,
        // component: () => import(/* webpackChunkName: "pot" */ '@/areas/pot/views/List.vue')
    },
    {
        path: '/unit/list',
        name: UNIT_LIST,
        component: () => import(/* webpackChunkName: "unit" */ '@/areas/unit/views/List.vue')
    },
    {
        path: '/unit',
        name: UNIT_CREATE,
        component: () => import(/* webpackChunkName: "unit" */ '@/areas/unit/views/Create.vue')
    },
    {
        path: '/unit/:id',
        name: UNIT_EDIT,
        component: () => import(/* webpackChunkName: "unit" */ '@/areas/unit/views/Edit.vue'),
        props: (route: Route) => ({ id: Number(route.params.id) })
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
