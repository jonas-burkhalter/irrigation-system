<template>
    <v-container fluid>
        <v-alert
            dismissible
            :type="type"
            :value="visible"
            v-show="$t(text).length > 0"
            @input="close"
        >{{$t(text)}}</v-alert>
    </v-container>
</template>

<script>
import { createNamespacedHelpers } from "vuex";
import { ALERT } from "@/plugins/store/alert/name";
import { CLOSE } from "@/plugins/store/alert/actions";
import { TEXT, TYPE, VISIBLE } from "@/plugins/store/alert/getters";
const { mapGetters, mapActions } = createNamespacedHelpers(ALERT);

export default {
    computed: {
        ...mapGetters({
            text: [TEXT],
            type: [TYPE],
            visible: [VISIBLE]
        })
    },
    methods: {
        ...mapActions({
            close: CLOSE
        })
    }
};
</script>