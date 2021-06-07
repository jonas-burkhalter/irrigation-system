<template>
    <v-container>
        <Modify v-if="entity" v-model="entity" @save="create" />
    </v-container>
</template>

<script lang="ts">
import { Component } from "vue-property-decorator";
import { namespace } from "vuex-class";

import { Unit as Entity } from "@/model/Unit";

import { NAME as NAME_UNIT } from "@/areas/unit/store"
const unitModul = namespace(NAME_UNIT);
import { CREATE } from "@/areas/unit/store/actions"

import View from "@/components/View.vue";
import Modify from "@/areas/unit/components/Modify.vue"
@Component({
    components: {
        Modify
    }
})
export default class UnitCreateView extends View {
    private entity: Entity = {description: "", id: 0, name: ""};

    @unitModul.Action(CREATE) create!: Function;
    
    private created() {
        super.title = "unit.create.title";
    }
};
</script>