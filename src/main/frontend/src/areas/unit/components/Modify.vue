<template>
    <v-container>
        <v-card>
            <v-card-text>
                <v-form ref="unit-create-form">
                    <v-text-field
                        :label="$t('unit.name')"
                        v-model="value.name"
                    />
                    <v-text-field
                        :label="$t('unit.description')"
                        v-model="value.description"
                    />
                    <!-- <v-text-field
                        :label="$t('unit.unitId')"
                        v-model="value.unitId"
                    /> -->
                </v-form>

            </v-card-text>

            <v-card-actions>
                <v-btn
                    v-text="$t('unit.save')"
                    @click="$emit('save')"
                />
            </v-card-actions>
        </v-card>
    </v-container>
</template>

<script lang="ts">
import Vue from "vue";
import { Component, Prop } from "vue-property-decorator";

import { Unit as Entity } from "@/model/Unit";

@Component({
    components: {
    }
})
export default class UnitModify extends Vue {
    @Prop({ default: () => {}, type: Object })
    public value!: Entity; 
};
</script>

