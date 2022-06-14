<template>
    <div class="flex flex-row h-full">
        <CMenu></CMenu>

        <div class="flex-1 flex flex-col">
            <CBar></CBar>
            <CContent></CContent>
        </div>
    </div>
</template>

<script setup lang="ts">
import CBar from './CBar.vue'
import CContent from './CContent.vue'
import CMenu from './CMenu.vue'</script>

<style scoped>

</style>