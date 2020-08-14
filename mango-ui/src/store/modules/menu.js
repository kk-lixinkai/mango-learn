export default {
  state: {
    navTree: [],   // 导航栏菜单
  },
  getters: {

  },
  mutations: {
    setNavTree(state, navTree) { // 设置导航菜单树
      state.navTree = navTree;
    }
  },
  actions: {}
}
