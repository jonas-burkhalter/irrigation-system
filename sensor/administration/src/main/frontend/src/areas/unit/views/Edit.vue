<template>
    <v-container>
        <Modify v-if="entity" v-model="entity" @save="edit" />
    </v-container>
</template>

<script lang="ts">
import { Component, Prop } from "vue-property-decorator";
import { namespace } from "vuex-class";

import { Unit as Entity } from "@/model/Unit";

import { NAME as NAME_UNIT } from "@/areas/unit/store"
const unitModul = namespace(NAME_UNIT);
import { EDIT, GET } from "@/areas/unit/store/actions"

import View from "@/components/View.vue";
import Modify from "@/areas/unit/components/Modify.vue"
@Component({
    components: {
        Modify
    }
})
export default class UnitEditView extends View {
    @Prop({ required: true, type: Number })
    public id!: number; 

    private entity: Entity | null = null;

    @unitModul.Action(EDIT) edit!: Function;
    @unitModul.Action(GET) get!: Function;

    
    private created() {
        super.title = "unit.edit.title";
    }

    private async mounted() {
        this.entity = await this.get(this.id);
    }
};
</script>

