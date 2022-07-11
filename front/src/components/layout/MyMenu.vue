<template>
    <div class="w-64 overflow-auto">
        <div class="text-5xl text-center p-10 text-green-500">
            Demo
        </div>

        <n-menu :options="menuOptions"/>
    </div>
</template>

<script lang="ts" setup>
import {Component, h, reactive} from 'vue'
import type {MenuOption} from 'naive-ui'
import {NIcon} from 'naive-ui'
import {FishOutline as FishIcon, PawOutline as PawIcon} from '@vicons/ionicons5'

function renderIcon(icon: Component) {
    return () => h(NIcon, null, {default: () => h(icon)})
}

const menuOptions: MenuOption[] = reactive([
    
])
50.
for (let i = 0; i < 20; i++) {
    menuOptions.push({
        label: '熊掌' + i,
        key: 'bear-paw' + i,
        icon: renderIcon(PawIcon),
        children: [
            {
                label: '保护野生动物' + i,
                key: 'protect-wild-animals' + i
            }
        ]
    })
}
</script>

<style scoped>

</style>