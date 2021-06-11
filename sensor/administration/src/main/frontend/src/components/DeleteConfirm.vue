<template>
    <v-dialog v-model="dialog" max-width="600">
        <template v-slot:activator="{ on }">
            <v-icon class="mr-2" color="red" small v-text="'mdi-delete'" v-on="on" />
        </template>

        <v-card>
            <v-card-title class="headline" v-text="$t('components.deleteConfirm.title')" />

            <v-card-text v-text="$t('components.deleteConfirm.text')" />

            <v-card-actions>
                <v-spacer></v-spacer>

                <v-btn
                    color="darken-1"
                    text
                    v-text="$t('components.deleteConfirm.cancel')"
                    @click="dialog = false"
                />

                <v-btn
                    color="red darken-1"
                    text
                    v-text="$t('components.deleteConfirm.confirm')"
                    @click="onDelete(onDeleteParameter)"
                />
            </v-card-actions>
        </v-card>
    </v-dialog>
</template>

<script>
export default {
    data: () => ({
        dialog: false
    }),
    props: {
        onDelete: {
            type: Function,
            required: true
        },
        onDeleteParameter: {
            type: Object,
            required: false,
            default: () => {}
        }
    }
};
</script>
