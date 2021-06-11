<template>
    <v-card>
        <v-card-title>
            <span class="headline" v-text="title" />
        </v-card-title>

        <ValidationObserver ref="observer" v-slot="{ invalid }">
            <v-form lazy-validation @submit.prevent="save">
                <v-card-text>
                    <v-container>
                        <v-row>
                            <v-col sm="12">
                                <ValidationProvider
                                    v-slot="{ errors }"
                                    :name="$t('areas.authenticate.name')"
                                    rules="required"
                                    type="text"
                                >
                                    <v-text-field
                                        :error-messages="errors"
                                        :label="$t('areas.authenticate.name')"
                                        required
                                        v-model="value.name"
                                    />
                                </ValidationProvider>
                            </v-col>
                        </v-row>
                        <v-row>
                            <v-col sm="12">
                                <ValidationProvider
                                    v-slot="{ errors }"
                                    :name="$t('areas.authenticate.password')"
                                    rules="required"
                                    type="text"
                                >
                                    <v-text-field
                                        :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
                                        :error-messages="errors"
                                        :label="$t('areas.authenticate.password')"
                                        :type="showPassword ? 'text' : 'password'"
                                        required
                                        v-model="value.password"
                                        @click:append="showPassword = !showPassword"
                                    />
                                </ValidationProvider>
                            </v-col>
                        </v-row>
                    </v-container>
                </v-card-text>

                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn
                        color="green darken-1"
                        :disabled="invalid"
                        text
                        v-text="title"
                        @click="save"
                    />
                </v-card-actions>
            </v-form>
        </ValidationObserver>
    </v-card>
</template>

<script>
import { required } from "vee-validate/dist/rules";
import { extend, ValidationObserver, ValidationProvider } from "vee-validate";
extend("required", required);

export default {
    components: {
        ValidationProvider,
        ValidationObserver
    },
    data: () => ({
        showPassword: false
    }),
    props: {
        save: {
            type: Function,
            required: true
        },
        title: {
            type: String,
            required: true
        },
        value: {
            type: Object,
            required: true
        }
    }
};
</script>
