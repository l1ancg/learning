// =============== lit 写法 ==================

import { LitElement, html, css } from 'lit'

class LitCounter extends LitElement {
    static properties = {
        count: {}
    }
    static styles = css`
    button {
        background: var(--color-red);
    }
    `

    constructor() {
        super();
        this.count = 0; // 赋值property
    }

    firstUpdated() {
        console.log('firstUpdated')
    }

    render() {
        return html`<button @click=${() => this.count++}>${this.count}</button>`
    }
}

customElements.define(`lit-counter`, LitCounter)


// ====================== 以下是原生的写法 ==================

class MyDiv extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({ mode: 'open' })
        this.shadowRoot.innerHTML = `
        <style>
            div {
                width: 100px; height: 100px; background: green;
            }
        </style>
        <div>
            <slot></slot>
        </div>
        `
    }
}

customElements.define("my-div", MyDiv)


class Counter extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({ mode: 'open' })
        this.shadowRoot.innerHTML = `<button>${this.count}</button>`
        this.btn = this.shadowRoot.querySelector(`button`)
        this.btn.addEventListener('click', () => this.count++)
    }

    get count() {
        return this.getAttribute(`count`) ? this.getAttribute(`count`) : 10
    }

    set count(count) {
        this.setAttribute(`count`, count)
    }

    static get observedAttributes() {
        return ['count']
    }

    attributeChangedCallback(attr, old, newVal) {
        if (attr === 'count') {
            this.btn.textContent = newVal
        }
    }


}

customElements.define("my-counter", Counter)
