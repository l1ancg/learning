<template>
    <div class="flex flex-row h-full">
        <MyMenu></MyMenu>

        <div class="flex-1 flex flex-col">
            <MyBar></MyBar>
            <MyContent></MyContent>
        </div>
    </div>
</template>

<script setup lang="ts">
import MyBar from './MyBar.vue'
import MyContent from './MyContent.vue'
import MyMenu from './MyMenu.vue'</script>

<style scoped>

</style>