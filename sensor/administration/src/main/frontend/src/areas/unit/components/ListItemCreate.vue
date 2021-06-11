<template>
    <v-card :to="{ name: UNIT_CREATE }">
        <v-card-text>
            <v-icon large v-text="'mdi-plus'" />
        </v-card-text>
    </v-card>
</template>

<script lang="ts">
import Vue from "vue";
import { Component } from "vue-property-decorator";

import { UNIT_CREATE } from "@/plugins/router";

@Component({
    components: {}
})
export default class UnitListItemCreate extends Vue {
    private UNIT_CREATE = UNIT_CREATE;
};
</script>

