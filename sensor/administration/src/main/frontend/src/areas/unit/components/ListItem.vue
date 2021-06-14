<template>
    <v-card :to="{ name: UNIT_EDIT, params: { id: entity.id }}" >
        <v-card-title v-text="entity.name" />

        <v-card-text v-text="entity.description" />
    </v-card>
</template>

<script lang="ts">
import Vue from "vue";
import { Component, Prop } from "vue-property-decorator";

import { Unit as Entity } from "@/model/Unit";
import { UNIT_EDIT } from "@/plugins/router";

@Component({
    components: {}
})
export default class UnitListItem extends Vue {
    private UNIT_EDIT = UNIT_EDIT;

    @Prop({ required: true, type: Object })
    public entity!: Entity; 
};
</script>

