import Vue from 'vue'
import vuex from 'vuex'
// 引入子模块
import app from './modules/app'
import user from "./modules/user";
import menu from "./modules/menu";
import tab from './modules/tab'
import iframe from "./modules/iframe";


Vue.use(vuex)


const store = new vuex.Store({
  modules: {
    app: app,
    tab: tab,
    user: user,
    menu: menu,
    iframe: iframe
  }
})

export default store
