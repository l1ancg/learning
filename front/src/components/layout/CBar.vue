<template>
    <div class="h-28 p-1">
        <div class="flex justify-between items-center h-16 pl-6 pr-6">
            <div class="bar-left">
                bar left
            </div>
            <div class="bar-right">
                bar right
            </div>
        </div>

        <div class="h-8">
            <n-tag v-for="item in tags" :key="item.label" round="true" class="ml-1 mr-1" :closable="item.closable">
                {{item.label}}
            </n-tag>
        </div>
    </div>
</template>

<script lang="ts" setup>
// '首页', '爱在西元前', '不该', '手写的从前', '哪里都是你'
const tags = [
    {'label':'首页','closable': false},
    {'label':'爱在西元前','closable': true},
    {'label':'不该','closable': true},
    {'label':'手写的从前','closable': true},
    {'label':'哪里都是你','closable': true}
];
</script>

<style scoped>

</style>