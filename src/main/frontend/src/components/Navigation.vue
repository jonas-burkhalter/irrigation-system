<template>
    <v-navigation-drawer app :clipped="false" fixed :style="styleNavigationDrawer" v-model="value">
        <v-list>
            <template v-for="(item, key) in navigation">

                <router-link class="layout-default-router-link" :key="key" :to="item.to">
                    <v-list-item exact router>
                        <v-list-item-action>
                            <v-icon v-text="item.icon" />
                        </v-list-item-action>
                        <v-list-item-content>
                            <v-list-item-title v-text="$t(item.title)" />
                        </v-list-item-content>
                    </v-list-item>
                </router-link>

            </template>
        </v-list>
    </v-navigation-drawer>
</template>


<script>
import { UNIT_LIST, POT_LIST } from '@/plugins/router';

export default {
    computed: {
        navigation() {
            let list = new Array();
                list.push({
                    icon: "mdi-calendar-check",
                    title: "areas.unit.navigation",
                    to: { name: UNIT_LIST }
                });

                list.push({
                    icon: "mdi-calendar-check",
                    title: "areas.pot.navigation",
                    to: { name: POT_LIST }
                });

            return list;
        },
        styleNavigationDrawer() {
            return {
                background: this.$vuetify.theme.themes[this.theme].secondary
            };
        }
    },
    data: () => ({
        fixed: false
    }),
    props: {
        theme: {
            type: String,
            required: true
        },
        value: {
            type: Boolean,
            required: true
        }
    },
    watch: {
        value(newVal) {
            this.$emit("input", newVal);
        }
    }
};
</script>

<style scoped>
.layout-default-router-link {
    text-decoration: none;
}
</style>
