<template>
    <v-card>
        <v-card-title>
            <span class="headline" v-text="title" />
        </v-card-title>
        <v-card-text>
            <apexchart type="line" :options="options" :series="series"></apexchart>
        </v-card-text>
    </v-card>
</template>

<script lang="ts">
import Vue from "vue";
import { Component, Prop } from "vue-property-decorator";

@Component({
    components: {}
})
export default class PlantListItem extends Vue {
    @Prop({ required: true, type: Array })
    public data!: Array<{date: any, value: number}>; 

    @Prop({ default: Math.random().toString().substr(2, 8), type: String })
    public id!: string; 

    @Prop({ default: "test", type: String })
    public title!: string; 

    private options = {
        chart: {
            id: this.id,
        },
        stroke: {
            width: 1
        },
        theme: {
            mode: this.$vuetify.theme.dark ? "dark": "ligth"
        },
        tooltip: {
            x: {
                show: true,
                format: 'dd MMM - hh:mm:ss',
                formatter: undefined,
            },      
            // y: {
            //     formatter: function(value: any, opts: any) {
            //         let percent = opts.w.globals.seriesPercent[opts.seriesIndex][opts.dataPointIndex];
            //         return percent.toFixed(0) + '%'
            //     }
            // }
        },
        xaxis: {
            type: 'datetime',
        },
        yaxis: {
            // forceNiceScale:false,
            // min: 0,
            // max: 100,
        },
        zoom: {
            type: 'x',
            enabled: true,
            autoScaleYaxis: true
        },
      };

      private series= [{
            name:"Moisture",
            data: this.data,
      }];

};
</script>

