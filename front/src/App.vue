<script setup lang="ts">
import MyMain from '@/components/layout/MyMain.vue'

import {reactive, ref} from 'vue'
import {darkTheme, dateZhCN, lightTheme, zhCN} from 'naive-ui'

const dark = ref(true);

const themeClass = reactive(['bg-slate-800', 'text-slate-200', ''])

</script>

<template>
    <n-config-provider :locale="zhCN" :date-locale="dateZhCN" :theme="dark? darkTheme : lightTheme" :class="themeClass">
        <MyMain></MyMain>
    </n-config-provider>
</template>

<style scoped>
</style>
