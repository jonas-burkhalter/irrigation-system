<script lang="ts">
import Vue from "vue";
import { Component } from "vue-property-decorator";

@Component
export default class View extends Vue {
    protected get title() {
        return "test";
    }; 
    protected set title(value: String) {}; 
};
</script>

