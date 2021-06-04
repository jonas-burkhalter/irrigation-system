<template></template>

<script>
import { createNamespacedHelpers } from "vuex";
import { AUTHENTICATE } from "../store/name";
import { LOGOUT } from "../store/actions";
const { mapActions } = createNamespacedHelpers(AUTHENTICATE);

export default {
    methods: {
        ...mapActions({
            logout: LOGOUT
        })
    },
    mounted() {
        this.logout();
        this.$router.push({ name: "login" });
    }
};
</script>
