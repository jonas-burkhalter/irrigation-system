<template>
    <v-container>
      <v-row v-if="datacollection && datacollection.feeds">
        <v-col :cols="12" :md="6" :xl="4">
          <ListItem :data="getData('field1')" title="Rosmarin" />
        </v-col>
        <v-col :cols="12" :md="6" :xl="4">
          <ListItem :data="getData('field2')" title="Thymian" />
        </v-col>
        <v-col :cols="12" :md="6" :xl="4">
          <ListItem :data="getData('field3')" title="Schnittlauch" />
        </v-col>
        <v-col :cols="12" :md="6" :xl="4">
          <ListItem :data="getData('field4')" title="Salbei" />
        </v-col>
        <v-col :cols="12" :md="6" :xl="4">
          <ListItem :data="getData('field5')" title="field5" />
        </v-col>
      </v-row>
    </v-container>
</template>

<script lang="ts">
import Vue from "vue";
import { Component } from "vue-property-decorator";

import {thingSpeakService} from "@/areas/plant/services/ThingSpeakService"

import ListItem from "@/areas/plant/components/ListItem.vue";
@Component({
    components: {
        ListItem
    }
})
export default class PlantListView extends Vue {
    private datacollection: any = {};

    private mounted() {
      thingSpeakService.get().then(value => {
        console.log("value", value)
        this.datacollection = value;
      });
    }

    private getData(field: string) : Array<{date: any, value: number}> {
      let value: Array<any> = [];

      if (!this.datacollection || !this.datacollection.feeds) {
        return value;
      }

      this.datacollection.feeds.forEach((element: any) => {
        let date = new Date(element.created_at);
        date.setMinutes(date.getMinutes() - date.getTimezoneOffset());
        value.push({
          x: date.getTime(), 
          // y: Math.round((4095 - element[field]) * 100 / 4095)
          y: element[field]
        });
      });

      return value;
    }
};
</script>

