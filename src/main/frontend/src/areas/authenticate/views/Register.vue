<template>
    <v-container fluid>
        <authenticate-card :save="save" :title="$t('areas.authenticate.register')" v-model="user" />
    </v-container>
</template>

<script>
import AuthenticateCard from "../components/AuthenticateCard.vue";

import { createNamespacedHelpers } from "vuex";
import { AUTHENTICATE } from "../store/name";
import { REGISTER } from "../store/actions";
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
            register: REGISTER
        }),
        save: function() {
            this.register(this.user).then(() => {
                this.user = Object.assign({});
                this.$router.push({ name: "home" });
            });
        }
    }
};
</script>
