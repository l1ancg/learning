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
    {
        label: '开发者工具',
        key: 'dev',
        icon: renderIcon(PawIcon),
        children: [
            {
                label: '数据中心',
                key: 'protect-wild-animals'
            },
            {
                label: '图标集合',
                key: 'protect-wild-animals'
            },
            {
                label: '缓存工具',
                key: 'protect-wild-animals'
            },
            {
                label: '接口工具',
                key: 'protect-wild-animals'
            },
            {
                label: '编排工具',
                key: 'protect-wild-animals'
            },
            {
                label: '管理员工具',
                key: 'protect-wild-animals'
            },
        ]
    },
    {
        label: '鱼',
        key: 'fish',
        icon: renderIcon(FishIcon),
        children: [
            {
                label: '红烧',
                key: 'braise',
                children: [
                    {
                        label: '加辣',
                        key: 'spicy'
                    }
                ]
            },
            {
                label: '清蒸',
                key: 'steamed',
                children: [
                    {
                        label: '不要葱',
                        key: 'no-green-onion'
                    }
                ]
            }
        ]
    },
    {
        label: '熊掌',
        key: 'bear-paw',
        icon: renderIcon(PawIcon),
        children: [
            {
                label: '保护野生动物',
                key: 'protect-wild-animals'
            }
        ]
    },
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