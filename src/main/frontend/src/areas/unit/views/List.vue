<template>
    <v-container>
        <v-row>
            <template v-for="(entity, key) in entities">
                <v-col :key="key" :cols="12" :md="6" :xl="4">
                    <ListItem :entity="entity" />
                </v-col>
            </template>

            <v-col :cols="12" :md="6" :xl="4">
                <ListItemCreate />
            </v-col>
        </v-row>
    </v-container>
</template>

<script lang="ts">
import { Component } from "vue-property-decorator";
import { namespace } from "vuex-class";

import { Unit as Entity} from "@/model/Unit";

import { NAME as NAME_UNIT } from "@/areas/unit/store"
const unitModul = namespace(NAME_UNIT);
import { GET_ALL } from "@/areas/unit/store/actions"
import { ENTITIES } from "@/areas/unit/store/getters"

import View from "@/components/View.vue";
import ListItem from "@/areas/unit/components/ListItem.vue";
import ListItemCreate from "@/areas/unit/components/ListItemCreate.vue";
@Component({
    components: {
        ListItem,
        ListItemCreate
    }
})
export default class UnitListView extends View {
    @unitModul.Action(GET_ALL) getAll!: Function;
    @unitModul.Getter(ENTITIES) entities!: Array<Entity>;

    private created() {
        super.title = "unit.list.title";
    }

    private async mounted() {
        this.getAll();
    }

};
</script>

