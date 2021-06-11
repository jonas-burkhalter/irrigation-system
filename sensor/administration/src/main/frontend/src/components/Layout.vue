<template>
    <v-app :style="styleApp" dark>
        <navigation v-model="drawer" :theme="theme" />

        <v-app-bar :style="styleAppBar" :clipped-left="false" :fixed="false" color="primary" app>
            <v-app-bar-nav-icon @click.stop="drawer = !drawer" />
            <v-toolbar-title v-text="$t('common.application.title')" />
            <v-spacer />
        </v-app-bar>

        <v-content>
            <v-container>
                <alert />
                <router-view />
            </v-container>
        </v-content>
    </v-app>
</template>

<script>
import Alert from "./Alert.vue";
import Navigation from "./Navigation.vue";
export default {
    components: { Alert, Navigation },
    data: () => ({
        drawer: false
    }),
    computed: {
        styleApp() {
            return {
                background: this.$vuetify.theme.themes[this.theme].background,
                color: this.$vuetify.theme.themes[this.theme].text.content
            };
        },
        styleAppBar() {
            return {
                color: this.$vuetify.theme.themes[this.theme].text.header
            };
        },
        theme() {
            return this.$vuetify.theme.dark ? "dark" : "light";
        }
    },
    mounted() {
        this.$vuetify.theme.dark =
            !window.matchMedia("(prefers-color-scheme: light)").matches && true;
    }
};
</script>

<style scoped>
#layout-default-logo {
    position: relative;
    top: 45px;

    height: 130px;
    width: 12%;
    max-width: 135px;
}
@media only screen and (max-width: 600px) {
    #layout-default-logo {
        width: 20%;
    }
}
</style>
