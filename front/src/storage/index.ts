import { FishOutline as FishIcon, PawOutline as PawIcon } from '@vicons/ionicons5'
import { NIcon } from 'naive-ui'
import { Component, h, reactive } from 'vue'

function renderIcon(icon: Component) {
    return () => h(NIcon, null, { default: () => h(icon) })
}

const my_menu_tree = [
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
]