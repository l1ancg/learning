<template>
    <div class="bg-red-900">
        <n-layout>
            <span>内容</span>
            <n-calendar #="{ year, month, date }">
                {{ year }}-{{ month }}-{{ date }}
            </n-calendar>
        </n-layout>
    </div>

</template>

<script>
export default {
    name: "Content"
}
</script>

<style scoped>

</style>