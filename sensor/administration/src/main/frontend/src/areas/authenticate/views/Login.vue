<template>
    <v-container fluid>
        <authenticate-card :save="save" :title="$t('areas.authenticate.login')" v-model="user" />
    </v-container>
</template>

<script>
import AuthenticateCard from "../components/AuthenticateCard.vue";

import { createNamespacedHelpers } from "vuex";
import { AUTHENTICATE } from "../store/name";
import { LOGIN } from "../store/actions";
const { mapActions } = createNamespacedHelpers(AUTHENTICATE);

export default {
    components: {
        AuthenticateCard
    },
    data: () => ({
        dialog: true,
        user: {}
    }),
    methods: {
        ...mapActions({
            login: LOGIN
        }),
        save: function() {
            this.login(this.user).then(() => {
                this.user = Object.assign({});
                this.$router.push({ name: "home" });
            });
        }
    }
};
</script>
